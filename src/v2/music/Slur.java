package v2.music;
import java.util.ArrayList;
public class Slur extends Tied {
  ArrayList<String> types;
  public Slur(String type) throws IllegalArgumentException {
    super(type);
  }
  private String[] validTypes = new String[]{"start", "stop", "continue"};    
}
