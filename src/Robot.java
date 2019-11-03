public class Robot {
    Position Robot_Position;
    int Angle =90;
    Robot(Position position){
        this.Robot_Position=position;
    }
    public void Move (Command command){
        Angle =Angle+command.getChangeAngle();
        if(Angle<0)
            Angle=Angle+360;
        Robot_Position.robot_y+=command.getDistance()*Math.sin(Math.PI*Angle/180);
        Robot_Position.robot_x+=command.getDistance()*Math.cos(Math.PI*Angle/180);
        Robot_Position.direction=Direction(Angle);
    }

    public String Direction(int Angle){
        String direction ="";
        switch (Angle){
            case 0:
                direction="E";
                break;
            case 90:
                direction="N";
                break;
            case 180:
                direction="W";
                break;
            case 270:
                direction="S";
                break;
            default:
                direction="undefine";
                break;
        }
       return direction;
    }
}
