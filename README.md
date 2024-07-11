# Swing Calculator Application

![Screenshot](https://github.com/JackBadawy/swing_calculator/blob/main/src/img.png)

## Overview

This project is a calculator application built using Swing. The goal of this project is to compare file size and CPU usage of Swing and JavaFX, and to create a functional and visually appealing desktop application.

## Features

- Basic calculator functionality (number input and display).
- Unit & e2e testing.
- Simple and intuitive user interface designed with Swing.
- Dynamic number display based on button presses.
- Basic arithmetic operations (addition, subtraction, multiplication, division).
- Handling division by zero appropriately.
- Jpackage installer.

## Change Log

### Initial Commit

- Set up the project structure.
- Added basic layout with buttons for digits 0-9 and a display area.

### [11/07/2024]

- **UI Implementation**
  - Created `CalculatorUI` class with Swing components.
  - Added buttons for digits 0-9, basic arithmetic operations (+, -, \*, /), and additional functions (clear, equals, toggle sign, square, square root).
  - Styled buttons with colors, border radius, and dimensions.
- **Controller Implementation**
  - Created `Controller` class to handle calculator logic.
  - Implemented number input handling, operation setting, and equals button functionality.
  - Added logic to handle division by zero and display an appropriate error message.
- **Testing**
  - Added unit tests for `Division` operation to ensure division by zero throws an appropriate exception.
  - Added end-to-end tests using AssertJ Swing to simulate button clicks and verify display output.
- **Styling Enhancements**
  - Applied background and foreground colors to buttons and display.
  - Ensured rounded edges for buttons.
  - Added padding to the button panel for a better layout.
- **JPackage Installer**
  - Generated JPackage Installer in SwingCalculator dir to compare file size and CPU usage with other implementations.

## Getting Started

### Prerequisites

- JDK 17 or higher
- IDE with Swing support (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository:
   ```bash
   git clone git@github.com:YourUsername/CalculatorSwing.git
   ```
2. Run App.java through IDE
