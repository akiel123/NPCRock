package engine.rendering.components;

import engine.GameInstance;


public abstract class MButton extends MActionComponent{

	public MButton(int posx, int posy, int sizex, int sizy, double priority , GameInstance game) {
		super(posx, posy, sizex, sizy, priority, game);
		// TODO Auto-generated constructor stub
	}
	
	public MButton(double pposx, double pposy, double psizex, double psizy,
			double priority, String description, GameInstance game) {
		super(pposx, pposy, psizex, psizy, priority, description, game);
		// TODO Auto-generated constructor stub
	}
}
