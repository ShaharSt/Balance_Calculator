import java.util.concurrent.ConcurrentLinkedQueue;

public class TransactionsQueueThreadSafe  {
    
    // private instance, so that it can be
    // accessed only by getInstance() method
    private static TransactionsQueueThreadSafe transactionsInstance;
    
    // Java util that is thread safe
    public ConcurrentLinkedQueue<Transaction> transactionsQueue = null;

    // private constractor
    private TransactionsQueueThreadSafe() {
        this.transactionsQueue = new ConcurrentLinkedQueue<>();
    }

    // synchronized getInstance method so both threads will access the same instance
    synchronized public static TransactionsQueueThreadSafe getTransactionsQueueInstance(){
        if(transactionsInstance == null){
            transactionsInstance = new TransactionsQueueThreadSafe();
        }
        return transactionsInstance;
    }

    public void add(Transaction trans) {
        transactionsQueue.add(trans);
    }

    public Transaction poll() {
        return transactionsQueue.poll();
    }

    public Transaction peek() {
        return transactionsQueue.peek();
    }
}
