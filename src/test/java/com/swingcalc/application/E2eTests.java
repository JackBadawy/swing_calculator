package com.swingcalc.application;

import org.junit.jupiter.api.Test;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import javax.swing.*;

public class E2eTests {
    private FrameFixture window;
    @BeforeEach
    public void setUp() {
        CalculatorUI calculatorUI = GuiActionRunner.execute(() -> new CalculatorUI());
        new Controller(calculatorUI);
        JFrame testFrame = GuiActionRunner.execute(() -> {
            JFrame frame = new JFrame();
            frame.add(calculatorUI);
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return frame;
        });
        window = new FrameFixture(testFrame);
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    public void buttonClickProducesExpectedOutput() {
        window.button("button7").click();
        window.button("button/").click(); 
        window.button("button0").click();
        window.button("button=").click();

        window.textBox().requireText("Cannot divide by zero");
    }
}
