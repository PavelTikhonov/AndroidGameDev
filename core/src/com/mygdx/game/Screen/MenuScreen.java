package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private SpriteBatch batch;
    private Texture img;
    private Texture img1;
    private Vector2 toutch;
    private Vector2 v;
    private Vector2 pos;
    private Vector2 posPrev;
    private float rightBorder;
    private float topBorder;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("sky.jpg");
        img1 = new Texture("deathStar2.jpg");
        toutch = new Vector2();
        v = new Vector2(3,3);
        pos = new Vector2();
        posPrev = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.draw(img1, pos.x, pos.y);
        batch.end();

        rightBorder = pos.x + img1.getHeight();
        topBorder = pos.x + img1.getWidth();

        System.out.println("pos.x = " + pos.x + " pos.y = " + pos.y);
        System.out.println("toutch.x = " + toutch.x + " toutch.y = " + toutch.y);

        if((Math.abs(pos.x - toutch.x) > 0.001) && (Math.abs(pos.y - toutch.y) > 0.001)){
            System.out.println("v.x = " + v.x + " v.y = " + v.y);
            pos.add(v);
        } else {
            posPrev = pos.cpy();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        toutch.set(screenX, Gdx.graphics.getHeight() - screenY);

        v = toutch.cpy().sub(posPrev);
        v.x /= 10;
        v.y /= 10;
        return false;
    }
}
