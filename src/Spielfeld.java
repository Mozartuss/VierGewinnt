public class Spielfeld {
    /**
     * Spielfeldmaske um zwischen den Klammern leerzeichen zu lassen
     *
     * @param spielFeld
     */
    public static void spielfeldLeer(char[][] spielFeld) {
        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++)
                spielFeld[i][j] = ' ';
        }
    }

    /**
     * Das Spielfeld (größe wird in der Run Klasse bestimmt)
     * Fehler wenn eine andere Größe eingegeben wird stimmt die Beschriftung des Feldes nicht mehr
     *
     * @param spielFeld
     */
    public static void spielfeld(char[][] spielFeld) {
        System.out.print(" ");
        for (int i = 0; i <= spielFeld.length; i++) {
            System.out.print(i + 1 + "  ");
        }
        System.out.println();

        for (int i = 0; i < spielFeld.length; i++) {
            for (int j = 0; j < spielFeld[i].length; j++)
                System.out.print(("[") + (spielFeld[i][j]) + ("]"));
            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i <= spielFeld.length; i++) {
            System.out.print(i + 1 + "  ");
        }
        System.out.println();
    }
}

