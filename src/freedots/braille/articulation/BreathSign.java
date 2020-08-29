package freedots.braille.articulation;
import freedots.braille.articulation.ArticulationSign;
public class BreathSign extends ArticulationSign {
  public BreathSign() {
    super(braille(6, 34));
  }
  public String getDescription() {
    return "A breath mark";
  }
}
