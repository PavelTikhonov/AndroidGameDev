package com.mygdx.game.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.SpritesPool;
import com.mygdx.game.Math.Rect;
import com.mygdx.game.Sprite.Enemy;
import com.mygdx.game.Sprite.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Sound bulletSound;
    private Rect worldBounds;
    private MainShip mainShip;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Sound bulletSound, Rect worldBounds, MainShip mainShip) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.bulletSound = bulletSound;
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, explosionPool, bulletSound, worldBounds, mainShip);
    }
}
