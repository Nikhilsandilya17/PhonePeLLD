import model.Transaction;

import java.util.List;

public interface SortTransactionsStrategy {
    public List<Transaction> sortTransactionByCriteria(List<Transaction> transactionList);



}
