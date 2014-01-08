package vastus.sokoban;

import vastus.sokoban.logic.Level;
import vastus.sokoban.logic.Movable;
import vastus.sokoban.logic.Point;

import org.newdawn.slick.*;

public class Game extends BasicGame {

    public Game() {
        super("Soko");
    }

    public static void main(String[] args) throws Exception {
        /*
        Level level = Level.buildAry("@.O.+..");
        Movable player = level.getPlr();
        Movable box = level.getMovable(new Point(2, 0));

        System.out.println(level);
        System.out.println("P: " + player.getPosition());
        System.out.println("B: " + box.getPosition());
        System.out.println("----------------------\n");

        moveRight(player, box, level);
        moveRight(player, box, level);

        moveLeft(player, box, level);

        moveRight(player, box, level);
        moveRight(player, box, level);

        moveLeft(player, box, level);
        moveLeft(player, box, level);
        moveLeft(player, box, level);
        moveLeft(player, box, level);
        moveLeft(player, box, level);
        moveLeft(player, box, level);
        */

        AppGameContainer container = new AppGameContainer(new Game(), 800, 600, false);
        container.start();
    }


    @Override
    public void init(GameContainer gc) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
    }

    private static void moveLeft(Movable player, Movable box, Level level) {
        System.out.println("Move left");
        player.moveLeft(level);
        System.out.println(level);
        System.out.println("P: " + player.getPosition());
        System.out.println("B: " + box.getPosition());
        System.out.println("----------------------\n");
    }

    private static void moveRight(Movable player, Movable box, Level level) {
        System.out.println("Move right");
        player.moveRight(level);
        System.out.println(level);
        System.out.println("P: " + player.getPosition());
        System.out.println("B: " + box.getPosition());
        System.out.println("----------------------\n");
    }

}
