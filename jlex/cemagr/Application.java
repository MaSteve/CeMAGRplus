package cemagr;

/**
 * Created by marcoantonio on 12/5/17.
 */
public class Application {
    private static boolean debug = false;
    private static boolean error = false;
    private static int instID = 0;

    public static boolean debug() {
        return debug;
    }

    public static int nextRef() {
        return instID;
    }

    public static boolean isOK() {
        return !error;
    }

    public static void notifyError(String msg) {
        error = true;
        System.err.println("ERROR: " + msg);
    }

    public static void newComment(String comment) {
        String output = "{" + instID + "}";
        save(comment);
    }

    public static void newInst(String inst) {
        String output = "{" + instID + "} " + inst + ";";
        save(output);
        instID++;
    }

    public static int jump(int len) {
        return instID + len + 1;
    }

    public static int getInstID() {
        return instID;
    }

    private static void save(String s) {
        //TODO: Use a file.
        System.out.println(s);
    }

    public static final String LEX_MSG = "Error léxico: ";
    public static final String SYNTAX_MSG = "Error sintáctico: ";
    public static final String DUPLICATED_MSG = "Símbolo duplicado";
    public static final String UNKNOWN_MSG = "Símbolo desconocido";
    public static final String TYPE_MSG = "Lío de tipos";
    public static final String TYPE_EXP_MSG = "Tipo esperado: ";
    public static final String DEREFENCE_MSG = "No se puede derrefenciar la variable ";
    public static final String ADDRESS_MSG = "No se puede obtener la direccion de ";
    public static final String ARRAY_MSG = "No es un array ";
    public static final String ARRAY2_MSG = "Indice indeterminado de ";
    public static final String ARRAY3_MSG = " es un array";
    public static final String ARG_MSG = "No existe esa signatura para ";
    public static final String ZERO_MSG = "Tamaño 0";
    public static final String MAIN_MSG = "Función main no encontrada";
}
