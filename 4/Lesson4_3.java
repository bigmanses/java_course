import java.util.logging.Logger;
import java.util.logging.*;
import java.util.Arrays;


public class Lesson4_3 {
    /**
     * Created by vitaly on 28/09/16.
     */
    public static class A{

    }
    public static class B{

    }
    public static final Logger LOGGER = Logger.getLogger(Lesson4_3.class.getName());

    public static void main(String[] args) {
            // default logging level INFO, all finer events will be ignored
            // default level could be redefined in .properties config file
            LOGGER.log(Level.FINE, "Started with arguments: {0}", Arrays.toString(args));

            try {

            }
            catch (IllegalStateException e) {
                LOGGER.log(Level.SEVERE, "Exception caught", e);
                System.exit(2);
            }
            LOGGER.fine("Finished successfully");

        }

    private static void configureLogging() {

            final Logger LOGGER_1 = Logger.getLogger(A.class.getName());
            LOGGER_1.setLevel(Level.ALL);
            final Logger LOGGER_2 = Logger.getLogger(B.class.getName());
            LOGGER_2.setLevel(Level.WARNING);
           // final Logger LOGGER_3 = Logger.getLogger(java.class.getName());
           // LOGGER_3.setUseParentHandlers(false);
            Handler handler_1 = new ConsoleHandler();
            handler_1.setLevel(Level.ALL);
            Formatter formatter = new XMLFormatter();
            handler_1.setFormatter(formatter);
           // LOGGER_3.addHandler(handler_1);


        }


    }


