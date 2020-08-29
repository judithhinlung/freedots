package freedots.braille.articulation;
import freedots.braille.articulation.ArticulationSign;

public class TenutoSign extends ArticulationSign {
  public TenutoSign() {
    super(braille(456, 236));
  }
  public String getDescription() {
    return "A tenuto sign";
  }
}
