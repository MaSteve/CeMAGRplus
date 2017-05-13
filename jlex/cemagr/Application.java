package cemagr;

/**
 * Created by marcoantonio on 12/5/17.
 */
public class Application {
    private static boolean debug = false;
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
    public static final String UNKNOWN_MSG = "Símbolo desconocido";
    public static final String TYPE_MSG = "Lío de tipos";
    public static final String TYPE_EXP_MSG = "Tipo esperado: ";
    public static final String DEREFENCE_MSG = "No se puede derrefenciar la variable ";
    public static final String ADDRESS_MSG = "No se puede obtener la direccion de ";
    public static final String ARRAY_MSG = "No es un array ";
    public static final String ARRAY2_MSG = "Indice indeterminado de ";
}
