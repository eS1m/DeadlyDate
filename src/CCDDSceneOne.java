
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class CCDDSceneOne extends JLayeredPane implements ActionListener{

    JLabel sceneBG;
    NBButtons next, back;

    int dialogueNum = 0;
    int postDial = 0;

    CCDDdialogues dialogues = new CCDDdialogues();
    CCDDUI UI = new CCDDUI();

    CCDDSoundPlayer sfx = new CCDDSoundPlayer();
    CCDDSoundPlayer music = new CCDDSoundPlayer();

    SceneTwo s2 = new SceneTwo();

    Endings end = new Endings(3);
    
    DecisionBox s1Yes, s1No;
    Font decisionTextFont;

    bgImages img = new bgImages();
    assetImgs ass = new assetImgs();
    HarrisonChar harry = new HarrisonChar();

    int repeat = 0;

    CCDDSceneOne() throws IOException
    {
        setLayout(null);
        setBounds(0,0, 1280,720);

        try
        {
            decisionTextFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\DecisionsTextFont.otf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\DecisionsTextFont.otf")));
        } 
        catch (IOException | FontFormatException e) 
        {
        
        }

        sceneBG = new JLabel(img.returnImage(0));
        add(sceneBG, Integer.valueOf(1));
        sceneBG.setBounds(0,0,1280,720);
        sceneBG.setVisible(true);

        next = new NBButtons("Next");
        next.setBounds(1006, 630, 100, 25);
        next.addActionListener(this);

        back = new NBButtons("Back");
        back.setBounds(165, 630, 100, 25);
        back.addActionListener(this);

        setLayout(null);
        setBounds(0,0,1280,720);

        s1Yes = new DecisionBox("Give them your name");
        s1Yes.setBounds(515, 180, 250, 60);
        s1Yes.setFont(decisionTextFont);
        s1Yes.addActionListener(this);

        s1No = new DecisionBox("Bail on him");
        s1No.setBounds(515, 250, 250, 60);
        s1No.setFont(decisionTextFont);
        s1No.addActionListener(this);
       
        add(next, Integer.valueOf(6));
        add(back, Integer.valueOf(6));

        add(s1Yes, Integer.valueOf(7));
        add(s1No, Integer.valueOf(7));

        add(UI, Integer.valueOf(5));

        add(harry, Integer.valueOf(2));
        harry.setVisible(false);

        add(ass, Integer.valueOf(3));

        setVisible(false);
        removeDecision();

        add(end, Integer.valueOf(10));
        end.setVisible(false);

        add(s2, Integer.valueOf(10));
        s2.setVisible(false);

    }

    public void drawScene()
    {
        setVisible(true);
        UI.drawDialogueBox();
        setStartDialogue();
    }

    public void removeScene()
    {
        setVisible(false);
    }

    public void nextDialogue()
    {

        if(dialogueNum<=dialogues.getDialogueLength() && !(postDial >= 1))
        {
            if(dialogueNum!=22)
            {
                System.out.println(dialogueNum);
                dialogueNum++;
                UI.changeText(dialogues.getDialogueText(dialogueNum));
            }
            else
            {
                decisionTree();
                drawDecision();
            }
        }

        switch(postDial)
        {
            case 1:
                if(dialogueNum<=dialogues.get1DialogueLength())
                {
                    System.out.println(dialogueNum);
                    dialogueNum++;
                    UI.changeText(dialogues.get1DialogueText(dialogueNum));
                }

                break;

            case 2:
                if(dialogueNum<=dialogues.get2DialogueLength())
                {
                    System.out.println(dialogueNum);
                    dialogueNum++;
                    UI.changeText(dialogues.get2DialogueText(dialogueNum));
                }

                break;
        }
    }

    public void prevDialogue()
    {
        if(0<dialogueNum && !(postDial >= 1))
        {
            dialogueNum--;
            UI.changeText(dialogues.getDialogueText(dialogueNum));
        }

        System.out.println(dialogueNum);
        
        switch (postDial) {
            case 1:
                if(0<dialogueNum)
                {
                    dialogueNum--;
                    UI.changeText(dialogues.get1DialogueText(dialogueNum));
                }

                break;

            case 2:
                if(0<dialogueNum)
                {
                    dialogueNum--;
                    UI.changeText(dialogues.get2DialogueText(dialogueNum));
                }
                break;
        }
    }

    public void setStartDialogue()
    {
        UI.changeText(dialogues.getDialogueText(0));
    }

    public void actionPerformed(ActionEvent e)
    {
        String input = e.getActionCommand();
        System.out.println(input);

        switch(input)
        {
            case "Next":
                playSE(1);
                nextDialogue();

                switch(postDial)
                {
                    case 0:
                        switch (dialogueNum)
                        {
                            case 4:
                                if(repeat==0)
                                {
                                    playMusic(3);
                                    repeat++;
                                }

                                break;

                            case 9:
                                changeImage(1);

                                break;

                            case 16:
                                changeImage(2);
                                break;
                        }

                        break;

                    case 1:
                        switch(dialogueNum)
                        {
                            case 3:
                                changeImage(0);
                                break;

                            case 7:
                                changeImage(7);
                                break;

                            case 10:
                                stopMusic();
                                playMusic(5);
                                changeImage(8);

                                break;

                            case 21:
                                harry.setVisible(true);
                                harry.show();
                                harryChangeFace(4);
                                break;

                            case 22:

                                harryChangeFace(0);
                                break;

                            case 31:
                                harryChangeFace(1);
                                break;

                            case 33:
                                harryChangeFace(4);
                                break;
                            case 35:
                                ass.setImage(0);
                                ass.setVisible(true);
                                ass.showAsset();
                                break;

                            case 36:
                                ass.setVisible(false);
                                break;

                            case 37:
                                break;

                            case 39:
                                harryChangeFace(1);
                                break;

                            case 40:
                                harryChangeFace(4);
                                break;

                            case 43:
                                stopMusic();
                                s2.setVisible(true);
                                s2.drawScene();
                                break;
                        }

                        break;

                    case 2:
                        switch(dialogueNum)
                        {
                            case 4:
                                changeImage(5);
                                break;

                            case 5:
                                changeImage(6);
                                break;

                            case 9:
                                end.setVisible(true);
                                break;
                        }
                        
                        break;
                }

                break;
            

            case "Back":
                playSE(1);
                prevDialogue();
                break;

            case "Give them your name":

                removeDecision();
                playSE(1);

                postDial = 1;

                drawNB();

                changeImage(3);

                dialogueNum = 0;

                UI.changeText(dialogues.get1DialogueText(0));
                break;

            case "Bail on him":

                removeDecision();
                stopMusic();
                playSE(1);

                playMusic(4);

                changeImage(4);

                postDial = 2;
                drawNB();
                dialogueNum = 0;

                UI.changeText(dialogues.get2DialogueText(0));
                break;

            case "Submit":
                
                playSE(1);

                drawNB();
                nextDialogue();
                break;

        }
        
        }
    

    public void playSE(int i)
    {
        sfx.setFile(i);
        sfx.play();
    }

    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic()
    {
        music.stop();
    }

    public void decisionTree()
    {
        next.setVisible(false);
        back.setVisible(false);
    }

    public void drawNB()
    {
        next.setVisible(true);
        back.setVisible(true);
    }

    public void drawDecision()
    {
        s1Yes.setVisible(true);
        s1No.setVisible(true);

    }
    public void removeDecision()
    {
        s1Yes.setVisible(false);
        s1No.setVisible(false);
    }

    public void changeImage(int i)
    {
        sceneBG.setIcon(img.returnImage(i));
    }

    public void harryChangeFace(int i)
    {
        harry.changeExpression(i);
    }

}
