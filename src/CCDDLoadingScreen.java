import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class CCDDLoadingScreen extends JPanel
{
    int sec = 7;
    int waitTime = 7;

    JLabel loadingText;

    CCDDLoadingScreen()
    {
        setLayout(null);
        setBackground(Color.black);
        setBounds(0,0, 1280, 720);

        loadingText = new JLabel("LOADING");
        loadingText.setBounds(35,610, 300, 50);
        loadingText.setForeground(Color.white);
        add(loadingText);

        loadingText.setVisible(true);

        setVisible(false);
    }

    public void loadingFont(Font i)
    {
        loadingText.setFont(i);
    }

    public void drawLoadingScreen()
    {
        setVisible(true);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() 
        {
            @Override
            public void run()
            {
                if(sec!=0)
                {
                    sec--;

                    loadingText.setText(loadingText.getText()+".");

                    if (loadingText.getText().equals("LOADING...."))
                    {
                        loadingText.setText("LOADING");
                    }
                    else
                    {

                    }
                }
                else
                {
                    setVisible(false);
                    timer.cancel();
                }

                System.out.println(sec);
            }
        };

        timer.schedule(task, 0, 1000);
    }
    
}