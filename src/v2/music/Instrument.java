package v2.music;
public class Instrument {
  String instrumentName;
  String instrumentId;
  public Instrument(String name, String id) {
    this.instrumentName = name;
    this.instrumentId = id;
  }
  String instrumentSound;
  public String getInstrumentSound() {
    return this.instrumentSound;
  }
  public void setInstrumentSound(String sound) {
    this.instrumentSound = sound;
  }
  VirtualInstrument virtualInstrument = null;
  public VirtualInstrument getVirtualInstrument() {
    return this.virtualInstrument;
  }
  public static class VirtualInstrument {
    String virtualName;
    String virtualLibrary;
    public VirtualInstrument(String name, String library) {
      this.virtualName = name;
      this.virtualLibrary = library;
    }
    public String getVirtualName() {
      return this.virtualName;
    }
    public String getVirtualLibrary() {
      return this.virtualLibrary;
    }
  }
  MidiInstrument midiInstrument = null;
  public MidiInstrument getMidiInstrument() {
    return this.midiInstrument;
  }
  public void setMidiInstrument(MidiInstrument midiInstrument) {
    this.midiInstrument = midiInstrument;
  }
  public static class MidiInstrument {
    String instrumentId;
    int midiChannel;
    int midiProgram;
    int midiBank;
    int volume;
    int pan;
    int elevation;
    public MidiInstrument(String id) {
      this.instrumentId = id;
      this.midiChannel = 0;
      this.midiProgram = 0;
      this.midiBank = 1;
      this.volume = 50;
      this.pan = 0;
      this.elevation = 0;
    }
    public int getMidiChannel() {
      return this.midiChannel;
    }
    public void setMidiChannel(int channel) {
      this.midiChannel = channel;
    }
    public int getMidiProgram() {
      return this.midiProgram;
    }
    public void setMidiProgram(int program) {
      this.midiProgram = program;
    }
    public int getMidiBank() {
      return this.midiBank;
    }
    public void setMidiBank(int bank) {
      this.midiBank = bank;
   }
    public int getVolume() {
      return this.volume;
    }
    public void setVolume(int volume) {
      this.volume = volume;
    }
    public int getPan() {
      return this.pan;
    }
    public void setPan(int pan) {
      this.pan = pan;
    }
    public int getElevation() {
      return this.elevation;
    }
    public int setElevation(int elevation) {
      return this.elevation;
    }
  }
}
