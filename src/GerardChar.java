import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import javax.imageio.ImageIO;

public class GerardChar extends JLayeredPane{
    ImageIcon expressions[] = new ImageIcon[10];
    JLabel gerard;

    GerardChar() throws IOException
    {
        setLayout(null);
        setBounds(0,0,1280,720);
        setVisible(true);

        BufferedImage neutral = ImageIO.read(new File("src\\resources\\GerardNeutral.png"));
        Image image1 = neutral.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[0] = new ImageIcon(image1);

        BufferedImage friendly = ImageIO.read(new File("src\\resources\\GerardFriendly.png"));
        Image image2 = friendly.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[1] = new ImageIcon(image2);

        BufferedImage curious = ImageIO.read(new File("src\\resources\\GerardCurious.png"));
        Image image3 = curious.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[2] = new ImageIcon(image3);

        gerard = new JLabel(expressions[0]);
        gerard.setVisible(true);
        gerard.setBounds(0,0, 1280,720);

        add(gerard, Integer.valueOf(1));

    }

    public void changeExpression(int i)
    {
        gerard.setIcon(expressions[i]);
    }

    public void hide()
    {
        gerard.setVisible(false);
    }

    public void show()
    {
        gerard.setVisible(true);;
    }
    
}
