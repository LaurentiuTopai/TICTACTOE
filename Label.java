import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Label extends JPanel  implements ActionListener {

    Label() {

    }


    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(0,0,100,100);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
