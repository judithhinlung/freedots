package v2.music;
public class Fingering {
  int fingering;
  public Fingering(int fingering) throws IllegalArgumentException {
    if (fingering < 1 || fingering > 5) {
      throw new IllegalArgumentException("Invalid fingering: " + fingering);
    }
    this.fingering = fingering;
  }
}
