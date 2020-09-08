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
      Element noteElement = document.createElement("note");
      root.appendChild(noteElement);
      Element pitchElement = document.createElement("pitch");
      noteElement.appendChild(pitchElement);
      Element octaveElement = document.createElement("octave");
      pitchElement.appendChild(octaveElement);
      Element stepElement = document.createElement("step");
      pitchElement.appendChild(stepElement);
      octaveElement.appendChild(document.createTextNode("4"));
      pitchElement.appendChild(document.createTextNode("C"));
      noteElement.appendChild(document.createElement("grace"));
      Note note = new Note();
      XMLToNote.parseNote(note, noteElement);
      assertEquals(4, note.getPitch().getOctave());
      assertEquals(0, note.getPitch().getStep());
      assertEquals(0, note.getPitch().getAlter());
      assertNotNull(note.getGrace());
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
