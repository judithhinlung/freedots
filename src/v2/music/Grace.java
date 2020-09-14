package v2.music;
public class Grace {
  private int stealTimePrevious;
  private int stealTimeFollowing;
  private int makeTime;
  private boolean slash;

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
