import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class Endings extends JLayeredPane implements ActionListener{
    JLabel endingText, endingPath;
    JLabel testBackground;
    DecisionBox closeGame;
    Font endingFont, endingPathFont, buttonFont;

    Endings(int num) throws IOException
    {

        try
        {
            endingFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\Pinky Love.ttf")).deriveFont(120f);
            endingPathFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\EndingFont.otf")).deriveFont(30f);
            buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\DecisionsTextFont.otf")).deriveFont(25f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\Pinky Love.ttf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\EndingFont.otf")));
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\DecisionsTextFont.otf")));
        } 
        catch (IOException | FontFormatException e) 
        {
        
        }

        setLayout(null);
        setBounds(0,0,1280,720);

        endingText = new JLabel("THE END");
        endingPath = new JLabel("ENDING: " + num + "/4");

        endingText.setBounds(440, 50, 400, 150);
        endingPath.setBounds(520, 155, 400, 150);

        endingText.setFont(endingFont);
        endingPath.setFont(endingPathFont);

        endingText.setForeground(Color.WHITE);
        endingPath.setForeground(Color.WHITE);

        add(endingText, Integer.valueOf(1));
        add(endingPath, Integer.valueOf(1));

        closeGame = new DecisionBox("Close Game");
        closeGame.setFont(buttonFont);
        closeGame.setBounds(502, 300, 250, 60);
        closeGame.addActionListener(this);

        add(closeGame, Integer.valueOf(1));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==closeGame)
        {
            System.exit(0);
        }
    }

    public void endingNum(int i)
    {
        endingPath.setText("ENDING: " + i + "/4");
    }
}
