import javax.swing.*;

public class TicTacToe {
    static JFrame frame = new JFrame("Tic-Tac-Toe | Player 1");
    static boolean queue = true; // Кол-во игроков 2, так-же, как и boolean состояний. true: игрок 1, false: игрок 2.
    static char[][] moves = new char[3][3];
    static int moveCount = 0;
    static JButton
            button1 = new JButton(),
            button2 = new JButton(),
            button3 = new JButton(),
            button4 = new JButton(),
            button5 = new JButton(),
            button6 = new JButton(),
            button7 = new JButton(),
            button8 = new JButton(),
            button9 = new JButton();

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // При нажатии на крестик завершаем прогу.
        frame.setSize(486, 509);
        frame.setResizable(false); // Убираем возможность изменять размер окна, в том числе и развертывать его на полный экран.
        frame.setLocationRelativeTo(null); // Устанавливаем позицию окна в центре экрана.
        frame.setLayout(null); // Не разобрался до конца, но без этого не работают кнопки. Они просто не появляются.
        frame.setVisible(true);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);

        button1.setBounds(5, 5, 150, 150);
        button2.setBounds(160, 5, 150, 150);
        button3.setBounds(315, 5, 150, 150);
        button4.setBounds(5, 160, 150, 150);
        button5.setBounds(160, 160, 150, 150);
        button6.setBounds(315, 160, 150, 150);
        button7.setBounds(5, 315, 150, 150);
        button8.setBounds(160, 315, 150, 150);
        button9.setBounds(315, 315, 150, 150);

        /*
        Да, вызывать 9 раз gameCheck боль, но в случае если вызвать его 1 раз в move
        и при этом кто-то победил или случилась ничья, вам придется делать еще 1 ход
        для того, чтобы результаты игры отобразились. А так не должно быть...
        */
        button1.addActionListener(e -> {
            if (button1.getText().equals("")) {
                moves[0][0] = move(button1);
                gameCheck();
            }
        });
        button2.addActionListener(e -> {
            if (button2.getText().equals("")) {
                moves[0][1] = move(button2);
                gameCheck();
            }
        });
        button3.addActionListener(e -> {
            if (button3.getText().equals("")) {
                moves[0][2] = move(button3);
                gameCheck();
            }
        });
        button4.addActionListener(e -> {
            if (button4.getText().equals("")) {
                moves[1][0] = move(button4);
                gameCheck();
            }
        });
        button5.addActionListener(e -> {
            if (button5.getText().equals("")) {
                moves[1][1] = move(button5);
                gameCheck();
            }
        });
        button6.addActionListener(e -> {
            if (button6.getText().equals("")) {
                moves[1][2] = move(button6);
                gameCheck();
            }
        });
        button7.addActionListener(e -> {
            if (button7.getText().equals("")) {
                moves[2][0] = move(button7);
                gameCheck();
            }
        });
        button8.addActionListener(e -> {
            if (button8.getText().equals("")) {
                moves[2][1] = move(button8);
                gameCheck();
            }
        });
        button9.addActionListener(e -> {
            if (button9.getText().equals("")) {
                moves[2][2] = move(button9);
                gameCheck();
            }
        });
    }

    private static char move(JButton button) {
        char returnValue;
        if (queue) {
            frame.setTitle("Tic-Tac-Toe | Player 2");
            button.setText("X");
            returnValue = 'X';
        } else {
            frame.setTitle("Tic-Tac-Toe | Player 1");
            button.setText("O");
            returnValue = 'O';
        }

        queue ^= true; // Переворачиваем значение на противоположное каждый раз при вызове.
        moveCount++;
        return returnValue;
    }

    private static void gameCheck() { // Над проверками пришлось посидеть :)
        if (moves[0][0] == 'X' && moves[0][1] == 'X' && moves[0][2] == 'X' ||
                moves[1][0] == 'X' && moves[1][1] == 'X' && moves[1][2] == 'X' ||
                moves[2][0] == 'X' && moves[2][1] == 'X' && moves[2][2] == 'X' ||
                moves[0][0] == 'X' && moves[1][0] == 'X' && moves[2][0] == 'X' ||
                moves[0][1] == 'X' && moves[1][1] == 'X' && moves[2][1] == 'X' ||
                moves[0][2] == 'X' && moves[1][2] == 'X' && moves[2][2] == 'X' ||
                moves[0][0] == 'X' && moves[1][1] == 'X' && moves[2][2] == 'X' ||
                moves[0][2] == 'X' && moves[1][1] == 'X' && moves[2][0] == 'X') {
            System.out.println("Player 1 Wins!");
            System.exit(0);
        } else if (moves[0][0] == 'O' && moves[0][1] == 'O' && moves[0][2] == 'O' ||
                moves[1][0] == 'O' && moves[1][1] == 'O' && moves[1][2] == 'O' ||
                moves[2][0] == 'O' && moves[2][1] == 'O' && moves[2][2] == 'O' ||
                moves[0][0] == 'O' && moves[1][0] == 'O' && moves[2][0] == 'O' ||
                moves[0][1] == 'O' && moves[1][1] == 'O' && moves[2][1] == 'O' ||
                moves[0][2] == 'O' && moves[1][2] == 'O' && moves[2][2] == 'O' ||
                moves[0][0] == 'O' && moves[1][1] == 'O' && moves[2][2] == 'O' ||
                moves[0][2] == 'O' && moves[1][1] == 'O' && moves[2][0] == 'O') {
            System.out.println("Player 2 Wins!");
            System.exit(0);
        } else if (moveCount == 9) {
            System.out.println("Draw!");
            System.exit(0);
        }
    }
}