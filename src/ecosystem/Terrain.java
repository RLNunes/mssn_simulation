package ecosystem;

import processing.core.PApplet;

/**
 * Representa o terreno onde a simulação ocorre. É modelado como uma grelha 2D com diferentes estados.
 */
public class Terrain {
    private final int rows, cols; // Dimensões da grelha
    private final int[][] grid; // Representação do estado de cada célula
    private int[] stateColors; // Cores associadas aos estados
    private final PApplet p;

    public static final int EMPTY = 0; // Estado vazio
    public static final int FERTILE = 1; // Estado fértil
    public static final int OBSTACLE = 2; // Obstáculo
    public static final int FOOD = 3; // Alimento

    /**
     * Construtor da classe Terrain.
     *
     * @param p    Instância de PApplet para renderização.
     * @param rows Número de linhas na grelha.
     * @param cols Número de colunas na grelha.
     */
    public Terrain(PApplet p, int rows, int cols) {
        this.p = p;
        this.rows = rows;
        this.cols = cols;
        this.grid = new int[rows][cols];
    }

    /**
     * Inicializa o terreno com estados aleatórios.
     */
    public void initRandom() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = (int) p.random(4); // Estados aleatórios entre 0 e 3
            }
        }
    }

    /**
     * Define as cores associadas aos estados do terreno.
     *
     * @param colors Array de cores para cada estado.
     */
    public void setStateColors(int[] colors) {
        this.stateColors = colors;
    }

    /**
     * Atualiza o estado do terreno.
     */
    public void update() {
        // Exemplo: Implementar regeneração de alimento ou outros comportamentos.
    }

    /**
     * Renderiza o terreno na janela gráfica.
     */
    public void display(PApplet p) {
        float cellWidth = p.width / (float) cols;
        float cellHeight = p.height / (float) rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                p.fill(stateColors[grid[i][j]]);
                p.rect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    /**
     * Altera o estado de uma célula no terreno.
     *
     * @param x Coordenada x do clique.
     * @param y Coordenada y do clique.
     */
    public void toggleState(int x, int y) {
        int col = x / (p.width / cols);
        int row = y / (p.height / rows);

        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = (grid[row][col] + 1) % 4; // Alterna entre os estados
        }
    }

    /**
     * Verifica se há uma presa na célula especificada.
     *
     * @param x Coordenada x da célula.
     * @param y Coordenada y da célula.
     * @return True se houver uma presa na célula, False caso contrário.
     */
    public boolean hasPreyAt(int x, int y) {
        // Exemplo: Simula uma verificação com base no estado da célula
        return grid[y][x] == FOOD;
    }

    /**
     * Remove uma presa da célula especificada.
     *
     * @param x Coordenada x da célula.
     * @param y Coordenada y da célula.
     */
    public void removePrey(int x, int y) {
        if (grid[y][x] == FOOD) {
            grid[y][x] = FERTILE; // Altera o estado da célula para fértil após remoção
        }
    }

    /**
     * Obtém o estado de uma célula no terreno.
     *
     * @param x Coordenada x da célula.
     * @param y Coordenada y da célula.
     * @return O estado da célula.
     */
    public int getState(int x, int y) {
        return grid[y][x];
    }

    /**
     * Define o estado de uma célula no terreno.
     *
     * @param x     Coordenada x da célula.
     * @param y     Coordenada y da célula.
     * @param state Novo estado para a célula.
     */
    public void setState(int x, int y, int state) {
        grid[y][x] = state;
    }

    /**
     * Obtém o número de colunas do terreno.
     *
     * @return Número de colunas.
     */
    public int getCols() {
        return cols;
    }

    /**
     * Obtém o número de linhas do terreno.
     *
     * @return Número de linhas.
     */
    public int getRows() {
        return rows;
    }
}
