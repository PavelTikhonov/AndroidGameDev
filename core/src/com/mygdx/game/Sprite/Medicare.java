package com.mygdx.game.Sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Math.Rnd;

public class Medicare extends Sprite {

    private Vector2 v;
    private Rect worldBounds;
    private float generateInterval = 4f;
    private float generateTimer;
    private final float PROBABILITY = 0.2f;

    public Medicare(TextureAtlas atlas) {
        super(atlas.findRegion("medicare"));
        float vX = 0f;
        float vY = -0.5f;
        v = new Vector2(vX, vY);
        setHeightProportion(0.1f);
    }

    private void newPosition(){
        float posX = Rnd.nextFloat(worldBounds.getLeft() + this.getHalfWidth(), worldBounds.getRight() - this.getHalfWidth());
        float posY = worldBounds.getTop();
        pos.set(posX, posY);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);

        generateTimer += delta;
        if (generateTimer >= generateInterval) {
            generateTimer = 0f;
            float type = (float) Math.random();

            if (getRight() < worldBounds.getLeft()) {
                if (type < PROBABILITY) {
                    setLeft(worldBounds.getRight());
                    newPosition();
                }
            }
            if (getLeft() > worldBounds.getRight()) {
                if (type < PROBABILITY) {
                    setRight(worldBounds.getLeft());
                    newPosition();
                }
            }
            if (getTop() < worldBounds.getBottom()) {
                if (type < PROBABILITY) {
                    setBottom(worldBounds.getTop());
                    newPosition();
                }
            }
        }
    }

    @Override
    public void resize(Rect wordBounds) {
        this.worldBounds = wordBounds;
        newPosition();
    }

    @Override
    public void destroy() {
        super.destroy();
        setBottom(worldBounds.getBottom() - this.getHeight());
    }
}
