package v2.music;
public class Sound {
  /** Decapo, segno, dalsegno, coda, and tocoda indicate backward or forward jumps in playback;
   * 0  no jump
   * 1  jump occurs this time through
   * n  play through n-1 times before making the jump
   */
  Instrument instrument = null;
  int division;
  public Sound(Instrument instrument, int division) {
    this.instrument = instrument;
    this.division = division;
  }
  int velocity = 100;
  public int getVelocity() {
    return this.velocity;
  }
  public void setVelocity(int velocity) {
    this.velocity = velocity;
  }
  int tempo = 100;
  public int getTempo() {
    return this.tempo;
  }
  public void setTempo(int tempo) {
    this.tempo = tempo;
  }
  int decapo = 0;
  public int getDecapo() {
    return this.decapo;
  }
  public void setDecapo(int decapo) {
    this.decapo = decapo;
  }
  int segno = 0;
  public int getSegno() {
    return this.segno;
  }
  public void setSegno(int segno) {
    this.segno = segno;
  }
  int dalsegno = 0;
  public int getDalsegno() {
    return this.dalsegno;
  }
  public void setDalsegno(int dalsegno) {
    this.dalsegno = dalsegno;
  }
  int coda = 0;
  public int getCoda() {
    return this.coda;
  }
  public void setCoda(int coda) {
    this.coda = coda;
  }
  int tocoda = 0;
  public int getTocoda() {
    return this.tocoda;
  }
  public void setTocoda(int tocoda) {
    this.tocoda = tocoda;
  }
  boolean fine = false;
  public boolean getFine() {
    return this.fine;
  }
  public void setFine(boolean fine) {
    this.fine = fine;
  }
  boolean isPizzicato = false;
  public boolean getPizzicato() {
    return this.isPizzicato;
  }
  public void setPizzicato(boolean pizz) {
    this.isPizzicato = pizz;
  }
  boolean forwardRepeat = false;
  public boolean getForwardRepeat() {
    return this.forwardRepeat;
  }
  public void setForwardRepeat(boolean repeat) {
    this.forwardRepeat = repeat;
  }
  int pedalPress = 0;
  public int getPedalPress() {
    return this.pedalPress;
  }
  public void setPedalPress(int press) {
    this.pedalPress = press;
  }
}