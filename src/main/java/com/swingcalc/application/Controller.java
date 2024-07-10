package com.swingcalc.application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import com.swingcalc.operations.*;

public class Controller {
	
	 private CalculatorUI calculatorUI;

	    private StringBuilder currentInputNumber = new StringBuilder();
	    private StringBuilder previousInputNumber = new StringBuilder();

	    private char currentOperation;
	    private final Map<Character, Operation<Float>> operations = new HashMap<>();

	    public Controller(CalculatorUI calculatorUI) {
	        this.calculatorUI = calculatorUI;

	        operations.put('+', new Addition());
	        operations.put('-', new Subtraction());
	        operations.put('*', new Multiplication());
	        operations.put('/', new Division());
	        operations.put('s', new Sqr());
	        operations.put('^', new SqrRoot());

	        calculatorUI.addNumberButtonListener(new NumberButtonListener());
	        calculatorUI.addOperationButtonListener(new OperationButtonListener());
	        calculatorUI.addEqualsButtonListener(new EqualsButtonListener());
	        calculatorUI.addClearButtonListener(new ClearButtonListener());
	    }

	    private void clearInput() {
	        previousInputNumber.setLength(0);
	        currentInputNumber.setLength(0);
	        renderDisplayedNumber();
	    }

	    private void appendNumber(String number) {
	        if (currentInputNumber.length() == 0 && number.equals("0")) {
	            return;
	        }
	        currentInputNumber.append(number);
	        renderDisplayedNumber();
	    }

	    private void setOperation(char operation) {
	        currentOperation = operation;
	        if (currentOperation == 's' || currentOperation == '^') {
	            float result = performMathsOperation();
	            calculatorUI.getDisplayText().setText(Float.toString(result));
	            currentInputNumber.setLength(0);
	            currentInputNumber.append(result);
	        } else {
	            previousInputNumber.setLength(0);
	            previousInputNumber.append(currentInputNumber);
	            currentInputNumber.setLength(0);
	            renderDisplayedNumber();
	        }
	    }

	    private float performMathsOperation() {
	        float num1 = previousInputNumber.length() > 0 ? Float.parseFloat(previousInputNumber.toString()) : 0;
	        float num2 = currentInputNumber.length() > 0 ? Float.parseFloat(currentInputNumber.toString()) : 0;
	        Operation<Float> operation = operations.get(currentOperation);
	        if (operation == null) {
	            throw new IllegalStateException("Unknown operation: " + currentOperation);
	        }
	        return operation.apply(num1, num2);
	    }

	    private void handleEqualsClick() {
	        try {
	            float result = performMathsOperation();
	            calculatorUI.getDisplayText().setText(Float.toString(result));
	            clearInput();
	            currentInputNumber.append(result);
	            renderDisplayedNumber();
	        } catch (ArithmeticException e) {
	            calculatorUI.getDisplayText().setText(e.getMessage());
	        }
	    }

	    private void renderDisplayedNumber() {
	        calculatorUI.getDisplayText().setText(currentInputNumber.toString());
	    }

	    private class NumberButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JButton source = (JButton) e.getSource();
	            appendNumber(source.getText());
	        }
	    }

	    private class OperationButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            JButton source = (JButton) e.getSource();
	            setOperation(source.getText().charAt(0));
	        }
	    }

	    private class EqualsButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            handleEqualsClick();
	        }
	    }

	    private class ClearButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            clearInput();
	        }
	    }
	}
