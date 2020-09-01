/* -*- c-basic-offset: 2; indent-tabs-mode: nil; -*- */
/*
 * FreeDots -- MusicXML to braille music transcription
 *
 * Copyright 2008-2010 Mario Lang  All Rights Reserved.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details (a copy is included in the LICENSE.txt file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License
 * along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * this file is maintained by Mario Lang <mlang@delysid.org>.
 */
/**
 * @param type 1 = repeated-note, 2 = alternation
 * @param val Nove value of the repetition or alternation, in divisions of quarter note.
*/
package freedots.braille.ornament;
import freedots.braille.BrailleList;
import freedots.braille.Sign;
public class BrailleTremolo extends BrailleList {
  private int type;
  private int val;
  public BrailleTremolo(int type, final int val) {
    super();
    this.type = type;
    this.val = val;
    if (type == 1) {
      add(new RepeatedNoteTremoloSign());
    }
    else if (type == 2) {
      add(new AlternationTremoloSign());
    }
    add(new NoteValueSign(val));
  }

  public static class RepeatedNoteTremoloSign extends Sign {
    public RepeatedNoteTremoloSign() {
      super(braille(45));
    }
    public String getDescription() {
      return "A repeated-note tremolo sign";
    }
  }

  public static class AlternationTremoloSign extends Sign {
    public AlternationTremoloSign() {
      super(braille(46));
    }
    public String getDescription() {
      return "An alternation tremolo sign";
    }
  }

  public static class NoteValueSign extends Sign {
    private final int val;
    public NoteValueSign(final int val) {
      super(NOTEVALUES[val-1]);
      this.val = val;
    }

    public String getDescription() {
      return "Tremolo in " + noteValueNames[val-1];
    }

    private static final String[] NOTEVALUES = new String[] {braille(1), braille(12), braille(123), braille(5), braille(13), braille(3)};

    private static final String[] noteValueNames = new String[] {"8ths", "16ths", "32ths", "64ths", "128ths"};
  }
}
