package v2.parsers.musicxml;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import v2.music.*;


public class XMLToNote {
   private static final Logger LOG = Logger.getLogger(Note.class.getName());
  public static void parseNote(Note note, Element element) {
    if (element.hasAttribute("pizzicato")) {
      note.setPizzicato(true);
    }
    for (Node node = element.getFirstChild(); node != null;
      node = node.getNextSibling()) {
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)node;
        String tag = child.getTagName();
        if (tag.equals("pitch")) {
          note.setPitch(parsePitch(child));
        }
        else if (tag.equals("grace")) {
          note.setGrace(parseGrace(child));
        }
        else if (tag.equals("unpitched")) {
           note.setUnpitched(parseUnpitched(child));
        }
        else if (tag.equals("rest")) {
          note.setRest(parseRest(child));
        }
        else if (tag.equals("duration")) {
          note.setDuration(parseDuration(child));
 }
	else if (tag.equals("time-modification")) {
		note.setTimeModification(parseTimeModification(child));
	    }
		else if (tag.equals("instrument")) {
	    note.setInstrumentId(parseInstrumentId(child));
	}
		else if (tag.equals("type")) {
	    note.setType(parseType(child));
	}
	else if (tag.equals("dot")) {
	    note.setDotted(true);
	}
		else if (tag.equals("accidental")) {
	    note.setAccidental(parseAccidental(child));
	}
		else if (tag.equals("notations")) {
      parseNotations(note, child);
		}
      else if (tag.equals("lyric")) {
        note.setLyric(parseLyric(child));
      }
      else if (tag.equals("figured-bass")) {
        note.setFiguredBass(parseFiguredBass(child));
      }
      else if (tag.equals("backup")) {
        note.setBackup(parseBackup(child));
      }
      else if (tag.equals("forward")) {
        note.setForward(parseForward(child));
      }
    }
  }
  }
    private static Pitch parsePitch(Element element) throws MusicXMLParseException {
    int octave = 0;
    int alter = 0;
    String step = null;
    NodeList list = element.getChildNodes();
    boolean foundOctave = false;
    boolean foundStep = false;
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)(list.item(i));
        String tag = child.getTagName();
        if (tag.equals("alter")) {
          alter = Integer.parseInt(child.getTextContent());
        }
        else if (tag.equals("octave")) {
          octave = Integer.parseInt(child.getTextContent());
          foundOctave = true;
        }
        else if (tag.equals("step")) {
          step = child.getTextContent();
          foundStep = true;
        }
      }
    }
    if (!foundOctave || !foundStep) {
      throw new MusicXMLParseException("Missing step or octave element");
    }
    return new Pitch(octave, step, alter);
  }
  private static Grace parseGrace(Element element) {
    if (element.getAttributes().getLength() == 0) {
      return new Grace();
    }
    int stealTimePrevious = 0;
    int stealTimeFollowing = 0;
    int makeTime = 0;
    boolean slash = false;
    if (element.hasAttribute("steal-time-previous")) {
	stealTimePrevious = Integer.parseInt(element.getAttribute("steal-time-previous"));
    }
    if (element.hasAttribute("steal-time-following")) {
      stealTimeFollowing = Integer.parseInt(element.getAttribute("steal-time-following"));
    }
    if (element.hasAttribute("make-time")) {
      makeTime = Integer.parseInt(element.getAttribute("make-time"));
    }
    if (element.hasAttribute("slash")) {
      slash = element.getAttribute("slash").equals("yes");
    }
    return new Grace(stealTimePrevious, stealTimeFollowing, makeTime, slash);
	 }
  public static Unpitched parseUnpitched(Element element) {
    NodeList list = element.getChildNodes();
    int octave = -1;
    String step = null;
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)(list.item(i));
        String tag = child.getTagName();
        if (tag.equals("octave")) {
          octave = Integer.parseInt(child.getTextContent());
        }
        else if (tag.equals("step")) {
	    step = child.getTextContent();
        }
      }
    }
    return new Unpitched(octave, step);
  }
  public static Rest parseRest(Element element) {
    String displayStep = null;
    int displayOctave = -1;
    boolean isMeasureRest = false;
    if (element.hasAttribute("measure")) {
      isMeasureRest = element.getAttribute("measure").equals("yes");
    }
    NodeList list = element.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)(list.item(i));
        String tag = child.getTagName();
        if (tag.equals("octave")) {
          displayOctave = Integer.parseInt(child.getTextContent());
        }
        else if (tag.equals("step")) {
	    displayStep = child.getTextContent();
        }
      }
    }
    Rest rest = new Rest(displayOctave, displayStep);
    rest.setIsMeasureRest(isMeasureRest);
    return rest;
  }
  public static int parseDuration(Element element) {
    return Integer.parseInt(element.getTextContent());
  }
  public static TimeModification parseTimeModification(Element element) {
    int normalNotes = 0;
    int actualNotes = 0;
    String normalType = null;
    NodeList list = element.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)(list.item(i));
        String tag = child.getTagName();
        if (tag.equals("normal-notes")) {
          normalNotes = Integer.parseInt(child.getTextContent());
        }
        else if (tag.equals("actual-notes")) {
          actualNotes = Integer.parseInt(child.getTextContent());
        }
	else if (tag.equals("normal-type")) {
	    normalType = child.getTextContent();
	}
      }
    }
    TimeModification tm = null;
    if (normalType != null) {
      tm = new TimeModification(normalNotes, actualNotes, normalType);
    }
    else {
      tm = new TimeModification(normalNotes, actualNotes);
    }
    return tm;
  }
  public static String parseInstrumentId(Element element) {
    return element.getAttribute("id");
  }
  public static String parseType(Element element) {
    return element.getTextContent();
  }
  public static Accidental parseAccidental(Element element) {
    return new Accidental(element.getTextContent());
  }
  public static void parseNotations(Note note, Element element) {
    for (Node node = element.getFirstChild(); node != null;
      node = node.getNextSibling()) {
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)node;
        String tag = child.getTagName();
        if (tag.equals("tie")) {
           note.setTie(true);
        }
        else if (tag.equals("tied")) {
          note.setTied(true);
        }
	       else if (tag.equals("slur")) {
          note.setSlur(true);
        }
        else if (tag.equals("tuplet")) {
        note.setTuplet(parseTuplet(child));
        }
        else if (tag.equals("glissando")) {
          note.setGlissando(true);
        }
        else if (tag.equals("slide")) {
          note.setSlide(true);
        }
        else if (tag.equals("ornaments")) {
          parseOrnaments(note, child);
        }
        else if (tag.equals("articulations")) {
          parseArticulations(note, child);
        }
        else if (tag.equals("fermata")) {
          note.setFermata(true);
        }
        else if (tag.equals("dynamics")) {
          parseDynamic(note, child);
        }
      	else if (tag.equals("arpeggiate")) {
	    note.setArpeggiate(parseArpeggiate(child));
	}
      }
    }
  }
  public static Tuplet parseTuplet(Element element) {
    int normalNotes = 0;
    int actualNotes = 0;
    NodeList list = element.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)(list.item(i));
        String tag = child.getTagName();
        if ((tag.equals("tuplet-normal")) && (child.hasAttribute("tuplet-number"))) {
	    normalNotes = Integer.parseInt(child.getAttribute("tuplet-number"));
        }
        else if ((tag.equals("tuplet-actual")) && (child.hasAttribute("tuplet-number"))) {
	    actualNotes = Integer.parseInt(child.getAttribute("tuplet-number"));
        }
      }
    }
    return new Tuplet(normalNotes, actualNotes);
  }
    // Converts a hyphenated string to camel case
  public static String hyphenatedToCamel(String hyphenatedString) {
    String[] words = hyphenatedString.split("-");
    if (words.length < 2) {
	    return words[0];
    }
    String camelString = words[0].toLowerCase();
    for (int i = 1; i < words.length; i++) {
       camelString.concat(words[i].toLowerCase());
    }
    return camelString;
  }
  public static void parseOrnaments(Note note, Element element) {
	ArrayList<Ornament> ornaments = note.getOrnaments();
	    for (Node node = element.getFirstChild(); node != null;
      node = node.getNextSibling()) {
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)node;
        String tag = child.getTagName();
        String ornamentType = null;
        if (tag.equals("trill-mark")) {
          ornamentType = "trill";
        }
        else {
          ornamentType = hyphenatedToCamel(tag);
        }
        try {
          note.addOrnament(new Ornament(ornamentType));
        }
        catch(IllegalArgumentException e) {
        	System.out.println("Unsupported type: " + ornamentType);
        }
      }
    }
  }
  public static void parseArticulations(Note note, Element element) {
    for (Node node = element.getFirstChild(); node != null;
      node = node.getNextSibling()) {
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)node;
        String tag = child.getTagName();
        String articulationType = hyphenatedToCamel(tag);
        try {
          note.addArticulation(new Articulation(articulationType));
        }
        catch(IllegalArgumentException e) {
        	System.out.println("Unsupported type: " + articulationType);
        }
      }
    }
  }
  public static void parseTechnicals(Note note, Element element) {
	    for (Node node = element.getFirstChild(); node != null;
      node = node.getNextSibling()) {
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)node;
        String tag = child.getTagName();
        if (tag.equals("harmonic")) {
	    parseHarmonic(child);
        }
        else if (tag.equals("fingering")) {
            note.setFingering(parseFingering(child));
        }
        else if (tag.equals("pluck")) {
            note.setPluckFingering(parsePluck(child));
        }
        else if (tag.equals("fret")) {
            note.setFret(parseFret(child));
        }
        else if (tag.equals("string")) {
            note.setMusicString(parseMusicString(child));
        }
        else if (tag.equals("hole")) {
            note.setHole(parseHole(child));
        }
	else {
        String technicalType = hyphenatedToCamel(tag);
        try {
	    note.addTechnical(new Technical(technicalType));
        }
        catch(IllegalArgumentException e) {
        	System.out.println("Unsupported type: " + technicalType);
        }
	}
      }
	    }
    }
  /** Unless artificial is specified in the XML score, harmonics are 
   * instantiated with the natural type by default.
   */
  public static Harmonic parseHarmonic(Element element) {
    String type = null;
    NodeList list = element.getElementsByTagName("artificial");
    if (list.getLength() > 0) {
      type = "artificial";
    }
    else {
      type = "natural";
    }
    Harmonic harmonic = null;
    try {
      harmonic = new Harmonic(type);
    }
    catch(IllegalArgumentException e) {
	System.out.println("Invalid harmonic type: " + type);
    }
    return harmonic;
  }
  public static Fingering parseFingering(Element element) {
    int finger = Integer.parseInt(element.getTextContent());
    Fingering fingering = null;
    try {
      fingering = new Fingering(finger);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Unknown fingering: " + finger);
    }
    return fingering;
  }
  public static PluckFingering parsePluck(Element element) {
    String finger = element.getTextContent();
    PluckFingering pluckFingering = null;
    try {
      pluckFingering = new PluckFingering(finger);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Invalid pluck fingering: " + finger);
    }
    return pluckFingering;
  }
  public static Fret parseFret(Element element) {
    return new Fret(Integer.parseInt(element.getTextContent()));
  }
  public static MusicString parseMusicString(Element element) {
    return new MusicString(Integer.parseInt(element.getTextContent()));
  }
    /** Determines whether the hole should be closed (yes), half-closed (half), 
     * or open (no) using the hole-closed child element
     */
  public static Hole parseHole(Element element) {
    Hole hole = null;
    Element holeClosed = (Element)(element.getElementsByTagName("hole-closed").item(0));
    String type = holeClosed.getTextContent();
    try {
      hole = new Hole(type);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Invalid hole symbol: " + type);
    }
    return hole;
  }  public static void parseDynamic(Note note, Element element) {
    NodeList list = element.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
	Element child = (Element)(list.item(i));
      String type = child.getTagName();
      try {
       	note.setDynamic(new Dynamic(type));
      }
      catch (IllegalArgumentException e) {
       	System.out.println("Unknown dynamic: " + type);
      }
    }
  }
  public static Arpeggiate parseArpeggiate(Element element) {
    if (element.hasAttribute("number") && element.hasAttribute("direction")) {
      int num = Integer.parseInt(element.getAttribute("number"));
      String dir = element.getAttribute("direction");
      return new Arpeggiate(num, dir);
   	}
    return new Arpeggiate();
  }
  public static Lyric parseLyric(Element element) {
    String text = null;
    String syllabic = null;
    boolean hasElision = false;
    boolean isExtended = false;
    NodeList list = element.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
	    Element child = (Element)list.item(i);
	    String tag = child.getTagName();
	    if (tag.equals("text")) {
	      text = child.getTextContent();
	    }
	    else if (tag.equals("syllabic")) {
	      syllabic = child.getTextContent();
	    }
     else if (tag.equals("extended")) {
       isExtended = true;
	    }
	    else if (tag.equals("elision")) {
	      hasElision = true;
	    }
    }
    if ((text != null && syllabic != null) && (isExtended && hasElision)) {
      try {
        return new Lyric(text, syllabic, hasElision, isExtended);
      }
      catch (IllegalArgumentException e) {
        System.out.println("Invalid lyric arguments: " + text + ", " + syllabic + ", " + hasElision + ", " + isExtended);
      }
    }
    else if (text != null && syllabic != null) {
      try {
	       return new Lyric(text, syllabic);
      }
      catch (IllegalArgumentException e) {
        System.out.println("Invalid lyric arguments: " + text + ", " + syllabic);
      }
    }
    else if (text != null) {
      try {
        return new Lyric(text);
      }
      catch (IllegalArgumentException e) {
        System.out.println("Invalid lyric arguments: " + text);
      }
    }
    return null;
  }
  public static FiguredBass parseFiguredBass(Element element) {
    int duration = 0;
    String prefix = null;
    int number = 0;
    String suffix = null;;
    FiguredBass figuredBass = null;
    if (element.hasAttribute("duration")) {
      duration = Integer.parseInt(element.getAttribute("duration"));
    }
    Element figureElement = (Element)element.getElementsByTagName("figure").item(0);
    NodeList list = figureElement.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
	Element child = (Element)list.item(i);
      String tag = child.getTagName();
      if (tag.equals("prefix")) {
        prefix = child.getTextContent();
      }
      else if (tag.equals("number")) {
        number = Integer.parseInt(child.getTextContent());
      }
      else if (tag.equals("suffix")) {
 	      suffix = child.getTextContent();
      }
    }
    if (prefix != null && number > 0 && suffix != null) {
      try {
        figuredBass = new FiguredBass(prefix, number, suffix);
      }
      catch (IllegalArgumentException e) {
	  System.out.println("Invalid arguments: " + prefix + ", " + number + ", " + suffix);
      }
    }
    else if (number > 0) {
      try {
	       figuredBass = new FiguredBass(number);
      }
      catch (IllegalArgumentException e) {
	  System.out.println("Invalid argument: " + number);
      }
      if (prefix != null) {
        try {
          figuredBass.addPrefix(prefix);
        }
        catch(IllegalArgumentException e) {
	    System.out.println("Invalid argument: " + prefix);
        }
      }
      if (suffix != null) {
        try {
	  figuredBass.addSuffix(suffix);
	}
        catch (IllegalArgumentException e) {
	    System.out.println("Invalid argument: " + suffix);
        }
      }
    }
    return figuredBass;
  }
  public static int parseBackup(Element element) {
    int duration = 0;
    NodeList list = element.getElementsByTagName("duration");
    if (list.getLength() == 1) {
      duration = Integer.parseInt(element.getElementsByTagName("duration").item(0).getTextContent());
    }
    return duration;
  }
  public static Note.Forward parseForward(Element element) {
    int duration = 0;
    int staff = 0;
    int voice = 0;
    NodeList list = element.getElementsByTagName("duration");
    if (list.getLength() == 1) {
      duration = Integer.parseInt(list.item(0).getTextContent());
    }
    list = element.getElementsByTagName("staff");
    if (list.getLength() == 1) {
      staff = Integer.parseInt(list.item(0).getTextContent());
    }
    list = element.getElementsByTagName("voice");
    if (list.getLength() == 1) {
      staff = Integer.parseInt(list.item(0).getTextContent());
    }
    if (duration == 0) {
      return null;
    }
    Note.Forward forward = new Note.Forward(duration);
    forward.setStaff(staff);
    forward.setVoice(voice);
    return forward;
  }
}
