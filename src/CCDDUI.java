import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CCDDUI extends JLayeredPane
{
    JPanel dialogueBox;
    JLabel chatDialogue;
    Font dialogueFont;

    CCDDUI()
    {
        try
        {
            dialogueFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\ComicNeueSansID.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\ComicNeueSansID.ttf")));
        } 
        catch (IOException | FontFormatException e) 
        {
        
        }

        setLayout(null);

        dialogueBox = new JPanel();
        dialogueBox.setBounds(145, 510, 950, 150);
        dialogueBox.setBackground(new Color(0,0,0,166));
        add(dialogueBox, Integer.valueOf(1));
        dialogueBox.setVisible(true);

        setBounds(0,0,1280,720);
        setVisible(false);

        chatDialogue = new JLabel("");
        chatDialogue.setForeground(Color.WHITE);
        chatDialogue.setBounds(160, 523, 918, 20);
        add(chatDialogue, Integer.valueOf(2));
        chatDialogue.setVisible(true);
        chatDialogue.setFont(dialogueFont);

    }

    public void drawDialogueBox()
    {
        setVisible(true);
        dialogueBox.setVisible(true);
    }

    public void removeDialogueBox()
    {
        dialogueBox.setVisible(false);
    }

    public void changeText(String i)
    {
        chatDialogue.setText(i);
    }

}