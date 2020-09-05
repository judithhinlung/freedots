package test.v2;
import v2.music.*;
import v2.parsers.musicxml.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
public class NoteTest extends junit.framework.TestCase {
  public void shouldReturnMiddleC() throws ParserConfigurationException {
    // Creates a note element in a dom
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    Document document = builderFactory.newDocumentBuilder().newDocument();
    Element root = document.createElement("root");
    document.appendChild(root);
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
    // Tests
    Note note = new Note();
    ParseNote.parseNote(note, noteElement);
    assertEquals(4, note.getPitch().getOctave());
  }
}
