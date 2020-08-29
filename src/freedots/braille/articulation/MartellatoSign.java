package freedots.braille.articulation;

import freedots.braille.articulation.ArticulationSign;
public class MartellatoSign extends ArticulationSign {
  public MartellatoSign() {
    super(braille(56, 236));
  }
  public String getDescription() {
    return "A martellato (strong accent) sign";
  }
}
