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
    public static class MidiInstrument {
    String instrumentId;
    public MidiInstrument(String id) {
      this.instrumentId = id;
    }
     
    }
}
