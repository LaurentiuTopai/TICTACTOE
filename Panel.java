import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Panel extends JPanel  implements ActionListener {
    private final int size=3;
    private String[][] board = new String[size][size];
    private String currentPlayer;
    private boolean gameOver;

    Panel(){
        this.board = new String[size][size];
        this.gameOver = false;
        this.currentPlayer = "X";

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.board[i][j] = "";
            }
        }
        setBackground(Color.BLACK);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (gameOver) return;

                int row = e.getY() / (getHeight() / size);
                int col = e.getX() / (getWidth() / size);

                if (board[row][col].isEmpty()) {
                    board[row][col] = currentPlayer;
                    if (checkWin()) {
                        gameOver = true;
                    } else {
                        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                    }
                    repaint();  // Redraw the board
                }
            }
        });

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        int width = getWidth() / size;
        int height = getHeight() / size;

        g.setColor(Color.WHITE);
        for (int i = 1; i < size; i++) {
            g.drawLine(i * width, 0, i * width, getHeight());
            g.drawLine(0, i * height, getWidth(), i * height);
        }


        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col].equals("X")) {
                    drawX(g, col * width, row * height, width, height);
                } else if (board[row][col].equals("O")) {
                    drawO(g, col * width, row * height, width, height);
                }
            }
        }
    }
    public void drawX(Graphics g,int x,int y,int width,int height)
    {
        g.setColor(Color.RED);
        g.drawLine(x,y,x+width,y+height);
        g.drawLine(x+width,y,x,y+height);
    }
    public void drawO(Graphics g,int x,int y,int width,int height)
    {
        g.setColor(Color.BLUE);
        g.drawOval(x,y,width,height);
    }
    private boolean checkWin()  {

        for (int i = 0; i < size; i++) {
            if (board[i][0].equals(currentPlayer) && board[i][1].equals(currentPlayer) && board[i][2].equals(currentPlayer)) {
                return true;
            }
            if (board[0][i].equals(currentPlayer) && board[1][i].equals(currentPlayer) && board[2][i].equals(currentPlayer)) {
                return true;
            }
        }

        if (board[0][0].equals(currentPlayer) && board[1][1].equals(currentPlayer) && board[2][2].equals(currentPlayer)) {
            return true;
        }
        if (board[0][2].equals(currentPlayer) && board[1][1].equals(currentPlayer) && board[2][0].equals(currentPlayer)) {
            return true;
        }

        return false;
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
