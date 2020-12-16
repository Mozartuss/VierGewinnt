public class SpielAnweisung {

    /**
     * Die Eingabe wird verarbeitet und an die Klasse Spielfeld weitergegeben
     * Wichtig! Enterpuffer oder einen Scanner verwenden
     * Fehler überprüfung (keine Zahl zwischen 1 und 7 & ob die Spalte voll ist)
     * Spieler == true --> X
     * Spieler == false --> O
     * Test
     *
     * @param spielFeld
     * @throws Exception
     */
    public static void spielanweisung(char[][] spielFeld) throws Exception {
        boolean gameOver = false, spieler = true;
        int position;
        char spielStein;

        while (!gameOver) {
            if (spieler) {
                System.out.println("Spieler 1 wählen sie eine Spalte (1-7):");
                position = System.in.read() - 49;
                int pufferEnter = System.in.read();
                spielStein = 'X';

                //Eingabeüberprüfung
                if (position < 0 || position > 6) {
                    System.err.println("Ungültige Eingabe! Es sind nur zahlen zwischen 1 und 7 erlaubt!");
                    continue;
                }

                if (chipVerlauf(spielFeld, position, spielStein)) {
                    Spielfeld.spielfeld(spielFeld);
                    spieler = !spieler;
                } else
                    System.err.println("Spalte Voll!! Bitte wählen sie eine andere Spalte!");
            } else {
                System.out.println("Spieler 2 wählen sie eine Spalte (1-7):");
                position = System.in.read() - 49;
                int pufferEnter2 = System.in.read();
                spielStein = 'O';

                //Eingabeüberprüfung
                if (position < 0 || position > 6) {
                    System.err.println("Ungültige Eingabe! Es sind nur zahlen zwischen 1 und 7 erlaubt!");
                    continue;
                }

                if (chipVerlauf(spielFeld, position, spielStein)) {
                    Spielfeld.spielfeld(spielFeld);
                    spieler = !spieler;
                } else
                    System.err.println("Spalte Voll!! Bitte wählen sie eine andere Spalte!");
            }
            SpielRegeln.SpielStatus(spielFeld, position, spielStein);
            if (SpielRegeln.checkUnentschieden(spielFeld)) {
                gameOver = true;
                System.out.println("Unentschieden! Bitte Starten sie das Spiel neu!");
            }


        }

    }

    /**
     * Ersetzen der Leerzeichenmaske vom Spielfeld
     * @param spielFeld
     * @param position
     * @param setzen
     * @return
     */
    public static boolean chipVerlauf(char[][] spielFeld, int position, char setzen) {
        for (int i = spielFeld.length - 1; i >= 0; i--) {
            if (spielFeld[i][position] == ' ') {
                spielFeld[i][position] = setzen;
                return true;
            }
        }
        return false;
    }

}
