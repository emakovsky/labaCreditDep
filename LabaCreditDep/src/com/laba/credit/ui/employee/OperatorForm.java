package com.laba.credit.ui.employee;

import com.laba.credit.employee.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorForm {
    public JPanel panel;

    private JButton addNewClientButton;

    public OperatorForm(final Employee employee) {
        addNewClientButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        final JFrame frame = new JFrame("Add client form");
                        frame.setContentPane(new AddClientForm(employee).panel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                    }
                }
        );
    }
}
