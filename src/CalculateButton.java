import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateButton extends Button implements ActionListener {
    public CalculateButton(int x, int y) {
        super("=");
        setSize(Window.BUTTON_WIDTH, Window.BUTTON_HEIGHT);
        setLocation(x, y);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String allText = Window.getInstance().getDisplay().allText;
        allText = doSum(allText.split("[0123456789]+"),
                allText.split("[*+/-]"));
        Window.getInstance().getDisplay().setText(allText);
        if (allText.equals(Window.ERROR_MESSAGE)) {
            allText = "0";
        }
        Window.getInstance().getDisplay().allText = allText;
    }

    private String doSum(String[] chars, String[] nums) {
        long result = Integer.parseInt(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            int num = Integer.parseInt(nums[i]);
            char firstChar = chars[i].charAt(0);
            if (firstChar == Sign.PLUS.getSign()) {
                result += num;
            } else if (firstChar == Sign.MINUS.getSign()) {
                result -= num;
            } else if (firstChar == Sign.DIVIDE.getSign()) {
                if (num == 0)
                    return Window.ERROR_MESSAGE;
                result /= num;
            } else if (firstChar == Sign.MULTIPLY.getSign()) {
                result *= num;
            }
        }
        return Long.toString(result);
    }
}
