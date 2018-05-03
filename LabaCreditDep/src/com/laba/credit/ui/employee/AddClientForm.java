package com.laba.credit.ui.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.laba.credit.ServiceLocator;
import com.laba.credit.client.Client;
import com.laba.credit.client.ClientService;
import com.laba.credit.client.ClientServiceImpl;
import com.laba.credit.employee.Employee;
import com.laba.credit.utils.Utils;

/**
 *
 */
public class AddClientForm {

    JPanel panel;

    private JButton addClientButton;

    private JEditorPane nameEditorPane;

    private JEditorPane passportEditorPane;
    private JEditorPane passwordEditorPane;

    public AddClientForm(final Employee employee) {
        addClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client client = new Client(
                        Utils.generateId(),
                        employee.getId(),
                        nameEditorPane.getText(),
                        passportEditorPane.getText(),
                        passwordEditorPane.getText()
                ); //todo: validate fields

                ServiceLocator.getInstance().getClientService().saveClient(client);
            }
        });
    }
}
