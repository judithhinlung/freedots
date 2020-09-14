package v2.music;
/** Miscellaneous ornaments
  */
public class Ornament {
  private String ornament;
  private Accidental accidental;
  public Ornament(String ornament) throws IllegalArgumentException {
    if (!Utils.contains(ornament, validOrnaments)) {
	throw new IllegalArgumentException("Unknown ornament: " + ornament);
    }
    this.ornament = ornament;
  }
  public void setAccidental(Accidental accidental) {
    this.accidental = accidental;
  }
  public String getOrnament() {
    return this.ornament;
  }
  public String getAccidental() {
    return this.accidental.getAccidental();
  }
    // private String[] validOrnaments = new String[]{"trill", "turn", "delayedTurn", "invertedTurn", "delayedInvertedTurn", verticalTturn", "invertedVerticalTurn", "shake", "wavyLine", "mordent", "invertedMordent", "schleifer", "tremolo", "haydn", "accidentalMark"};
}
