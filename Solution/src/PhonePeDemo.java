import model.User;

public class PhonePeDemo {
    public static void main(String[] args) {
        PhonePeService phonePeService = PhonePeService.getInstance();

        User user = new User("Nikhil", "12345");
        phonePeService.registerUser(user);
        phonePeService.addMoneyToWallet(user, 300.0);
        phonePeService.addMoneyToWallet(user, 100.0);
        phonePeService.addMoneyToWallet(user, 200.0);
        phonePeService.setPaymentStrategy(new CreditCardImpl());
        phonePeService.addMoneyToWallet(user, 200.0);

        phonePeService.getBalance(user);
        phonePeService.sortTransactionByCriteria(user, new SortTransactionByAmountStrategy());
        phonePeService.sortTransactionByCriteria(user, new SortTransactionByDateStrategy());


    }
}
