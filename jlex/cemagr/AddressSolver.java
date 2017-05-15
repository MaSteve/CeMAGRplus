package cemagr;

/**
 * Created by marcoantonio on 15/5/17.
 */
public class AddressSolver {
    private int address = 0;

    public int getAddress() {
        address++;
        return address - 1;
    }
}
