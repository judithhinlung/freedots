package v2.music;
public class Pluck {
  Character fingering;
  public Pluck(Character fingering) throws IllegalArgumentException {
    if (!Utils.contains(fingering, validFingerings)) {
      throws new IllegalArgumentException("Unknown fingering: " + fingering);
    }
    this.fingering = fingering;
  }
  private char[] pluckFingerings = new String[]{"p", "i", "m", "a"};
}
