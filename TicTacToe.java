import javax.swing.*;
import java.awt.Color;

public class TicTacToe {
    private static final JFrame FRAME = new JFrame("Tic-Tac-Toe | Player 1");
    private static final char[][] MOVES = new char[3][3];
    private static boolean queue = true; // Кол-во игроков 2, так-же, как и boolean состояний. true: игрок 1, false: игрок 2.
    private static int moveCount = 0;
    private static final JButton
            CELL1 = new JButton(),
            CELL2 = new JButton(),
            CELL3 = new JButton(),
            CELL4 = new JButton(),
            CELL5 = new JButton(),
            CELL6 = new JButton(),
            CELL7 = new JButton(),
            CELL8 = new JButton(),
            CELL9 = new JButton();

    public static void main(String[] args) {
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // При нажатии на крестик завершаем прогу.
        FRAME.setSize(486, 509);
        FRAME.setResizable(false); // Убираем возможность изменять размер окна, в том числе и развертывать его на полный экран.
        FRAME.setLocationRelativeTo(null); // Устанавливаем позицию окна в центре экрана.
        FRAME.setLayout(null); // Не разобрался до конца, но без этого не работают кнопки. Они просто не появляются.
        FRAME.setVisible(true);

        FRAME.add(CELL1);
        FRAME.add(CELL2);
        FRAME.add(CELL3);
        FRAME.add(CELL4);
        FRAME.add(CELL5);
        FRAME.add(CELL6);
        FRAME.add(CELL7);
        FRAME.add(CELL8);
        FRAME.add(CELL9);

        CELL1.setBounds(5, 5, 150, 150);
        CELL2.setBounds(160, 5, 150, 150);
        CELL3.setBounds(315, 5, 150, 150);
        CELL4.setBounds(5, 160, 150, 150);
        CELL5.setBounds(160, 160, 150, 150);
        CELL6.setBounds(315, 160, 150, 150);
        CELL7.setBounds(5, 315, 150, 150);
        CELL8.setBounds(160, 315, 150, 150);
        CELL9.setBounds(315, 315, 150, 150);

        CELL1.addActionListener(e -> move(CELL1, 0, 0));
        CELL2.addActionListener(e -> move(CELL2, 0, 1));
        CELL3.addActionListener(e -> move(CELL3, 0, 2));
        CELL4.addActionListener(e -> move(CELL4, 1, 0));
        CELL5.addActionListener(e -> move(CELL5, 1, 1));
        CELL6.addActionListener(e -> move(CELL6, 1, 2));
        CELL7.addActionListener(e -> move(CELL7, 2, 0));
        CELL8.addActionListener(e -> move(CELL8, 2, 1));
        CELL9.addActionListener(e -> move(CELL9, 2, 2));
    }

    private static void move(JButton cell, int x, int y) {
        if (cell.getText().equals("")) {
            if (queue) {
                MOVES[x][y] = 'X';
                FRAME.setTitle("Tic-Tac-Toe | Player 2");
                cell.setText("X");
                cell.setBackground(new Color(170, 0, 0));
            } else {
                MOVES[x][y] = 'O';
                FRAME.setTitle("Tic-Tac-Toe | Player 1");
                cell.setText("O");
                cell.setBackground(new Color(0, 170, 0));
            }

            queue ^= true; // Переворачиваем значение на противоположное каждый раз при вызове.
            moveCount++;
            gameCheck();
        }
    }

    private static void gameCheck() { // Над проверками пришлось посидеть :)
        if (MOVES[0][0] == 'X' && MOVES[0][1] == 'X' && MOVES[0][2] == 'X' ||
                MOVES[1][0] == 'X' && MOVES[1][1] == 'X' && MOVES[1][2] == 'X' ||
                MOVES[2][0] == 'X' && MOVES[2][1] == 'X' && MOVES[2][2] == 'X' ||
                MOVES[0][0] == 'X' && MOVES[1][0] == 'X' && MOVES[2][0] == 'X' ||
                MOVES[0][1] == 'X' && MOVES[1][1] == 'X' && MOVES[2][1] == 'X' ||
                MOVES[0][2] == 'X' && MOVES[1][2] == 'X' && MOVES[2][2] == 'X' ||
                MOVES[0][0] == 'X' && MOVES[1][1] == 'X' && MOVES[2][2] == 'X' ||
                MOVES[0][2] == 'X' && MOVES[1][1] == 'X' && MOVES[2][0] == 'X') {
            System.out.println("Player 1 Wins!");
            System.exit(0);
        } else if (MOVES[0][0] == 'O' && MOVES[0][1] == 'O' && MOVES[0][2] == 'O' ||
                MOVES[1][0] == 'O' && MOVES[1][1] == 'O' && MOVES[1][2] == 'O' ||
                MOVES[2][0] == 'O' && MOVES[2][1] == 'O' && MOVES[2][2] == 'O' ||
                MOVES[0][0] == 'O' && MOVES[1][0] == 'O' && MOVES[2][0] == 'O' ||
                MOVES[0][1] == 'O' && MOVES[1][1] == 'O' && MOVES[2][1] == 'O' ||
                MOVES[0][2] == 'O' && MOVES[1][2] == 'O' && MOVES[2][2] == 'O' ||
                MOVES[0][0] == 'O' && MOVES[1][1] == 'O' && MOVES[2][2] == 'O' ||
                MOVES[0][2] == 'O' && MOVES[1][1] == 'O' && MOVES[2][0] == 'O') {
            System.out.println("Player 2 Wins!");
            System.exit(0);
        } else if (moveCount == 9) {
            System.out.println("Draw!");
            System.exit(0);
        }
    }
}