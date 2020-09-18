package v2.music;
public class Harmonic extends Technical {
  String type;
  public Harmonic(String type) throws IllegalArgumentException {
    super(type);
  }
  private String[] validTypes = new String[]{"natural", "artificial"};
}    
