package com.mygdx.game.Sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;
import com.mygdx.game.Base.ScaledTouchUpButton;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Screen.GameScreen;

public class ButtonNewGame extends ScaledTouchUpButton {

    GameScreen gameScreen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        setHeightProportion(0.07f);
        this.gameScreen = gameScreen;

    }

    @Override
    public void resize(Rect wordBounds) {
        setWidth(wordBounds.getHalfWidth());
        setBottom(wordBounds.getBottom() + 0.3f);
    }
    @Override
    public void action() {
        this.gameScreen.restartGame();
    }

}
