package v2.music;
public class Lyric {
  /**
  * @param text   lyric text
  * @param syllabic  representing  single, begin (word-beginning), middle (mid-word), end (word-ending) syllables
  * @param isExtended  indicates a word extension across multiple notes
  * @param elision  separates multiple syllables on a single note
  */
  String text;
  String syllabic;
  boolean isExtended;
  boolean hasElision;   
  String[] syllabicTypes = new String[]{"single", "begin", "middle", "end"};
  public Lyric(String text) {
    this.text = text;
  }
  public Lyric(String text, String syllabic) throws IllegalArgumentException {
    if (!Utils.contains(syllabic, syllabicTypes)) {
      throw new IllegalArgumentException("Unknown syllabic type: " + syllabic);
    }
    this.text = text;
    this.syllabic = syllabic;
  }    public Lyric(String text, String syllabic, boolean hasElision, boolean isExtended) throws IllegalArgumentException {
    if (!Utils.contains(syllabic, syllabicTypes)) {
      throw new IllegalArgumentException("Unknown syllabic type: " + syllabic);
    }
    this.text = text;
    this.syllabic = syllabic;
    this.hasElision = hasElision;
    this.isExtended = isExtended;
  }
  public String getText() {
    return this.text;
  }
  public String getSyllabic() {
    return this.syllabic;
  }
  public boolean getElision() {
    return this.hasElision;
  }
  public boolean getExtended() {
    return this.isExtended;
  }
}
