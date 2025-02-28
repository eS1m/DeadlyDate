import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Scene5 extends JLayeredPane implements ActionListener{
    CCDDSoundPlayer music = new CCDDSoundPlayer();
    CCDDSoundPlayer sfx = new CCDDSoundPlayer();

    dialogues5 dialogues = new dialogues5();

    CCDDUI UI = new CCDDUI();

    NBButtons next, back;
    JLabel sceneBG;

    int knife = 0;
    int dialogueNum = 0;

    bgImages img = new bgImages();

    HarrisonChar harry = new HarrisonChar();

    Scene6 s6 = new Scene6();

    Scene5() throws IOException
    {
        setLayout(null);
        setBounds(0,0,1280,720);
        setVisible(false);

        sceneBG = new JLabel(img.returnImage(8));
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

        UI.setVisible(true);

        drawNB();

        add(s6, Integer.valueOf(10));
        s6.setVisible(false);

    }

    public void actionPerformed(ActionEvent e)
    {
        String input = e.getActionCommand();
        switch (input)
        {
            case "Next":
                nextDialogue();
                playSFX(1);

                switch(dialogueNum)
                {
                    case 8:
                        harry.show();
                        break;

                    case 14:
                        harry.hide();
                        break;

                    case 19:
                        stopMusic();
                        playMusic(7);
                        break;

                    case 24:
                        sceneBG.setIcon(img.returnImage(13));
                        break;

                    case 26:
                        sceneBG.setIcon(img.returnImage(8));
                        break;

                    case 28:
                        harry.show();
                        break;

                    case 34:
                        stopMusic();
                        s6.setVisible(true);
                        s6.drawScene();
                        s6.knifeResult(knife);
                        break;
                }
                break;

            case "Back":
                playSFX(1);
                prevDialogue();
                break;

        }
    }

    public void drawScene()
    {
        setVisible(true);
        UI.drawDialogueBox();
        setStartDialogue();
        playMusic(5);
    }

    public void setStartDialogue()
    {
        UI.changeText(dialogues.getDialogueText(0));
    }

    public void removeScene()
    {
        setVisible(false);
    }

    public void knifeResult (int input)
    {
        knife = input;
    }

    public void drawNB()
    {
        next.setVisible(true);
        back.setVisible(true);

    }

    public void decisionTree()
    {
        next.setVisible(false);
        back.setVisible(false);
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

    public void stopMusic()
    {
        music.stop();
    }

    public void nextDialogue()
    {
        if(dialogueNum<=dialogues.getDialogueLength())
        {
            dialogueNum+=1;
            System.out.println(dialogueNum);
            UI.changeText(dialogues.getDialogueText(dialogueNum));
        }
    }

    public void prevDialogue()
    {
        if(0<dialogueNum)
        {
            dialogueNum--;
            UI.changeText(dialogues.getDialogueText(dialogueNum));
        }
    }
}


