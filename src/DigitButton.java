import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DigitButton extends Button implements ActionListener {
    public DigitButton(int x, int y, int number) {
        super(String.valueOf(number));
        setSize(Window.BUTTON_WIDTH, Window.BUTTON_HEIGHT);
        setLocation(x, y);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Display display = Window.getInstance().getDisplay();
        if (Objects.equals(display.getText(), "0") || display.getText().equals(Window.ERROR_MESSAGE)) {
            display.setText(this.getLabel());
        } else {
            display.setText(display.getText() + this.getLabel());
        }
        display.allText += this.getLabel();
    }
}
