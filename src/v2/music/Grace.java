package v2.music;
public class Grace {
  int stealTimePrevious;
  int stealTimeFollowing;
  int makeTime;
  boolean slash;

  public Grace() {
    this.stealTimePrevious = 0;
    this.stealTimeFollowing = 0;
    this.makeTime = 0;
    this.slash = false;
  }
  public Grace(int stealTimePrevious, int stealTimeFollowing, int makeTime, boolean slash) {
    this.stealTimePrevious = stealTimePrevious;
    this.stealTimeFollowing = stealTimeFollowing;
    this.makeTime = makeTime;
    this.slash = slash;
  }
}
