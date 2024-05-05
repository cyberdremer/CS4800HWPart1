package States;

public interface StateOfVendingMachine<VendingMachine> {
    void selectSnack(VendingMachine vendingMachine, Snack snack);
    void insertPayment(VendingMachine vendingMachine, int payment);

    void dispenseSnack(VendingMachine vendingMachine);
}
