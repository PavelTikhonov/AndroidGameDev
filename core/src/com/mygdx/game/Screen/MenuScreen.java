package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Sprite.Background;
import com.mygdx.game.Sprite.BadLogic;

public class MenuScreen extends BaseScreen {

    private Vector2 touch;
    private Vector2 v;
    private Vector2 pos;

    private Texture bg;
    private Texture badLogicTexture;
    private Background background;
    private BadLogic badLogic;


    @Override
    public void show() {
        super.show();
        bg = new Texture("bg.png");
        background = new Background(new TextureRegion(bg));
        badLogicTexture = new Texture("badlogic.jpg");
        badLogic = new BadLogic(new TextureRegion(badLogicTexture));

        touch = new Vector2();
        v = new Vector2(3,3);
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        badLogic.draw(batch);
        badLogic.pos.set(this.pos);
        batch.end();

//        System.out.println("pos.x = " + pos.x + " pos.y = " + pos.y);
//        System.out.println("toutch.x = " + toutch.x + " toutch.y = " + toutch.y);

        if((Math.abs(pos.x - touch.x) > 0.001) && (Math.abs(pos.y - touch.y) > 0.001)){
            //System.out.println("v.x = " + v.x + " v.y = " + v.y);
            pos.add(v);
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        badLogicTexture.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        badLogic.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer){
        super.touchDown(touch, pointer);

        this.touch.set(touch.x, touch.y);
        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);

        v = touch.cpy().sub(pos);
        v.x /= 10;
        v.y /= 10;
        return false;
    }
}
