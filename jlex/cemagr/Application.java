package cemagr;

/**
 * Created by marcoantonio on 12/5/17.
 */
public class Application {
    private static boolean debug = true;
    private static int ref = 0;
    private static boolean error = false;

    public static boolean debug() {
        return debug;
    }

    public static int nextRef() {
        ref++;
        return ref;
    }

    public static void notifyError(String msg) {
        error = true;
        System.err.println("ERROR: " + msg);
    }

    public static final String DUPLICATED_MSG = "Símbolo duplicado";
}
