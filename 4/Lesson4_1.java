public class Lesson4_1 {
    /*public static double sqrt  (double x) throws IllegalArgumentException {
        if(Double.compare(x, 0) < 0){
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
   }*/
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        if (stackTraceElements.length>2) {
            return String.format("%s#%s",
                                 stackTraceElements[2].getClassName(),
                                 stackTraceElements[2].getMethodName());
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }
    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }
}
