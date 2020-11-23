package com.assignment.kafka.model;

public class ResponseToBank {


    private long total_amount;
    private String account_no;
    private String transactionDate;
    private String sourceApplication;


    public long getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(long total_amount) {
        this.total_amount = total_amount;
    }

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSourceApplication() {
        return sourceApplication;
    }

    public void setSourceApplication(String sourceApplication) {
        this.sourceApplication = sourceApplication;
    }

    @Override
    public String toString() {
        return "ResponseToBank{" +
                "total_amount=" + total_amount +
                ", account_no=" + account_no +
                ", transactionDate='" + transactionDate + '\'' +
                ", sourceApplication='" + sourceApplication + '\'' +
                '}';
    }
}
