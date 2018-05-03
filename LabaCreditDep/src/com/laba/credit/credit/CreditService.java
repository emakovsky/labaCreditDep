package com.laba.credit.credit;

import java.util.List;

public interface CreditService {

    void addCreditRequest(CreditRequest creditRequest);

    List<CreditRequest> getPendingRequests();

    List<CreditRequest> getReviewingRequests(String creditorEmployeeId);

    List<CreditRequest> getReviewedRequests();

    List<CreditRequest> getVerifyingRequests(String creditorEmployeeId);

    void startReviewing(String requestId, String creditorEmployeeId);

    void passReview(String requestId, String creditorEmployeeId);

    void failReview(String requestId, String creditorEmployeeId, String failReason);

    CreditOperationStatus getStatus(String requestId);
}
