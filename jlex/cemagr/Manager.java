package cemagr;

/**
 * Created by marcoantonio on 12/5/17.
 */
public class Manager {
    private static GlobalBlockNode block;

    public static void init(GlobalBlockNode block1) {
        block = block1;
        //System.out.println(block);
        block.initGlobalReferences();
        GlobalBlockNode.initReferences();
        System.out.println(GlobalBlockNode.getRefs());
        System.out.println("FIN");
    }
}
