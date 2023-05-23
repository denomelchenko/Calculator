import java.awt.*;

public class Display extends TextField {
    public String allText;
    private static final int HEIGHT = 30;
    private static final int WIDTH_DIFFERENCE = 10;
    private static final int Y_LOCATION = 30;
    private static final int X_LOCATION = WIDTH_DIFFERENCE / 2;

    public Display() {
        super("0");
        allText = getText();
        setSize(Window.WIDTH - WIDTH_DIFFERENCE, HEIGHT);
        setLocation(X_LOCATION, Y_LOCATION);
        this.setEditable(false);
    }
}
