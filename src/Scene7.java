import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.File;
import java.awt.*;

public class Scene7 extends JLayeredPane implements ActionListener{

    CCDDUI UI = new CCDDUI();

    CCDDSoundPlayer music = new CCDDSoundPlayer();
    CCDDSoundPlayer sfx = new CCDDSoundPlayer();

    Endings end;

    dialogues7 d7 = new dialogues7();

    NBButtons next, back;
    DecisionBox join, death, secret;

    int knife = 0;
    int dialogueNum = 0;
    int joinCount, deathCount, secretCount;

    JLabel sceneBG;

    bgImages img = new bgImages();

    HarrisonChar harry = new HarrisonChar();

    Font decision1Font, secretFont, revealFont;

    Scene7() throws IOException
    {
        try
        {
            decision1Font = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\HelpMe.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\HelpMe.ttf")));

            secretFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\Wingding Review.ttf")).deriveFont(25f);
            GraphicsEnvironment eg = GraphicsEnvironment.getLocalGraphicsEnvironment();
            eg.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\Wingding Review.ttf")));

            revealFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\ComicNeueSansID.ttf")).deriveFont(25f);
            GraphicsEnvironment gu = GraphicsEnvironment.getLocalGraphicsEnvironment();
            gu.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\resources\\ComicNeueSansID.ttf")));
        } 
        catch (IOException | FontFormatException e) 
        {
        
        }

        end = new Endings(0);

        setLayout(null);
        setBounds(0,0,1280,720);
        setVisible(false);

        sceneBG = new JLabel(img.returnImage(16));
        add(sceneBG, Integer.valueOf(0));
        sceneBG.setBounds(0,0,1280,720);
        sceneBG.setVisible(true);

        next = new NBButtons("Next");
        back = new NBButtons("Back");
        next.setBounds(1006, 630, 100, 25);
        back.setBounds(165, 630, 100, 25);
        next.addActionListener(this);
        back.addActionListener(this);

        join = new DecisionBox("Join Him");
        join.setBounds(485, 180, 250, 60);
        join.setFont(decision1Font);
        join.addActionListener(this);

        death = new DecisionBox("Retaliate");
        death.setBounds(485, 250, 250, 60);
        death.setFont(decision1Font);
        death.addActionListener(this);

        secret = new DecisionBox("eioarnbuiearvn");
        secret.setBounds(485, 320, 250, 60);
        secret.setEnabled(false);
        secret.setFont(secretFont);
        secret.addActionListener(this);

        joinCount = deathCount = secretCount = 0;

        add(join, Integer.valueOf(1));
        add(death, Integer.valueOf(1));
        add(secret, Integer.valueOf(1));

        add(next, Integer.valueOf(6));
        add(back, Integer.valueOf(6));

        add(UI, Integer.valueOf(5));
        add(harry, Integer.valueOf(1));
        harry.changeExpression(4);
        harry.hide();

        add(end, Integer.valueOf(5));
        end.setVisible(false);

        removeDecision();
    }

