package first.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.Iterator;



public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img,img1;
	private BitmapFont myBitmapFont;
	private int intX;
	private Music music;
	private Sound sound;
	private com.badlogic.gdx.math.Rectangle minerRectangle,coinRectangel;
	private OrthographicCamera orthographicCamery;
	private Vector3 objVector3;
	private Array<com.badlogic.gdx.math.Rectangle> objCoinDrop;
	private long LastDroptime;
	private Iterator<com.badlogic.gdx.math.Rectangle> objIterator;
	private Sound soundSuccess, soundfalse;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("pig.png");
		img1 =new Texture("coins.png");

		orthographicCamery = new OrthographicCamera();
		orthographicCamery.setToOrtho(false, 800, 480);
		batch =new SpriteBatch();

		minerRectangle = new com.badlogic.gdx.math.Rectangle();
		minerRectangle.x=368;
		minerRectangle.y=20;
		minerRectangle.width=64;
		minerRectangle.height=64;

		myBitmapFont = new BitmapFont();
		myBitmapFont.setColor(Color.YELLOW);
		objCoinDrop=new Array<com.badlogic.gdx.math.Rectangle>();
		gameCoinDrop();
		music = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		soundSuccess =Gdx.audio.newSound(Gdx.files.internal("coins_drop.mp3"));
		soundfalse = Gdx.audio.newSound(Gdx.files.internal("water_drop.mp3"));
		music.setLooping(true);
        music.play();
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(166/255.0f, 200/255.0f, 240/255.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		orthographicCamery.update();
		batch.setProjectionMatrix(orthographicCamery.combined);
		batch.draw(img, minerRectangle.x,minerRectangle.y);
		//batch.draw(img, intX, 0);
		for (com.badlogic.gdx.math.Rectangle forRactangle : objCoinDrop){batch.draw(img1,forRactangle.x,forRactangle.y);}
		batch.end();

		if(Gdx.input.isTouched()){objVector3=new Vector3(); objVector3.set(Gdx.input.getX(),Gdx.input.getY(),0);
			orthographicCamery.unproject(objVector3);minerRectangle.x=objVector3.x-32;}

		if (minerRectangle.x < 0) {
			minerRectangle.x=0;
		}
		if (minerRectangle.x>736) {
			minerRectangle.x=736;
		}
		if (TimeUtils.nanoTime()-LastDroptime>1E9) {
			gameCoinDrop();
		}
		objIterator=objCoinDrop.iterator();
		while (objIterator.hasNext()){
			Rectangle onjMyCoins = objIterator.next();
			onjMyCoins.y-=200*Gdx.graphics.getDeltaTime();
			if (onjMyCoins.y+64<0){
				objIterator.remove();
				soundfalse.play();
			}
			if (onjMyCoins.overlaps(minerRectangle)) {
				soundSuccess.play();
				objIterator.remove();
			}


		}
	}
	private void gameCoinDrop(){
		coinRectangel= new com.badlogic.gdx.math.Rectangle();
		coinRectangel.x = MathUtils.random(0,736);
		coinRectangel.y = 480;
		coinRectangel.width=64;
		coinRectangel.height=64;
		objCoinDrop.add(coinRectangel);
		LastDroptime = TimeUtils.nanoTime();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}