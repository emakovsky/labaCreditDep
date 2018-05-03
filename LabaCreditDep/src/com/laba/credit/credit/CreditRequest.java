package com.laba.credit.credit;

import java.io.Serializable;
import java.util.Date;

public class CreditRequest implements Serializable {

    private String id;

    private String clientId;

    private Date submitDate;

    private int sum;

    private String currency; //todo use enum here

    public CreditRequest(String id, String clientId, Date submitDate, int sum, String currency) {
        this.id = id;
        this.clientId = clientId;
        this.submitDate = submitDate;
        this.sum = sum;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public int getSum() {
        return sum;
    }

    public String getCurrency() {
        return currency;
    }
}
