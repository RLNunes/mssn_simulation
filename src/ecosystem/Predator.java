package ecosystem;

import processing.core.PApplet;
import processing.core.PVector;

public class Predator extends Agent {
    public Predator(PApplet p, Terrain terrain) {
        super(p, terrain);
    }

    @Override
    public void update(float dt) {
        position.add(PVector.random2D().mult(0.7f));
        energy -= dt * 3;

        if (terrain.hasPreyAt((int) position.x, (int) position.y)) {
            energy += 50;
            terrain.removePrey((int) position.x, (int) position.y);
        }
    }

    @Override
    public void display(PApplet p) {
        p.fill(255, 0, 0);
        p.ellipse(position.x * p.width / terrain.getCols(),
                position.y * p.height / terrain.getRows(), 12, 12);
    }
}
