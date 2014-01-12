package vastus.sokoban;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

class GameGoal extends BasicGameState {

    private GameStates state;

    public GameGoal(GameStates state) {
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
        drawGoal(container, sbg, g);
    }

    @Override
    public int getID() {
        return state.ordinal();
    }

    private void drawGoal(GameContainer container, StateBasedGame sbg, Graphics g) {
        g.drawString("Goal of the Game", 60, 20);
        g.drawString("The goal of the game is to move the brown boxes", 90, 60);
        g.drawString("to their storage locations which are marked as", 90, 90);
        g.drawString("red dots in the level. You are the pink player who", 90, 120);
        g.drawString("is the only one who can move them. But be aware", 90, 150); 
        g.drawString("you can only push the boxes one at a time. You can't", 90, 180);
        g.drawString("pull any of the boxes.", 90, 210);
        g.drawString("Back - [Esc|Enter]", 60, 270);
    }

    private void handleInput(GameContainer container, StateBasedGame sbg) {
        Input input = container.getInput();
        if (input.isKeyPressed(Input.KEY_ESCAPE) || input.isKeyPressed(Input.KEY_ENTER)) {
            sbg.enterState(GameStates.MENU.ordinal(), new FadeOutTransition(), new FadeInTransition());
        }
    }

}
