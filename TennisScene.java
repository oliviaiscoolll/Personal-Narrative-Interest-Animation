import org.code.theater.*;
import org.code.media.*;
import java.util.Arrays;

/*
 * This class shows my tennis matches throuhgout the season on the different courts ive played on from different
 schools and match scores.
 */
public class TennisScene extends Scene {

  private ImageFilter[][] images;
  private String[] titles = {
    "Birmingham (Negative)",
    "Taft (Blur)",
    "Chatsworth (Sepia)"
  };

  private static final int SAMPLE_RATE = 44100;

  /*
   * Preconditions: images must not be null
   * Postconditions: images stored for when the scene is played
   */
  public TennisScene(ImageFilter[][] images) {
    this.images = images;
  }

 
  //Runs the full tennis stat scene

  public void drawScene() {

  showIntroScreen("Tennis Match Stats:");

  playMusic(20);

  for (int i = 0; i < images.length; i++) {
    showTitle(titles[i]);
    displayMatch(images[i][0], i);
  }
}

// 2D array storing match scores {set1GamesWon, set1GamesLost}
private int[][] matchStats = {
  {6, 2},  // Birmingham
  {7, 5},  // Taft
  {6, 1}   // Chatsworth
};
  //Displays one match image with its filter and score
   
  private void displayMatch(ImageFilter img, int index) {

    clear("white");
    drawImage(img, 0, 0, 400, 400, 0);
    drawScore(getFormattedScore(index));
    pause(1);

    applyFilter(img, index);

    clear("white");
    drawImage(img, 0, 0, 400, 400, 0);
    drawScore(getFormattedScore(index));
    pause(1);
  }

  
   //Applies a filter based on index
   
  private void applyFilter(ImageFilter img, int index) {
    if (index == 0) img.makeNegative();
    else if (index == 1) img.applyBlur();
    else img.applySepia();
  }

      
 //Returns formatted match score and total games.
 
private String getFormattedScore(int index) {

  int gamesWon = matchStats[index][0];
  int gamesLost = matchStats[index][1];

  int totalGames = gamesWon + gamesLost;

  return "Match Score: " + gamesWon + "-" + gamesLost +
         " | Total Points played: " + totalGames;
}
  
   //Draws score text on screen
   
  private void drawScore(String score) {
    setTextHeight(20);
    setTextColor("white");
    drawText(score, 20, 380);
  }

  
   //Shows section title
   
  private void showTitle(String text) {
    clear("white");
    setTextHeight(28);
    setTextColor("black");
    drawText(text, 60, 200);
    pause(2);
  }

  
   //Plays background music
   
  private void playMusic(int seconds) {
    double[] audio = SoundLoader.read("music.wav");
    double[] clip = createClip(audio, 0, seconds);
    playSound(clip);
  }

  
   //Creates trimmed audio clip
   
  private static double[] createClip(double[] sound, int start, int end) {
    int startIndex = start * SAMPLE_RATE;
    int endIndex = end * SAMPLE_RATE;
    if (endIndex > sound.length) endIndex = sound.length;
    return Arrays.copyOfRange(sound, startIndex, endIndex);
  }
  // Displays the intro screen 
  private void showIntroScreen(String text) {
  clear("white");
  setTextHeight(32);
  setTextColor("black");
  drawText(text, 40, 200);
  pause(3);
}
  }

