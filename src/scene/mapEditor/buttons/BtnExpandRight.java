package scene.mapEditor.buttons;

import java.awt.Graphics2D;

import scene.Map;
import engine.GameInstance;

public class BtnExpandRight extends ToolButton{

	Map map;

	public BtnExpandRight(GameInstance game, Map map) {
		super(0.1, 0.6, 1, "Expands the map eastwards", "expandRight.png", game, map);
		this.map = map;
	}

	@Override
	public void onRelease() {
		System.out.println("waht");
		map.expandRight();
		
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
