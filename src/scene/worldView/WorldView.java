package scene.worldView;

import javax.swing.JPanel;

import misc.navigation.Translation;

public class WorldView extends JPanel{

	RoomInstance instance;
	Translation orientation;
	
	public WorldView(){
		
	}
	
	public void setInstance(RoomInstance newInstance){
		instance = newInstance;
	}
	
}
