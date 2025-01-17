package ecosystem;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Representa uma presa no ecossistema.
 * As presas movem-se aleatoriamente e consomem alimento para recuperar energia.
 */
public class Prey extends Agent {

    /**
     * Construtor da classe Prey.
     *
     * @param p       Instância de PApplet para renderização.
     * @param terrain Referência ao terreno do ecossistema.
     */
    public Prey(PApplet p, Terrain terrain) {
        super(p, terrain);
    }

    /**
     * Atualiza o estado da presa.
     * Inclui movimento aleatório, consumo de energia e alimentação.
     *
     * @param dt Delta de tempo desde o último ciclo de atualização.
     */
    @Override
    public void update(float dt) {
        // Movimento aleatório dentro do terreno
        position.add(PVector.random2D().mult(0.5f));

        // Consumo de energia devido ao movimento
        energy -= dt * 2;

        // Verifica se a presa está sobre uma célula de comida
        int state = terrain.getState((int) position.x, (int) position.y);
        if (state == Terrain.FOOD) {
            energy += 20; // Recupera energia
            terrain.setState((int) position.x, (int) position.y, Terrain.FERTILE); // Regenera o terreno
        }
    }

    /**
     * Renderiza a presa na janela gráfica.
     *
     * @param p Instância de PApplet para renderização.
     */
    @Override
    public void display(PApplet p) {
        p.fill(0, 255, 0); // Verde para representar presas
        p.ellipse(position.x * p.width / terrain.getCols(),
                position.y * p.height / terrain.getRows(), 8, 8);
    }
}
