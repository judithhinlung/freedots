package freedots.braille.articulation;

import freedots.braille.articulation.ArticulationSign;
public class MezzoStaccatoSign extends ArticulationSign {
  public MezzoStaccatoSign() {
    super(braille(5, 236));
  }
  public String getDescription() {
    return "A mezzo staccato sign";
  }
}
