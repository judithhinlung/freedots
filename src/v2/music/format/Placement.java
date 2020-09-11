package v2.music.format;
import v2.music.Utils;
public class Placement {
  String placement;
  public Placement(String placement) throws IllegalArgumentException {
      if (!Utils.contains(placement, validTypes)) {
      throw new IllegalArgumentException("Invalid placement: " + placement);
    }
    this.placement = placement;
  }
  private String[] validTypes = new String[]{"above", "below"};
}
