import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class SceneTwo  extends JLayeredPane implements ActionListener{
    JLabel sceneBG;
    NBButtons next, back;

    int dialogueNum = 0;

    CCDDUI UI = new CCDDUI();

    CCDDSoundPlayer music = new CCDDSoundPlayer();
    CCDDSoundPlayer sfx = new CCDDSoundPlayer();
    dialogues2 dialogue = new dialogues2();
    dialogues4 dialogue1 = new dialogues4();

    bgImages img = new bgImages();
    assetImgs ass = new assetImgs();

    Font decisionTextFont;

    HarrisonChar harry = new HarrisonChar();
    GerardChar gerard = new GerardChar();

    int sceneChange = 0;
    int knife, noKnife;
    int stallChoice, kitchenChoice;

    DecisionBox stall, kitchen;

    Scene5 s5 = new Scene5();

    SceneTwo() throws IOException
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

        sceneBG = new JLabel(img.returnImage(8));
        add(sceneBG, Integer.valueOf(0));
        sceneBG.setBounds(0,0,1280,720);
        sceneBG.setVisible(true);

        add(UI, Integer.valueOf(5));
        UI.setVisible(true);

        setVisible(false);

        next = new NBButtons("Next");
        next.setBounds(1006, 630, 100, 25);
        next.addActionListener(this);

        back = new NBButtons("Back");
        back.setBounds(165, 630, 100, 25);
        back.addActionListener(this);

        add(next, Integer.valueOf(6));
        add(back, Integer.valueOf(6));

        add(harry, Integer.valueOf(1));
        harry.changeExpression(4);

        add(gerard, Integer.valueOf(1));
        gerard.hide();

        knife = 0;

        stall = new DecisionBox("Go to the stall");
        stall.setBounds(515, 180, 250, 60);
        stall.setFont(decisionTextFont);
        stall.addActionListener(this);

        kitchen = new DecisionBox("Go to the kitchen");
        kitchen.setBounds(515, 250, 250, 60);
        kitchen.setFont(decisionTextFont);
        kitchen.addActionListener(this);

        add(stall, Integer.valueOf(7));
        add(kitchen, Integer.valueOf(7));
        kitchen.setVisible(false);
        stall.setVisible(false);

        stallChoice = kitchenChoice = 0;

        add(s5, Integer.valueOf(10));
        s5.setBounds(0,0,1280,720);
        s5.setVisible(false);

        add(ass,Integer.valueOf(5));
        ass.setBounds(0,0,1280,720);

    }

    public void actionPerformed(ActionEvent e)
    {
        String input = e.getActionCommand();

        switch (input) {
            case "Next":
                playSFX(1);
                nextDialogue();

                if(sceneChange==0)
                {
                    switch(dialogueNum)
                    {
                        case 8:
                            harry.changeExpression(1);
                            break;

                        case 10:
                            harry.changeExpression(2);
                            break;

                        case 13:
                            harry.changeExpression(0);
                            break;

                        case 16:
                            harry.changeExpression(1);
                            break;

                        case 17:
                            harry.changeExpression(4);
                            break;

                        case 22:
                            harry.changeExpression(0);
                            break;
                        
                        case 24:
                            harry.changeExpression(1);
                            break;

                        case 25:
                            harry.changeExpression(4);
                            break;

                        case 32:
                            harry.changeExpression(0);
                            break;

                        case 33:
                            harry.hide();
                            break;

                        case 34:
                            sceneBG.setIcon(img.returnImage(9));
                            break;

                        case 38:
                            gerard.changeExpression(2);
                            gerard.show();
                            break;

                        case 40:
                            gerard.changeExpression(1);
                            break;

                        case 41:
                            gerard.changeExpression(0);
                            break;
                        case 42:
                            gerard.changeExpression(1);
                            break;

                        case 63:
                            gerard.hide();
                            harry.show();
                            sceneBG.setIcon(img.returnImage(8));
                            break;

                        case 66:
                            harry.changeExpression(4);
                            break;

                        case 72:
                            harry.changeExpression(5);
                            break;

                        case 73:
                            sceneChange++;
                            dialogueNum = 0;
                            UI.changeText(dialogue1.getDialogueText(0));
                            break;
                    }
                } 
                else if(sceneChange == 1 && (kitchenChoice == 0 && stallChoice == 0))
                {
                        switch(dialogueNum)
                        {
                            case 2:
                                harry.changeExpression(4);
                                break;

                            case 6:
                                harry.changeExpression(1);
                                break;

                            case 7:
                                harry.changeExpression(4);
                                break;

                            case 12:
                                harry.changeExpression(1);
                                break;

                            case 13:
                                harry.changeExpression(4);
                                break;

                            case 20:
                                harry.changeExpression(3);
                                break;

                            case 24:
                                harry.changeExpression(4);
                                break;

                            case 29:
                                harry.changeExpression(0);
                                break;

                            case 31:
                                harry.changeExpression(4);
                                break;

                            case 34:
                                harry.changeExpression(1);
                                break;

                            case 35:
                                harry.changeExpression(4);
                                break;

                            case 43:
                                harry.changeExpression(1);
                                break;

                            case 46:
                                harry.changeExpression(4);
                                break;

                            case 55:
                                harry.changeExpression(1);
                                break;

                            case 56:
                                harry.changeExpression(4);
                                break;

                            case 58:
                                harry.changeExpression(3);
                                break;
                            case 59:
                                harry.changeExpression(0);
                                playSFX(6);
                                break;


                            case 65:
                                harry.hide();
                                sceneBG.setIcon(img.returnImage(9));
                                break;
                            case 71:
                                stall.setVisible(true);
                                kitchen.setVisible(true);
                                decisionTree();
                                break;
                        }
                }

                if (sceneChange == 1 && kitchenChoice == 1)
                {
                    System.out.println(dialogueNum);
                    switch (dialogueNum)
                    
                    {

                        case 6:
                            gerard.show();
                            gerard.setVisible(true);
                            break;

                        case 32:
                            ass.setImage(1);
                            ass.setVisible(true);
                            ass.showAsset();
                            break;

                        case 43:
                            stall.changeTitle("Take the knife");
                            kitchen.changeTitle("Reject the offer");

                            stall.setVisible(true);
                            kitchen.setVisible(true);
                            decisionTree();
                            break;

                    }
                }


                break;
        
            case "Back":
                playSFX(1);
                prevDialogue();
                break;

            case "Go to the stall":
                playSFX(1);
                removeDecision();
                dialogueNum = 0;
                stallChoice++;
                UI.changeText(dialogue1.get2DialogueText(0));
                sceneBG.setIcon(img.returnImage(10));
                drawNB();
                
                break;

            case "Go to the kitchen":
                playSFX(1);
                removeDecision();
                dialogueNum = 0;
                kitchenChoice++;
                UI.changeText(dialogue1.get3DialogueText(0));
                sceneBG.setIcon(img.returnImage(11));
                drawNB();

                break;

            case "Take the knife":
                playSFX(1);
                removeDecision();
                knife++;
                dialogueNum = 0;
                UI.changeText(dialogue1.get4DialogueText(0));
                drawNB();
                ass.removeAsset();
                break;

            case "Reject the offer":
                playSFX(1);
                removeDecision();
                dialogueNum = 0;
                noKnife++;
                UI.changeText(dialogue1.get5DialogueText(0));
                drawNB();
                ass.removeAsset();
                break;
        }
    }

    public void drawScene()
    {
        setVisible(true);
        UI.drawDialogueBox();
        UI.changeText(dialogue.getDialogueText(0));
        playMusic(5);
    }

    public void nextDialogue()
    {
        if(dialogueNum<=dialogue.getDialogueLength() && !(sceneChange >= 1))
        {
            dialogueNum++;
            UI.changeText(dialogue.getDialogueText(dialogueNum));
            System.out.println(dialogueNum);
        }

        if(dialogueNum<=dialogue1.getDialogueLength() && (sceneChange >= 1) && (stallChoice == 0 && kitchenChoice == 0))
        {
            dialogueNum++;
            UI.changeText(dialogue1.getDialogueText(dialogueNum));
            System.out.println(dialogueNum);
        }

        if(dialogueNum<=dialogue1.get2DialogueLength() && stallChoice == 1)
        {
            dialogueNum++;
            UI.changeText(dialogue1.get2DialogueText(dialogueNum));
        }

        if(dialogueNum<=dialogue1.get3DialogueLength() && kitchenChoice == 1 && !(knife >= 1 || noKnife >= 1))
        {
            dialogueNum++;
            UI.changeText(dialogue1.get3DialogueText(dialogueNum));
        }

        if(dialogueNum<=dialogue1.get4DialogueLength() && knife >= 1)
        {
            dialogueNum++;
            UI.changeText(dialogue1.get4DialogueText(dialogueNum));
        }

        if(dialogueNum<=dialogue1.get5DialogueLength() && noKnife >= 1)
        {
            dialogueNum++;
            UI.changeText(dialogue1.get5DialogueText(dialogueNum));
        }

        if(dialogueNum == 12 && stallChoice == 1)
        {
            s5.setVisible(true);
            s5.drawScene();
            music.stop();
        }

        if(dialogueNum == 12 && kitchenChoice == 1 && knife == 1)
        {
            s5.setVisible(true);
            s5.drawScene();
            s5.knifeResult(knife);
            music.stop();
            
        }

        if(dialogueNum == 8 && kitchenChoice == 1 && noKnife == 1)
        {
            s5.setVisible(true);
            s5.drawScene();
            music.stop();
            
        }
    }

    public void prevDialogue()
    {
        if(0<dialogueNum)
        {
            dialogueNum--;
            if (sceneChange==0) {
                UI.changeText(dialogue.getDialogueText(dialogueNum));
            } else
            {
                UI.changeText(dialogue1.getDialogueText(dialogueNum));
            }
        }
    }

    public void playSFX(int i)
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

    public void removeDecision()
    {
        stall.setVisible(false);
        kitchen.setVisible(false);
    }

    public void stopMusic()
    {
        music.stop();
    }

    public void removeScene()
    {
        setVisible(false);
    }
}
