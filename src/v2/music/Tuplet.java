package v2.music;
public class Tuplet {
  private int normalNotes;
  private int actualNotes;
  public Tuplet(int normalNotes, int actualNotes) {
    this.normalNotes = normalNotes;
    this.actualNotes = actualNotes;
  }
  public int getNormalNotes() {
    return this.normalNotes;
  }
  public int getActualNotes() {
    return this.actualNotes;
  }
}
