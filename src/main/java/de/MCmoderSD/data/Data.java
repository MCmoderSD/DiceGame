package de.MCmoderSD.data;

@SuppressWarnings("unused")
public class Data {
    private final byte[] dices;
    private byte counter;
    private int points;

    public Data() {
        dices = new byte[3];
        counter = 0;
        points = 0;
    }

    public void resetPoints() {
        points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public byte[] getDice() {
        return dices;
    }

    public void setDice(byte dice) {
        if (0 < dice && dice < 7) dices[counter++] = dice;
        if (counter == dices.length) counter = 0;
    }

    public byte getDice(int index) {
        return dices[index];
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}