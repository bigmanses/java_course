import static java.awt.Event.UP;

public class Lesson3_1 {
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
        Robot bob = new Robot(0, 0, Robot.Direction.DOWN);
        moveRobot(bob, 3, 0);
        System.out.println(bob.getX()); //1
        System.out.println(bob.getY());
    }
}