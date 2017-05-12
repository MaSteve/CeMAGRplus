package cemagr;

/**
 * Created by marcoantonio on 12/5/17.
 */
public class Application {
    private static boolean debug = false;
    private static int ref = 0;

    public static boolean debug() {
        return debug;
    }

    public static int nextRef() {
        ref++;
        return ref;
    }
}
