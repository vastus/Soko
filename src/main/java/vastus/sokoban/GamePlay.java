package vastus.sokoban;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import vastus.sokoban.logic.Element;
import vastus.sokoban.logic.Level;
import vastus.sokoban.logic.Movable;
import vastus.sokoban.logic.Player;
import vastus.sokoban.utils.Helpers;

public class GamePlay extends BasicGameState {

    private int moves;
    private GameStates state;
    private Level level;
    private Player player;

    public GamePlay(GameStates state) {
        this.state = state;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        File lvlFile = new File("src/main/resources/levels/1.lvl");
        try {
            String lvlString = Helpers.readFileToString(lvlFile);
            this.level = Level.build(lvlString);
            this.player = level.getPlayer();
            this.moves = 0;
        } catch (Exception ex) {
            Logger.getLogger(GamePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        drawElements(g, level.getElements());
        drawMovables(g, level.getMovables());
        drawMoves(g);
        checkLevelIsComplete(g);
    }

    @Override
    public void keyPressed(int key, char code) {
        switch (key) {
            case Input.KEY_UP:
                move("up");
                break;
            case Input.KEY_RIGHT:
                move("right");
                break;
            case Input.KEY_DOWN:
                move("down");
                break;
            case Input.KEY_LEFT:
                move("left");
                break;
        }
    }

    @Override
    public int getID() {
        return state.ordinal();
    }

    private void drawElements(Graphics g, List<Element> elements) {
        for (Element element : elements) {
            element.draw(g);
        }
    }

    private void drawMovables(Graphics g, List<Movable> movables) {
        for (Movable movable : movables) {
            movable.draw(g);
        }
    }

    private void move(String direction) {
        switch (direction) {
            case "up":
                if (player.moveUp(level)) moves++;
                break;
            case "right":
                if (player.moveRight(level)) moves++;
                break;
            case "down":
                if (player.moveDown(level)) moves++;
                break;
            case "left":
                if (player.moveLeft(level)) moves++;
                break;
        }
    }

    private void drawMoves(Graphics g) {
        g.setColor(new Color(220, 220, 220));
        g.drawString(String.format("Moves: %d", moves), 290, 8);
    }

    private void finished(Graphics g) {
        g.setColor(new Color(220, 220, 220));
        g.drawString("Level completed!", 290, 40);
    }

    private void checkLevelIsComplete(Graphics g) {
        try {
            if (level.isCompleted()) {
                finished(g);
            }
        } catch (Exception ex) {}
    }
    
}
