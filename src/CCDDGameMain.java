import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class CCDDGameMain extends JLayeredPane implements ActionListener{

    Font gameTitleFont;
    Font gameButtonsFont;
    JButton gameStart, gameExit, gameCredits;
    JPanel dialogueBox, loadingBox;
    JLabel gameBackground, loadingText, gameCreditsLabel, gameTitleName;
    int loadingTimer = 7;

    //Sound
    CCDDSoundPlayer Sounds = new CCDDSoundPlayer();

    //Credits
    CCDDCredits Credits = new CCDDCredits();

    //Loading Screen
    CCDDLoadingScreen loading = new CCDDLoadingScreen();

    //Scenes
    CCDDSceneOne s1 = new CCDDSceneOne();
    
    CCDDGameMain()  throws IOException{

        try {
            gameTitleFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\Pinky Love.ttf")).deriveFont(65f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\Pinky Love.ttf")));

            gameButtonsFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\fontButtonsFont.ttf")).deriveFont(35f);
            ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\fontButtonsFont.ttf")));
        }
        catch (IOException | FontFormatException e)
        {

        }

        setBounds(0,0,1280,720);

        //Background Image
        BufferedImage openingBG = ImageIO.read(new File("src\\resources\\GameOpening.jpg"));

        Image image = openingBG.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);

        ImageIcon openingBGImage = new ImageIcon(image);

        gameBackground = new JLabel(openingBGImage);
        gameBackground.setBounds(0,0,1280,720);
        add(gameBackground, Integer.valueOf(0));

        //Game Title
        gameTitleName = new JLabel("A Deadly Date");
        gameTitleName.setForeground(Color.white);
        gameTitleName.setFont(gameTitleFont);
        gameTitleName.setBounds(50, 50, 500, 100);

        add(gameTitleName, Integer.valueOf(1));

        //Start Game Button
        gameStart = new JButton("New Game");
        gameStart.addActionListener(this);
        gameStart.setBounds(5,200,300,50);
        gameStart.setFont(gameButtonsFont);
        gameStart.setOpaque(false);
        gameStart.setContentAreaFilled(false);
        gameStart.setBorderPainted(false);
        gameStart.setForeground(Color.WHITE);
        add(gameStart, Integer.valueOf(1));

        //Exit Game Button
        gameExit = new JButton("Exit Game");
        gameExit.addActionListener(this);
        gameExit.setBounds(25, 360, 250,50);
        gameExit.setFont(gameButtonsFont);
        gameExit.setOpaque(false);
        gameExit.setContentAreaFilled(false);
        gameExit.setBorderPainted(false);
        gameExit.setForeground(Color.WHITE);
        add(gameExit, Integer.valueOf(1));

        //Credits Button
        gameCredits = new JButton("Credits");
        gameCredits.addActionListener(this);
        gameCredits.setBounds(5, 280, 230,50);
        gameCredits.setFont(gameButtonsFont);
        gameCredits.setOpaque(false);
        gameCredits.setContentAreaFilled(false);
        gameCredits.setBorderPainted(false);
        gameCredits.setForeground(Color.WHITE);
        
        add(gameCredits, Integer.valueOf(1));

        add(Credits, Integer.valueOf(2));
        Credits.textFont(gameButtonsFont);

        //Loading Box Initialize
        loading.loadingFont(gameButtonsFont);
        add(loading, Integer.valueOf(99));

        playMusic(0);

        add(s1, Integer.valueOf(5));
    }

    public void playMusic(int i) {
        Sounds.setFile(i);
        Sounds.play();
        Sounds.loop();
    }

    public void stopMusic()
    {
        Sounds.stop();
    }
    public void playSE(int i)
    {
        Sounds.setFile(i);
        Sounds.play();
    }

    public void actionPerformed(ActionEvent e)
    {
        String input = e.getActionCommand();
        
        switch(input)
        {
            case "New Game":
                stopMusic();
                playSE(1);
                
                removeIntroScreen();
                gameBackground.setVisible(false);
                s1.drawScene();

                break;

            case "Exit Game":
                playSE(1);
                System.exit(0);

                break;

            case "Credits":
                stopMusic();
                playSE(1);
                Credits.drawCredits();

        }
    }

    public void removeIntroScreen()
    {
        gameStart.setVisible(false);
        gameExit.setVisible(false);
        gameTitleName.setVisible(false);
        gameCredits.setVisible(false);
    }

    public void drawIntroScreen()
    {
        playMusic(0);

        gameBackground.setVisible(true);
        gameStart.setVisible(true);
        gameExit.setVisible(true);
        gameTitleName.setVisible(true);
    }

}