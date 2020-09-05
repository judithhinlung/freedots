package v2.music;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import freedots.math.AbstractFraction;
import freedots.math.Fraction;
import freedots.math.PowerOfTwo;
import freedots.v2.music.*;

/** A wrapper around (the most important) note element.
 */
public class Note {
  public Note() {
  }
    /**
    public Note(int divisions, int durationMultiplier, Transpose transpose, Part part) {
    this.divisions = divisions;
    this.durationMultiplier = durationMultiplier;
    this.transpose = transpose;
    this.part = part;
  }
    */

  private final int divisions = 1;

  private final int durationMultiplier = 1;

  private boolean pizzicato = false;

  public boolean getPizzicato() {
    return this.pizzicato;
  }

  public void setPizzicato(boolean pizz) {
    this.pizzicato = pizz;
  }

  private Pitch pitch = null;

  public Pitch getPitch() {
    return this.pitch;
  }

  public void setPitch(Pitch pitch) {
    this.pitch = pitch;
  }

  private Grace grace = null;

  public Grace getGrace() {
    return this.grace;
  }

  public void setGrace(Grace grace) {
    this.grace = grace;
  }

    /**    private Part part;
    public Part getPart() { return part; }

    private Fraction moment;
    private Staff staff = null;
    private Unpitched unpitched = null;
    private int duration = 0;
    private boolean isChordNote = false;
    private boolean isTieStart = false;
    private boolean isTieStop = false;
    private String instrumentId = null;
    private String type = null;
    private int staffNumber = 0;
    private String voiceName = null;
    private Accidental accidental = null;
    private TimeModification timeModification = null;
    public TimeModification getTimeModification() { return timeModification; }
    private Lyric lyric = null;
    private Notations notations = null;
    private Tuplet tuplet = null;
    public Tuplet getTuplet() { return this.tuplet; }
    void addTuplet(Tuplet tuplet) { this.tuplet = tuplet; }

    private Attributes.Transpose transpose = null;
    private boolean grace = false;
    private boolean rest = false;
    private boolean glisandoStart = false;
    private boolean glisandoStop = false;
    private boolean slideStart = false;
    private boolean slideStop = false;


    void setMoment(final Fraction moment) { this.moment = moment; }

    public boolean isGrace() {
	return this.grace;
    }
    public boolean isRest() {
	return this.rest;
    }
    public Pitch getPitch() {
      return this.pitch;
    }
    public Unpitched getUnpitched() {
      return this.unpitched;
    }
    public int getStaffNumber() {
	return this.staffNumber;
    }
    public String getVoiceName() {
	return this.voiceName;
    }
    public void setVoiceName(String name) {
	this.voiceName = name;
    }

    public Accidental getAccidental() {
	return this.accidental;
    }
    void setAccidental(Accidental accidental) {
	this.accidental = accidental;
    }

    public boolean isTieStart() {
        // TODO
	    return false;
    }
    public Set<Articulation>  articulations;
    public Set<Articulation> getArticulations() {
      return this.articulations;
    }

    public Set<Ornament> ornaments;
    public Set<Ornament> getOrnaments() {
      return this.ornaments;
    }
    */
}
