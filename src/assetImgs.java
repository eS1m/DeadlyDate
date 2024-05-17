import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class assetImgs extends JLayeredPane{
    ImageIcon objects[] = new ImageIcon[10];
    JLabel image;

    assetImgs() throws IOException
    {
        setLayout(null);
        setBounds(0,0,1280,720);
        setVisible(true);

        BufferedImage flowers = ImageIO.read(new File("src\\resources\\Flowers.png"));
        Image flowers1 = flowers.getScaledInstance(328, 450, Image.SCALE_DEFAULT);
        objects[0] = new ImageIcon(flowers1);

        BufferedImage knife = ImageIO.read(new File("src\\resources\\Knife.png"));
        Image knife1 = knife.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        objects[1] = new ImageIcon(knife1);

        image = new JLabel(objects[0]);
        image.setBounds(0,0,1280,720);
        image.setVisible(false);

        add(image, Integer.valueOf(3));
    }

    public void showAsset()
    {
        image.setVisible(true);
    }

    public void removeAsset()
    {
        image.setVisible(false);
    }

    public void setImage(int i)
    {
        image.setIcon(objects[i]);
    }
}
