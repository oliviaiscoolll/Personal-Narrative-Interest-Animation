import org.code.theater.*;
import org.code.media.*;

/*
 * This class shows my travel experiences throughout the year and the different parts
 over the US that I have traveled.
 */
public class TravelScene extends Scene {

  private ImageFilter[][] images;

  private String[] titles = {
    "Hawaii (Mirror Vertical)",
    "Mexico (Saturate)",
    "Washington DC (Sepia)"
  };
  
//2D array showing rating of each location
  private int[][] travelStats = {
        {7, 9},  // Hawaii: 7 days, rating 9/10
        {5, 8},  // Mexico: 5 days, rating 8/10
        {3, 7}   // Washington DC: 3 days, rating 7/10
    };

  public TravelScene(ImageFilter[][] images) {
    this.images = images;
  }

  /*
   * Preconditions: Score must not be empty
   * Postconidtions: Score text appears in the lower
   * portion of the screen
   */
  public void drawScene() {

  showIntroScreen("Places I Visited:");

  for (int i = 0; i < images.length; i++) {
    showTitle(titles[i]);
    displayLocation(images[i][0], i);
  }
}

  
   //Displays one travel image and applies filter
   
  private void displayLocation(ImageFilter img, int index) {

    clear("white");
    drawImage(img, 0, 0, 400, 400, 0);
    drawTravelInfo(index); 
    pause(1);

    applyTravelFilter(img, index);

    clear("white");
    drawImage(img, 0, 0, 400, 400, 0);
    pause(1);
  }

  
   //Applies mirror vertical, saturate, and sepia filter
   
  private void applyTravelFilter(ImageFilter img, int index) {
    if (index == 0) img.mirrorVertical();
    else if (index == 1) img.saturate(1);
    else img.applySepia();
  }

  
   //Displays title text
   
  private void showTitle(String text) {
    clear("white");
    setTextHeight(28);
    setTextColor("black");
    drawText(text, 60, 200);
    pause(2);
  }
  //Shows intro screen
  private void showIntroScreen(String text) {
  clear("white");
  setTextHeight(32);
  setTextColor("black");
  drawText(text, 60, 200);
  pause(3);
  }
  
  // Displays the days stayed and rating for a travel location
   private void drawTravelInfo(int index) {
        int days = travelStats[index][0];
        int rating = travelStats[index][1];

        setTextHeight(20);
        setTextColor("white");
        drawText("Days: " + days + " | Rating: " + rating + "/10", 20, 380);
    }

}