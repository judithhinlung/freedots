package v2.music;
import java.util.ArrayList;
import java.util.HashMap;
import freedots.math.Fraction;

/** A wrapper around (the most important) note element.
 */
public class Note extends MeasureElement {
  Measure measure;
  Pitch pitch;
  public Note(Measure measure, Pitch pitch, Fraction duration) {
    super(measure);
    this.pitch = pitch;
    this.duration = duration;
    this.staff = 1;
    this.voice = 1;
  }
  public Pitch getPitch() {
    return this.pitch;
  }
  String type;
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
  public Fraction getDurationFromType(String type) {
    HashMap<String, Fraction> typesToDurations = new HashMap<String, Fraction>();
    typesToDurations.put("1024th", new Fraction(1, 1024));
    typesToDurations.put("512th", new Fraction(1, 512));
    typesToDurations.put("256th", new Fraction(1, 256));
    typesToDurations.put("128th", new Fraction(1, 128));
    typesToDurations.put("64th", new Fraction(1, 64));
    typesToDurations.put("32nd", new Fraction(1, 32));
    typesToDurations.put("16th", new Fraction(1, 16));
    typesToDurations.put("eighth", new Fraction(1, 8));
    typesToDurations.put("quarter", new Fraction(1, 4));
    typesToDurations.put("half", new Fraction(1, 2));
    typesToDurations.put("whole", new Fraction(1, 1));
    typesToDurations.put("breve", new Fraction(2, 1));
    typesToDurations.put("long", new Fraction(4, 1));
    typesToDurations.put("maxima", new Fraction(0, 1));
    return typesToDurations.get(type);
  }
  public String getTypeFromDuration(Fraction duration) {
    HashMap<Fraction, String> durationsToTypes = new HashMap<Fraction, String>();
    durationsToTypes.put(new Fraction(1, 1024), "1024th");
    durationsToTypes.put(new Fraction(1, 512), "512th");
    durationsToTypes.put(new Fraction(1, 256), "256th");
    durationsToTypes.put(new Fraction(1, 128), "128th");
    durationsToTypes.put(new Fraction(1, 64), "64th");
    durationsToTypes.put(new Fraction(1, 32), "32nd");
    durationsToTypes.put(new Fraction(1, 16), "16th");
    durationsToTypes.put(new Fraction(1, 8), "eighth");
    durationsToTypes.put(new Fraction(1, 4), "quarter");
    durationsToTypes.put(new Fraction(1, 2), "half");
    durationsToTypes.put(new Fraction(1, 1), "whole");
    durationsToTypes.put(new Fraction(2, 1), "breve");
    durationsToTypes.put(new Fraction(4, 1), "long");
    durationsToTypes.put(new Fraction(0, 1), "maxima");
    return durationsToTypes.get(duration);
  }
  private boolean pizzicato = false;
  public boolean getPizzicato() {
    return this.pizzicato;
  }
  public void setPizzicato(boolean pizz) {
    this.pizzicato = pizz;
  }
  private Grace grace = null;
  public Grace getGrace() {
    return this.grace;
  }
  public void setGrace(Grace grace) {
    this.grace = grace;
  }
  private TimeModification timeModification;
  public TimeModification getTimeModification() {
    return this.timeModification;
  }
  public void setTimeModification(TimeModification timeModification) {
    this.timeModification = timeModification;
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
  private boolean isDotted = false;
  public boolean getDotted() {
    return this.isDotted;
  }
  public void setDotted(boolean isDotted) {
    this.isDotted = isDotted;
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
  private ArrayList<Articulation> articulations = new ArrayList<Articulation>();
  public ArrayList<Articulation> getArticulations() {
    return this.articulations;
  }
  public void addArticulation(Articulation articulation) {
    articulations.add(articulation);
  }
  private ArrayList<Technical> technicals = new ArrayList<Technical>();
  public ArrayList<Technical> getTechnical() {
    return this.technicals;
  }
  public void addTechnical(Technical technical) {
    technicals.add(technical);
  }
  private Harmonic harmonic = null;
  public Harmonic getHarmonic() {
    return this.harmonic;
  }
  public void setHarmonic(Harmonic harmonic) {
    this.harmonic = harmonic;
  }
  private Hole hole = null;
  public Hole getHole() {
    return this.hole;
  }
  public void setHole(Hole hole) {
    this.hole = hole;
  }
  private Fingering fingering = null;
  public Fingering getFingering() {
    return this.fingering;
  }
  public void setFingering(Fingering fingering) {
    this.fingering = fingering;
  }
  private PluckFingering pluckFingering = null;
  public PluckFingering getPluckFingering() {
    return this.pluckFingering;
  }
  public void setPluckFingering(PluckFingering pluckFingering) {
    this.pluckFingering = pluckFingering;
  }
  private Fret fret = null;
  public Fret getFret() {
    return this.fret;
  }
  public void setFret(Fret fret) {
    this.fret = fret;
  }
  private MusicString musicString = null;
  public MusicString getMusicString() {
    return this.musicString;
  }
  public void setMusicString(MusicString musicString) {
    this.musicString = musicString;
  }
  boolean hasFermata = false;
  public boolean getFermata() {
    return this.hasFermata;
  }
  public void setFermata(boolean fermata) {
    this.hasFermata = fermata;
  }
  private Dynamic dynamic = null;
  public Dynamic getDynamic() {
    return this.dynamic;
  }
  public void setDynamic(Dynamic dynamic) {
    this.dynamic = dynamic;
  }
  private Arpeggiate arpeggiate = null;
  public Arpeggiate getArpeggiate() {
    return this.arpeggiate;
  }
  public void setArpeggiate(Arpeggiate arpeggiate) {
    this.arpeggiate = arpeggiate;
  }
  Lyric lyric = null;
  public Lyric getLyric() {
    return this.lyric;
  }
  public void setLyric(Lyric lyric) {
    this.lyric = lyric;
  }
}
