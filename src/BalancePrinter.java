public class BalancePrinter extends Thread {
    public void run() {
        CustomersBalanceThreadSafe customersBalance =  CustomersBalanceThreadSafe.getCustomersBalanceInstance();
        customersBalance.print();
    }
}
