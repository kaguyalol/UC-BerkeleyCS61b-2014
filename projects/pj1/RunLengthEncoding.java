/* RunLengthEncoding.java */

/**
 * The RunLengthEncoding class defines an object that run-length encodes
 * a PixImage object.  Descriptions of the methods you must implement appear
 * below.  They include constructors of the form
 * <p>
 * public RunLengthEncoding(int width, int height);
 * public RunLengthEncoding(int width, int height, int[] red, int[] green,
 * int[] blue, int[] runLengths) {
 * public RunLengthEncoding(PixImage image) {
 * <p>
 * that create a run-length encoding of a PixImage having the specified width
 * and height.
 * <p>
 * The first constructor creates a run-length encoding of a PixImage in which
 * every pixel is black.  The second constructor creates a run-length encoding
 * for which the runs are provided as parameters.  The third constructor
 * converts a PixImage object into a run-length encoding of that image.
 * <p>
 * See the README file accompanying this project for additional details.
 */

import java.util.Iterator;

public class RunLengthEncoding implements Iterable {

  /**
   * Define any variables associated with a RunLengthEncoding object here.
   * These variables MUST be private.
   */
  private Run head;
  private Run tail;
  private long numOfRecords;
  private int width;
  private int height;


  /**
   *  The following methods are required for Part II.
   */

  /**
   * RunLengthEncoding() (with two parameters) constructs a run-length
   * encoding of a black PixImage of the specified width and height, in which
   * every pixel has red, green, and blue intensities of zero.
   *
   * @param width  the width of the image.
   * @param height the height of the image.
   */

  public RunLengthEncoding(int width, int height) {
    // Your solution here.
    this(width, height, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{width * height});
  }

  /**
   * RunLengthEncoding() (with six parameters) constructs a run-length
   * encoding of a PixImage of the specified width and height.  The runs of
   * the run-length encoding are taken from four input arrays of equal length.
   * Run i has length runLengths[i] and RGB intensities red[i], green[i], and
   * blue[i].
   *
   * @param width      the width of the image.
   * @param height     the height of the image.
   * @param red        is an array that specifies the red intensity of each run.
   * @param green      is an array that specifies the green intensity of each run.
   * @param blue       is an array that specifies the blue intensity of each run.
   * @param runLengths is an array that specifies the length of each run.
   *                   <p>
   *                   NOTE:  All four input arrays should have the same length (not zero).
   *                   All pixel intensities in the first three arrays should be in the range
   *                   0...255.  The sum of all the elements of the runLengths array should be
   *                   width * height.  (Feel free to quit with an error message if any of these
   *                   conditions are not met--though we won't be testing that.)
   */

  public RunLengthEncoding(int width, int height, int[] red, int[] green,
                           int[] blue, int[] runLengths) {
    // Your solution here.
    this.width = width;
    this.height = height;
    int sum = 0;

    for (int i = 0; i < runLengths.length; i++) {
      insertEnd((short) red[i], (short) green[i],
          (short) blue[i], runLengths[i]);
      sum += runLengths[i];
    }

    if (sum > width * height) {
      System.out.println("Invalid input runLengths!");
      System.exit(0);
    }
  }

  private void insertEnd(short r, short g, short b, int runLength) {
    if (head == null) {
      head = new Run(r, g, b, runLength);
      tail = head;
    } else {
      tail.next = new Run(r, g, b, runLength);
      tail.next.prev = tail;
      tail = tail.next;
    }
    numOfRecords++;
  }

  private void insertFront(short r, short g, short b, int runLength) {
    if (head == null) {
      head = new Run(r, g, b, runLength);
      tail = head;
    } else {
      head.prev = new Run(r, g, b, runLength);
      head.prev.next = head;
      head = head.prev;
    }
    numOfRecords++;
  }

  /**
   * getWidth() returns the width of the image that this run-length encoding
   * represents.
   *
   * @return the width of the image that this run-length encoding represents.
   */

  public int getWidth() {
    // Replace the following line with your solution.
    return width;
  }

  /**
   * getHeight() returns the height of the image that this run-length encoding
   * represents.
   *
   * @return the height of the image that this run-length encoding represents.
   */
  public int getHeight() {
    // Replace the following line with your solution.
    return height;
  }

