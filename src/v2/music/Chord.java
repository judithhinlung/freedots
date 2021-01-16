package v2.music;
import java.util.ArrayList;
import freedots.math.Fraction;
public class Chord extends MeasureElement {
  ArrayList<Note> notes;
  public Chord(Measure measure) {
    super(measure);
    notes = new ArrayList<Note>();
  }
  public ArrayList<Note> getNotes() {
    return this.notes;
  }
  public void addNote(Note note) {
    this.notes.add(note);
  }
  public void setDuration(Fraction duration) {
    this.duration = duration;
  }
  public int getStaff() {
    return this.notes.get(0).getStaff();
  }
  public int getVoice() {
    return this.notes.get(0).getVoice();
  }
}
  
