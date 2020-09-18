package v2.music;
public class TimeModification {
  int normalNotes;
  int actualNotes;
  String normalType;
  public TimeModification(int normalNotes, int ActualNotes) {
    this.normalNotes = normalNotes;
    this.actualNotes = actualNotes;
    this.normalType = null;
  }
  public TimeModification(int normalNotes, int actualNotes, String normalType) {
    this.normalNotes = normalNotes;
    this.actualNotes = actualNotes;
    this.normalType = normalType;
  }
  public int getNormalNotes() {
    return this.normalNotes;
  }
  public int getActualNotes() {
    return this.actualNotes;
  }
  public String getNormalType() {
      return this.normalType;
  }
}
