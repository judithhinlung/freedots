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
    assertEquals(m1.getStaves().size(), 1);
  }

  public void testMeasureInstantiationWithOneStaffAndVoice() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    Pitch pitch = new Pitch("p", 4, 0);
    Note note1 = new Note(m1, pitch, new Fraction(1, 4));
    Note note2 = new Note(m1, pitch, new Fraction(1, 4));
    Note note3 = new Note(m1, pitch, new Fraction(1, 2));
    m1.addElement(note1);
    m1.addElement(note2);
    m1.addElement(note3);
    assertEquals(m1.getStaves().size(), 1);
    Staff staff = m1.getStaff(1);
    assertEquals(staff.getVoices().size(), 1);
    assertTrue(staff.hasVoice(1));
    Voice voice = staff.getVoice(1);
    assertEquals(voice.getElements().size(), 3);
  }
  public void testMeasureInstantiationWithOneStaffAnMultipleVoices() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    Pitch pitch = new Pitch("p", 4, 0);
    Note note1 = new Note(m1, pitch, new Fraction(1, 4));
    Note note2 = new Note(m1, pitch, new Fraction(1, 4));
    Note note3 = new Note(m1, pitch, new Fraction(1, 2));
    m1.addElement(note1);
    m1.addElement(note2);
    m1.addElement(note3);
    assertEquals(m1.getStaves().size(), 1);
    Staff staff = m1.getStaff(1);
    assertTrue(staff.hasVoice(1));
    Voice voice = staff.getVoice(1);
    assertEquals(voice.getElements().size(), 3);
    assertFalse(staff.hasVoice(2));
    Note note4 = new Note(m1, pitch, new Fraction(1, 2));
    note4.setVoice(2);
    Note note5 = new Note(m1, pitch, new Fraction(1, 4));
    note5.setVoice(2);
    Note note6 = new Note(m1, pitch, new Fraction(1, 4));
    note6.setVoice(2);
    m1.addElement(note4);
    m1.addElement(note5);
    m1.addElement(note6);
    assertEquals(staff.getVoices().size(), 2);
    assertTrue(staff.hasVoice(2));
  }
  public void testMeasureInstantiationWithTwoStavesAnTwoVoices() {
    Part p1 = new Part("p1");
    p1.setStaves(2);
    Measure m1 = new Measure(p1, 1);
    Pitch pitch = new Pitch("p", 4, 0);
    Note note1 = new Note(m1, pitch, new Fraction(1, 4));
    Note note2 = new Note(m1, pitch, new Fraction(1, 4));
    Note note3 = new Note(m1, pitch, new Fraction(1, 2));
    m1.addElement(note1);
    m1.addElement(note2);
    m1.addElement(note3);
    Note note4 = new Note(m1, pitch, new Fraction(1, 2));
    note4.setStaff(2);
    note4.setVoice(2);
    Note note5 = new Note(m1, pitch, new Fraction(1, 4));
    note5.setStaff(2);
    note5.setVoice(2);
    Note note6 = new Note(m1, pitch, new Fraction(1, 4));
    note6.setStaff(2);
    note6.setVoice(2);
    m1.addElement(note4);
    m1.addElement(note5);
    m1.addElement(note6);
    assertEquals(m1.getStaves().size(), 2);
    Staff s1 = m1.getStaff(1);
    Staff s2 = m1.getStaff(2);
    assertTrue(s1.hasVoice(1));
    assertTrue(s2.hasVoice(2));
    Voice v1 = s1.getVoice(1);
    assertEquals(v1.getElements().size(), 3);
    assertTrue(s2.hasVoice(2));
    Voice v2 = s2.getVoice(2);
    assertEquals(v2.getElements().size(), 3);
  }
  public void testMeasureInstantiationWithTwoStavesAndTwoChords() {
    Part p1 = new Part("p1");
    p1.setStaves(2);
    Measure m1 = new Measure(p1, 1);
    Note note1 = new Note(m1, new Pitch("p", 4, 0), new Fraction(1, 4));
    Note note2 = new Note(m1, new Pitch("p", 4, 2), new Fraction(1, 4));
    Note note3 = new Note(m1, new Pitch("p", 4, 4), new Fraction(1, 2));
    Chord c1 = new Chord(m1);
    c1.addNote(note1);
    c1.addNote(note2);
    c1.addNote(note3);
    m1.addElement(c1);
    Note note4 = new Note(m1, new Pitch("p", 5, 0), new Fraction(1, 2));
    note4.setStaff(2);
    note4.setVoice(2);
    Note note5 = new Note(m1, new Pitch("p", 5, 2), new Fraction(1, 4));
    note5.setStaff(2);
    note5.setVoice(2);
    Note note6 = new Note(m1, new Pitch("p", 6, 0), new Fraction(1, 4));
    note6.setStaff(2);
    note6.setVoice(2);
    Chord c2 = new Chord(m1);
    c2.addNote(note4);
    c2.addNote(note5);
    c2.addNote(note6);
    m1.addElement(c2);
    assertEquals(m1.getStaves().size(), 2);
    Staff s1 = m1.getStaff(1);
    Staff s2 = m1.getStaff(2);
    assertTrue(s1.hasVoice(1));
    assertTrue(s2.hasVoice(2));
    Voice v1 = s1.getVoice(1);
    assertEquals(v1.getElements().size(), 1);
    assertTrue(s2.hasVoice(2));
    Voice v2 = s2.getVoice(2);
    assertEquals(v2.getElements().size(), 1);
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
    Pitch pitch = new Pitch("p", 4, 0);
    Note note1 = new Note(m1, pitch, new Fraction(1, 4));
    Note note2 = new Note(m1, pitch, new Fraction(1, 4));
    Note note3 = new Note(m1, pitch, new Fraction(1, 4));
    Note note4 = new Note(m1, pitch, new Fraction(1, 4));
    Note note5 = new Note(m1, pitch, new Fraction(1, 16));
    Note note6 = new Note(m1, pitch, new Fraction(1, 4));
    m1.addElement(note1);
    m1.addElement(note2);
    m1.addElement(note3);
    m1.addElement(note4);
    m1.addElement(note5);
    m1.addElement(note6);
    assertEquals(m1.getStaves().size(), 1);
    Staff staff = m1.getStaff(1);
    assertEquals(staff.getVoices().size(), 1);
    assertTrue(staff.hasVoice(1));
    Voice voice = staff.getVoice(1);
    // assertEquals(voice.getElements().size(), 6);
    assertEquals(m1.calculateDivisions(), 4);
  }
  
  public void testCalculateDivisionsWithTimeModification() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    Pitch pitch = new Pitch("p", 4, 0);
    Note note1 = new Note(m1, pitch, new Fraction(1, 4));
    Note note2 = new Note(m1, pitch, new Fraction(1, 4));
    Note note3 = new Note(m1, pitch, new Fraction(1, 4));
    note3.setTimeModification(new TimeModification(2, 3));
    Note note4 = new Note(m1, pitch, new Fraction(1, 4));
    note4.setTimeModification(new TimeModification(2, 3));
    Note note5 = new Note(m1, pitch, new Fraction(1, 4));
    note5.setTimeModification(new TimeModification(2, 3));
    m1.addElement(note1);
    m1.addElement(note2);
    m1.addElement(note3);
    m1.addElement(note4);
    m1.addElement(note5);
    ArrayList<Fraction> durations = m1.getDurationsList();
    assertEquals(m1.calculateDivisions(), 3);
  }

    // CheckForCompleteMeasure
  //-----------------
  public void checkCompleteMeasure() {
    Part p1 = new Part("p1");
    Measure m1 = new Measure(p1, 1);
    m1.setTime(new TimeSignature(4, 4));
    Pitch pitch = new Pitch("p", 3, 4);
    Note note1 = new Note(m1, pitch, new Fraction(1, 4));
    Note note2 = new Note(m1, pitch, new Fraction(1, 4));
    Note note3 = new Note(m1, pitch, new Fraction(1, 4));
    m1.addElement(note1);
    m1.addElement(note2);
    m1.addElement(note3);
    assertFalse(m1.isCompleteMeasure());//
    Note note4 = new Note(m1, pitch, new Fraction(1, 8));
    Note note5 = new Note(m1, pitch, new Fraction(1, 8));
    assertTrue(m1.isCompleteMeasure());
  }
}
