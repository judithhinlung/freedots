package v2.music;
/** Miscellaneous ornaments
  */
public class Ornament {
  String type;
  Accidental accidental;
  public Ornament(String type) throws IllegalArgumentException {
    if (!Utils.contains(type, validTypes)) {
	throw new IllegalArgumentException("Unknown ornament: " + type);
    }
    this.type = type;
  }
  public void setAccidental(Accidental accidental) {
    this.accidental = accidental;
  }
  public String getOrnament() {
    return this.type;
  }
  public String getAccidental() {
    return this.accidental.getAccidental();
  }
  private String[] validTypes = new String[]{"trill", "turn", "delayedTurn", "invertedTurn", "delayedInvertedTurn", "verticalTurn", "invertedVerticalTurn", "shake", "wavyLine", "mordent", "invertedMordent", "schleifer", "tremolo", "haydn", "accidentalMark"};
}
