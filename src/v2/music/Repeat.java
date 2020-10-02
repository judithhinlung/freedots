package v2.music;
public class Repeat {
  String direction;
  int times;
  public Repeat(String direction, int times) throws IllegalArgumentException {
    if (!Utils.contains(direction, validDirections)) {
      throw new IllegalArgumentException("Invalid repeat direction: " + direction);
    }
    this.direction = direction;
    this.times = times;
  }
  public Repeat() {
    this.direction = "forward";
    this.times = 1;
  }
  public String getDirection() {
    return this.direction;
  }
  public int getTimes() {
    return this.times;
  }
  private String[] validDirections = new String[]{"backward", "forward"};
}
