package engine.rendering.components;

import engine.GameInstance;
import engine.rendering.MComponent;
import engine.rendering.components.Layouts.MLayout;

public abstract class MScreen extends MComponent{

	MLayout layout;
	
	public MScreen(double pposx, double pposy, double psizex, double psizy,
			double priority, String description, GameInstance game) {
		super(pposx, pposy, psizex, psizy, priority, description, game);
		// TODO Auto-generated constructor stub
	}
	
	public MScreen(int posx, int posy, int sizex, int sizy, double priority, GameInstance game) {
		super(posx, posy, sizex, sizy, priority, game);
		// TODO Auto-generated constructor stub
	}
	
	public void setLayout(MLayout newLayout){
		layout = newLayout;
	}
	public MLayout getLayout(){
		return layout;
	}
	
}
