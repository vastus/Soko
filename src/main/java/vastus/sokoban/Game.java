package vastus.sokoban;

import java.io.File;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import vastus.sokoban.logic.Level;
import vastus.sokoban.logic.Movable;
import vastus.sokoban.utils.Helpers;

public class Game extends StateBasedGame {

    public Game() {
        super("Soko");
    }

    public static void main(String[] args) throws Exception {
        AppGameContainer game = new AppGameContainer(new Game(), 800, 600, false);
        game.setTargetFrameRate(60);
        game.setShowFPS(false);
        game.start();

        /*
        Level level = Level.build("@O+");
        Movable player = level.getPlayer();
        List<Movable> boxes = new ArrayList<>(level.getMovables());
        System.out.println(boxes);
        boxes.remove(player);
        System.out.println(boxes);
        */

        /*
        File lvlFile = new File("src/main/resources/levels/1.lvl");
        String lvlString = Helpers.readFileToString(lvlFile);
        //Level level = Level.build("@X..+\n#.#.O\n#....");
        Level level = Level.build(lvlString);
        Movable player = level.getPlayer();

        System.out.print(level);
        System.out.println("========");
        
        right(player, level);
        up(player, level);
        right(player, level);
        down(player, level);
        right(player, level);
        down(player, level);
        down(player, level);
        down(player, level);
        down(player, level);
        left(player, level);
        down(player, level);
        left(player, level);
        down(player, level);
        left(player, level);
        left(player, level);
        up(player, level);
        up(player, level);
        */
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new GamePlay(GameStates.PLAY));
        this.addState(new GameMenu(GameStates.MENU));
    }

    private static void up(Movable player, Level level) {
        player.moveUp(level);
        System.out.print(level);
        System.out.println("========");
    }

    private static void right(Movable player, Level level) {
        player.moveRight(level);
        System.out.print(level);
        System.out.println("========");
    }

    private static void down(Movable player, Level level) {
        player.moveDown(level);
        System.out.print(level);
        System.out.println("========");
    }

    private static void left(Movable player, Level level) {
        player.moveLeft(level);
        System.out.print(level);
        System.out.println("========");
    }

}
