import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends Frame {
    public static final String ERROR_MESSAGE = "Error, dividing by zero";
    public static final int BUTTON_HEIGHT = 50;
    public static final int BUTTON_WIDTH = 50;
    public static final int WIDTH = 240;
    public static final int EDGE_DISTANCE = 55;
    public static final int DISTANCE_BETWEEN_BUTTONS = 10;
    public static final int HEIGHT = 365;
    public static final int SUMMARY_WIDTH_DISTANCE_BETWEEN_BUTTONS = DISTANCE_BETWEEN_BUTTONS + BUTTON_WIDTH;
    public static final int SUMMARY_HEIGHT_DISTANCE_BETWEEN_BUTTONS = DISTANCE_BETWEEN_BUTTONS + BUTTON_HEIGHT;
    private static final Point CLEAR_BUTTON_LOCATION = new Point(125, 70);
    private static final Point LOCATION = new Point(200, 70);
    private static Window instance;
    private final Display display;

    public static Window getInstance() {
        if (Window.instance == null)
            instance = new Window();
        return instance;
    }

    private Window() {
        super("Calculator");
        setSize(WIDTH, HEIGHT);
        setLocation(LOCATION);
        setLayout(null);
        add(display = new Display());
        addAllButtons();
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void addAllButtons() {
        add(new ClearButton(
                BUTTON_WIDTH * 2 + DISTANCE_BETWEEN_BUTTONS,
                BUTTON_HEIGHT,
                CLEAR_BUTTON_LOCATION.x, CLEAR_BUTTON_LOCATION.y));

        for (int y = BUTTON_WIDTH * 2 + DISTANCE_BETWEEN_BUTTONS * 3, number = 1; number <= 9
                && y <= HEIGHT - EDGE_DISTANCE * 2; y += BUTTON_HEIGHT + DISTANCE_BETWEEN_BUTTONS) {
            for (int x = 5; x <= WIDTH - BUTTON_WIDTH - DISTANCE_BETWEEN_BUTTONS; x += BUTTON_WIDTH
                    + DISTANCE_BETWEEN_BUTTONS) {
                add(new DigitButton(x, y, number));
                ++number;
            }
        }
        add(new DigitButton(EDGE_DISTANCE + DISTANCE_BETWEEN_BUTTONS, HEIGHT - EDGE_DISTANCE, 0));
        add(new SignButton(WIDTH - EDGE_DISTANCE,
                HEIGHT - EDGE_DISTANCE - SUMMARY_HEIGHT_DISTANCE_BETWEEN_BUTTONS, Sign.MINUS));
        add(new SignButton(WIDTH - EDGE_DISTANCE,
                HEIGHT - EDGE_DISTANCE - SUMMARY_HEIGHT_DISTANCE_BETWEEN_BUTTONS * 2, Sign.PLUS));
        add(new CalculateButton(WIDTH - EDGE_DISTANCE,
                HEIGHT - EDGE_DISTANCE - SUMMARY_HEIGHT_DISTANCE_BETWEEN_BUTTONS * 3));
        add(new SignButton(5 + SUMMARY_WIDTH_DISTANCE_BETWEEN_BUTTONS * 2, HEIGHT - EDGE_DISTANCE, Sign.DIVIDE));
        add(new SignButton(5 + SUMMARY_WIDTH_DISTANCE_BETWEEN_BUTTONS * 3, HEIGHT - EDGE_DISTANCE, Sign.MULTIPLY));
    }

    public Display getDisplay() {
        return display;
    }
}
