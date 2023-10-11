import java.util.Random;

public class Controller {
    private final Data data;
    private final GUI gui;
    public Controller() {
        gui = new GUI(this);
        data = new Data();
    }

    private byte randomByte() {
        Random random = new Random();
        return (byte) (random.nextInt(6) + 1);
    }

    public void rollButton() {
        for (int i = 0; i < data.getDice().length; i++) data.setDice(randomByte());

        boolean isSame = true;

        for (int i = 0; i < data.getDice().length - 1; i++) {
            if (data.getDice(i) != data.getDice(i + 1)) {
                isSame = false;
                break;
            }
        }

        boolean isConsecutive = true;

        for (int i = 0; i < data.getDice().length; i++) {
            if (data.getDice(i) != i + 1) {
                isConsecutive = false;
                break;
            }
        }

        if (isSame) data.addPoints(100);
        else if (isConsecutive) data.addPoints(100);

        gui.updateDicePanels(data);
        gui.setPoints(data.getPoints());

        // Debug
        System.out.println(data.getDice(0) + " " + data.getDice(1) + " " + data.getDice(2));

        if (isSame) gui.showMessage("You got doublets!", "Congrats!");
        else if (isConsecutive) gui.showMessage("You got 1-2-3", "Congrats!");
    }
}
