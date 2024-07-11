package com.swingcalc.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.geom.RoundRectangle2D;

public class CalculatorUI extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextArea displayText;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton, sqrButton, sqrtButton, equalsButton, clearButton, dotButton, toggleSignButton;

    public CalculatorUI() {
        setLayout(new BorderLayout());

        displayText = new JTextArea();
        displayText.setBackground(Color.decode("#3c3c3c"));
        displayText.setForeground(Color.decode("#ffffff"));
        displayText.setEditable(false);
        displayText.setFont(new Font("Arial", Font.PLAIN, 24));
        displayText.setPreferredSize(new Dimension(0, 50));
        add(displayText, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5)); 
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        buttonPanel.setBackground(Color.decode("#1e1e1e"));
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i), "#3c3c3c");
        }

        addButton = createOperationButton("+");
        subButton = createOperationButton("-");
        mulButton = createOperationButton("*");
        divButton = createOperationButton("/");
        sqrButton = createOperationButton("^2");
        sqrtButton = createOperationButton("sqr");
        equalsButton = createButton("=", "#FFE866");
        clearButton = createOperationButton("C");
        dotButton = createButton(".", "#5c5c5c");
        toggleSignButton = createOperationButton("-/+");

        buttonPanel.add(toggleSignButton);
        buttonPanel.add(sqrtButton);
        buttonPanel.add(sqrButton);
        buttonPanel.add(addButton);
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(subButton);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(mulButton);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(divButton);
        buttonPanel.add(dotButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text, String color) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10));
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground()); 
                g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 10, 10));
                g2.dispose();
            }
            
            @Override
            public void setContentAreaFilled(boolean b) {
               
            }
        };
        Dimension buttonSize = new Dimension(40, 40);
        button.setPreferredSize(buttonSize);
        button.setMinimumSize(buttonSize);
        button.setMaximumSize(buttonSize);
        button.setBackground(Color.decode(color));
        button.setForeground(text.equals("=") ? Color.decode("#2c2c2c") : Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setOpaque(false); 
        button.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
        button.setName("button" + text);
        return button;
    }


    private JButton createOperationButton(String text) {
        return createButton(text, "#2c2c2c");
    }

    public JTextArea getDisplayText() {
        return displayText;
    }

    public JButton[] getNumberButtons() {
        return numberButtons;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubButton() {
        return subButton;
    }

    public JButton getMulButton() {
        return mulButton;
    }

    public JButton getDivButton() {
        return divButton;
    }

    public JButton getSqrButton() {
        return sqrButton;
    }

    public JButton getSqrtButton() {
        return sqrtButton;
    }

    public JButton getEqualsButton() {
        return equalsButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getDotButton() {
        return dotButton;
    }

    public JButton getToggleSignButton() {
        return toggleSignButton;
    }

    public void addNumberButtonListener(ActionListener listener) {
        for (JButton button : numberButtons) {
            button.addActionListener(listener);
        }
    }

    public void addOperationButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mulButton.addActionListener(listener);
        divButton.addActionListener(listener);
        sqrButton.addActionListener(listener);
        sqrtButton.addActionListener(listener);
    }

    public void addEqualsButtonListener(ActionListener listener) {
        equalsButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }
    
    public void addToggleSignButtonListener(ActionListener listener) {
        toggleSignButton.addActionListener(listener);
    }
}
