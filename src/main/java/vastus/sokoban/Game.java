package vastus.sokoban;

import vastus.sokoban.logic.Level;
import vastus.sokoban.logic.Movable;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

    public Game() {
        super("Soko");
    }

    public static void main(String[] args) throws Exception {
        //AppGameContainer container = new AppGameContainer(new Game(), 800, 600, false);
        //container.start();
        Level level = Level.build("@X..+\n#.#.O\n#....");
        Movable player = level.getPlayer();

        System.out.print(level);
        System.out.println("========");

        player.moveRight(level);
        System.out.print(level);
        System.out.println("========");

        player.moveDown(level);
        System.out.print(level);
        System.out.println("========");

        player.moveDown(level);
        System.out.print(level);
        System.out.println("========");

        player.moveRight(level);
        System.out.print(level);
        System.out.println("========");

        player.moveRight(level);
        System.out.print(level);
        System.out.println("========");

        player.moveRight(level);
        System.out.print(level);
        System.out.println("========");

        player.moveUp(level);
        System.out.print(level);
        System.out.println("========");

        player.moveLeft(level);
        System.out.print(level);
        System.out.println("========");

        player.moveUp(level);
        System.out.print(level);
        System.out.println("========");

        player.moveLeft(level);
        System.out.print(level);
        System.out.println("========");

        System.out.println("LEVEL COMPLETED!");
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new GamePlay(GameStates.PLAY));
        this.addState(new GameMenu(GameStates.MENU));
    }

}
