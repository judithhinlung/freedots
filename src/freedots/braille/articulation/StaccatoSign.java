package freedots.braille.articulation;
import freedots.braille.articulation.ArticulationSign;

public class StaccatoSign extends ArticulationSign {
  public StaccatoSign() {
    super(braille(236));
  }
  public String getDescription() {
    return "A staccato sign";
  }
}
