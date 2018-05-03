package com.laba.credit.ui.employee;

import com.laba.credit.ServiceLocator;
import com.laba.credit.credit.CreditRequest;
import com.laba.credit.credit.CreditService;
import com.laba.credit.employee.Employee;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VerifierForm {
    private CreditService creditService = ServiceLocator.getInstance().getCreditService();

    public JPanel panel;
    private JTable table;

    public VerifierForm(Employee employee) {
        final List<CreditRequest> pendingRequests = creditService.getReviewedRequests();
        final List<CreditRequest> myVerifyingRequests = creditService.getVerifyingRequests(employee.getId());

        ArrayList<CreditRequest> requestsToShow = new ArrayList<CreditRequest>();
        requestsToShow.addAll(pendingRequests);
        requestsToShow.addAll(myVerifyingRequests);
        table.setModel(new CreditsTableModel(requestsToShow));

        // todo add buttons decline / complete
    }
}
