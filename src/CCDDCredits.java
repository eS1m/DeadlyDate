import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import javax.swing.*;

public class CCDDCredits extends JPanel implements ActionListener
{
    Font creditsTitleFont, creditsNameFont;
    JLabel coder, artistScriptWriter;
    JLayeredPane arrange;
    JButton creditsBack;

    CCDDSoundPlayer Sounds = new CCDDSoundPlayer();

    CCDDCredits() throws IOException
    {

        try {
            creditsTitleFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\CreditsTitleFont.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\CreditsTitleFont.ttf")));

            creditsNameFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\CreditsNameFont.ttf")).deriveFont(40f);
            ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\CreditsNameFont.ttf")));
        }
        catch (IOException | FontFormatException e)
        {

        }

        arrange = new JLayeredPane();
        arrange.setBounds(0,0,1280,720);
        add(arrange);

        //Back Button
        creditsBack = new JButton("BACK");
        creditsBack.setBounds(10,500,150,50);
        creditsBack.addActionListener(this);
        arrange.add(creditsBack);

        //Background Image
        BufferedImage bufferedImage = ImageIO.read(new File("src\\resources\\CreditsPlaceHolder.jpg"));

        Image image = bufferedImage.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);

        ImageIcon creditsBackgroundImage = new ImageIcon(image);
        JLabel creditsBackground = new JLabel(creditsBackgroundImage);
        creditsBackground.setBounds(0,0,1280,720);
        arrange.add(creditsBackground, Integer.valueOf(0));

        //Credits
        coder = new JLabel("CODERS & PLAYTESTERS");
        artistScriptWriter = new JLabel("ARTISTS & SCRIPTWRITERS");

        // - Coder Names
        coder.setBounds(750, 50, 480, 50);
        coder.setForeground(Color.BLACK);
        coder.setFont(creditsTitleFont);

        JLabel coderEvan = new JLabel("Evan Daniel F. Simbajon");
        coderEvan.setFont(creditsNameFont);
        coderEvan.setBounds(990, 100, 480, 50);
        JLabel coderJill = new JLabel("Jillian Althea Boc");
        coderJill.setFont(creditsNameFont);
        coderJill.setBounds(1040, 150, 480, 50);

        // - Artist Names
        artistScriptWriter.setBounds(700, 250, 540, 50);
        artistScriptWriter.setForeground(Color.BLACK);
        artistScriptWriter.setFont(creditsTitleFont);

        JLabel artistRica = new JLabel("Rice Louise Mascunana");
        artistRica.setFont(creditsNameFont);
        artistRica.setBounds(990, 300, 480, 50);
        JLabel artistMonica = new JLabel("Monica C Galla");
        artistMonica.setFont(creditsNameFont);
        artistMonica.setBounds(1060,350,480,50);
        JLabel artistCherdren = new JLabel("Cherdren Jaune E. Quirino");
        artistCherdren.setFont(creditsNameFont);
        artistCherdren.setBounds(975, 400, 480 ,50);

        arrange.add(coder, Integer.valueOf(1));
        arrange.add(artistScriptWriter, Integer.valueOf(1));
        arrange.add(coderEvan, Integer.valueOf(1));
        arrange.add(coderJill, Integer.valueOf(1));
        arrange.setVisible(true); 
        
        arrange.add(artistRica, Integer.valueOf(1));
        arrange.add(artistMonica, Integer.valueOf(1));
        arrange.add(artistCherdren, Integer.valueOf(1));

        setLayout(null);
        setBounds(0,0, 1280,720);
        setVisible(false);
    }

    public void drawCredits()
    {
        Sounds.setFile(2);
        Sounds.play();
        Sounds.loop();

        setVisible(true);
        coder.setVisible(true);
    }

    public void textFont(Font i)
    {
        creditsBack.setFont(i);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("BACK"))
        {
            Sounds.stop();
            Sounds.setFile(1);
            Sounds.play();

            Sounds.setFile(0);
            Sounds.play();

            setVisible(false);
        }
        else{

        }
    }
}
