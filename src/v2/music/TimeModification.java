package v2.music;
public class TimeModification {
  int normalNotes;
  int actualNotes;
    Type normalType;
    boolean normalDot;
    public TimeModification(int normalNotes, int ActualNotes,
			    Type normalType, boolean normalDot) {
    this.normalNotes = normalNotes;
    this.actualNotes = actualNotes;
    this.normalType = normalType;
    this.normalDot = true;
    }
    public int getNormalNotes() {
	return this.normalNotes;
    }
    public int getActualNotes() {
	return this.actualNotes;
    }String getNormalType() {
	return this.normalType.getType();
    }

  }
