import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private final JLabel pointsLabel;
    private final DicePanel[] dicePanel;

    public GUI(Controller controller) {
        super("Dice Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3));
        setResizable(false);

        dicePanel = new DicePanel[3];
        Font font = new Font("Roboto", Font.PLAIN, 18);
        JPanel[] emptyPanel = new JPanel[2];

        for (int i = 0; i < emptyPanel.length; i++) {
            emptyPanel[i] = new JPanel();
            emptyPanel[i].setLayout(null);
            emptyPanel[i].setPreferredSize(new Dimension(200, 200));
        }


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(null);
        controlPanel.setPreferredSize(new Dimension(200, 200));
        add(emptyPanel[0]);
        add(controlPanel);
        add(emptyPanel[1]);
        pack();

        for (int i = 0; i < dicePanel.length; i++) {
            dicePanel[i] = new DicePanel();
            dicePanel[i].setConfiguration(controlPanel.getWidth(), controlPanel.getHeight());
            add(dicePanel[i]);
        }

        pack();

        pointsLabel = new JLabel("Points: 0");
        pointsLabel.setSize(100, Math.toIntExact(Math.round(controlPanel.getHeight() * 0.25)));
        pointsLabel.setLocation(Math.toIntExact(Math.round((controlPanel.getWidth() - pointsLabel.getWidth()) * 0.5)),
                Math.toIntExact(Math.round((controlPanel.getHeight() - pointsLabel.getHeight()) * 0.75)));
        pointsLabel.setFont(font);
        controlPanel.add(pointsLabel);

        JButton rollButton = new JButton("Roll");
        rollButton.setSize(100, Math.toIntExact(Math.round(controlPanel.getHeight() * 0.25)));
        rollButton.setLocation(Math.toIntExact(Math.round((controlPanel.getWidth() - rollButton.getWidth()) * 0.5)),
                Math.toIntExact(Math.round((controlPanel.getHeight() - rollButton.getHeight()) * 0.25)));
        rollButton.setFont(font);
        rollButton.addActionListener(e -> controller.rollButton());
        controlPanel.add(rollButton);

        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(Math.toIntExact(Math.round((screenSize.width - getWidth()) * 0.5)), Math.toIntExact(Math.round((screenSize.height - getHeight()) * 0.5)));
        setVisible(true);
    }

    public void setPoints(int points) {
        pointsLabel.setText("Points: " + points);
    }

    public void updateDicePanels(Data data) {
        for (int i = 0; i < data.getDice().length; i++) dicePanel[i].diceRolled(data.getDice(i));
    }

}
