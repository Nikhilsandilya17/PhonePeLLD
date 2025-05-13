public class DebitCardImpl implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Debit Card Payment successful: "+ amount);
        return true;
    }
}
