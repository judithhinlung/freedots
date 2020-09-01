package freedots.braille.articulation;

import freedots.braille.articulation.ArticulationSign;
public class StaccatissimoSign extends ArticulationSign {
  public StaccatissimoSign() {
    super(braille(6, 236));
  }
  public String getDescription() {
    return "A staccatissimo sign";
  }
}