    public void actionPerformed(ActionEvent e)
    {
        String input = e.getActionCommand();

        switch(input)
        {
            case "Next":
                playSFX(1);
                nextDialogue();

                System.out.println(dialogueNum);
                if(joinCount == 1)
                {
                    switch(dialogueNum)
                    {
                        case 1:
                            harry.changeExpression(10);
                            break;

                        case 6:
                            sceneBG.setIcon(null);
                            sceneBG.setOpaque(true);
                            sceneBG.setBackground(Color.BLACK);
                            harry.hide();
                            break;

                        case 13:
                            next.setVisible(false);
                            back.setVisible(false);
                            UI.setVisible(false);
                            end.setVisible(true);
                            break;

                    }
                }

                if(deathCount == 1)
                {
                    switch(dialogueNum)
                    {
                        case 8:
                            harry.changeExpression(11);
                            break;

                        case 11:
                            harry.changeExpression(12);
                            break;

                        case 16:
                            harry.changeExpression(9);
                            break;

                        case 17:
                            harry.hide();
                            next.setVisible(false);
                            back.setVisible(false);
                            UI.setVisible(false);
                            end.setVisible(true);
                            break;
    
                    }
                }

                if(secretCount == 1)
                {
                    switch(dialogueNum)
                    {
                        case 11:
                            harry.changeExpression(6);
                            break;

                        case 12:
                            harry.changeExpression(10);
                            break;

                        case 15:
                            harry.hide();
                            break;

                        case 20:
                            harry.show();
                            harry.changeExpression(12);
                            break;

                        case 22:
                            harry.hide();
                            break;

                        case 24:
                            music.stop();
                            playMusic(14);
                            break;

                        case 27:
                            sceneBG.setIcon(img.returnImage(18));
                            break;

                        case 31:
                            sceneBG.setIcon(null);
                            break;

                        case 32:
                            next.setVisible(false);
                            back.setVisible(false);
                            UI.setVisible(false);
                            end.setVisible(true);
                            break;
    
                    }
                }

                if(joinCount == 0 && deathCount == 0 && secretCount == 0)
                {
                    switch (dialogueNum) 
                    {
                        case 3:
                            harry.changeExpression(9);
                            break;

                        case 8:
                            harry.changeExpression(6);
                            break;

                        case 11:
                            harry.changeExpression(10);
                            break;

                        case 17:
                            harry.changeExpression(7);
                            break;

                        case 20:
                            harry.changeExpression(6);
                            break;

                        case 21:
                            harry.changeExpression(10);
                            break;

                        case 27:
                            harry.changeExpression(6);
                            break;

                        case 30:
                            try {
                                harry.harryClose();
                            } catch (IOException e1) {

                            }
                            break;

                        case 34:
                            drawDecision();
                            break;
                    }    
                }
                break;

            case "Back":
                playSFX(1);
                prevDialogue();
                break;

            case "Join Him":
                music.stop();
                playSFX(1);
                playMusic(4);
                removeDecision();
                joinCount++;
                dialogueNum = 0;
                UI.changeText(d7.get1DialogueText(0));
                break;

            case "Retaliate":
                music.stop();
                playMusic(12);
                playSFX(1);
                removeDecision();
                deathCount++;
                dialogueNum = 0;
                UI.changeText(d7.get2DialogueText(0));
                break;

            case "Use the Knife":
                music.stop();
                playSFX(1);
                playMusic(13);
                removeDecision();
                secretCount++;
                dialogueNum = 0;
                UI.changeText(d7.get3DialogueText(0));
                break;
        }
    }

    public void drawScene() throws IOException
    {
        setVisible(true);
        UI.drawDialogueBox();
        setStartDialogue();
        playMusic(11);
        harry.show();
        //harry.changeExpression(6);
        harry.changeExpression(6);;
    }

    public void drawDecision()
    {
        join.setVisible(true);
        death.setVisible(true);
        secret.setVisible(true);
        next.setVisible(false);
        back.setVisible(false);

        if(knife == 1)
        {
            secret.setText("Use the Knife");
            secret.setEnabled(true);
            secret.setFont(revealFont);
        }
    }

    public void removeDecision()
    {
        join.setVisible(false);
        death.setVisible(false);
        secret.setVisible(false);
        next.setVisible(true);
        back.setVisible(true);
    }

    public void setStartDialogue()
    {
        UI.changeText(d7.getDialogueText(0));
    }

    public void nextDialogue()
    {
        if(dialogueNum<=d7.getDialogueLength() && (joinCount == 0 && deathCount == 0 && secretCount ==0))
        {
            dialogueNum++;
            UI.changeText(d7.getDialogueText(dialogueNum));
        }

        if(dialogueNum<=d7.get1DialogueLength() && joinCount == 1)
        {
            dialogueNum++;
            UI.changeText(d7.get1DialogueText(dialogueNum));
            end.endingNum(1);
        }

        if(dialogueNum<=d7.get2DialogueLength() && deathCount == 1)
        {
            dialogueNum++;
            UI.changeText(d7.get2DialogueText(dialogueNum));
            end.endingNum(2);
        }

        if(dialogueNum<=d7.get3DialogueLength() && secretCount == 1)
        {
            dialogueNum++;
            UI.changeText(d7.get3DialogueText(dialogueNum));
            end.endingNum(4);
        }
    }

    public void prevDialogue()
    {
        if(0<dialogueNum)
        {
            dialogueNum--;
            UI.changeText(d7.getDialogueText(dialogueNum));
        }
    }

    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void playSFX(int i)
    {
        sfx.setFile(i);
        sfx.play();
    }
    public void knifeResult(int i)
    {
        knife = i;
    }
}