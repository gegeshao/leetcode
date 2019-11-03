public class test2 {
    public static void main(String args[]){
        Position P= new Position(1,0,"N");
        Robot R= new Robot(P);
       R.Move(Command.LEFT);
       R.Move(Command.FORWARD);
       R.Move(Command.ROUND);
       R.Move(Command.BACKWARD);
       R.Move(Command.RIGHT);

        System.out.println(+R.Robot_Position.robot_x+"\t"+R.Robot_Position.robot_y+"\t"+R.Robot_Position.direction);
    }

}
