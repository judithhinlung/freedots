package v2.parsers.musicxml;
import v2.music.*;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class XMLToNote {
   private static final Logger LOG = Logger.getLogger(Note.class.getName());
  public static void parseNote(Note note, Element element) {
    for (Node node = element.getFirstChild(); node != null;
      node = node.getNextSibling()) {
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)node;
        String tag = child.getTagName();
        if (tag.equals("pitch")) {
          note.setPitch(parsePitch(note, child));
        }
        else if (tag.equals("grace")) {
          note.setGrace(parseGrace(note, child));
        }
	else if (tag.equals("unpitched")) {
	  note.setUnpitched(parseUnpitched(note, child));
	}
	else if (tag.equals("rest")) {
	  note.setRest(parseRest(note, child));
	}
      }
    }
  }
  private static int convertStep(String stepName) {
    return "CDEFGAB".indexOf(stepName.trim().toUpperCase());
  }
  private static Pitch parsePitch(Note note, Element element) throws MusicXMLParseException {
    int step = 0;
    int octave = 0;
    int alter = 0;
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
          String stepName = child.getTextContent();
	  step = convertStep(stepName);
          foundStep = true;
        }
      }
    }
    if (!foundOctave || !foundStep) {
      throw new MusicXMLParseException("Missing step or octave element");
    }
    return new Pitch(octave, step, alter);
  }

  private static Grace parseGrace(Note note, Element element) {
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
  public static Unpitched parseUnpitched(Note note, Element element) {
    NodeList list = element.getChildNodes();
	Unpitched unpitched = new Unpitched();
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)(list.item(i));
        String tag = child.getTagName();
        if (tag.equals("octave")) {
          int octave = Integer.parseInt(child.getTextContent());
	  unpitched.setDisplayOctave(octave);
        }
        else if (tag.equals("step")) {
          String stepName = child.getTextContent();
	  int step = convertStep(stepName);
	   unpitched.setDisplayStep(step);
        }
      }
    }
    return unpitched;
  }
  public static Rest parseRest(Note note, Element element) {
    Rest rest = new Rest();
    if (element.hasAttribute("measure")) {
      boolean isMeasureRest = element.getAttribute("measure").equals("yes");
      rest.setIsMeasureRest(isMeasureRest);
    }
    NodeList list = element.getChildNodes();
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element child = (Element)(list.item(i));
        String tag = child.getTagName();
        if (tag.equals("octave")) {
          int octave = Integer.parseInt(child.getTextContent());
	  rest.setDisplayOctave(octave);
        }
        else if (tag.equals("step")) {
          String stepName = child.getTextContent();
	  int step = convertStep(stepName);
	   rest.setDisplayStep(step);
        }
      }
    }
    return rest;
  }
}
