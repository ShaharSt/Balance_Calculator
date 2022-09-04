import java.io.*;

public class InputReader  {
    static FileReader fileReader = null;
    static BufferedReader bufferreader = null;
    static String line;

    // this is a new branch
    public static void readInput (){
        try {
            //Transactions queue
            TransactionsQueueThreadSafe transactions = TransactionsQueueThreadSafe.getTransactionsQueueInstance();
            
            //The input file locate in a local input directory
            String basePath = new File("").getAbsolutePath();
            fileReader = new FileReader(basePath+"/input/input.txt"); // this does not work for linux, fixed backslash
            bufferreader = new BufferedReader(new FileReader(basePath+"/input/input.txt"));

            //Read the input file line by line
            while ((line = bufferreader.readLine()) != null) {     
                String[] prop = line.split(",");
                //Parse input line to a transaction
                Transaction trans = new Transaction(prop[1], Integer.parseInt(prop[2]));
                transactions.add(trans);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally
        {
            try{fileReader.close();}catch(Exception e){}
            try{bufferreader.close();}catch(Exception e){}
        }
    }
}
