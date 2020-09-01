package freedots.braille.articulation;

import freedots.braille.articulation.ArticulationSign;
public class AccentSign extends ArticulationSign {
  public AccentSign() {
    super(braille(46, 236));
  }
  public String getDescription() { return "An accent sign";
  }
}
