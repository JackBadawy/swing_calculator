package com.swingcalc.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorUI extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea displayText;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton, sqrButton, sqrtButton, equalsButton, clearButton;

    public CalculatorUI() {
        setLayout(new BorderLayout());

        displayText = new JTextArea();
        displayText.setEditable(false);
        displayText.setFont(new Font("Arial", Font.PLAIN, 24));
        add(displayText, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new GridLayout(2, 3));

        addButton = createOperationButton("+");
        subButton = createOperationButton("-");
        mulButton = createOperationButton("*");
        divButton = createOperationButton("/");
        sqrButton = createOperationButton("s");
        sqrtButton = createOperationButton("^");
        equalsButton = createButton("=");

        operationPanel.add(addButton);
        operationPanel.add(subButton);
        operationPanel.add(mulButton);
        operationPanel.add(divButton);
        operationPanel.add(sqrButton);
        operationPanel.add(sqrtButton);
        operationPanel.add(equalsButton);

        add(operationPanel, BorderLayout.SOUTH);

        clearButton = new JButton("C");
        add(clearButton, BorderLayout.EAST);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        return button;
    }

    private JButton createOperationButton(String text) {
        JButton button = new JButton(text);
        return button;
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
}
