import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Scene6 extends JLayeredPane implements ActionListener{
    CCDDSoundPlayer music = new CCDDSoundPlayer();
    CCDDSoundPlayer sfx = new CCDDSoundPlayer();
    CCDDSoundPlayer ambiance = new CCDDSoundPlayer();

    NBButtons next, back;

    CCDDUI UI = new CCDDUI();

    HarrisonChar harry = new HarrisonChar();

    dialogues6 d6 = new dialogues6();

    int knife = 0;
    int dialogueNum = 0;
    int funniCount = 0;

    JLabel sceneBG;

    bgImages img = new bgImages();

    Scene7 s7 = new Scene7();

    JButton funni;

    Scene6() throws IOException 
    {
        setLayout(null);
        setBounds(0,0,1280,720);
        setVisible(false);

        sceneBG = new JLabel(img.returnImage(14));
        add(sceneBG, Integer.valueOf(0));
        sceneBG.setBounds(0,0,1280,720);
        sceneBG.setVisible(true);

        next = new NBButtons("Next");
        back = new NBButtons("Back");
        next.setBounds(1006, 630, 100, 25);
        back.setBounds(165, 630, 100, 25);
        next.addActionListener(this);
        back.addActionListener(this);

        add(next, Integer.valueOf(6));
        add(back, Integer.valueOf(6));

        add(UI, Integer.valueOf(5));
        add(harry, Integer.valueOf(1));
        harry.changeExpression(4);
        harry.hide();

        funni = new JButton("");
        funni.setBounds(640, 100, 100, 100);
        funni.addActionListener(this);
        add(funni, Integer.valueOf(1));
        funni.setOpaque(false);
        funni.setContentAreaFilled(false);
        funni.setBorderPainted(false);
        funni.setVisible(false);

        add(s7, Integer.valueOf(10));
        s7.setBounds(0,0,1280,720);

        UI.setVisible(true);

        drawNB();
    }

    public void actionPerformed(ActionEvent e)
    {
        String input = e.getActionCommand();

        if(e.getSource()==funni){
            funniCount++;
            if (funniCount!=4)
            {
                sceneBG.setIcon(img.getFunni(funniCount));
            }
            else if (funniCount == 4)
            {
                funniCount = 0;
                sceneBG.setIcon(img.returnImage(17));
            }

            System.out.println(funniCount);
        }
        switch(input)
        {
            case "Next":
                playSFX(1);
                nextDialogue();
                switch(dialogueNum)
                {
                    case 17:
                    harry.show();
                    harry.changeExpression(0);
                    break;

                    case 19:
                    sceneBG.setIcon(img.returnImage(15));
                    harry.hide();
                    break;

                    case 26:
                    sceneBG.setIcon(img.returnImage(14));
                    harry.show();
                    harry.changeExpression(10);
                    break;

                    case 29:
                    harry.changeExpression(7);
                    break;

                    case 30:
                    harry.changeExpression(6);
                    break;

                    case 32:
                    harry.changeExpression(7);
                    break;

                    case 33:
                    harry.hide();

                    case 35:
                    music.stop();
                    sceneBG.setIcon(img.returnImage(16));
                    break;

                    case 40:
                    playMusic(10);
                    break;

                    case 43:
                    sceneBG.setIcon(img.returnImage(17));
                    funni.setVisible(true);
                    break;

                    case 44:
                    music.stop();
                    ambiance.stop();
                        try {
                            s7.drawScene();
                        } catch (IOException e1) {

                        }
                    s7.knifeResult(knife);
                    break;

                }
                break;

            case "Back":
                playSFX(1);
                prevDialogue();
                break;

        }
    }

    public void nextDialogue()
    {
        if(dialogueNum<=d6.getDialogueLength())
        {
            dialogueNum++;
            UI.changeText(d6.getDialogueText(dialogueNum));
        }
    }

    public void prevDialogue()
    {
        if(0<dialogueNum)
        {
            dialogueNum--;
            UI.changeText(d6.getDialogueText(dialogueNum));
        }
    }

    public void drawScene()
    {
        setVisible(true);
        UI.drawDialogueBox();
        setStartDialogue();
        playAmb(8);
        playMusic(9);
    }

    public void knifeResult(int i)
    {
        knife = i;
    }

    public void setStartDialogue()
    {
        UI.changeText(d6.getDialogueText(0));
    }

    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void playAmb(int i)
    {
        ambiance.setFile(i);
        ambiance.play();
        ambiance.loop();
    }

    public void playSFX(int i)
    {
        sfx.setFile(i);
        sfx.play();
    }

    public void drawNB()
    {
        next.setVisible(true);
        back.setVisible(true);
    }


}