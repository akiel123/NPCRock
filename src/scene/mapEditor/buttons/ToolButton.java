package scene.mapEditor.buttons;

import java.awt.Color;
import java.awt.Graphics2D;

import scene.Map;
import engine.GameInstance;
import engine.rendering.components.MButton;

public abstract class ToolButton extends MButton{
	
	Map map;
	
	public ToolButton(double pposx, double pposy,
			double priority, String description, String graphicsPath, GameInstance game, Map map) {
		super(pposx, pposy, 0.06, 0.3, 1, description, game);
		setGraphics("graphics/worldEditor/buttons/" + graphicsPath);
		this.map = map;
	}
	
	@Override
	public void paint(Graphics2D g) {
		g.drawImage(graphics, posx, posy, sizex, sizey, null);	
		outline(g, 2, new Color(120, 150, 200));
	}

}
