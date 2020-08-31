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
Note repetition values are in divisions of quarter note.
*/
package freedots.braille.ornament;
import freedots.braille.BrailleList;
public class RepeatedNoteTremoloSign extends BrailleList {
  int val;
  public RepeatedNoteTremoloSign(final int val) {
    super();
    this.val = val;
  }

  public String getDescription() {
          String noteValue;
      int val = this.val;
      switch(val) {
      case 1: noteValue = "8ths";
      case 2: noteValue = "16ths";
      case 3: noteValue = "32nds";
      case 4: noteValue= "64ths";
      case 5: noteValue = "128ths";
      }
      return String.format("A tremolo sign indicating that this note should be played in %s", noteValue);
  }

    public int getRepetitionSymbol(int val) {
	switch(val) {
	case 1: return 12;
	case 2: return 123;
	case 3: return 5;
	case 4: return 13;
	case 5: return 3;
	}
    }
}
