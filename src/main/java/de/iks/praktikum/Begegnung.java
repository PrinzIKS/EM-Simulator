package de.iks.praktikum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Begegnung {

    public Begegnung(Mannschaft mannschaft1, Mannschaft mannschaft2) {
        this.mannschaft1 = mannschaft1;
        this.mannschaft2 = mannschaft2;
    }

    private Mannschaft mannschaft1;
    private Mannschaft mannschaft2;
    private Spielstand regulaer = new Spielstand();
    private Spielstand nachspielzeit = new Spielstand();
    private Spielstand elfmeter = new Spielstand();
    private Mannschaft sieger;
    private Mannschaft verlierer;

    public void ermittleSpielstand() {
        regulaer.setToreMannschaft1(randomTore());
        regulaer.setToreMannschaft2(randomTore());
        if (regulaer.getToreMannschaft1() == regulaer.getToreMannschaft2()) {
            nachspielzeit.setToreMannschaft1(randomTore());
            nachspielzeit.setToreMannschaft2(randomTore());
            if (nachspielzeit.getToreMannschaft1() == nachspielzeit.getToreMannschaft2()) {
                do {
                    elfmeter.setToreMannschaft1(randomTore());
                    elfmeter.setToreMannschaft2(randomTore());
                } while (elfmeter.getToreMannschaft1() == elfmeter.getToreMannschaft2());
                sieger = elfmeter.getToreMannschaft1() > elfmeter.getToreMannschaft2() ? mannschaft1 : mannschaft2;
                verlierer = elfmeter.getToreMannschaft1() < elfmeter.getToreMannschaft2() ? mannschaft1 : mannschaft2;
            } else {
                sieger = nachspielzeit.getToreMannschaft1() > nachspielzeit.getToreMannschaft2() ? mannschaft1 : mannschaft2;
                verlierer = nachspielzeit.getToreMannschaft1() < nachspielzeit.getToreMannschaft2() ? mannschaft1 : mannschaft2;
            }
        } else {
            sieger = regulaer.getToreMannschaft1() > regulaer.getToreMannschaft2() ? mannschaft1 : mannschaft2;
            verlierer = regulaer.getToreMannschaft1() < regulaer.getToreMannschaft2() ? mannschaft1 : mannschaft2;
        }
    }

    private int randomTore() {
        int[] percentages = {25, 20, 15, 12, 10, 8, 5, 2, 1, 1, 1};
        double random = Math.random() * 100;
        double percentage = 0.0;
        for (int i = 0; i < percentages.length; i++) {
            percentage = percentage + percentages[i];
            if (random < percentage) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String a = mannschaft1.getName() + " vs " + mannschaft2.getName() + ":    ";

        if (regulaer.getToreMannschaft1() == regulaer.getToreMannschaft2()) {
            if (nachspielzeit.getToreMannschaft1() == nachspielzeit.getToreMannschaft2()) {
                a = a + (regulaer.getToreMannschaft1() + nachspielzeit.getToreMannschaft1() + elfmeter.getToreMannschaft1()) + ":" + (regulaer.getToreMannschaft2() + nachspielzeit.getToreMannschaft2() + elfmeter.getToreMannschaft2()) +
                        " (" + (regulaer.getToreMannschaft1() + nachspielzeit.getToreMannschaft1()) + ":" + (regulaer.getToreMannschaft2() + nachspielzeit.getToreMannschaft2()) + ")" +
                        " (" + regulaer.getToreMannschaft1() + ":" + regulaer.getToreMannschaft2() + ")";
            } else {
                a = a + (regulaer.getToreMannschaft1() + nachspielzeit.getToreMannschaft1()) + ":" + (regulaer.getToreMannschaft2() + nachspielzeit.getToreMannschaft2()) +
                        " (" + regulaer.getToreMannschaft1() + ":" + regulaer.getToreMannschaft2() + ")";
            }
        } else {
            a = a + regulaer.getToreMannschaft1() + ":" + regulaer.getToreMannschaft2();
        }
        return a;
    }
}
