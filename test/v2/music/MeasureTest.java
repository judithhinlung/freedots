package v2.music;
import java.util.ArrayList;
import freedots.math.Fraction;
import junit.framework.TestCase;
import org.junit.Test;
public class MeasureTest extends TestCase {
  //~ Static fields/initializers ---------------------------------------------
  //~ Methods ----------------------------------------------------------------
      //------//
  // main //
  //------//
  //-------//
  // setUp //
  //-------//
  @Override
  protected void setUp() {
    // TODO
  }
  //-----------------//
  //-------//
  // tearDown //
    //-------//
   @Override
  protected void tearDown () {
  }
  //-----------------//
  // checkMeasureInstantiation
  //-----------------//
  public void testMeasureInstantiation() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    assertEquals(m1.getPart().getId(), "p1");
    assertEquals(m1.getNumber(), 1);
  }

  // TestReturnsCorrectKeyAndTimeSignatures
  //-----------------//
  public void testReturnsCorrectKeyAndTimeWhenSpecifiedWithinMeasure() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    KeySignature key = new KeySignature(1);
    TimeSignature time = new TimeSignature(4, 4);
    m1.setKey(key);
    m1.setTime(time);
    assertEquals(m1.getKey().getType(), 1);
    assertEquals(m1.getTime(), new Fraction(4, 4));
  }
  public void testReturnsCorrectKeyAndTimeWhenSpecifiedInPreviousMeasure() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    KeySignature key = new KeySignature(1);
    TimeSignature time = new TimeSignature(4, 4);
    m1.setKey(key);
    m1.setTime(time);
    Measure m2 = new Measure(p1, 2);
    assertEquals(m2.getKey().getType(), 1);
    assertEquals(m2.getTime(), new Fraction(4, 4));
  }

  public void testReturnsCorrectKeyAndTimeWithKeyChange() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    m1.setKey(new KeySignature(-1));
    m1.setTime(new TimeSignature(4, 4));
    Measure m2 = new Measure(p1, 2);
    m2.setKey(new KeySignature(1));
    m2.setTime(new TimeSignature(3, 4));
    Measure m3 = new Measure(p1, 3);
    assertEquals(m3.getKey().getType(), 1);
    assertEquals(m3.getTime(), new Fraction(3, 4));
  }
  // TestCalculateDivisionsPerQuarterNoteFromMusicDurations
  //-----------------//
  public void testCalculateDivisions() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    Note note1 = new Note(m1);
    note1.setDuration(new Fraction(1, 4));
    Note note2 = new Note(m1);
    note2.setDuration(new Fraction(1, 4));
    Note note3 = new Note(m1);
    note3.setDuration(new Fraction(1, 4));
    Note note4 = new Note(m1);
    note4.setDuration(new Fraction(1, 4));
    Note note5 = new Note(m1);
    note5.setDuration(new Fraction(1, 16));
    Note note6 = new Note(m1);
    note6.setDuration(new Fraction(1, 4));
    m1.addNote(note1);
    m1.addNote(note2);
    m1.addNote(note3);
    m1.addNote(note4);
    m1.addNote(note5);
    m1.addNote(note6);
    assertEquals(m1.calculateDivisions(), 4);
  }

  public void testCalculateDivisionsWithTimeModification() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    Note note1 = new Note(m1);
    note1.setDuration(new Fraction(1, 4));
    Note note2 = new Note(m1);
    note2.setDuration(new Fraction(1, 4));
    Note note3 = new Note(m1);
    note3.setDuration(new Fraction(1, 4));
    note3.setTimeModification(new TimeModification(2, 3));
    Note note4 = new Note(m1);
    note4.setDuration(new Fraction(1, 4));
    note4.setTimeModification(new TimeModification(2, 3));
    Note note5 = new Note(m1);
    note5.setDuration(new Fraction(1, 4));
    note5.setTimeModification(new TimeModification(2, 3));
    m1.addNote(note1);
    m1.addNote(note2);
    m1.addNote(note3);
    m1.addNote(note4);
    m1.addNote(note5);
    ArrayList<Fraction> durations = m1.getDurationsList();
    assertEquals(m1.calculateDivisions(), 3);
  }

    // CheckForCompleteMeasure
  //-----------------
  public void checkCompleteMeasure() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    m1.setTime(new TimeSignature(4, 4));
    Note note1 = new Note(m1);
    note1.setDuration(new Fraction(1, 4));
    Note note2 = new Note(m1);
    note2.setDuration(new Fraction(1, 4));
    Note note3 = new Note(m1);
    note3.setDuration(new Fraction(1, 4));
    m1.addNote(note1);
    m1.addNote(note2);
    m1.addNote(note3);
    assertFalse(m1.isCompleteMeasure());//
    Note note4 = new Note(m1);
    note4.setDuration(new Fraction(1, 8));
    Note note5 = new Note(m1);    note5.setDuration(new Fraction(1, 8));
    assertTrue(m1.isCompleteMeasure());
  }
}
