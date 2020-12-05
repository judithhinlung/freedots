package v2.music;
public class Transpose {
  int chromaticStep = 0;
  int diatonicPitch = 0;
  int octaveChange = 0;
  int staffNumber = 0;
  public Transpose(int chromaticStep) {
    this.chromaticStep = chromaticStep;
  }
  public int getChromaticStep() {
    return this.chromaticStep;
  }
  public int getDiatonicPitch() {
    return this.diatonicPitch;
  }
  public void setDiatonicPitch(int diatonicPitch) {
    this.diatonicPitch = diatonicPitch;
  }
  public int getOctaveChange() {
    return this.octaveChange;
  }
  public void setOctaveChange(int octaveChange) {
    this.octaveChange = octaveChange;
  }
  public int getStaffNumber() {
    return this.staffNumber;
  }
  public void setStaffNumber(int number) {
    this.staffNumber = number;
  }
  boolean doubling = false;
  public boolean getDoubling() {
    return this.doubling;
  }
  public void setDoubling(boolean doubling) {
    this.doubling = doubling;
  }
}
