import javax.swing.*;
import java.awt.*;

public class TextBox extends JTextField{
    TextBox(String title)
    {
        setText(title);
        setBackground(new Color(0,0,0,166));
        setForeground(Color.WHITE);
        setFocusable(false);
        setBounds(50, 50, 250, 60);
        setEditable(true);
    }
}
