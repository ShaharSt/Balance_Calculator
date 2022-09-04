import java.util.*;

public class CustomersBalanceThreadSafe {

    // private instance, so that it can be
    // accessed only by getInstance() method
    private static CustomersBalanceThreadSafe customersBalanceInstance ;
        
    public Hashtable<String, Integer> customersBalance = null;
    
    // private constractor
    private CustomersBalanceThreadSafe(){
        this.customersBalance = new Hashtable<String, Integer>(); 
    }

    // synchronized getInstance method so both threads will access the same instance
    synchronized public static CustomersBalanceThreadSafe getCustomersBalanceInstance(){
        if (customersBalanceInstance == null){
            customersBalanceInstance = new CustomersBalanceThreadSafe();
        }
        return customersBalanceInstance;
    }

    // synchronized put
    public synchronized void put(String name, Integer amount){
        if (customersBalance.containsKey(name)) {
            Integer previous = customersBalance.get(name);
            this.customersBalance.put(name, previous+amount);
        }
        else {
            this.customersBalance.put(name, amount);
        }
    }

    public void print(){
        for(String name: this.customersBalance.keySet()){
            Integer amount = this.customersBalance.get(name);
            System.out.println(name + ": " + amount);
        }
    }
}