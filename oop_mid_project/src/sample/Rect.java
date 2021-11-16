package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends Drawing{

    int w;
    int h;

    public Rect(int x, int y, int w, int h, Color color, GraphicsContext gc){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        draw(gc);
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(color);
        gc.fillRect(x, y, w, h);
    }

}
