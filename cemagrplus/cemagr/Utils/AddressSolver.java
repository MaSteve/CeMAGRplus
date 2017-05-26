package cemagr.Utils;

/**
 * Created by marcoantonio on 15/5/17.
 */
public class AddressSolver {
    private int address = 0;
    private int MAX = 0;
    private int offSet;

    public AddressSolver() {
        offSet = 0;
    }

    public AddressSolver(int val) {
        offSet = val;
    }

    public AddressSolver(AddressSolver addressSolver) {
        address = addressSolver.address;
        offSet = addressSolver.offSet;
    }

    public int getAddress() {
        address++;
        return address + offSet - 1;
    }

    public int getAddress(int size) {
        address += size;
        return address + offSet - size;
    }

    public void max(AddressSolver solver) {
        if (solver.getSize() > MAX) MAX = solver.getSize();
    }

    public int getSize() {
        return address > MAX? address: MAX;
    }
}
