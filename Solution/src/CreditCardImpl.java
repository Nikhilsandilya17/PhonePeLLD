public class CreditCardImpl implements PaymentStrategy{

    @Override
    public boolean pay(double amount) {
        System.out.println("Credit Card Payment failed: "+ amount);
        return false;
    }
}
