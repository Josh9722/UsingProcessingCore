import processing.core.PApplet;

import processing.core.*;

public class Visualization extends PApplet {
    
    public static void main(String[] args) {
        String[] mainSketch = concat(new String[] { getSketchClassName() }, args);
        PApplet.main(mainSketch);
    }

    public static final String getSketchClassName() {
        return Thread.currentThread().getStackTrace()[1].getClassName();
    }

    public static final String[] getSketchNestedClassNames() {
        Class[] nested;

        try {
            nested = Class.forName(getSketchClassName()).getClasses();
        }
        catch (ClassNotFoundException cause) {
            throw new RuntimeException(cause);
        }
        int idx = 0, len = max(0, nested.length - 2);
        String[] classes = new String[len];

        while (idx != len)
            classes[idx] = nested[idx++].getName();
        return classes;
    }

    Drop[] drops = new Drop[300]; // Array of 300 Drop Objects 

    @Override
    public void settings() { // Window size 
        size(640, 480);
    }

    @Override
    public void setup() { 
        for (int i = 0; i < drops.length; i++) { 
            drops[i] = new Drop(this); 
        }
    }

    @Override
    public void draw() {
        background(230, 230, 250);
        
        for (int i = 0; i < drops.length; i++) {
            drops[i].fall(); 
            drops[i].show(); 
        }
    }
    
    public void parseDraw(float x2, float y2, float x3, float f) {
        //line(x2, y2, x3, f);
        ellipse(10,10,10,10);
        // stroke(138, 43, 226); // purple color
        // strokeWeight(10); // weight of the drop
    }

}
