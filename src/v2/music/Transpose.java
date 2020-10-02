package v2.music;
public class Transpose {
  String step;
  String diatonicPitch;
  int chromatic = 0;
  int octaveChange = 0;
  int staffNumber = 0;
  public Transpose(String step) {
    this.step = step;
  }
  public String getStep() {
    return this.step;
  }
  public String getDiatonicPitch() {
    return this.diatonicPitch;
  }
  public void setDiatonicPitch(String pitch) {
    this.diatonicPitch = pitch;
  }
  public int getChromatic() {
    return this.chromatic;
  }
  public void setChromatic(int chromatic) {
    this.chromatic = chromatic;
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
}
