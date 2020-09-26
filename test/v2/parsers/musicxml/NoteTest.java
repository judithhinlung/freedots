package v2.parsers.musicxml;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.TestCase;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import v2.music.*;
import java.io.File;
import org.w3c.dom.NodeList;

public class NoteTest extends TestCase {
    //~ Static fields/initializers 
    private Document document;
    private Element root;
    
    //~ Methods ------------------------------------------------------------------------------------
    Element createMiddleC() {
      Element noteElement = document.createElement("note");
      root.appendChild(noteElement);
      Element pitchElement = document.createElement("pitch");
      noteElement.appendChild(pitchElement);
      Element octaveElement = document.createElement("octave");
      pitchElement.appendChild(octaveElement);
      Element stepElement = document.createElement("step");
      pitchElement.appendChild(stepElement);
      octaveElement.appendChild(document.createTextNode("4"));
      stepElement.appendChild(document.createTextNode("C"));
      return noteElement;
    }
    //------//
    // main //
    //------//
    //-------//
    // setUp //
    //-------//
    @Override
    protected void setUp () throws Exception {
      DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
      document = builderFactory.newDocumentBuilder().newDocument();
      root = document.createElement("root");
      document.appendChild(root);
    }
    //-----------------//
    //-------//
    // tearDown //
    //-------//
    @Override
    protected void tearDown () throws Exception {
      document = null;
      root = null;
    }
    //-----------------//
    // checkNoteParsing //
    //-----------------//
    public void testNoteParsing() throws ParserConfigurationException {
      Element noteElement = createMiddleC();
      noteElement.appendChild(document.createElement("grace"));
      Element durationElement = document.createElement("duration");
      durationElement.appendChild(document.createTextNode("24"));
      noteElement.appendChild(durationElement);
      Element instrumentElement = document.createElement("instrument");
      instrumentElement.setAttribute("id", "1");
      noteElement.appendChild(instrumentElement);

      Note note = new Note();
      XMLToNote.parseNote(note, noteElement);
      assertEquals(4, note.getPitch().getOctave());
      assertEquals("C", note.getPitch().getStep());
      assertEquals(0, note.getPitch().getAlter());
      assertNotNull(note.getGrace());
      assertEquals(note.getDuration(), 24);
      assertEquals(note.getInstrumentId(), "1");
    }
    public void NotationsTest()  throws ParserConfigurationException {
      Element noteElement = createMiddleC();
      Element notationsElement = document.createElement("notations");
      noteElement.appendChild(notationsElement);
      Element slurElement = document.createElement("slur");
      slurElement.setAttribute("type", "start");
      notationsElement.appendChild(slurElement);
      Element ornamentsElement = document.createElement("ornaments");
      notationsElement.appendChild(ornamentsElement);
      Element turnElement = document.createElement("turn");
      Element delayedTurnElement = document.createElement("delayed-turn");
      Element unknownElement = document.createElement("unknown-ornament");
      ornamentsElement.appendChild(turnElement);
      ornamentsElement.appendChild(delayedTurnElement);
      ornamentsElement.appendChild(unknownElement);
      Element articulationsElement = document.createElement("articulations");
      noteElement.appendChild(articulationsElement);
      Element accentElement = document.createElement("accent");
      articulationsElement.appendChild(accentElement);
      Element technicalsElement = document.createElement("technical");
      notationsElement.appendChild(technicalsElement);
      Element upbowElement = document.createElement("up-bow");
      Element fingeringElement = document.createElement("fingering");
      fingeringElement.appendChild(document.createTextNode("2"));
      technicalsElement.appendChild(upbowElement);
      technicalsElement.appendChild(fingeringElement);
      Note note = new Note();
      assertEquals(note.getTie(), false);
      assertEquals(note.getTied(), false);
      assertEquals(note.getSlur(), true);
      assertTrue(note.getOrnaments().contains("turn"));
      assertTrue(note.getOrnaments().contains("delayedTurn"));
      assertFalse(note.getOrnaments().contains("unknown"));
      assertTrue(note.getArticulations().contains("accent"));
      assertTrue(note.getTechnical().contains("upBow"));
      assertEquals(note.getFingering(), 2);
    }
    //-----------------//
    // checkRestParsing //
    //-----------------//
  public void testRestParsing() throws ParserConfigurationException {
    Element noteElement = document.createElement("note");
    root.appendChild(noteElement);
    Element restElement = document.createElement("rest");
    restElement.setAttribute("measure", "yes");
    noteElement.appendChild(restElement);
    Note restNote = new Note();
    XMLToNote.parseNote(restNote, noteElement);
    assertNotNull(restNote.getRest());
    assertTrue(restNote.getRest().getIsMeasureRest());
  }
}
