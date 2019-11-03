public enum Command {

    LEFT  (90,0),
    RIGHT(-90,0),
    ROUND(-180,0),
    FORWARD(0,1),
    BACKWARD(0,-1);



    private int STEP_LENGTH=1;
    private int changeAngle;
    private int distance;
    private Command(int changeAngle,int distance) {
        this.changeAngle = changeAngle;
        this.distance = distance;
    }

    public int getChangeAngle() {
        return changeAngle;
    }
    public int getDistance() {
        return distance;
    }
    public void setChangeAngle(int changeAngle) {
        this.changeAngle = changeAngle;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

}
