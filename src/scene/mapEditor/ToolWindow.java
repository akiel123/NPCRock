package scene.mapEditor;

import java.awt.Graphics2D;

import scene.Map;
import scene.mapEditor.buttons.BtnExpandDown;
import scene.mapEditor.buttons.BtnExpandLeft;
import scene.mapEditor.buttons.BtnExpandRight;
import scene.mapEditor.buttons.BtnExpandUp;
import engine.GameInstance;
import engine.rendering.components.MScreen;

public class ToolWindow extends MScreen{
	
	Map map;
	
	public ToolWindow(GameInstance game, Map map) {
		super(0, 0.8, 0.8, 0.2, 1, "Provides tools for manipulating the map", game);
		addComponent(new BtnExpandLeft(game, map));
		addComponent(new BtnExpandRight(game, map));
		addComponent(new BtnExpandDown(game, map));
		addComponent(new BtnExpandUp(game, map));
	}

	@Override
	public void onUpdate(int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		outline(g, 2);
	}

}
