Balance Calculator Exercise


The program  reads customers balance transactions from an input.txt file 
and prints the total balance for each customer according to the following rules:


Read the transactions from the input file into a queue.
Once done, two threads are processing the transactions.
Another thread is waiting for them to finish processing the transactions and then prints the total balance to the console.


Notes:
* In the input file, each line contains a transaction_id(not unique), customer_name, and a sum.
* The final balance output will be printed in the format of customer_name: total_balance.