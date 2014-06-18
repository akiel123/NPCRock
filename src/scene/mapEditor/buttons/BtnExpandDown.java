package scene.mapEditor.buttons;

import java.awt.Graphics2D;

import scene.Map;
import engine.GameInstance;

public class BtnExpandDown extends ToolButton{

	Map map;

	public BtnExpandDown(GameInstance game, Map map) {
		super(0.2, 0.6, 1, "Expands the map southwards", "expandDown.png", game, map);
		this.map = map;
	}

	@Override
	public void onRelease() {
		map.expandDown();
		
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
