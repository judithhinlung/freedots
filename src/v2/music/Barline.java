package v2.music;
public class Barline extends MeasureElement {
  Measure measure;
  String type;
  String location;
  public Barline(Measure measure) {
    super(measure);
    this.location = "left";
  }
  public Barline(Measure measure, String location) throws IllegalArgumentException {
    super(measure);
    if (!Utils.contains(location, validLocations)) {
      throw new IllegalArgumentException("Invalid barline location: " + location);
    }
    this.location = location;
  }
  public String getLocation(String location) {
    return this.location;
  }
  public void setLocation(String location) throws IllegalArgumentException {
    if (!Utils.contains(location, validLocations)) {
      throw new IllegalArgumentException("Invalid barline location: " + location);
    }
    this.location = location;
  }
  private String[] validLocations = new String[]{"left", "middle", "right"};
  private Ending ending;
  public Ending getEnding() {
    return this.ending;
  }
  public void setEnding(Ending ending) {
    this.ending = ending;
  }
  private int segno = -1;
  public int getSegno() {
    return this.segno;
  }
  public void setSegno(int segno) {
    this.segno = segno;
  }
  private int coda = -1;
  public int getCoda() {
    return this.coda;
  }
  public void setCoda(int coda) {
    this.coda = coda;
  }  
  private boolean hasFermata = false;
  public boolean getFermata() {
    return this.hasFermata;
  }
  public void setFermata(boolean fermata) {
    this.hasFermata = fermata;
  }
  private Repeat repeat = null;
  public Repeat getRepeat() {
    return this.repeat;
  }
  public void setRepeat(Repeat repeat) {
    this.repeat = repeat;
  }
  public static class Ending {
    int number;
    String type;
    public Ending(int number, String type) throws IllegalArgumentException {
      if (!Utils.contains(type, validTypes)) {
        throw new IllegalArgumentException("Unknown barline type: " + type);
      }
      this.type = type;
      this.number = number;
    }
    private String[] validTypes = new String[]{"start", "stop", "discontinue"};
    public int getNumber() {
      return this.number;
    }
    public String getType() {
      return this.type;
    }
  }

  public static class Repeat {
    String direction;
    int times = 0;
    public Repeat(String direction) throws IllegalArgumentException {
      if (!Utils.contains(direction, validDirections)) {
        throw new IllegalArgumentException("Unknown repeat direction: " + direction);
      }
      this.direction = direction;
    }
    private String[] validDirections = new String[]{"Forward", "backward"};
    public String getDirection() {
      return this.direction;
    }
    public int getTimes() {
      return this.times;
    }
    public void setTimes(int times) {
      this.times = times;
    }
  }
}
