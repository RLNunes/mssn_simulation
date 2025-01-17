package setup;

import processing.core.PApplet;

/**
 * A ‘interface’ IProcessingApp define os métodos fundamentais que uma aplicação em Processing deve implementar.
 * Estes métodos são chamados ao longo do ciclo de vida da aplicação gráfica, permitindo a sua configuração inicial,
 * a renderização dos elementos gráficos e a gestão de interações do utilizador.
 */
public interface IProcessingApp {

    /**
     * Método responsável pela configuração inicial da aplicação. É chamado uma única vez
     * no início da execução, sendo utilizado para inicializar os elementos e variáveis necessários.
     *
     * @param p Instância de PApplet que representa a janela gráfica onde a aplicação será desenhada.
     */
    void setup(PApplet p);

    /**
     * Método responsável por desenhar os elementos na janela gráfica. É chamado repetidamente
     * durante a execução da aplicação, garantindo a atualização constante do estado gráfico.
     *
     * @param p  Instância de PApplet que representa a janela gráfica onde a aplicação será desenhada.
     * @param dt Intervalo de tempo (em segundos) desde o último ciclo de desenho, permitindo animações suaves.
     */
    void draw(PApplet p, float dt);

    /**
     * Método invocado quando o botão do rato é pressionado. Pode ser utilizado para iniciar accesses
     * específicas ou interagir com os elementos gráficos.
     *
     * @param p Instância de PApplet que representa a janela gráfica onde a aplicação será desenhada.
     */
    void mousePressed(PApplet p);

    /**
     * Método invocado quando o botão do rato é libertado. Pode ser utilizado para concluir ou cancelar
     * acções iniciadas no método mousePressed.
     *
     * @param p Instância de PApplet que representa a janela gráfica onde a aplicação será desenhada.
     */
    void mouseReleased(PApplet p);

    /**
     * Método invocado quando o rato é arrastado enquanto um botão está pressionado. Permite implementar
     * funcionalidades que dependam do movimento contínuo do rato, como o desenho ou a manipulação de objects.
     *
     * @param p Instância de PApplet que representa a janela gráfica onde a aplicação será desenhada.
     */
    void mouseDragged(PApplet p);

    /**
     * Método invocado quando uma tecla é pressionada. Permite implementar funcionalidades baseadas
     * em interações com o teclado, como controlos ou atalho de comandos.
     *
     * @param p Instância de PApplet que representa a janela gráfica onde a aplicação será desenhada.
     */
    void keyPressed(PApplet p);
}
