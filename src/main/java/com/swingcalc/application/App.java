package com.swingcalc.application;


	

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import javax.swing.border.EmptyBorder;

	public class App extends JFrame {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int xOffset = 0;
	    private int yOffset = 0;

	    public App() {
	        setTitle("CalculatorSwing"); 
	        setUndecorated(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(300, 340);
	        setLocationRelativeTo(null);

	        JPanel titleBar = new JPanel();
	        titleBar.setBackground(new Color(44, 44, 44));
	        titleBar.setBorder(new EmptyBorder(10, 10, 10, 10));
	        titleBar.setLayout(new BorderLayout());

	        JLabel titleLabel = new JLabel("CalculatorFX");
	        titleLabel.setForeground(Color.WHITE);

	        JButton closeButton = new JButton("X");
	        closeButton.setForeground(Color.WHITE);
	        closeButton.setBackground(new Color(255, 0, 0));
	        closeButton.setBorderPainted(false);
	        closeButton.setFocusPainted(false);
	        closeButton.addActionListener(e -> dispose());

	        titleBar.add(titleLabel, BorderLayout.WEST);
	        titleBar.add(Box.createHorizontalGlue(), BorderLayout.CENTER);
	        titleBar.add(closeButton, BorderLayout.EAST);

	        titleBar.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
	                xOffset = e.getX();
	                yOffset = e.getY();
	            }
	        });

	        titleBar.addMouseMotionListener(new MouseAdapter() {
	            @Override
	            public void mouseDragged(MouseEvent e) {
	                setLocation(e.getXOnScreen() - xOffset, e.getYOnScreen() - yOffset);
	            }
	        });

	        JPanel container = new JPanel();
	        container.setLayout(new BorderLayout());
	        container.setBorder(BorderFactory.createEmptyBorder());
	        container.setBackground(Color.WHITE);
	        container.add(titleBar, BorderLayout.NORTH);

	        JPanel mainPanel = new JPanel();
	        mainPanel.setBackground(Color.WHITE);
	        container.add(mainPanel, BorderLayout.CENTER);

	        add(container);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            App app = new App();
	            app.setVisible(true);
	        });
	    }
	}


