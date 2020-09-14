package v2.music.format;
public class Font {
  String fontFamily;
  String fontStyle;
  String fontSize;
  String fontWeight;

  public Font() {
    this.fontFamily = null;
    this.fontStyle = null;
    this.fontWeight = null;
    this.fontSize = null;
  }

  public void setFontFamily(String fontFamily) {
    this.fontFamily = fontFamily;
  }
  public void setFontStyle(String fontStyle) {
    this.fontStyle = fontStyle;
  }
  public void setFontWeight(String fontWeight) {
    this.fontWeight = fontWeight;
  }
  public void setFontSize(String fontSize) {
    this.fontSize = fontSize;
  }
}
