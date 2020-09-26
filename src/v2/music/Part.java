package v2.music;
import java.util.ArrayList;
public class Part {
  private String partName;
  private String partId;
  public Part(String name, String id) {
    this.partName = name;
    this.partId = id;
  }
  public String getName() {
    return this.partName;
  }
  public void setName(String partName) {
    this.partName = partName;
  }
  public String getId() {
    return this.partId;
  }
  String partAbbreviation;
  public String getAbbreviation() {
    return this.partAbbreviation;
  }
  public void setAbbreviation(String abbreviation) {
    this.partAbbreviation = abbreviation;
  }
  ArrayList<Instrument> instruments;
  public ArrayList<Instrument> getInstruments() {
    return this.instruments;
  }
  public void addInstrument(Instrument instrument) {
    instruments.add(instrument);
  }
}
