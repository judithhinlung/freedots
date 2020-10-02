package v2.music;
public class Barline {
  String type;
  public Barline(String type) throws IllegalArgumentException {
    if (!Utils.contains(type, validTypes)) {
      throw new IllegalArgumentException("Unknown barline type: " + type);
    }
    this.type = type;
  }
  private String[] validTypes = new String[]{"start", "stop", "discontinue"};
  private String location = "right";
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
  private int ending;
  public int getEnding() {
    return this.ending;
  }
  public void setEnding(int ending) {
    this.ending = ending;
  }
  private boolean hasSegno = false;
  public boolean getSegno() {
    return this.hasSegno;
  }
  public void setSegno(boolean segno) {
    this.hasSegno = segno;
  }
  private boolean hasCoda = false;
  public boolean getCoda() {
    return this.hasCoda;
  }
  public void setCoda(boolean coda) {
    this.hasCoda = coda;
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
}
