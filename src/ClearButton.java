import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends Button implements ActionListener {
    public ClearButton(int width, int height, int locationX, int locationY) {
        super("C");
        setSize(width, height);
        setLocation(locationX, locationY);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.getInstance().getDisplay().setText("0");
        Window.getInstance().getDisplay().allText = "0";
    }
}
