package scene.mapEditor.buttons;

import java.awt.Graphics2D;

import scene.Map;
import engine.GameInstance;

public class BtnExpandUp extends ToolButton{

	Map map;

	public BtnExpandUp(GameInstance game, Map map) {
		super(0.2, 0.1, 1, "Expands the map northwards", "expandUp.png", game, map);

		this.map = map;
	}

	@Override
	public void onRelease() {
		System.out.println(map);
		map.expandUp();
		
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
