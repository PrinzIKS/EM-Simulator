package de.iks.praktikum;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mit dabei sind:");

        Mannschaft[] mannschaften = {
                new Mannschaft("Deutschland"),
                new Mannschaft("Spanien"),
                new Mannschaft("Italien"),
                new Mannschaft("Türkei"),
                new Mannschaft("Albanien"),
                new Mannschaft("Österreich"),
                new Mannschaft("Polen"),
                new Mannschaft("Niederlande"),
                new Mannschaft("Portugal"),
                new Mannschaft("Dänemark"),
                new Mannschaft("England"),
                new Mannschaft("Schottland"),
                new Mannschaft("Schweiz"),
                new Mannschaft("Kroatien"),
                new Mannschaft("Ukraine"),
                new Mannschaft("Tschechien"),
        };

        for (int i = 0; i < mannschaften.length; i++) {
            System.out.println(mannschaften[i].getName());
        }
        System.out.println();

        int i = 0;
        Begegnung[] achtelFinale = {
                new Begegnung(mannschaften[i++], mannschaften[i++]),
                new Begegnung(mannschaften[i++], mannschaften[i++]),
                new Begegnung(mannschaften[i++], mannschaften[i++]),
                new Begegnung(mannschaften[i++], mannschaften[i++]),
                new Begegnung(mannschaften[i++], mannschaften[i++]),
                new Begegnung(mannschaften[i++], mannschaften[i++]),
                new Begegnung(mannschaften[i++], mannschaften[i++]),
                new Begegnung(mannschaften[i++], mannschaften[i++])
        };
        for (int j = 0; j < achtelFinale.length; j++) {
            achtelFinale[j].ermittleSpielstand();
            System.out.println("AchtelFinale " + (j + 1) + ":\n" + achtelFinale[j]);
        }
        System.out.println();

        Begegnung[] viertelFinale = {
                new Begegnung(achtelFinale[0].getSieger(), achtelFinale[1].getSieger()),
                new Begegnung(achtelFinale[2].getSieger(), achtelFinale[3].getSieger()),
                new Begegnung(achtelFinale[4].getSieger(), achtelFinale[5].getSieger()),
                new Begegnung(achtelFinale[6].getSieger(), achtelFinale[7].getSieger())
        };
        for (int j = 0; j < viertelFinale.length; j++) {
            viertelFinale[j].ermittleSpielstand();
            System.out.println("ViertelFinale " + (j + 1) + ":\n" + viertelFinale[j]);
        }
        System.out.println();

        Begegnung[] halbFinale = {
                new Begegnung(viertelFinale[0].getSieger(), viertelFinale[1].getSieger()),
                new Begegnung(viertelFinale[2].getSieger(), viertelFinale[3].getSieger())
        };
        for (int j = 0; j < halbFinale.length; j++) {
            halbFinale[j].ermittleSpielstand();
            System.out.println("Halbfinale " + (j + 1) + ":\n" + halbFinale[j]);
        }
        System.out.println();

        Begegnung platz3 = new Begegnung(halbFinale[0].getVerlierer(), halbFinale[1].getVerlierer());
        platz3.ermittleSpielstand();
        System.out.println("Spiel um Platz 3\n" + platz3);
        System.out.println();

        Begegnung finale = new Begegnung(halbFinale[0].getSieger(), halbFinale[1].getSieger());
        finale.ermittleSpielstand();
        System.out.println("Finale\n" + finale);
        System.out.println();

        System.out.println("Sieger: " + finale.getSieger().getName());
        System.out.println("Zweiter: " + finale.getVerlierer().getName());
        System.out.println("Dritter: " + platz3.getSieger().getName());
    }
}
