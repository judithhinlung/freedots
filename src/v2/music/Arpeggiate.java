package v2.music;
/** Indicates that a note is part of an arpeggiated chord */
public class Arpeggiate {
  /**
  * @param number  Used to distinguish between two simultaneous arpeggiated chords 
  * @param direction  up/down, indicates the direction of the arpeggio
  */
  int number;
  String direction;
  public Arpeggiate() {
    this.direction = "up";
    this.number = 0;
  }
  public Arpeggiate(int number, String direction) throws IllegalArgumentException {
    if (!(direction.equals("up")) || (direction.equals("down"))) {
	     throw new IllegalArgumentException("Invalid arpeggiate direction: " + direction);
    }
    this.number = number;
    this.direction = direction;
  }
  public int getNumber() {
   return this.number;
  }
  public String getDirection() {
    return this.direction;
  }
}
