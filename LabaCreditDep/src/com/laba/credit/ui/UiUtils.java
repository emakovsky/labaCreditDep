package com.laba.credit.ui;

import com.laba.credit.ui.employee.CreditorForm;

import javax.swing.*;
import java.awt.*;

public class UiUtils {

    public static void showForm(String title, Container container) {
        final JFrame frame = new JFrame(title);
        frame.setContentPane(container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
