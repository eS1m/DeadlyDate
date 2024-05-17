import javax.swing.*;
import java.awt.*;

public class NBButtons extends JButton{
    NBButtons(String title)
    {
        setText(title);
        setVisible(true);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
    }
}
