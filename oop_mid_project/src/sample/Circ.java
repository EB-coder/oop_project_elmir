package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circ extends Drawing{

    int size;

    public Circ(int x, int y, int size, Color color, GraphicsContext gc){
        this.size = size;
        this.x = x;
        this.y = y;
        this.color = color;
        draw(gc);
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(color);
        gc.fillOval(x, y, size, size);
        gc.strokeOval(x, y, size, size);
    }
}
