package v2.music;
import java.util.HashMap;
import java.util.ArrayList;
public class Staff {
  int number;
  HashMap<Integer, Voice> voices;
  public Staff(int number) {
    this.number = number;
    this.voices = new HashMap<Integer, Voice>();
  }
  public int getNumber() {
    return this.number;
  }
  public boolean hasVoice(int voice) {
    return this.voices.containsKey(voice);
  }
  public void addVoice(Voice voice) {
    this.voices.put(voice.getNumber(), voice);
  }
  public Voice getVoice(int number) {
    if (this.voices.containsKey(number)) {
      return this.voices.get(number);
    }
    return null;
  }
  public HashMap<Integer, Voice> getVoices() {
    return this.voices;
  }
}
