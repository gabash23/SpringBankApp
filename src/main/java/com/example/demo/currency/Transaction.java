package com.example.demo.currency;

import java.util.Date;


public class Transaction {
    Holder buyer;
    Holder seller;
    Integer exchanged;
    Date date;

    public Transaction(Holder buyer, Holder seller, Integer exchanged, Date date) throws NotEnoughMoneyException {
        this.buyer = buyer;
        this.seller = seller;
        this.exchanged = exchanged;
        this.date = date;
        exchange();
    }


    public void exchange() throws NotEnoughMoneyException {
        if (this.buyer.getMoney() < this.exchanged)
            throw new NotEnoughMoneyException("Buyer cannot afford this transaction");
        this.buyer.setMoney(this.buyer.getMoney() - exchanged);
        this.seller.setMoney(this.seller.getMoney() + exchanged);
    }

    public Holder getBuyer() {
        return buyer;
    }

    public void setBuyer(Holder buyer) {
        this.buyer = buyer;
    }

    public Holder getSeller() {
        return seller;
    }

    public void setSeller(Holder seller) {
        this.seller = seller;
    }

    public Integer getExchanged() {
        return exchanged;
    }

    public void setExchanged(Integer exchanged) {
        this.exchanged = exchanged;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "buyer=" + buyer +
                ", seller=" + seller +
                ", exchanged=" + exchanged +
                ", date=" + date +
                '}';
    }
}
