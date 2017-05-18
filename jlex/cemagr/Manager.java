package cemagr;

/**
 * Created by marcoantonio on 12/5/17.
 */
public class Manager {
    private static GlobalBlockNode block;

    public static void init(GlobalBlockNode block1) {
        if (Application.isOK()) {
            block = block1;
            //System.out.println(block);
            block.initGlobalReferences();
            GlobalBlockNode.initReferences();
            boolean check = GlobalBlockNode.typeChecker();
            System.out.println("CHECK: " + check);
            //System.out.println("Memory: " + block1.getDeclSize());
            if (check && Application.isOK() && GlobalBlockNode.hasMain()) {
                block.translate();
            }
        }
        System.out.println("FIN");

    }
}
