import model.Transaction;

import java.util.Comparator;
import java.util.List;

public class SortTransactionByAmountStrategy implements SortTransactionsStrategy {

    @Override
    public List<Transaction> sortTransactionByCriteria(List<Transaction> transactionList) {
        transactionList.sort(Comparator.comparingDouble(Transaction::getAmount));
        return transactionList;

    }
}
