package com.laba.credit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.laba.credit.ServiceLocator;
import com.laba.credit.employee.Employee;

/**
 *
 */
public class LoginForm {
    private JEditorPane loginEditorPane;

    private JPanel panel1;

    private JEditorPane passwordEditorPane;

    private JButton loginButton;

    public static void main(String[] args) {
        final JFrame frame = new JFrame("LoginForm");
        final LoginForm loginForm = new LoginForm();
        frame.setContentPane(loginForm.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        loginForm.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean loginSucceeded = ServiceLocator.getInstance().getLoginService().login(loginForm.loginEditorPane.getText(), loginForm.passwordEditorPane.getText());


                for (Employee employee: ServiceLocator.getInstance().getEmployeeService().getAll()) {
                    System.out.println(employee);
                }


                if (loginSucceeded) {
                    frame.dispose();

                    if ("admin".equals(loginForm.loginEditorPane.getText()) && "admin".equals(loginForm.passwordEditorPane.getText())) {
                        final JFrame frame = new JFrame("Admin form");
                        frame.setContentPane(new AdminForm().getPanel());
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                    }
                    else {
                        final JFrame frame = new JFrame("Add client form");
                        frame.setContentPane(new AddClientForm().panel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                    }
                }
            }
        });
    }
}
