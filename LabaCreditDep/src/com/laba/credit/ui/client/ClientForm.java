package com.laba.credit.ui.client;

import com.laba.credit.ServiceLocator;
import com.laba.credit.client.Client;
import com.laba.credit.credit.CreditRequest;
import com.laba.credit.utils.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ClientForm {
    private JPanel panel;
    private JEditorPane creditSumEditorPane;
    private JEditorPane currencyEditorPane;
    private JButton submitButton;

    private Client client;

    public ClientForm(final Client client) {
        this.client = client;

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreditRequest request = new CreditRequest(
                        Utils.generateId(),
                        client.getId(),
                        new Date(),
                        Integer.valueOf(creditSumEditorPane.getText()),//todo: validate
                        currencyEditorPane.getText()
                );

                ServiceLocator.getInstance().getCreditService().addCreditRequest(request);

                JOptionPane.showMessageDialog(panel, "Request submitted");
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
