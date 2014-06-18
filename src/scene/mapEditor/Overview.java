package scene.mapEditor;

import java.awt.Graphics2D;

import scene.Map;
import engine.GameInstance;
import engine.Launcher;
import engine.rendering.TextureHandler;
import engine.rendering.components.MScreen;

public class Overview extends MScreen{

	final int defaultTileSize = 100;
	
	Map map;
	int sizex,
		sizey;
		
	double	zoom = 1,
			x,			//Describes what tile is in the uppermost left corner (0.5 means it is the middle of the tile at 0.0)
			y,
			tileSize;
	
	public Overview(GameInstance game) {
		super(0, 0, 0.8, 0.8, 100, "Provides a graphical overview of the map currently being edited, and displays the map", game);
		sizex = (int) (Launcher.resx * psizex);
		sizey = (int) (Launcher.resy * 1.0 * psizey);
		map = new Map();
		x = 0;
		y = 0;
		tileSize = defaultTileSize * zoom;
	}
	public Overview(GameInstance game, Map map) {
		super(0.0, 0.0, 0.8, 0.8, 100, "Provides a graphical overview of the map currently being edited, and displays the map", game);
		sizex = (int) (Launcher.resx * psizex);
		sizey = (int) (Launcher.resy * 1.0 * psizey);
		this.map = map;
		x = 0;
		y = 0;
		calculateActualPosition();
		System.out.println(sizex);
		
		tileSize = defaultTileSize * zoom;
	}
	
	public void zoom(double zoom){
		tileSize = defaultTileSize * zoom;
		this.zoom = zoom;
	}

	@Override
	public void onUpdate(int time) {
	
	}

	@Override
	public void paint(Graphics2D g) {
		int tilesToBeDrawnx = 0,
			tilesToBeDrawny = 0;
		if(map.map.length - x < sizex / defaultTileSize)	tilesToBeDrawnx = (int)(map.map.length - x);
		else												tilesToBeDrawnx = sizex / defaultTileSize;
		if(map.map[(int)(y)].length - y < sizey / defaultTileSize)	tilesToBeDrawny = (int)(map.map[(int)(y)].length - y);
		else														tilesToBeDrawny = sizey / defaultTileSize;
		for(int i = 0; i < tilesToBeDrawnx; i++){
			for(int j = 0; j < tilesToBeDrawny; j++){
				g.drawImage(TextureHandler.texture[map.map[i + (int)(x)][j + (int)(y)][0]][map.map[i + (int)(x)][j + (int)(y)][1]].img, (int)(i * tileSize - (x % 1) * tileSize), (int)(j * tileSize - (y % 1) * tileSize), (int)(tileSize), (int)(tileSize), null);
			}
		}
		outline(g, 2);
	}
	
	
	
}
