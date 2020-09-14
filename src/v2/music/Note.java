package v2.music;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import freedots.math.AbstractFraction;
import freedots.math.Fraction;
import freedots.math.PowerOfTwo;

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
  private Unpitched unpitched = null;
  public Unpitched getUnpitched() {
    return this.unpitched;
  }
  public void setUnpitched(Unpitched unpitched) {
    this.unpitched = unpitched;
  }
  private Rest rest = null;
  public Rest getRest() {
    return this.rest;
  }
  public void setRest(Rest rest) {
    this.rest = rest;
  }
  private boolean isTie = false;
  public boolean getTie() {
    return this.isTie;   
  }
  public void setTie(boolean isTie) {
    this.isTie = isTie;
  }
  private boolean isTied = false;
  public boolean getTied() {
    return this.isTied;
  }
  public void setTied(boolean tied) {
    this.isTied = tied;
  }
  private boolean isSlur = false;
  public boolean getSlur() {
    return this.isSlur;
  }
  public void setSlur(boolean slur) {
    this.isSlur = slur;
  }
  private String instrumentId;
  public String getInstrumentId() {
    return this.instrumentId;
  }
  public void setInstrumentId(String id) {
    this.instrumentId = id;
  }
  private String type;
  public String getType() {
	return this.type;
  }
  public void setType(String type) throws IllegalArgumentException {
    String[] availableTypes = new String[]{"1024th", "512th", "256th", "128th", "64th", "32nd", "16th", "eighth", "quarter", "half", "whole", "breve", "long", "maxima"};
    if (!Utils.contains(type, availableTypes)) {
       throw new IllegalArgumentException("Invalid note type: " + type);
    }
    this.type = type;
  }
  private Accidental accidental = null;
  public Accidental getAccidental() {
    return this.accidental;
  }
  public void setAccidental(Accidental accidental) {
    this.accidental = accidental;
  }
  private Tuplet tuplet = null;
  public Tuplet getTuplet() {
    return this.tuplet;
  }
  public void setTuplet(Tuplet tuplet) {
    this.tuplet = tuplet;
  }
  private boolean hasGlissando = false;
  public boolean getGlissando() {
    return this.hasGlissando;
  }
  public void setGlissando(boolean hasGlissando) {
    this.hasGlissando = hasGlissando;
  }
  private boolean hasSlide = false;
  public boolean getSlide() {
    return this.hasSlide;
  }
  public void setSlide(boolean hasSlide) {
    this.hasSlide = hasSlide;
  }
    private ArrayList<Ornament> ornaments = new ArrayList<Ornament>();
  public ArrayList<Ornament> getOrnaments() {
    return this.ornaments;
  }
  public void addOrnament(Ornament ornament) {
    ornaments.add(ornament);
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
