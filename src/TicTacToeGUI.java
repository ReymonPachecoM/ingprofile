import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}

class GameGUI {
    private final JFrame frame;
    private final JButton[][] buttons;
    private final char[][] board;
    private char currentPlayer;

    public GameGUI() {
        frame = new JFrame("Tic Tac Toe");
        buttons = new JButton[3][3];
        board = new char[3][3];
        currentPlayer = 'X';

        initializeBoard();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j] = button;
                final int row = i;
                final int col = j;

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (board[row][col] == '\0' && !isGameOver()) {
                            board[row][col] = currentPlayer;
                            button.setText(String.valueOf(currentPlayer));
                            if (checkWin(currentPlayer)) {
                                JOptionPane.showMessageDialog(frame, currentPlayer + " wins!");
                                resetGame();
                            } else if (isDraw()) {
                                JOptionPane.showMessageDialog(frame, "It's a draw!");
                                resetGame();
                            } else {
                                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                            }
                        }
                    }
                });

                frame.add(button);
            }
        }

        frame.setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\0';
            }
        }
    }

    private boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isGameOver() {
        return checkWin('X') || checkWin('O') || isDraw();
    }

    private void resetGame() {
        initializeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
    }
}
