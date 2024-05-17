import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class bgImages {
    
    ImageIcon images[] = new ImageIcon[30];
    ImageIcon funni[] = new ImageIcon[4];


    bgImages() throws IOException
    {
        BufferedImage mainSceneBG = ImageIO.read(new File("src\\resources\\bedroom.jpg"));
        Image image1 = mainSceneBG.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[0] = new ImageIcon(image1);

        BufferedImage lipstickSceneBG = ImageIO.read(new File("src\\resources\\SCENE1-1.png"));
        Image image2 = lipstickSceneBG.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[1] = new ImageIcon(image2);

        BufferedImage lipstickSceneBG1 = ImageIO.read(new File("src\\resources\\SCENE1-2.png"));
        Image image3 = lipstickSceneBG1.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[2] = new ImageIcon(image3);

        BufferedImage lipstickSceneBG2 = ImageIO.read(new File("src\\resources\\SCENE1-CHOICE1.png"));
        Image image4 = lipstickSceneBG2.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[3] = new ImageIcon(image4);

        BufferedImage lipstickSceneBG3 = ImageIO.read(new File("src\\resources\\SCENE1-CHOICE2.png"));
        Image image5 = lipstickSceneBG3.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[4] = new ImageIcon(image5);

        BufferedImage lipstickSceneBG4 = ImageIO.read(new File("src\\resources\\SCENE1-CHOICE2-2.png"));
        Image image6 = lipstickSceneBG4.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[5] = new ImageIcon(image6);

        BufferedImage lipstickSceneBG5 = ImageIO.read(new File("src\\resources\\SCENE1-CHOICE2-3.png"));
        Image image7 = lipstickSceneBG5.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[6] = new ImageIcon(image7);

        BufferedImage outside = ImageIO.read(new File("src\\resources\\sidewalk2.jpg"));
        Image image8 = outside.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[7] = new ImageIcon(image8);

        BufferedImage restaurant = ImageIO.read(new File("src\\resources\\fancyrestaurant3.jpg"));
        Image image9 = restaurant.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[8] = new ImageIcon(image9);

        BufferedImage restaurant2 = ImageIO.read(new File("src\\resources\\fancyRest.jpeg"));
        Image image10 = restaurant2.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[9] = new ImageIcon(image10);

        BufferedImage restCR = ImageIO.read(new File("src\\resources\\fancyrestroom1.jpg"));
        Image image11 = restCR.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[10] = new ImageIcon(image11);

        BufferedImage kitchen = ImageIO.read(new File("src\\resources\\kitchen1.jpg"));
        Image image12 = kitchen.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[11] = new ImageIcon(image12);

        BufferedImage harryEat2 = ImageIO.read(new File("src\\resources\\SCENE5-3.png"));
        Image image14 = harryEat2.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[13] = new ImageIcon(image14);

        BufferedImage outside61 = ImageIO.read(new File("src\\resources\\sidewalk1.jpg"));
        Image image15 = outside61.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[14] = new ImageIcon(image15);

        BufferedImage blazer = ImageIO.read(new File("src\\resources\\SCENE6-1.png"));
        Image image16 = blazer.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[15] = new ImageIcon(image16);

        BufferedImage alleyway = ImageIO.read(new File("src\\resources\\backalley1.jpg"));
        Image image17 = alleyway.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[16] = new ImageIcon(image17);

        BufferedImage gerardDead = ImageIO.read(new File("src\\resources\\SCENE6-2.png"));
        Image image18 = gerardDead.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[17] = new ImageIcon(image18);

        BufferedImage harryKill = ImageIO.read(new File("src\\resources\\SCENE7-ENDING3.png"));
        Image image19 = harryKill.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        images[18] = new ImageIcon(image19);

        //funni

        BufferedImage funni1 = ImageIO.read(new File("src\\resources\\SCENE6-2- funny 1.png"));
        Image fun1 = funni1.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        funni[1] = new ImageIcon(fun1);

        BufferedImage funni2 = ImageIO.read(new File("src\\resources\\SCENE6-2- funny 2.png"));
        Image fun2 = funni2.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        funni[2] = new ImageIcon(fun2);

        BufferedImage funni3 = ImageIO.read(new File("src\\resources\\SCENE6-2- funny 3.png"));
        Image fun3= funni3.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
        funni[3] = new ImageIcon(fun3);
        
    }

    public Icon returnImage(int i)
    {
        return images[i];
    }

    public Icon getFunni(int i)
    {
        return funni[i];
    }
}
