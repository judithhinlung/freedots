/* -*- c-basic-offset: 2; indent-tabs-mode: nil; -*- */
import freedots.Braille;
import freedots.music.Fingering;

import freedots.braille.BrailleFingering;
import freedots.braille.ornament.BrailleTremolo;
public class TestBraille extends junit.framework.TestCase {
  // Helper methods
  // Converts a braille dot pattern to ISO 11548-1.
  protected static final int dotsToBits(final int dots) {
    int bits = 0;
    for (int decimal = dots; decimal > 0; decimal /= 10) {
      bits |= 1 << ((decimal % 10) - 1);
    }
    return bits;
  }
  protected static final int UNICODE_BRAILLE_MASK = 0X2800;
  protected static String braille(final int dots) {
    return String.valueOf((char)(UNICODE_BRAILLE_MASK|dotsToBits(dots)));
  }
  // Tests
  public void testFingering() {
    Fingering fingering = new Fingering();

    fingering.getFingers().add(1);

    assertEquals("1st finger", new BrailleFingering(fingering).toString(), "⠁");
  }

  public void testTremolo() {

    BrailleTremolo t = new BrailleTremolo(1, 1);
    assertEquals(t.toString(), (braille(45) + braille(1)));
    t = new BrailleTremolo(2, 5);
    assertEquals(t.toString(), (braille(46) + braille(13)));
  }
}
