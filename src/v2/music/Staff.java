package v2.music;
import java.util.ArrayList;
public class Staff {
  int staffNumber;
  public Staff(int number) {
    this.staffNumber = number;
  }
  public int getStaffNumber() {
    return this.staffNumber;
  }
  ArrayList<Note> notes = new ArrayList<Note>();
  public ArrayList<Note> getNotes() {
    return this.notes;
  }
}
