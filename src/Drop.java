import processing.core.*;
import java.lang.Math;
import java.util.Map;

public class Drop extends Visualization {
    Visualization v;

    float x; 
    float y; 
    float z; // For perspective setting. Should be more drops further back
    float len; 
    float ySpeed;

    public Drop(Visualization v) {
        this.v = v; 

        x = (int) (640 * Math.random());
        y = (int) -((500 * Math.random()) + 50); // Drop should start off screen so neg 
        z = (int) (20 * Math.random());
        len = map(z, 0, 20, 10, 20);
        ySpeed = map(z, 0, 20, 1, 20);
    }

    public void fall() { 
        y = y + ySpeed; 
        float grav = map(z, (float) 0, (float) 20, (float) 0, (float) 0.2); 
        ySpeed = ySpeed + grav; 

        if (y > 420) {
            y = random(-200, -100);
            ySpeed = map(z, 0, 20, 4, 10);
        }
    }

    void show() { // function to render the drop onto the screen
        v.line(x, y, x, y + len);
    }

    

}
