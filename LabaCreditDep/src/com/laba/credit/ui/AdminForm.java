package com.laba.credit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.laba.credit.ServiceLocator;
import com.laba.credit.employee.Employee;
import com.laba.credit.employee.EmployeeRole;
import com.laba.credit.utils.Utils;

/**
 *
 */
public class AdminForm {
    private JEditorPane nameEditorPane;
    private JEditorPane passwordEditorPane;

    private JPanel panel;

    private JList roleList;

    private JButton saveButton;

    public JPanel getPanel() {
        return panel;
    }

    public AdminForm() {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();
                employee.setId(Utils.generateId()); //todo: guarantee uniqueness
                employee.setPassword(passwordEditorPane.getText());
                employee.setName(nameEditorPane.getText());//todo: add validators ( empty value, no special symbols...)

                String selectedRole = roleList.getSelectedValue().toString();
                if (selectedRole.equalsIgnoreCase(EmployeeRole.OPERATOR.toString())) {
                    employee.setEmployeeRole(EmployeeRole.OPERATOR);
                } else if (selectedRole.equalsIgnoreCase(EmployeeRole.CREDITOR.toString())) {
                    employee.setEmployeeRole(EmployeeRole.CREDITOR);
                } else if (selectedRole.equalsIgnoreCase(EmployeeRole.VERIFIER.toString())) {
                    employee.setEmployeeRole(EmployeeRole.VERIFIER);
                }

                ServiceLocator.getInstance().getEmployeeService().saveEmployee(employee);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AdminForm");
        final AdminForm adminForm = new AdminForm();
        frame.setContentPane(adminForm.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
