package v2.music;
public class Hole extends Technical {
    String type;
    public Hole(String type) throws IllegalArgumentException {
	super(type);
    }
    private String[] validTypes = new String[]{"yes", "no", "half"};
}
