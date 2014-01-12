package vastus.sokoban;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

class GameCredits extends BasicGameState {

    private GameStates state;

    public GameCredits(GameStates state) {
        this.state = state;
    }

    @Override
    public void init(GameContainer container, StateBasedGame sbg)
            throws SlickException {
    }

    @Override
    public void update(GameContainer container, StateBasedGame sbg, int delta)
            throws SlickException {
        handleInput(container, sbg);
    }

    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g)
            throws SlickException {
        drawCredits(container, sbg, g);
    }

    @Override
    public int getID() {
        return state.ordinal();
    }

    private void drawCredits(GameContainer container, StateBasedGame sbg, Graphics g) {
        g.drawString("Credits", 60, 20);
        g.drawString("Sokoban was created by Hiroyuki Imabayashi in 1981.", 90, 60);
        g.drawString("This is my simple clone of the game." , 90, 90);
        g.drawString("Juho Hautala <juho.hautala@helsinki.fi>" , 90, 150);
        g.drawString("GitHub https://github.com/vastus/Soko.", 90, 180);
        g.drawString("Back - [Esc|Enter]", 60, 240);
    }

    private void handleInput(GameContainer container, StateBasedGame sbg) {
        Input input = container.getInput();
        if (input.isKeyPressed(Input.KEY_ESCAPE) || input.isKeyPressed(Input.KEY_ENTER)) {
            sbg.enterState(GameStates.MENU.ordinal(), new FadeOutTransition(), new FadeInTransition());
        }
    }

}
