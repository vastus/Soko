package vastus.sokoban;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

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
        handleInput(container, sbg);
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Soko - Box moving puzzle", 60, 20);
        g.drawString("Play - [Enter]", 90, 60);
        g.drawString("Goal - [G]", 90, 90);
        g.drawString("Credits - [C]", 90, 120);
        g.drawString("Quit - [Q]", 90, 150);
    }

    @Override
    public int getID() {
        return state.ordinal();
    }

    private void handleInput(GameContainer container, StateBasedGame sbg) {
        Input input = container.getInput();
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            sbg.enterState(GameStates.PLAY.ordinal(), new FadeOutTransition(), new FadeInTransition());
        } else if (input.isKeyPressed(Input.KEY_G)) {
            sbg.enterState(GameStates.GOAL.ordinal(), new FadeOutTransition(), new FadeInTransition());
        } else if (input.isKeyPressed(Input.KEY_C)) {
            sbg.enterState(GameStates.CREDITS.ordinal(), new FadeOutTransition(), new FadeInTransition());
        } else if (input.isKeyPressed(Input.KEY_Q)) {
            container.exit();
        }
    }

}
