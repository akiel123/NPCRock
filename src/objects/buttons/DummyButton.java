package objects.buttons;

import java.awt.Graphics2D;

import engine.GameInstance;
import engine.rendering.components.MActionComponent;

public class DummyButton extends MActionComponent{

	boolean check = false;
	
	public DummyButton(GameInstance game) {
		super(400, 400, 300, 300, 10, game);
		this.setGraphics("graphics/misc/textureMissing.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onRelease() {
		check = false;
		System.out.println("Button released");
	}

	@Override
	public void onPress() {
		check = true;
		System.out.println("Button pressed");
	}

	@Override
	public void onUpdate(int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		g.drawImage(graphics, posx, posy, sizex, sizey, null);
		if(check){
			g.fillRect(500, 500, 200, 200);
		}
	}

}
