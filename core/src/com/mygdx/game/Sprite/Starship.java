package com.mygdx.game.Sprite;


import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Math.Rnd;
import com.mygdx.game.Screen.GameScreen;

public class Starship extends Sprite {

    private static final float LEN = 0.01f;
    private Vector2 v;
    private Vector2 touch;
    private Vector2 buf;
    private Rect worldBounds;

    public Starship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        getRegion(atlas);
        setHeightProportion(0.2f);
        v = new Vector2();
        touch = new Vector2();
        buf = new Vector2();
    }

    private TextureRegion getRegion(TextureAtlas atlas){
        TextureRegion region = atlas.findRegion("main_ship");
        region.setRegion(region.getRegionX(),region.getRegionY(), region.getRegionWidth() / 2, region.getRegionHeight());
        return region;
    }

    @Override
    public void resize(Rect wordBounds) {
        this.worldBounds = wordBounds;
        setBottom(wordBounds.getBottom() + 0.03f);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        touch.y = pos.y;

        if(Math.abs(this.touch.x) >= (worldBounds.getHalfWidth() - this.halfWidth)){
            this.touch.x = (worldBounds.getHalfWidth() - this.halfWidth) * this.touch.x / Math.abs(this.touch.x);
        }
        buf.set(touch);
        if(buf.sub(pos).len() <= LEN){
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        this.touch = touch;
        this.touch.y = pos.y;
        v.set(this.touch.cpy().sub(pos)).setLength(LEN);
        return false;
    }
}
