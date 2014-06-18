package scene.mapEditor.buttons;

import java.awt.Graphics2D;

import scene.Map;
import engine.GameInstance;

public class BtnExpandLeft extends ToolButton{


	public BtnExpandLeft(GameInstance game, Map map) {
		super(0.1, 0.1, 1, "Expands the map westwards", "expandLeft.png", game, map);
		this.map = map;
	}

	@Override
	public void onRelease() {
		map.expandLeft();
	}

	@Override
	public void onPress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdate(int time) {
		// TODO Auto-generated method stub
		
	}
}
