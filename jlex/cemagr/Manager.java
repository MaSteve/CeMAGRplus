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
            //System.out.println(block);
            block.initGlobalReferences();
            GlobalBlockNode.initReferences();
            boolean check = GlobalBlockNode.typeChecker();
            System.out.println("CHECK: " + check);
            //System.out.println("Memory: " + block1.sizeAndSolve());
            if (check && Application.isOK() && GlobalBlockNode.hasMain()) {
                Application.prepare();
                block.translate();
            }
        }
        System.out.println("FIN");
    }
}
