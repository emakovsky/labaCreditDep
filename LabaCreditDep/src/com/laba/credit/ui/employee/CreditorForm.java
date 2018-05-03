package com.laba.credit.ui.employee;

import com.laba.credit.ServiceLocator;
import com.laba.credit.credit.CreditRequest;
import com.laba.credit.credit.CreditService;
import com.laba.credit.employee.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreditorForm {
    private CreditService creditService = ServiceLocator.getInstance().getCreditService();

    public JPanel panel;
    private JTable table;
    private JButton startReviewingButton;
    private JButton markPassedButton;
    private JButton declineButton;

    public CreditorForm(final Employee employee) {
        final List<CreditRequest> pendingRequests = creditService.getPendingRequests();
        final List<CreditRequest> myReviewingRequests = creditService.getReviewingRequests(employee.getId());

        final ArrayList<CreditRequest> requestsToShow = new ArrayList<CreditRequest>();
        requestsToShow.addAll(pendingRequests);
        requestsToShow.addAll(myReviewingRequests);
        table.setModel(new CreditsTableModel(requestsToShow));

        //todo on selection changed -> change buttons visibility
        //todo update table right after startReviewing / passReview

        startReviewingButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow >= 0) {
                            creditService.startReviewing(requestsToShow.get(selectedRow).getId(), employee.getId());
                        }
                    }
                });

        markPassedButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow >= 0) {
                            creditService.passReview(requestsToShow.get(selectedRow).getId(), employee.getId());
                        }
                    }
                });
    }

    public JPanel getPanel() {
        return panel;
    }
}
