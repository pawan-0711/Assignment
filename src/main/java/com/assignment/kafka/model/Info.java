package com.assignment.kafka.model;


public class Info {

    private String payment_mode;
    private String gateway;
    private long previous_balance;
    private long credit_amount;
    private long account_no;
    private String transactionDate;

    public Info() {
    }

    public Info(String payment_mode, String gateway, long previous_balance, long credit_amount, long account_no, String transactionDate) {
        this.payment_mode = payment_mode;
        this.gateway = gateway;
        this.previous_balance = previous_balance;
        this.credit_amount = credit_amount;
        this.account_no = account_no;
        this.transactionDate = transactionDate;
    }


    public String getPayment_mode() {
        return payment_mode;
    }

    public String getGateway() {
        return gateway;
    }

    public long getPrevious_balance() {
        return previous_balance;
    }

    public long getCredit_amount() {
        return credit_amount;
    }

    public long getAccount_no() {
        return account_no;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Info{" +
                "payment_mode='" + payment_mode + '\'' +
                ", gateway='" + gateway + '\'' +
                ", previous_balance=" + previous_balance +
                ", credit_amount=" + credit_amount +
                ", account_no=" + account_no +
                ", transactionDate='" + transactionDate + '\'' +
                '}';
    }
}
