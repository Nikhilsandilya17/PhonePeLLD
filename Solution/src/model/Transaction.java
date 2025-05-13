package model;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private double amount;
    private LocalDateTime date;
    private User toUser;
    private User fromUser;

    public Transaction(double amount, LocalDateTime date, User toUser, User fromUser) {
        this.amount = amount;
        this.date = date;
        this.toUser = toUser;
        this.fromUser = fromUser;
    }


    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", toUser=" + toUser +
                ", fromUser=" + fromUser +
                '}';
    }
}
