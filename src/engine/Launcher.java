package engine;

import javax.swing.JFrame;
import javax.swing.JPanel;

import scene.Map;
import engine.rendering.TextureHandler;
import engine.rendering.components.MButton;

public class Launcher{
	
	public static final int resx = 1600,
							resy = 900;
	
	public static void main(String[] args){
		TextureHandler.assignTextureValues();
		JFrame instance = new JFrame();
		instance.setSize(resx, resy);
		GameInstance game = new GameInstance(instance);
		instance.setSize(resx, resy);
		instance.setLocationRelativeTo(null);
		instance.setVisible(true);
		instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		instance.add(game);
		game.start();
		
	}
	
}
