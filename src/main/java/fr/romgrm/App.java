package fr.romgrm;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Game game = new Game();
        
        game.startGame();
        game.tirageDuMot();
        game.cacherMot();
        game.randomMotFixe();
        game.entrerUneLettre();
        game.remplacerLettre();
        game.replay();
        //game.finish();
        game.victory();
    }
}
