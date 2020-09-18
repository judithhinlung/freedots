package v2.music;
public class Articulation {
  String type; 
  public Articulation(String type) throws IllegalArgumentException {
    if (!Utils.contains(type, validTypes)) {
      throw new IllegalArgumentException("Unknown articulation: " + type);
    }
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
    private String[] validTypes = new String[]{"accent", "strongAccent", "staccato", "tenuto", "detachedLegato", "staccatissimo", "spiccato", "scoop", "plop", "doit", "falloff", "breathMark", "caesura", "stress", "unstress", "softAccent"};
}
