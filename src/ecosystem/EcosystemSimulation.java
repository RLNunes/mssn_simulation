package ecosystem;

import processing.core.PApplet;
import setup.IProcessingApp;

/**
 * A classe EcosystemSimulation implementa a interface IProcessingApp e define o comportamento
 * inicial de uma simulação de ecossistema. Esta classe inclui a configuração do terreno,
 * da população inicial e dos elementos gráficos, bem como a atualização do sistema
 * durante o ciclo de vida da aplicação.
 */
public class EcosystemSimulation implements IProcessingApp {

    // Variáveis principais para o terreno e a população
    private Terrain terrain;
    private Population population;

    // Temporizador para controlar a atualização da simulação
    private float timer;

    /**
     * Configuração inicial do ecossistema.
     * Inicializa o terreno e a população com os parâmetros padrão.
     *
     * @param p Instância de PApplet que representa a janela gráfica.
     */
    @Override
    public void setup(PApplet p) {
        // Inicializar terreno
        terrain = new Terrain(p, 50, 50); // Exemplo: 50x50 células
        terrain.initRandom();

        // Inicializar população
        population = new Population(p, terrain);
        population.initRandom(20, 10); // Exemplo: 20 presas, 10 predadores

        // Inicializar temporizador
        timer = 0;
    }

    /**
     * Atualização do ecossistema. Inclui a lógica de interação entre agentes e o terreno.
     *
     * @param p  Instância de PApplet que representa a janela gráfica.
     * @param dt Intervalo de tempo desde o último ciclo (em segundos).
     */
    @Override
    public void draw(PApplet p, float dt) {
        // Atualizar temporizador
        timer += dt;

        // Atualizar terreno
        terrain.update();

        // Atualizar população
        population.update(dt);

        // Renderizar terreno
        terrain.display(p);

        // Renderizar população
        population.display(p);
    }

    /**
     * Lógica para interação ao pressionar o botão do rato.
     * Exemplo: adicionar agentes ou interagir com o terreno.
     *
     * @param p Instância de PApplet que representa a janela gráfica.
     */
    @Override
    public void mousePressed(PApplet p) {
        // Exemplo: Adicionar uma presa no local do clique
        int x = p.mouseX;
        int y = p.mouseY;
        population.addPrey(x, y);
    }

    /**
     * Lógica para interação ao soltar o botão do rato.
     *
     * @param p Instância de PApplet que representa a janela gráfica.
     */
    @Override
    public void mouseReleased(PApplet p) {
        // Implementar funcionalidades adicionais se necessário
    }

    /**
     * Lógica para interação ao arrastar o rato.
     *
     * @param p Instância de PApplet que representa a janela gráfica.
     */
    @Override
    public void mouseDragged(PApplet p) {
        // Exemplo: Alterar o estado do terreno enquanto o rato é arrastado
        int x = p.mouseX;
        int y = p.mouseY;
        terrain.toggleState(x, y);
    }

    /**
     * Lógica para interação ao pressionar uma tecla.
     * Exemplo: Reiniciar a simulação ou alterar parâmetros.
     *
     * @param p Instância de PApplet que representa a janela gráfica.
     */
    @Override
    public void keyPressed(PApplet p) {
        if (p.key == 'r' || p.key == 'R') {
            setup(p); // Reinicializar a simulação
        }
    }
}
