import javax.swing.*;
import java.awt.*;

public class DecisionBox extends JButton{
    DecisionBox(String title)
    {
        setText(title);
        setBackground(new Color(0,0,0,166));
        setForeground(Color.WHITE);
        setBorderPainted(true);
        setFocusable(false);
        setRolloverEnabled(false);
    }

    public void changeTitle(String input)
    {
        setText(input);
    }
}
