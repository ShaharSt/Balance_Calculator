
public class TransactionsProcessor extends Thread {
    
    TransactionsQueueThreadSafe transactionsQueue = TransactionsQueueThreadSafe.getTransactionsQueueInstance();
    CustomersBalanceThreadSafe customersBalance =  CustomersBalanceThreadSafe.getCustomersBalanceInstance();
    
    private Transaction current = null;

    public void run() {
        
        while((current = transactionsQueue.poll()) != null){
                customersBalance.put(current.name, current.amount);                
        }
    }
}
