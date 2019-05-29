package com.mygdx.game.pool;


import com.mygdx.game.Base.SpritesPool;
import com.mygdx.game.Sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
