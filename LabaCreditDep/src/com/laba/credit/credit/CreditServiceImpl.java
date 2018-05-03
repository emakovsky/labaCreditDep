package com.laba.credit.credit;

import com.laba.credit.employee.EmployeeService;
import com.laba.credit.util.SerializationUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CreditServiceImpl implements CreditService {
    private static final String REQUESTS_FILE = "SerializedCreditRequests.dat";
    private static final String OPERATIONS_FILE = "SerializedCreditOperations.dat";

    private HashSet<CreditRequest> requests = new HashSet<CreditRequest>();
    private HashSet<CreditOperation> operations = new HashSet<CreditOperation>();

    public CreditServiceImpl() {
        Object restored = new SerializationUtils().restoreObjectFromFile(REQUESTS_FILE);
        if (restored != null && restored instanceof HashSet) {
            requests = (HashSet<CreditRequest>) restored;
            System.out.println("restored requests: " + requests.size());
        }

        Object restoredOperations = new SerializationUtils().restoreObjectFromFile(OPERATIONS_FILE);
        if (restoredOperations != null && restoredOperations instanceof HashSet) {
            operations = (HashSet<CreditOperation>) restoredOperations;
            System.out.println("restored operations: " + operations.size());
        }
    }

    @Override
    public void addCreditRequest(CreditRequest creditRequest) {
        requests.add(creditRequest);
        operations.add(new CreditOperation(
                creditRequest.getId(),
                CreditOperationStatus.PENDING
        ));

        persistAll();
    }

    @Override
    public List<CreditRequest> getPendingRequests() {
        List<CreditRequest> result = new ArrayList<CreditRequest>();
        for (CreditOperation operation : operations) {
            if (operation.getStatus() == CreditOperationStatus.PENDING) {
                CreditRequest request = findRequestById(operation.getCreditRequestId());
                if (request != null) {
                    result.add(request);
                } else {
                    System.out.println("request not found for id: " + operation.getCreditRequestId());
                }
            }
        }
        return result;
    }

    @Override
    public List<CreditRequest> getReviewingRequests(String creditorEmployeeId) {
        List<CreditRequest> result = new ArrayList<CreditRequest>();
        for (CreditOperation operation : operations) {
            if (operation.getStatus() == CreditOperationStatus.REVIEWING && creditorEmployeeId.equals(operation.getAssigneeEmployeeId())) {
                CreditRequest request = findRequestById(operation.getCreditRequestId());
                if (request != null) {
                    result.add(request);
                } else {
                    System.out.println("request not found for id: " + operation.getCreditRequestId());
                }
            }
        }
        return result;
    }

    @Override
    public List<CreditRequest> getReviewedRequests() {
        //todo get rid of cope paste
        List<CreditRequest> result = new ArrayList<CreditRequest>();
        for (CreditOperation operation : operations) {
            if (operation.getStatus() == CreditOperationStatus.REVIEW_SUCCEDED) {
                CreditRequest request = findRequestById(operation.getCreditRequestId());
                if (request != null) {
                    result.add(request);
                } else {
                    System.out.println("request not found for id: " + operation.getCreditRequestId());
                }
            }
        }
        return result;
    }

    @Override
    public List<CreditRequest> getVerifyingRequests(String creditorEmployeeId) {
        List<CreditRequest> result = new ArrayList<CreditRequest>();
        for (CreditOperation operation : operations) {
            if (operation.getStatus() == CreditOperationStatus.VERIFYING && creditorEmployeeId.equals(operation.getAssigneeEmployeeId())) {
                CreditRequest request = findRequestById(operation.getCreditRequestId());
                if (request != null) {
                    result.add(request);
                } else {
                    System.out.println("request not found for id: " + operation.getCreditRequestId());
                }
            }
        }
        return result;
    }

    @Override
    public void startReviewing(String requestId, String creditorEmployeeId) {
        CreditOperation operation = findOperationByRequestId(requestId);

        if (operation != null) {
            operation.setStatus(CreditOperationStatus.REVIEWING);
            operation.setAssigneeEmployeeId(creditorEmployeeId);

            persistAll();
        } else {
            System.out.println("operation not found for request id: " + requestId);
        }
    }

    @Override
    public void passReview(String requestId, String creditorEmployeeId) {
        CreditOperation operation = findOperationByRequestId(requestId);

        if (operation != null) {
            operation.setStatus(CreditOperationStatus.REVIEW_SUCCEDED);

            persistAll();
        } else {
            System.out.println("operation not found for request id: " + requestId);
        }
    }

    @Override
    public void failReview(String requestId, String creditorEmployeeId, String failReason) {
        CreditOperation operation = findOperationByRequestId(requestId);

        if (operation != null) {
            operation.setStatus(CreditOperationStatus.COMPLETED);
            operation.setResult(CreditOperationResult.DECLINED);
            operation.setDeclineReason(failReason);
        } else {
            System.out.println("operation not found for request id: " + requestId);
        }
    }

    @Override
    public CreditOperationStatus getStatus(String requestId) {
        CreditOperation operation = findOperationByRequestId(requestId);
        return operation == null ? null : operation.getStatus();
    }

    private CreditRequest findRequestById(String requestId) {
        for (CreditRequest request : requests) {
            if (request.getId().equals(requestId)) {
                return request;
            }
        }
        return null;
    }

    private CreditOperation findOperationByRequestId(String requestId) {
        for (CreditOperation operation : operations) {
            if (operation.getCreditRequestId().equals(requestId)) {
                return operation;
            }
        }
        return null;
    }

    private void persistAll() {
        SerializationUtils serializationUtils = new SerializationUtils();

        serializationUtils.saveObjectToFile(REQUESTS_FILE, requests);
        System.out.println("saved requests: " + requests.size());

        serializationUtils.saveObjectToFile(OPERATIONS_FILE, operations);
        System.out.println("saved operations: " + operations.size());
    }
}
