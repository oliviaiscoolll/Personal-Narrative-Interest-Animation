import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
    public static void main(String[] args) {

        ImageFilter[][] images = {
            { new ImageFilter("bham.png") },   
            { new ImageFilter("taft.png") }, 
            { new ImageFilter("chatsworth.png") }  
        };

        ImageFilter[][] images1 = {
            { new ImageFilter("hawaii.png") }, 
            { new ImageFilter("mexico.png") }, 
            { new ImageFilter("washingtondc.png") }    
        };

        // Instantiate Scene subclasses
        TennisScene scene1 = new TennisScene(images);
        TravelScene scene2 = new TravelScene(images1); 

        // Draw scenes
        scene1.drawScene();
        scene2.drawScene();

        // Play scenes in order
        Theater.playScenes(scene1, scene2);
    }
}