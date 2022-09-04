
public class App {
    public static void main(String[] args) throws Exception {
        //Reads customers balance transactions from an input.txt file into a queue
        InputReader.readInput();

        //2 threads to process the transactions from the queue to the balace hash table
        Thread TransactionsProcessor1 = new Thread(new TransactionsProcessor());
        Thread TransactionsProcessor2 = new Thread(new TransactionsProcessor());

        //Thread to print total balance to the console
        Thread balancePrinter = new Thread(new BalancePrinter());

        TransactionsProcessor1.start();
        TransactionsProcessor2.start();

        //The thread for the print waits for the 2 process thread to finish before execute
        TransactionsProcessor1.join();
        TransactionsProcessor2.join();
        
        balancePrinter.start();
    }
}
