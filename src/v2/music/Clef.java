package v2.music;
public class Clef {
  String sign;
  int line = 0;
  int clefOctaveChange = 0;
  Staff staff;
  public Clef(String sign) {
    this.sign = sign;
  }
  public Clef(String sign, int line) {
    this.sign = sign;
    this.line = line;
  }
  public String getSign() {
    return this.sign;
  }
  public int getLine() {
    return this.line;
  }
  public void setStaff(Staff staff) {
    this.staff = staff;
  }
  public Staff getStaff() {
    return this.staff;
  }
  int octaveChange = 0;
  public int getOctaveChange() {
    return this.octaveChange;
  }
  public void setOctaveChange(int octaveChange) {
    this.octaveChange = octaveChange;
  }
  public boolean isTrebleCleff() {
    return (this.sign == "G" && this.line == 2);
  }
  public boolean isBassCleff() {
    return (this.sign == "F" && this.line == 4);
  }
  public boolean isAltoCleff() {
    return (this.sign == "C" && this.line == 3);
  }
  public boolean isTab() {
    return this.line == 5;
  }
}
