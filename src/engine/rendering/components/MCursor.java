package engine.rendering.components;

import java.awt.Graphics2D;
import java.awt.MouseInfo;

import engine.GameInstance;
import engine.rendering.MComponent;
import engine.rendering.Texture;

public class MCursor extends MComponent{
	
	int size;
	private Texture texture;
	
	public MCursor(int size, GameInstance game) {
		super(0, 0, 0, 0, 0, game);
		this.size = size;
	}
	
	public MCursor(double pposx, double pposy, double psizex, double psizy,
			double priority, String description, GameInstance game) {
		super(pposx, pposy, psizex, psizy, priority, description, game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpdate(int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		if(texture != null){
			double	w = texture.img.getWidth(),
					h = texture.img.getHeight();
			int width = 0,
				height = 0;
			if(w < h){
				width = (int) (w / h * size);
				height = size;
			} else {
				width = size;
				height = (int)(h / w * size);
			}
			
			int	x = MouseInfo.getPointerInfo().getLocation().x,
				y = MouseInfo.getPointerInfo().getLocation().y,
				locationX = game.frame.getLocation().x,
				locationY = game.frame.getLocation().y;
			g.drawImage(texture.img, x - width/2 - locationX - 7, y - height/2 - locationY - 30, width, height, null);
			
			System.out.println(game.frame.getLocation().x + "    " + game.frame.getLocation().y);
		}
	}
	
	public void setTexture(Texture txture){
		texture = txture;
	}
	public Texture getTexture(){
		return texture;
	}
}
