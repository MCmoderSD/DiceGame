import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {

    // Hardcoded 2D array as default
    private final Boolean[][] none = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
    };

    // Hardcoded 2D array for one
    private final Boolean[][] one = {
            {false, false, false},
            {false, true, false},
            {false, false, false}
    };

    // Hardcoded 2D array for two
    private final Boolean[][] two = {
            {false, false, true},
            {false, false, false},
            {true, false, false}
    };

    // Hardcoded 2D array for three
    private final Boolean[][] three = {
            {false, false, true},
            {false, true, false},
            {true, false, false}
    };

    // Hardcoded 2D array for four
    private final Boolean[][] four = {
            {true, false, true},
            {false, false, false},
            {true, false, true}
    };

    // Hardcoded 2D array for five
    private final Boolean[][] five = {
            {true, false, true},
            {false, true, false},
            {true, false, true}
    };

    // Hardcoded 2D array for six
    private final Boolean[][] six = {
            {true, false, true},
            {true, false, true},
            {true, false, true}
    };
    private boolean isConfigured = false;
    private int radius;
    private int margin;
    private int size;
    private int offsetX, offsetY;
    private Boolean[][] diceArray;

    public DicePanel() {
        super();
        diceArray = six;
    }

    public void setConfiguration(int parentWidth, int parentHeight) {
        int windowSize = Math.min(parentWidth, parentHeight);

        offsetX = (parentWidth - windowSize) / 2;
        offsetY = (parentHeight - windowSize) / 2;

        radius = Math.toIntExact(Math.round(windowSize * 0.2));
        margin = Math.toIntExact(Math.round(windowSize * 0.1));
        size = radius + margin;

        isConfigured = true;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());


        // Left Row
        if (diceArray[0][0])
            g.fillOval(offsetX + margin, offsetY + margin, radius, radius); // Top
        if (diceArray[1][0])
            g.fillOval(offsetX + margin, offsetY + size + margin, radius, radius); // Middle
        if (diceArray[2][0])
            g.fillOval(offsetX + margin, offsetY + 2 * size + margin, radius, radius); // Bottom

        // Middle Row
        if (diceArray[0][1])
            g.fillOval(offsetX + size + margin, offsetY + margin, radius, radius); // Top
        if (diceArray[1][1])
            g.fillOval(offsetX + size + margin, offsetY + size + margin, radius, radius); // Middle
        if (diceArray[2][1])
            g.fillOval(offsetX + size + margin, offsetY + 2 * size + margin, radius, radius); // Bottom

        // Right Row
        if (diceArray[0][2])
            g.fillOval(offsetX + 2 * size + margin, offsetY + margin, radius, radius); // Top
        if (diceArray[1][2])
            g.fillOval(offsetX + 2 * size + margin, offsetY + size + margin, radius, radius); // Middle
        if (diceArray[2][2])
            g.fillOval(offsetX + 2 * size + margin, offsetY + 2 * size + margin, radius, radius); // Bottom
    }

    public void diceRolled(byte dice) {
        if (!isConfigured) throw new IllegalStateException("DicePanel is not configured");
        else switch (dice) {
            case 1 : diceArray = one; break;
            case 2 : diceArray = two; break;
            case 3 : diceArray = three; break;
            case 4 : diceArray = four; break;
            case 5 : diceArray = five; break;
            case 6 : diceArray = six; break;
            default: diceArray = none; break;
        }
        repaint();
    }
}