package scene.mapEditor.buttons;

import java.awt.Graphics2D;

import engine.GameInstance;
import engine.rendering.Texture;
import engine.rendering.TextureHandler;
import engine.rendering.components.MButton;
import engine.rendering.components.MCursor;

public class BtnSelectTexture extends MButton{

	MCursor cursor;
	
	public BtnSelectTexture(double pposx, double pposy, double psizex, double psizey, Texture texture, MCursor cursor, GameInstance game) {
		super(pposy, pposx, psizex, psizey, 0, "Sets the cursor to select the " + texture.getName() + " texture", game);
		this.cursor = cursor;
		graphics = texture.img;
	}

	@Override
	public void onRelease() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdate(int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	
}
