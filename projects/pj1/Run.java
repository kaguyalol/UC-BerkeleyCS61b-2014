public class Run {

  public short red;
  public short green;
  public short blue;
  public int runLength;
  public Run prev;
  public Run next;

  Run () {
    red = (short) 0;
    green = (short) 0;
    blue = (short) 0;
    runLength = 1;
    prev = null;
    next = null;
  }

  Run (short red, short green, short blue, int runLength) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.runLength = runLength;
    prev = null;
    next = null;
  }
}