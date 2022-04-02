import java.util.logging.Logger;
import java.util.logging.*;

public class Lesson4_3 {

    public static void main(String[] args) {
           configureLogging();
        }

        private static void configureLogging() {
            Logger Logger1 = Logger.getLogger("org.stepic.java.logging.ClassA");
            Logger1.setLevel(Level.ALL);
            Logger Logger2 = Logger.getLogger("org.stepic.java.logging.ClassB");
            Logger2.setLevel(Level.WARNING);
            Logger Logger3 = Logger.getLogger("org.stepic.java");
            ConsoleHandler handler = new ConsoleHandler();
            handler.setLevel(Level.ALL);
            handler.setFormatter(new XMLFormatter());
            Logger3.addHandler(handler);
            Logger3.setUseParentHandlers(false);

        }
}





