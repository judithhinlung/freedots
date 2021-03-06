/* -*- c-basic-offset: 2; -*- */

import java.awt.Color;
import freedots.braille.articulation.AccentSign;
import freedots.braille.BrailleNote;
import freedots.braille.DoubleBarSign;
import freedots.gui.SignColorMap;

public class ColorTest extends junit.framework.TestCase {
  public void testColorLookup() {
    SignColorMap scm = SignColorMap.DEFAULT;
    assertEquals("accent color", new Color(0, 250, 154),
                                 scm.get(AccentSign.class));
    assertEquals("double bar color", new Color(255, 126, 0),
                                     scm.get(DoubleBarSign.class));
  }
}

