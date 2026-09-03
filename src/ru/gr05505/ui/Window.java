package ru.gr05505.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JTextField tfArgument1;
    private JTextField tfArgument2;
    private JButton bAdd;
    private JButton bSub;
    private JButton bDiv;
    private JButton bMult;
    private JLabel lRes;
    private JLabel lAns;

    public Window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,200);

        tfArgument1 = new JTextField();
        tfArgument2 = new JTextField();
        bAdd = new JButton();
        bSub = new JButton();
        bMult = new JButton();
        bDiv = new JButton();
        lRes = new JLabel();
        lAns = new JLabel();

        lAns.setText("Ответ:");
        bAdd.setText("+");
        bSub.setText("-");
        bMult.setText("*");
        bDiv.setText("/");

        bAdd.addActionListener(e -> {
            setResult(Action.PLUS);
        });
        bSub.addActionListener(e -> {
            setResult(Action.MINUS);
        });
        bMult.addActionListener(e -> {
            setResult(Action.TIMES);
        });
        bDiv.addActionListener(e -> {
            setResult(Action.DIV);
        });

//        bAdd.setSize(40,40);
//        bSub.setSize(40,40);
//        bMult.setSize(40,40);
//        bDiv.setSize(40,40);
//
//        tfArgument1.setSize(220,25);
        GridLayout  layout = new GridLayout(4,2,8,8);
        setLayout(layout);
        add(tfArgument1);
        add(tfArgument2);
        add(bAdd);
        add(bSub);
        add(bMult);
        add(bDiv);
        add(lAns);
        add(lRes);
        setLocationRelativeTo(null);
    }

    private void setResult(Action act) {
        double value1 = Double.parseDouble(tfArgument1.getText());
        double value2 = Double.parseDouble(tfArgument2.getText());
        double res = 0.0;
        switch(act) {
            case PLUS: res = value1 + value2; break;
            case MINUS: res = value1 - value2; break;
            case TIMES: res = value1 * value2; break;
            case DIV: res = value1 / value2; break;
        }
        lRes.setText(Double.toString(res));
    }

    enum Action {
        PLUS, MINUS, TIMES, DIV
    }
}