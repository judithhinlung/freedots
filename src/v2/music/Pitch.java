package v2.music;
import v2.music.*;
public class Pitch {
  private int octave, alter;
  private int step;
  public Pitch(final int octave, final int step, final int alter) {
    this.octave = octave;
    this.step = step;
    this.alter = alter;
    }
  public int getStep() {
    return this.step;
  }
  public int getAlter() {
    return this.alter;
  }
  public int getOctave() {
    return this.octave;
  }
  public int getMIDIPitch() {
    int midiPitch = (getOctave()+1) * CHROMATIC_STEPS
                  + STEP_TO_CHROMATIC[step]
                  + getAlter();
    return midiPitch;
  }
  @Override
  public final boolean equals(Object object) {
    if (object instanceof Pitch) {
	Pitch other = (Pitch)object;
      if (this.getStep() == other.getStep()) {
        if (this.getAlter() == other.getAlter()) {
          if (this.getOctave() == other.getOctave()) return true;
        }
      }
    }
    return false;
  }
  public final int diatonicDifference(Pitch other) {
    return ((this.getOctave()*STEPS) + this.getStep())
           - ((other.getOctave()*STEPS) + other.getStep());
  }
  public int compareTo(Pitch other) {
    int diatonicDifference = diatonicDifference(other);
    if (diatonicDifference != 0) return diatonicDifference;
    else {
      final boolean flatter = getAlter() < other.getAlter();
      final boolean sharper = getAlter() > other.getAlter();
      return flatter ? -1 : sharper ? 1 : 0;
    }      
  }

  @Override
  public final String toString() {
    final String[] stepNames = new String[] {"C", "D", "E", "F", "G", "A", "B"};
    return stepNames[getStep()]+getOctave()+" ("+getAlter()+")";
  }
  private static final int STEPS = 7;
  private static final int CHROMATIC_STEPS = 12;
  private static final int[] STEP_TO_CHROMATIC = new int[] {
    0, 2, 4, 5, 7, 9, 11
  };

  private class TemporaryPitch extends Pitch {
    private int octave, step, alter;
    TemporaryPitch(final int octave, final int step, final int alter) {
	super(octave, step, alter);
    }
    public int getOctave() { return octave; }
    public int getStep() { return step; }
    public int getAlter() { return alter; }
  }
}
