package com.laba.credit.client;

import java.io.Serializable;

/**
 *
 */
public class Client implements Serializable {
    private String id;
    private String operatorEmployeeId;
    private String name;
    private String password;
    private String passport;

    public Client(String id, String operatorEmployeeId, String name, String password, String passport) {
        this.id = id;
        this.operatorEmployeeId = operatorEmployeeId;
        this.name = name;
        this.password = password;
        this.passport = passport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOperatorEmployeeId() {
        return operatorEmployeeId;
    }

    public void setOperatorEmployeeId(String operatorEmployeeId) {
        this.operatorEmployeeId = operatorEmployeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Client client = (Client) o;

        return id.equals(client.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
