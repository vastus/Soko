package vastus.sokoban;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GameMenu extends BasicGameState {

    private GameStates state;

    public GameMenu(GameStates state) {
        this.state = state;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
    }

    @Override
    public int getID() {
        return state.ordinal();
    }

}
