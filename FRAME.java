import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRAME extends JFrame{

    FRAME(){
        super();
        this.setTitle("TIC/TAC/TOE");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new Panel());
        this.setVisible(true);
    }

}
