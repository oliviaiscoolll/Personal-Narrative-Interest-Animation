import org.code.theater.*;
import org.code.media.*;

/*
 * Represents an image that can be modified with filters and effects
 */
public class ImageFilter extends ImagePlus {

    /** Constructor */
    public ImageFilter(String fileName) {
        super(fileName);
    }

    /*
     * Negative Filter
     * Inverts RGB colors
     */
    public void makeNegative() {

        Pixel[][] pixels = getImagePixels();

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {

                Pixel currentPixel = pixels[row][col];

                currentPixel.setRed(255 - currentPixel.getRed());
                currentPixel.setGreen(255 - currentPixel.getGreen());
                currentPixel.setBlue(255 - currentPixel.getBlue());
            }
        }
    }

    /*
     * Blur Filter
     * Averages each pixel with neighbors
     */
    public void applyBlur() {

        Pixel[][] pixels = getImagePixels();

        Pixel[][] copy = new Pixel[pixels.length][pixels[0].length];

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                copy[r][c] = pixels[r][c];
            }
        }

        for (int r = 1; r < pixels.length - 1; r++) {
            for (int c = 1; c < pixels[0].length - 1; c++) {

                Pixel current = pixels[r][c];

                int redAvg =
                        (copy[r][c].getRed()
                        + copy[r-1][c].getRed()
                        + copy[r+1][c].getRed()
                        + copy[r][c-1].getRed()
                        + copy[r][c+1].getRed()) / 5;

                int greenAvg =
                        (copy[r][c].getGreen()
                        + copy[r-1][c].getGreen()
                        + copy[r+1][c].getGreen()
                        + copy[r][c-1].getGreen()
                        + copy[r][c+1].getGreen()) / 5;

                int blueAvg =
                        (copy[r][c].getBlue()
                        + copy[r-1][c].getBlue()
                        + copy[r+1][c].getBlue()
                        + copy[r][c-1].getBlue()
                        + copy[r][c+1].getBlue()) / 5;

                current.setRed(redAvg);
                current.setGreen(greenAvg);
                current.setBlue(blueAvg);
            }
        }
    }
/*
 * Sepia filter
 * Recalculates each pixel’s RGB values
 * to create a warm brown tone effect
 */
    public void applySepia() {

        Pixel[][] pixels = getImagePixels();

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[r].length; c++) {

                Pixel p = pixels[r][c];

                int red = p.getRed();
                int green = p.getGreen();
                int blue = p.getBlue();

                int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
                int newGreen = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
                int newBlue = (int)(0.272 * red + 0.534 * green + 0.131 * blue);

                if (newRed > 255) newRed = 255;
                if (newGreen > 255) newGreen = 255;
                if (newBlue > 255) newBlue = 255;

                p.setRed(newRed);
                p.setGreen(newGreen);
                p.setBlue(newBlue);
            }
        }
    }

    /*
     * Mirrors image across vertical center line
     */
    public void mirrorVertical() {

        Pixel[][] pixels = getImagePixels();

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length / 2; col++) {

                Pixel left = pixels[row][col];
                Pixel right = pixels[row][pixels[row].length - 1 - col];

                right.setColor(left.getColor());
            }
        }
    }
   public void saturate(int factor) {
    Pixel[][] pixels = getImagePixels();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int avgColor = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) / 3;
        int greyScaleValue = avgColor + (avgColor - 255) * factor;

        int red = Math.min(2 * greyScaleValue - currentPixel.getRed(), 255);
        int green = Math.min(2 * greyScaleValue - currentPixel.getGreen(), 255);
        int blue = Math.min(2 * greyScaleValue - currentPixel.getBlue(), 255);

        currentPixel.setRed(red);
        currentPixel.setGreen(green);
        currentPixel.setBlue(blue);
      }
    }
  }

}
