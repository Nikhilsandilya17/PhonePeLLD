import model.Transaction;
import model.User;
import model.Wallet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhonePeService {
    private static PhonePeService instance;
    private Map<String, User> users;
    private Map<User, List<Transaction>> transactions;
    private SortTransactionsStrategy sortTransactionsStrategy;
    private PaymentStrategy paymentStrategy;


    private PhonePeService() {
        users = new HashMap<>();
        transactions = new HashMap<>();
        paymentStrategy = new DebitCardImpl();

    }

    public void setSortTransactions(SortTransactionsStrategy sortTransactionsStrategy) {
        this.sortTransactionsStrategy = sortTransactionsStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public static PhonePeService getInstance() {
        if (instance == null) {
            instance = new PhonePeService();
        }
        return instance;
    }

    public void registerUser(User user) {
        users.put(user.getPhone(), user);
        System.out.println("Registering User: " + user.toString());
    }

    public void getBalance(User user){
        System.out.println("User Balance in wallet is: " + user.getWallet().getBalance());
    }

    public void sortTransactionByCriteria(User user, SortTransactionsStrategy sortTransactionsStrategy){
        System.out.println("Transactions sorted by date are: ");
        List<Transaction> transactionList = transactions.get(user);
        if(transactionList == null){
            System.out.println("Transactions are empty");
        }
        List<Transaction> transactionsByDate = sortTransactionsStrategy.sortTransactionByCriteria(transactionList);
        printTransactions(transactionsByDate);
    }

    public void addMoneyToWallet(User user, double amount) {
        Transaction transaction = createTransaction(user, amount);
        if (paymentStrategy.pay(transaction.getAmount()) && transaction.getAmount() > 0) {
            topUpWallet(user, transaction.getAmount());
            recordTransaction(user, transaction);
            System.out.println("Added " + transaction.getAmount() + " to wallet of user: " + user);
        } else {
            System.out.println("Payment failed. Wallet top-up declined for user: " + user.getName());
        }
    }

    private Transaction createTransaction(User user, double amount) {
        return new Transaction(amount, LocalDateTime.now(), user, user);
    }

    private void topUpWallet(User user, double amount) {
        Wallet wallet = user.getWallet();
        wallet.setBalance(wallet.getBalance() + amount);
    }

    private void recordTransaction(User user, Transaction transaction) {
        transactions.computeIfAbsent(user, k -> new ArrayList<>()).add(transaction);
    }

    private void printTransactions(List<Transaction> transactionList) {
        for(Transaction transaction : transactionList){
            System.out.println(transaction.toString());
        }
    }

}