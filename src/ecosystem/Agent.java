package ecosystem;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Classe abstrata que define o comportamento genérico de um agente no ecossistema.
 * Os agentes possuem posição, energia e interagem com o terreno.
 */
public abstract class Agent {
    protected PApplet p; // Instância de PApplet para renderização
    protected PVector position; // Posição atual do agente no terreno
    protected float energy; // Energia do agente (define se está vivo)
    protected Terrain terrain; // Referência ao terreno onde o agente se move

    /**
     * Construtor da classe Agent.
     *
     * @param p       Instância de PApplet para renderização.
     * @param terrain Referência ao terreno do ecossistema.
     */
    public Agent(PApplet p, Terrain terrain) {
        this.p = p;
        this.terrain = terrain;
        // Inicializa posição aleatória dentro dos limites do terreno
        this.position = new PVector(p.random(terrain.getCols()), p.random(terrain.getRows()));
        this.energy = 100; // Energia inicial padrão
    }

    /**
     * Atualiza o estado do agente, incluindo movimento e consumo de energia.
     *
     * @param dt Delta de tempo desde o último ciclo de atualização.
     */
    public abstract void update(float dt);

    /**
     * Renderiza o agente na janela gráfica.
     *
     * @param p Instância de PApplet para renderização.
     */
    public void display(PApplet p) {
        p.fill(255, 0, 0); // Cor padrão (vermelho para predadores)
        p.ellipse(position.x * p.width / terrain.getCols(),
                position.y * p.height / terrain.getRows(), 10, 10);
    }

    /**
     * Verifica se o agente ainda está vivo (energia maior que 0).
     *
     * @return True se o agente está vivo, False caso contrário.
     */
    public boolean isAlive() {
        return energy > 0;
    }
}
