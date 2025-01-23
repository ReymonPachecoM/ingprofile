import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel para organizar los elementos
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear un campo de texto para mostrar los resultados
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(display, BorderLayout.NORTH);

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Botones de la calculadora
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Acción para manejar eventos de botones
        ActionListener listener = new ActionListener() {
            private String currentInput = "";
            private String operator = "";
            private double operand1 = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                if ("0123456789.".contains(command)) {
                    currentInput += command;
                    display.setText(currentInput);
                } else if ("+-*/".contains(command)) {
                    if (!currentInput.isEmpty()) {
                        operand1 = Double.parseDouble(currentInput);
                        operator = command;
                        currentInput = "";
                    }
                } else if ("=".equals(command)) {
                    if (!currentInput.isEmpty() && !operator.isEmpty()) {
                        double operand2 = Double.parseDouble(currentInput);
                        double result = 0;
                        switch (operator) {
                            case "+":
                                result = operand1 + operand2;
                                break;
                            case "-":
                                result = operand1 - operand2;
                                break;
                            case "*":
                                result = operand1 * operand2;
                                break;
                            case "/":
                                if (operand2 != 0) {
                                    result = operand1 / operand2;
                                } else {
                                    display.setText("Error");
                                    return;
                                }
                                break;
                        }
                        display.setText(String.valueOf(result));
                        currentInput = "";
                        operator = "";
                    }
                }
            }
        };

        // Agregar botones al panel
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(listener);
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);

        // Agregar el panel principal a la ventana
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
