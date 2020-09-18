package v2.music;
public class PluckFingering {
  String fingering;
  public PluckFingering(String fingering) throws IllegalArgumentException {
    if (!Utils.contains(fingering, validFingerings)) {
      throw new IllegalArgumentException("Unknown fingering: " + fingering);
    }
    this.fingering = fingering;
  }
  private String[] validFingerings = new String[]{"p", "i", "m", "a"};
}
