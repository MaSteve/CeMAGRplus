package cemagr;

import java.io.IOException;

/**
 * Created by marcoantonio on 12/5/17.
 */
public class Manager {
    private static GlobalBlockNode block;

    public static void init(GlobalBlockNode block1) throws IOException {
        if (Application.isOK()) {
            block = block1;
            GlobalBlockNode.reset();
            block.initGlobalReferences();
            GlobalBlockNode.initReferences();
            boolean check = GlobalBlockNode.typeChecker();
            System.out.println("CHECK: " + check);
            if (check && Application.isOK() && GlobalBlockNode.hasMain()) {
                Application.prepare();
                block.translate();
                Application.close();
            } else {
                System.out.println("Compilation error");
            }
        } else {
            System.out.println("Compilation error");
        }
        System.out.println("FIN");
    }
}
