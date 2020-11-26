package v2.music;
public class Instrument {
  String instrumentId;
  public Instrument(String id) {
    this.instrumentId = id;
  }
  public String getId() {
    return this.instrumentId;
  }
  String instrumentName;
  public String getName() {
    return this.instrumentName;
  }
  public void setName(String name) {
    this.instrumentName = name;
  }
  String instrumentSound;
  public String getInstrumentSound() {
    return this.instrumentSound;
  }
  public void setInstrumentSound(String sound) {
    this.instrumentSound = sound;
  }
  int midiChannel = 0;
  public int getMidiChannel() {
    return this.midiChannel;
  }
  public void setMidiChannel(int channel) {
    this.midiChannel = channel;
  }
  int midiProgram = 0;
  public int getMidiProgram() {
    return this.midiProgram;
  }
  public void setMidiProgram(int program) {
    this.midiProgram = program;
  }
  int volume = 100;
  public int getVolume() {
    return this.volume;
  }
  public void setVolume(int volume) {
    this.volume = volume;
  }
  int pan = 64;
  public int getPan() {
    return this.pan;
  }
  public void setPan(int pan) {
    this.pan = pan;
  }
  int elevation = 0;
  public int getElevation() {
    return this.elevation;
  }
  public int setElevation(int elevation) {
    return this.elevation;
  }
}
