import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class SignButton extends Button implements ActionListener {
    private final static Set<Character> signs;

    static {
        signs = new HashSet<>();
        signs.add(Signs.DIVIDE.getSign());
        signs.add(Signs.MINUS.getSign());
        signs.add(Signs.PLUS.getSign());
        signs.add(Signs.MULTIPLY.getSign());
    }

    public SignButton(int x, int y, Signs sign) throws IllegalArgumentException {
        super(sign.toString());
        if (!signs.contains(sign.getSign())) {
            throw new IllegalArgumentException();
        }
        setSize(Window.BUTTON_WIDTH, Window.BUTTON_HEIGHT);
        setLocation(x, y);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String allText = Window.getInstance().getDisplay().allText;
        char lastChar = allText.charAt(allText.length() - 1);
        if (!signs.contains(lastChar)) {
            Window.getInstance().getDisplay().setText("");
            Window.getInstance().getDisplay().allText += this.getLabel();
        }
    }
}
