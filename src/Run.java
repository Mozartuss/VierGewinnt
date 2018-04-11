public class Run {
    /**
     * Ausführen des Programms und Bestimmung der größe des Spielfelds
     * Achtung größen Änderung funktioniert nicht zu 100%
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        char[][] spielFeld = new char[6][7];

        Spielfeld.spielfeldLeer(spielFeld);
        Spielfeld.spielfeld(spielFeld);
        SpielAnweisung.spielanweisung(spielFeld);
    }
}
