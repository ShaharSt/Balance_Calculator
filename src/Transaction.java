public class Transaction {
    String name;
    Integer amount;

    public Transaction(String name, Integer amount){
        this.name = name;
        this.amount = amount;
    }

    public String myToString() {
        return "name: " + this.name + " ; amount: " + this.amount;
    }
}

