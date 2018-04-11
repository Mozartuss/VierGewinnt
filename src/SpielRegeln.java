public class SpielRegeln {
    private int spielSteinZaehler;

    /**
     * Abrufen aller Spielregeln und bestimmung in welcher Zeile der Stein ist.
     *
     * @param spielFeld
     * @param position
     * @param spielStein
     */

    public static void SpielStatus(char[][] spielFeld, int position, char spielStein) {
        int spaltenPosition = 0;

        for (int i = 0; i < spielFeld.length; i++)
            if (spielFeld[i][position] != ' ') {
                spaltenPosition = i;
                break;
            }
        checkSpalte(spielFeld, position, spielStein, spaltenPosition);
        checkZeile(spielFeld, position, spielStein, spaltenPosition);
        checkDiagonaleAufwaerts(spielFeld, position, spielStein, spaltenPosition);
        checkDiagonaleAbwaerts(spielFeld, position, spielStein, spaltenPosition);

    }

    /**
     * Die Diagonale von links unten nach rechts oben wird betrachtet
     *
     * @param spielFeld
     * @param position
     * @param spielStein
     * @param spaltenPosition
     */

    public static void checkDiagonaleAufwaerts(char[][] spielFeld, int position, char spielStein, int spaltenPosition) {
        int spielSteinZaehler = 1;

        for (int i = spaltenPosition + 1, j = position - 1; i < spielFeld.length && j >= 0; i++, j--)
            if (spielStein == spielFeld[i][j])
                spielSteinZaehler++;
            else
                break;
        if (spielSteinZaehler >= 4) {
            System.err.println("Spieler " + spielStein + " gewinnt, wegen einer diagonalen Reihe ");
            System.exit(0);
        }
        for (int i = spaltenPosition - 1, j = position + 1; i >= 0 && j < spielFeld[0].length; i--, j++)
            if (spielStein == spielFeld[i][j])
                spielSteinZaehler++;
            else
                break;
        if (spielSteinZaehler >= 4) {
            System.err.println("Spieler " + spielStein + " gewinnt, wegen einer diagonalen Reihe ");
            System.exit(0);
        }
    }

    /**
     * Wenn eine Spalte 4 gleiche in einer reihe hat Gewinnt ein Spieler
     *
     * @param spielFeld
     * @param position
     * @param spielStein
     * @param spaltenPosition
     */

    public static void checkSpalte(char[][] spielFeld, int position, char spielStein, int spaltenPosition) {
        int spielSteinZaehler = 1;
        if (spaltenPosition + 4 <= spielFeld.length)
            for (int i = spaltenPosition + 1; i <= (spaltenPosition + 3); i++)
                if (spielStein == spielFeld[i][position])
                    spielSteinZaehler++;
                else
                    break;
        if (spielSteinZaehler == 4) {
            System.out.println("\033[33m" + "Der Spieler mit dem Spielstein: " + spielStein + "  hat gewonnen! Er hat 4 Spielsteine in einer Spalte");
            System.exit(0);
        }

    }

    /**
     * Es wird überprüft ob ein Gewinnervierling in der Zeile ist
     *
     * @param spielFeld
     * @param position
     * @param spielStein
     * @param spaltenPosition
     */

    public static void checkZeile(char[][] spielFeld, int position, char spielStein, int spaltenPosition) {
        int spielSteinZaehler = 1;

        for (int i = position + 1; i < spielFeld[0].length; i++)
            if (spielStein == spielFeld[spaltenPosition][i])
                spielSteinZaehler++;                                            //links
            else
                break;

        if (spielSteinZaehler >= 4) {
            System.err.println("\033[36m" + "Der Spieler mit dem Spielstein: " + spielStein + "  hat gewonnen! Wegen einer Viererreihe in einer Zeile");
            System.exit(0);
        }
        for (int i = position - 1; i >= 0; i--)
            if (spielStein == spielFeld[spaltenPosition][i])
                spielSteinZaehler++;                                            //rechts
            else
                break;

        if (spielSteinZaehler >= 4) {
            System.out.println("\033[36m" + "Der Spieler mit dem Spielstein: " + spielStein + "  hat gewonnen! Wegen einer Viererreihe in einer Zeile");
            System.exit(0);
        }
    }

    /**
     * Die Diagonale von links oben nach rechts unten wird betrachtet
     *
     * @param spielFeld
     * @param position
     * @param spielStein
     * @param spaltenPosition
     */
    public static void checkDiagonaleAbwaerts(char[][] spielFeld, int position, char spielStein, int spaltenPosition) {
        int spielSteinZaehler = 1;

        for (int i = spaltenPosition - 1, j = position - 1; i >= 0 && j >= 0; i--, j--)
            if (spielStein == spielFeld[i][j])
                spielSteinZaehler++;
            else
                break;
        if (spielSteinZaehler >= 4) {
            System.err.println("Spieler " + spielStein + " gewinnt, wegen einer diagonalen Reihe ");
            System.exit(0);
        }
        for (int i = spaltenPosition + 1, j = position + 1; i < spielFeld.length && j < spielFeld[0].length; i++, j++)
            if (spielStein == spielFeld[i][j])
                spielSteinZaehler++;
            else
                break;
        if (spielSteinZaehler >= 4) {
            System.err.println("Spieler " + spielStein + " gewinnt, wegen einer diagonalen Reihe ");
            System.exit(0);
        }
    }

    /**
     * Wenn die Zeile 0 keine Leerzeichen enthält ist unentschieden
     *
     * @param spielFeld
     * @return
     */

    public static boolean checkUnentschieden(char[][] spielFeld) {
        for (int i = 0; i < spielFeld[0].length; i++)
            if (spielFeld[0][i] == ' ')
                return false;
        return true;
    }
}

