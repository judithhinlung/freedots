package v2.music.format;
import v2.music.Utils;
public class Orientation extends Placement {
  String orientation;
  public Orientation(String orientation) throws IllegalArgumentException {
    super(orientation);
  }
    private String[] validTypes = new String[]{"Over", "under"};
}
