package com.laba.credit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.laba.credit.ServiceLocator;
import com.laba.credit.client.Client;
import com.laba.credit.employee.Employee;
import com.laba.credit.ui.client.ClientForm;
import com.laba.credit.ui.employee.CreditorForm;
import com.laba.credit.ui.employee.OperatorForm;
import com.laba.credit.ui.employee.VerifierForm;

/**
 *
 */
public class LoginForm {
    private JEditorPane loginEditorPane;

    private JPanel panel1;

    private JEditorPane passwordEditorPane;

    private JButton loginButton;

    public static void main(String[] args) {
        final JFrame loginFrame = new JFrame("LoginForm");
        final LoginForm loginForm = new LoginForm();
        loginFrame.setContentPane(loginForm.panel1);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
        loginFrame.setVisible(true);

        loginForm.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Employee employee = ServiceLocator.getInstance().getEmployeeService().findByName(loginForm.loginEditorPane.getText());
                Client client = ServiceLocator.getInstance().getClientService().findByName(loginForm.loginEditorPane.getText());

                if ("admin".equals(loginForm.loginEditorPane.getText())) {

                    if ("admin".equals(loginForm.passwordEditorPane.getText())) {
                        final JFrame frame = new JFrame("Admin form");
                        frame.setContentPane(new AdminForm().getPanel());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                    } else {
                        //todo: show admin password incorrect
                    }

                } else if (employee != null) {
                    if (loginForm.passwordEditorPane.getText().equals(employee.getPassword())) {
                        switch (employee.getEmployeeRole()) {
                            case OPERATOR:
                                UiUtils.showForm("Operator", new OperatorForm(employee).panel);
                                break;
                            case CREDITOR:
                                UiUtils.showForm("Creditor", new CreditorForm(employee).panel);
                                break;
                            case VERIFIER:
                                UiUtils.showForm("Verifier", new VerifierForm(employee).panel);
                                break;
                        }

                        loginFrame.dispose();
                    } else {
                        //todo: show employee password incorrect
                        JOptionPane.showMessageDialog(loginForm.panel1, "employee password incorrect");
                    }
                } else if (client != null) {
                    if (loginForm.passwordEditorPane.getText().equals(client.getPassword())) {
                        final JFrame frame = new JFrame("Client form");
                        frame.setContentPane(new ClientForm(client).getPanel());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);

                        loginFrame.dispose();
                    } else {
                        //todo: show client password incorrect
                        JOptionPane.showMessageDialog(loginForm.panel1, "client password incorrect");
                    }
                } else {
                    //todo: show user not found
                    JOptionPane.showMessageDialog(loginForm.panel1, "user not found");
                }
            }
        });
    }
}
