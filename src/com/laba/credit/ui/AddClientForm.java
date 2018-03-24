package com.laba.credit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.laba.credit.client.Client;
import com.laba.credit.client.ClientService;
import com.laba.credit.client.InMemoryClientService;

/**
 *
 */
public class AddClientForm {

    JPanel panel;

    private JButton addClientButton;

    private JEditorPane nameEditorPane;

    private JEditorPane passportEditorPane;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        final AddClientForm addClientForm = new AddClientForm();
        frame.setContentPane(addClientForm.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final ClientService clientService = new InMemoryClientService();

        addClientForm.addClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client client = new Client();
                client.setId("1");
                client.setName(addClientForm.nameEditorPane.getText());
                client.setPassport(addClientForm.passportEditorPane.getText());

                clientService.saveClient(client);
            }
        } );


    }
}
