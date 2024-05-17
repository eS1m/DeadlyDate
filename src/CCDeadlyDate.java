import java.awt.Color;
import java.io.IOException;

import javax.swing.*;


public class CCDeadlyDate extends JFrame {
    public CCDeadlyDate() throws IOException{
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Deadly Date");
        ImageIcon icon = new ImageIcon("src\\resources\\Icon2.jpg");
        setIconImage(icon.getImage());

        CCDDGameMain gamePanel = new CCDDGameMain();
        add(gamePanel);

        pack();

        setVisible(true);
        setSize(1280,720);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
    }

    public static void main(String[] args) throws IOException
    {
        new CCDeadlyDate();

    }
}