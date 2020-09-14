package v2.music;
public class TimeModification {
  private int normalNotes;
  private int actualNotes;
  private String normalType;
  private boolean isNormalDot;
  public TimeModification(int normalNotes, int ActualNotes) {
    this.normalNotes = normalNotes;
    this.actualNotes = actualNotes;
    this.normalType = null;
    this.isNormalDot = true;
  }
  public TimeModification(int normalNotes, int actualNotes, String normalType, boolean isNormalDot) {
    this.normalNotes = normalNotes;
    this.actualNotes = actualNotes;
    this.normalType = normalType;
    this.isNormalDot = isNormalDot;
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
  public boolean getIsNormalDot() {
    return this.isNormalDot;
  }
}
