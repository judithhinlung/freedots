package v2.music;
public class Hole extends Technical {
  /** 
  * @param holeClosed  indicates whether the hole is closed (yes), open (no), or half-closed (half)
  */
  String holeClosed;
  public Hole(String holeClosed) throws IllegalArgumentException {
    super(holeClosed);
  }
  private String[] validTypes = new String[]{"yes", "no", "half"};
  public String toString() {
    return this.holeClosed;
  }
}
