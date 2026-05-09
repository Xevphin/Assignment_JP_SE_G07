import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame {

    // Maintaining your original logic components
    enum Player {X, O}
    private String board = "123456789";
    private Player turn = Player.X;
    private boolean gameActive = true;
    private Random generator = new Random();

    // GUI Components
    private JButton[] buttons = new JButton[9];

    public TicTacToe() {
        // Setting up the frame
        setTitle("Tic-Tac-Toe GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(3, 3)); // 3x3 grid for the board

        // Initialize buttons and add to the frame
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].setFocusPainted(false);
            
            final int index = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    onButtonClick(index);
                }
            });
            add(buttons[i]);
        }
    }

    private void onButtonClick(int index) {
        char moveChar = Integer.toString(index + 1).charAt(0);

        // Logic: Check if move is valid and game is active
        if (gameActive && board.indexOf(moveChar) != -1 && turn == Player.X) {
            handleMove(index, moveChar);
            
            // AI (Player O) move after Player X
            if (gameActive) {
                aiMove();
            }
        }
    }

    private void aiMove() {
        int move;
        char moveChar;
        do {
            move = generator.nextInt(9) + 1;
            moveChar = Integer.toString(move).charAt(0);
        } while (board.indexOf(moveChar) == -1 && board.replaceAll("[X|O]", "").length() > 0);

        handleMove(move - 1, moveChar);
    }

    private void handleMove(int index, char moveChar) {
        // Update Board Logic
        board = board.replace(moveChar, turn.name().charAt(0));
        buttons[index].setText(turn.name());
        buttons[index].setEnabled(false); // Disable button after use

        int movesMade = 9 - board.replaceAll("[X|O]", "").length();

        // Check Winner
        if (movesMade >= 5 && checkWinner(board)) {
            JOptionPane.showMessageDialog(this, "Player " + turn + " wins!");
            gameActive = false;
        } else if (movesMade == 9) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            gameActive = false;
        } else {
            // Switch Turn
            turn = (turn == Player.X) ? Player.O : Player.X;
        }
    }

    // --- Maintained Original Logic Methods ---
    
    public static boolean checkWinner(String b) {
        return (check(b, 0, 1, 2) || check(b, 3, 4, 5) || check(b, 6, 7, 8) || 
                check(b, 0, 3, 6) || check(b, 1, 4, 7) || check(b, 2, 5, 8) || 
                check(b, 0, 4, 8) || check(b, 2, 4, 6));                    
    }

    private static boolean check(String b, int i1, int i2, int i3) {
        return (b.charAt(i1) == b.charAt(i2) && b.charAt(i2) == b.charAt(i3)); 
    }

    public static void main(String[] args) {
        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            new TicTacToe().setVisible(true);
        });
    }
}