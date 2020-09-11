package v2.music;
/** Utility methods */
public class Utils {
  public static boolean contains(String val, String[] values) {
    for (int i = 0; i < values.length; i++) {
      if (val.equals(values[i])) {
	       return true;
      }
    }
    return false;
  }
}
