package de.MCmoderSD.core;

import de.MCmoderSD.UI.GUI;
import de.MCmoderSD.data.Data;

public class Controller {
    private final Data data;
    private final GUI gui;

    public Controller() {
        gui = new GUI(this);
        data = new Data();
    }

    public void rollButton() {
        for (int i = 0; i < data.getDice().length; i++) data.setDice((byte) (Math.random() * 6 + 1));

        boolean isSame = true;

        for (int i = 0; i < data.getDice().length - 1; i++) {
            if (data.getDice(i) != data.getDice(i + 1)) {
                isSame = false;
                break;
            }
        }

        boolean isConsecutive = true;

        for (int i = 0; i < data.getDice().length - 1; i++) {
            if (data.getDice(i) + 1 != data.getDice(i + 1)) {
                isConsecutive = false;
                break;
            }
        }

        if (isSame) data.addPoints(100);
        if (isConsecutive) data.addPoints(100);

        gui.updateDicePanels(data);
        gui.setPoints(data.getPoints());
    }
}
