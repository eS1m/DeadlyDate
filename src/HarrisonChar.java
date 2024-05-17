import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HarrisonChar extends JLayeredPane{
    ImageIcon expressions[] = new ImageIcon[15];

    JLabel Harry;

    HarrisonChar() throws IOException
    {
        setLayout(null);
        setBounds(0,0,1280,720);
        setVisible(true);

        //With Blazer
        BufferedImage img1 = ImageIO.read(new File("src\\resources\\Harrison - Murderer (1).png"));
        Image image1 = img1.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[0] = new ImageIcon(image1);

        BufferedImage img2 = ImageIO.read(new File("src\\resources\\Harrison - Murderer (2).png"));
        Image image2 = img2.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[1] = new ImageIcon(image2);

        BufferedImage img3 = ImageIO.read(new File("src\\resources\\Harrison - Murderer (3).png"));
        Image image3 = img3.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[2] = new ImageIcon(image3);

        BufferedImage img4 = ImageIO.read(new File("src\\resources\\Harrison - Murderer (4).png"));
        Image image4 = img4.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[3] = new ImageIcon(image4);

        BufferedImage img5 = ImageIO.read(new File("src\\resources\\Harrison - Murderer (5).png"));
        Image image5 = img5.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[4] = new ImageIcon(image5);

        BufferedImage img6 = ImageIO.read(new File("src\\resources\\Harrison shaded1.png"));
        Image image6 = img6.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[5] = new ImageIcon(image6);

        //WithoutBlazer

        BufferedImage img7 = ImageIO.read(new File("src\\resources\\HarrisonNB - Murderer (1).png"));
        Image image7 = img7.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[6] = new ImageIcon(image7);

        BufferedImage img8 = ImageIO.read(new File("src\\resources\\HarrisonNB - Murderer (2).png"));
        Image image8 = img8.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[7] = new ImageIcon(image8);

        BufferedImage img9 = ImageIO.read(new File("src\\resources\\HarrisonNB - Murderer (3).png"));
        Image image9 = img9.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[8] = new ImageIcon(image9);

        BufferedImage img10 = ImageIO.read(new File("src\\resources\\HarrisonNB - Murderer (4).png"));
        Image image10 = img10.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[9] = new ImageIcon(image10);

        BufferedImage img11 = ImageIO.read(new File("src\\resources\\HarrisonNB - Murderer (5).png"));
        Image image11 = img11.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[10] = new ImageIcon(image11);

        BufferedImage img12 = ImageIO.read(new File("src\\resources\\HarrisonNB - Murderer (6).png"));
        Image image12 = img12.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[11] = new ImageIcon(image12);

        BufferedImage img13 = ImageIO.read(new File("src\\resources\\HarrisonNB - Murderer (7).png"));
        Image image13 = img13.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        expressions[12] = new ImageIcon(image13);

        Harry = new JLabel(expressions[0]);
        Harry.setVisible(true);
        Harry.setBounds(15,0, 1280,720);

        add(Harry, Integer.valueOf(1));
    }

    public void changeExpression(int i)
    {
        Harry.setIcon(expressions[i]);
        Harry.setBounds(15,0, 1280,720);
    }

    public void hide()
    {
        Harry.setVisible(false);
    }

    public void show()
    {
        Harry.setVisible(true);;
    }

    public void harryClose() throws IOException
    {
        BufferedImage img14 = ImageIO.read(new File("src\\resources\\HarrisonNB - Murderer (7).png"));
        Image image14 = img14.getScaledInstance(1800, 1013, Image.SCALE_DEFAULT);
        expressions[13] = new ImageIcon(image14);
        Harry.setBounds(-285,-30,1920,1080);

        Harry.setIcon(expressions[13]);
    }
}
