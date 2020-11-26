package v2.music;
import java.util.ArrayList;
import freedots.math.Fraction;
public class Chord extends MeasureElement {
  ArrayList<Note> notes;
  public Chord(Measure measure) {
    super(measure);
    notes = new ArrayList<Note>();
  }
  public void addNote(Note note) {
    this.notes.add(note);
  }
  Fraction duration;
  public Fraction getDuration() {
    return this.duration;
  }
  public void setDuration(Fraction duration) {
    this.duration = duration;
  }
}
  
