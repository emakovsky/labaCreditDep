package com.laba.credit.credit;

import java.io.Serializable;

public class CreditOperation implements Serializable {

    private String creditRequestId;

    private String assigneeEmployeeId;

    private CreditOperationStatus status;

    private CreditOperationResult result;

    private String declineReason;

    public CreditOperation(String creditRequestId, CreditOperationStatus status) {
        this.creditRequestId = creditRequestId;
        this.status = status;
    }

    public void setAssigneeEmployeeId(String assigneeEmployeeId) {
        this.assigneeEmployeeId = assigneeEmployeeId;
    }

    public void setStatus(CreditOperationStatus status) {
        this.status = status;
    }

    public void setResult(CreditOperationResult result) {
        this.result = result;
    }

    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }

    public String getCreditRequestId() {
        return creditRequestId;
    }

    public String getAssigneeEmployeeId() {
        return assigneeEmployeeId;
    }

    public CreditOperationStatus getStatus() {
        return status;
    }

    public CreditOperationResult getResult() {
        return result;
    }

    public String getDeclineReason() {
        return declineReason;
    }
}
