package engine.rendering.components;

import engine.GameInstance;
import engine.rendering.MComponent;

public abstract class MActionComponent extends MComponent{

	public MActionComponent(double pposx, double pposy, double psizex,
			double psizey, double priority, String description, GameInstance game) {
		super(pposx, pposy, psizex, psizey, priority, description, game);
		// TODO Auto-generated constructor stub
	}

	public MActionComponent(int posx, int posy, int sizex, int sizy,
			double priority, GameInstance game) {
		super(posx, posy, sizex, sizy, priority, game);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void onRelease();
	
	public abstract void onPress();

}
