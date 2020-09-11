package v2.music;
import java.util.ArrayList;
public class Tied extends Tie {
  ArrayList<String> types;
  public Tied(String type) throws IllegalArgumentException {
    super(type);
  }
  private String[] validTypes = new String[]{"start", "stop", "letRing"};
}