  /**
   * iterator() returns a newly created RunIterator that can iterate through
   * the runs of this RunLengthEncoding.
   *
   * @return a newly created RunIterator object set to the first run of this
   * RunLengthEncoding.
   */
  public RunIterator iterator() {
    // Replace the following line with your solution.
    RunIterator runIterator = new RunIterator(head);

    return runIterator;
    // You'll want to construct a new RunIterator, but first you'll need to
    // write a constructor in the RunIterator class.
  }

  /**
   * toPixImage() converts a run-length encoding of an image into a PixImage
   * object.
   *
   * @return the PixImage that this RunLengthEncoding encodes.
   */
  public PixImage toPixImage() {
    // Replace the following line with your solution.
    int x = 0, y = 0;
    int length;
    PixImage pixImage = new PixImage(width, height);
    Run dummy = head;

    while (dummy != null) {
      length = dummy.runLength;

      while (length > 0) {
        pixImage.setPixel(x, y, (short) dummy.red, (short) dummy.green, (short) dummy.blue);
        length--;

        if (x >= width - 1) {
          y++;
          x = 0;
        } else {
          x++;
        }
      }

      dummy = dummy.next;

    }
    return pixImage;
  }

  /**
   * toString() returns a String representation of this RunLengthEncoding.
   * <p>
   * This method isn't required, but it should be very useful to you when
   * you're debugging your code.  It's up to you how you represent
   * a RunLengthEncoding as a String.
   *
   * @return a String representation of this RunLengthEncoding.
   */
  public String toString() {
    // Replace the following line with your solution.
    String s = "";
    Run dummy = head;

    while (dummy != null) {
      s += "[";
      s += dummy.red;
      s += ",";
      s += dummy.runLength;
      s += "],";
      dummy = dummy.next;
    }
    return s;
  }


  /**
   *  The following methods are required for Part III.
   */

