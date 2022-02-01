import java.io.File;
import java.io.IOException;

public class Lesson4_2<RobotConnectionManager1> {
    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }
    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public static class RobotConnectionException extends RuntimeException { //Искючение

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

   public static class RobotConnection1 implements RobotConnection { //Устанавливает соединение

       @Override
       public void moveRobotTo(int x, int y) {
           Robot bob = new Robot(0, 0, Robot.Direction.DOWN);
           moveRobot(bob, 3, 0);
       }
       @Override
       public void close() {

       }
   }

    public static class RobotConnectionManager1 implements RobotConnectionManager {
        public RobotConnection getConnection(){
            return new RobotConnection1();
        }

    }
    public static void moveRobot1(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        // your implementation here
        int i = 1;
        boolean flag = false;
        Object help_2 = null;
        for (; i < 2 || flag ; i++) {
            try {
                RobotConnection help = robotConnectionManager.getConnection();
                help_2 = help;
                if(help_2 != null) {
                    help.moveRobotTo(toX, toY);
                }
            } catch (RobotConnectionException e) {
                flag = i != 3;
                if(!flag)
                    throw new RobotConnectionException("Ошибка соединения");
            }
            finally {
                if(help_2 != null)
                    try {
                    ((RobotConnection) help_2).close();
                    }
                    catch (Exception e){

                    }
                    }

        }

    }


    public static class Robot {
        public int x = 0, y = 0;
        Direction sight ;
        public Robot(int x, int y, Direction sight){
            this.x = x;
            this.y = y;
            this.sight = sight;
        }
        public Direction getDirection() {
            return sight;// текущее направление взгляда
        }

        public int getX() {
            return x; // текущая координата X
        }

        public int getY() {
            return y;// текущая координата Y
        }

        public void turnLeft() {
            if(sight == Direction.UP)
                sight = Direction.LEFT;
            else if(sight == Direction.LEFT)
                sight = Direction.DOWN;
            else if(sight == Direction.DOWN)
                sight = Direction.RIGHT;
            else if(sight == Direction.RIGHT)
                sight = Direction.UP;
            // повернуться на 90 градусов против часовой стрелки
        }

        public void turnRight() {
            if(sight == Direction.UP)
                sight = Direction.RIGHT;
            else if(sight == Direction.RIGHT)
                sight = Direction.DOWN;
            else if(sight == Direction.DOWN)
                sight = Direction.LEFT;
            else if(sight == Direction.LEFT)
                sight = Direction.UP;
            // повернуться на 90 градусов по часовой стрелке
        }

        public void stepForward() {
            if(sight == Direction.UP)
                y+=1;
            else if(sight == Direction.DOWN)
                y-=1;
            else if(sight == Direction.LEFT)
                x-=1;
            else if(sight == Direction.RIGHT)
                x+=1;
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу
        }
        public enum Direction {
            UP,
            DOWN,
            LEFT,
            RIGHT
        }
    }
    public static void moveRobot(Robot robot, int toX, int toY) {
        /* Двигаем робот по оси ОХ */
        if(robot.getX() > toX){
            while (robot.getDirection() != Robot.Direction.LEFT){
                robot.turnRight();
            }
        }
        else if(robot.getX() < toX){
            while (robot.getDirection() != Robot.Direction.RIGHT){
                robot.turnRight();
            }
        }
        while (robot.getX() != toX){
            robot.stepForward();
        }
        /*                          */
        /* Двигаем робот по оси ОY */
        if(robot.getY() > toY){
            while (robot.getDirection() != Robot.Direction.DOWN){
                robot.turnRight();
            }
        }
        else if(robot.getY() < toY){
            while (robot.getDirection() != Robot.Direction.UP){
                robot.turnRight();
            }
        }
        while (robot.getY() != toY){
            robot.stepForward();
        }
    }
    public static void main(String[] args) {
        Lesson4_2.RobotConnectionManager1 a = new Lesson4_2.RobotConnectionManager1();
        moveRobot1(a, 0, 3);

    }
}
