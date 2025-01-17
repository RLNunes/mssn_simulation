package ecosystem;

import processing.core.PApplet;
import sun.management.Agent;

import java.util.ArrayList;

/**
 * Gerencia a população de agentes no ecossistema.
 */
public class Population {
    private ArrayList<Agent> agents;
    private Terrain terrain;
    private PApplet p;

    /**
     * Construtor da classe Population.
     *
     * @param p       Instância de PApplet para renderização.
     * @param terrain O terreno onde os agentes se movem.
     */
    public Population(PApplet p, Terrain terrain) {
        this.p = p;
        this.terrain = terrain;
        this.agents = new ArrayList<>();
    }

    /**
     * Inicializa a população com agentes aleatórios.
     *
     * @param numPrey      Número de presas.
     * @param numPredators Número de predadores.
     */
    public void initRandom(int numPrey, int numPredators) {
        for (int i = 0; i < numPrey; i++) {
            agents.add(new Prey(p, terrain));
        }
        for (int i = 0; i < numPredators; i++) {
            agents.add(new Predator(p, terrain));
        }
    }

    /**
     * Atualiza os estados dos agentes.
     *
     * @param dt Intervalo de tempo desde o último ciclo.
     */
    public void update(float dt) {
        for (Agent agent : agents) {
            agent.update(dt);
        }
    }

    /**
     * Renderiza a população na janela gráfica.
     *
     * @param p Instância de PApplet para renderização.
     */
    public void display(PApplet p) {
        for (Agent agent : agents) {
            agent.display(p);
        }
    }

    /**
     * Adiciona uma nova presa à população.
     *
     * @param x Coordenada x da nova presa.
     * @param y Coordenada y da nova presa.
     */
    public void addPrey(int x, int y) {
        agents.add(new Prey(p, terrain, x, y));
    }
}
