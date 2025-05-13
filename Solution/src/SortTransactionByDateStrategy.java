import model.Transaction;

import java.util.Comparator;
import java.util.List;

public class SortTransactionByDateStrategy implements SortTransactionsStrategy {


    @Override
    public List<Transaction> sortTransactionByCriteria(List<Transaction> transactionList) {
        transactionList.sort(Comparator.comparing(Transaction::getDate));
        return transactionList;
    }
}