  /**
   * RunLengthEncoding() (with one parameter) is a constructor that creates
   * a run-length encoding of a specified PixImage.
   * <p>
   * Note that you must encode the image in row-major format, i.e., the second
   * pixel should be (1, 0) and not (0, 1).
   *
   * @param image is the PixImage to run-length encode.
   */
  public RunLengthEncoding(PixImage image) {
    // Your solution here, but you should probably leave the following line
    // at the end.
    height = image.getHeight();
    width = image.getWidth();
    int cnt = 1, r = -1, g = -1, b = -1;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {

        if (x == 0 && y == 0) {
          r = image.getRed(x, y);
          g = image.getGreen(x, y);
          b = image.getBlue(x, y);
          continue;
        }

        if (r == image.getRed(x, y) && g == image.getGreen(x, y) && b == image.getBlue(x, y)) {
          cnt++;

        } else {
          insertEnd((short) r, (short) g, (short) b, cnt);
          cnt = 1;
          r = image.getRed(x, y);
          g = image.getGreen(x, y);
          b = image.getBlue(x, y);
        }

        if (x == width - 1 && y == height - 1) {
          insertEnd((short) r, (short) g, (short) b, cnt);
        }

      }
    }
    // System.out.println(toString());
    check();
  }

  /**
   * check() walks through the run-length encoding and prints an error message
   * if two consecutive runs have the same RGB intensities, or if the sum of
   * all run lengths does not equal the number of pixels in the image.
   */
  public void check() {
    // Your solution here.
    int runLengths = 0, r = -1, g = -1, b = -1;
    Run dummy = head;

    while (dummy != null) {
      if (dummy.red == r && dummy.green == g && dummy.blue == b) {
        System.out.println("Consecutive Runs Error!");
      }
      if (runLengths > width * height) System.out.println("Total Run Length Error!");
      if (dummy.runLength < 1) System.out.println("Single Run Length Error!");
      runLengths += dummy.runLength;
      dummy = dummy.next;
    }
  }


  /**
   *  The following method is required for Part IV.
   */

  /**
   * setPixel() modifies this run-length encoding so that the specified color
   * is stored at the given (x, y) coordinates.  The old pixel value at that
   * coordinate should be overwritten and all others should remain the same.
   * The updated run-length encoding should be compressed as much as possible;
   * there should not be two consecutive runs with exactly the same RGB color.
   *
   * @param x     the x-coordinate of the pixel to modify.
   * @param y     the y-coordinate of the pixel to modify.
   * @param red   the new red intensity to store at coordinate (x, y).
   * @param green the new green intensity to store at coordinate (x, y).
   * @param blue  the new blue intensity to store at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here, but you should probably leave the following line
    //   at the end.
    Run dummy = head;
    int len = y * width + x - dummy.runLength;
    System.out.println(toString());
    while (len >= 0) {
      dummy = dummy.next;
      len -= dummy.runLength;
    }

    if (dummy.red != red || dummy.green != green || dummy.blue != blue) {
      if ((dummy == head && len + dummy.runLength == 0) || (dummy == tail && len == -1)) {
        if (dummy.runLength == 1) {
          dummy.red = red;
          dummy.green = green;
          dummy.blue = blue;
        } else {
          Run newR = new Run(red, green, blue, 1);
          dummy.runLength -= 1;
          if (dummy == head) {
            insertFront(red, green, blue, 1);
          } else {
            insertEnd(red, green, blue, 1);
          }
        }
      } else {

        if (dummy.runLength == 1) {

          if (dummy.prev.red == red && dummy.prev.green == green && dummy.prev.blue == blue &&
              dummy.next.red == red && dummy.next.green == green && dummy.next.blue == blue) {
            dummy.prev.next = dummy.next.next;
            dummy.next.next.prev = dummy.prev;
            dummy.prev.runLength += 1 + dummy.next.runLength;
          } else if (
              dummy.prev.red == red && dummy.prev.green == green && dummy.prev.blue == blue &&
                  (dummy.next.red != red || dummy.next.green != green || dummy.next.blue != blue)) {
            dummy.prev.next = dummy.next;
            dummy.next.prev = dummy.prev;
            dummy.prev.runLength += 1;
          } else if (
              dummy.next.red == red && dummy.next.green == green && dummy.next.blue == blue &&
                  (dummy.prev.red != red || dummy.prev.green != green || dummy.prev.blue != blue)) {
            dummy.prev.next = dummy.next;
            dummy.next.prev = dummy.prev;
            dummy.next.runLength += 1;
          } else {
            dummy.red = red;
            dummy.green = green;
            dummy.blue = blue;
          }
        } else {
          Run newRun = new Run((short) red, (short) green, (short) blue, 1);

          if (len + dummy.runLength == 0) {
            if (dummy.prev.red == red && dummy.prev.green == green && dummy.prev.blue == blue) {
              dummy.prev.runLength += 1;
              dummy.runLength -= 1;
            } else {
              dummy.prev.next = newRun;
              dummy.prev.next.next = dummy;
              dummy.prev.next.prev = dummy.prev;
              dummy.prev = dummy.prev.next;
              dummy.runLength -= 1;
            }
          } else if (len == -1) {
            if (dummy.next.red == red && dummy.next.green == green && dummy.next.blue == blue) {
              dummy.next.runLength += 1;
              dummy.runLength -= 1;
            } else {
              dummy.next.prev = newRun;
              dummy.next.prev.next = dummy.next;
              dummy.next = dummy.next.prev;
              dummy.next.prev = dummy;
              dummy.runLength -= 1;
            }
          } else {
            Run newRun2 = new Run(
                (short) dummy.red, (short) dummy.green, (short) dummy.blue,
                -len - 1);
            dummy.runLength += len; // -= (1 + (-len));
            newRun2.next = dummy.next;
            newRun.next = newRun2;
            newRun2.prev = newRun;
            dummy.next.prev = newRun2;
            dummy.next = newRun;
            newRun.prev = dummy;
          }
        }
      }
    }
    check();
  }


  /**
   * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
   * You are welcome to add tests, though.  Methods below this point will not
   * be tested.  This is not the autograder, which will be provided separately.
   */


  /**
   * doTest() checks whether the condition is true and prints the given error
   * message if it is not.
   *
   * @param b   the condition to check.
   * @param msg the error message to print if the condition is false.
   */
  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  /**
   * array2PixImage() converts a 2D array of grayscale intensities to
   * a grayscale PixImage.
   *
   * @param pixels a 2D array of grayscale intensities in the range 0...255.
   * @return a new PixImage whose red, green, and blue values are equal to
   * the input grayscale intensities.
   */
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
            (short) pixels[x][y]);
      }
    }

    return image;
  }

  /**
   * setAndCheckRLE() sets the given coordinate in the given run-length
   * encoding to the given value and then checks whether the resulting
   * run-length encoding is correct.
   *
   * @param rle       the run-length encoding to modify.
   * @param x         the x-coordinate to set.
   * @param y         the y-coordinate to set.
   * @param intensity the grayscale intensity to assign to pixel (x, y).
   */
  private static void setAndCheckRLE(RunLengthEncoding rle,
                                     int x, int y, int intensity) {
    rle.setPixel(x, y,
        (short) intensity, (short) intensity, (short) intensity);
    rle.check();
  }

  /**
   * main() runs a series of tests of the run-length encoding code.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    PixImage image1 = array2PixImage(new int[][]{{0, 3, 6},
        {1, 4, 7},
        {2, 5, 8}});

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
        "on a 3x3 image.  Input image:");
    System.out.print(image1);
    RunLengthEncoding rle1 = new RunLengthEncoding(image1);
    rle1.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle1.getWidth() == 3 && rle1.getHeight() == 3,
        "RLE1 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(image1.equals(rle1.toPixImage()),
        "image1 -> RLE1 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 42);
    image1.setPixel(0, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           /*
                       array2PixImage(new int[][] { { 42, 3, 6 },
                                                    { 1, 4, 7 },
                                                    { 2, 5, 8 } })),
           */
        "Setting RLE1[0][0] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 0, 42);
    image1.setPixel(1, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
        "Setting RLE1[1][0] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 1, 2);
    image1.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle1.toPixImage().equals(image1),
        "Setting RLE1[0][1] = 2 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 0);
    image1.setPixel(0, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle1.toPixImage().equals(image1),
        "Setting RLE1[0][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 7);
    image1.setPixel(2, 2, (short) 7, (short) 7, (short) 7);
    doTest(rle1.toPixImage().equals(image1),
        "Setting RLE1[2][2] = 7 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 42);
    image1.setPixel(2, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
        "Setting RLE1[2][2] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 2, 42);
    image1.setPixel(1, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
        "Setting RLE1[1][2] = 42 fails.");


    PixImage image2 = array2PixImage(new int[][]{{2, 3, 5},
        {2, 4, 5},
        {3, 4, 6}});

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
        "on another 3x3 image.  Input image:");
    System.out.print(image2);
    RunLengthEncoding rle2 = new RunLengthEncoding(image2);
    rle2.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle2.getWidth() == 3 && rle2.getHeight() == 3,
        "RLE2 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(rle2.toPixImage().equals(image2),
        "image2 -> RLE2 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 0, 1, 2);
    image2.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
        "Setting RLE2[0][1] = 2 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 2, 0, 2);
    image2.setPixel(2, 0, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
        "Setting RLE2[2][0] = 2 fails.");


    PixImage image3 = array2PixImage(new int[][]{{0, 5},
        {1, 6},
        {2, 7},
        {3, 8},
        {4, 9}});

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
        "on a 5x2 image.  Input image:");
    System.out.print(image3);
    RunLengthEncoding rle3 = new RunLengthEncoding(image3);
    rle3.check();
    System.out.println("Testing getWidth/getHeight on a 5x2 encoding.");
    doTest(rle3.getWidth() == 5 && rle3.getHeight() == 2,
        "RLE3 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 5x2 encoding.");
    doTest(rle3.toPixImage().equals(image3),
        "image3 -> RLE3 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 4, 0, 6);
    image3.setPixel(4, 0, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
        "Setting RLE3[4][0] = 6 fails.");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 1, 6);
    image3.setPixel(0, 1, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
        "Setting RLE3[0][1] = 6 fails.");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 0, 1);
    image3.setPixel(0, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle3.toPixImage().equals(image3),
        "Setting RLE3[0][0] = 1 fails.");


    PixImage image4 = array2PixImage(new int[][]{{0, 3},
        {1, 4},
        {2, 5}});

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
        "on a 3x2 image.  Input image:");
    System.out.print(image4);
    RunLengthEncoding rle4 = new RunLengthEncoding(image4);
    rle4.check();
    System.out.println("Testing getWidth/getHeight on a 3x2 encoding.");
    doTest(rle4.getWidth() == 3 && rle4.getHeight() == 2,
        "RLE4 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x2 encoding.");
    doTest(rle4.toPixImage().equals(image4),
        "image4 -> RLE4 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 2, 0, 0);
    image4.setPixel(2, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
        "Setting RLE4[2][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 0);
    image4.setPixel(1, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
        "Setting RLE4[1][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 1);
    image4.setPixel(1, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle4.toPixImage().equals(image4),
        "Setting RLE4[1][0] = 1 fails.");
  }
}
