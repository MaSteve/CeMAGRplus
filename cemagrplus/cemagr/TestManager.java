package cemagr;

import cemagr.parser.parser;

import java.io.File;
import java.io.PrintStream;

/**
 * Created by marcoantonio on 20/5/17.
 */
public class TestManager {
    public static void main(String args[]) throws Exception {
        File folder = new File("../Examples");
        if (folder.exists()) {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    File test = fileEntry.getAbsoluteFile();
                    for (final File prog : test.listFiles()) {
                        if (prog.getName().matches("(.*).cemagr")) {
                            System.out.println(prog.getCanonicalPath());
                            String [] nargs = new String[2];
                            nargs[0] = prog.getCanonicalPath();
                            nargs[1] = test.getCanonicalPath() + "/a.asm";
                            try {
                                System.setErr(new PrintStream(test.getCanonicalPath() + "/out.err"));
                                Application.reset();
                                parser.main(nargs);
                                System.err.flush();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
