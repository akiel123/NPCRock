package scene.mapEditor;

import java.awt.Graphics2D;

import scene.mapEditor.buttons.BtnSelectTexture;
import engine.GameInstance;
import engine.rendering.Texture;
import engine.rendering.TextureHandler;
import engine.rendering.components.MCursor;
import engine.rendering.components.MScreen;

public class PalletePanel extends MScreen{

	public PalletePanel(int columns, MCursor cursor, GameInstance game) {
		super(0.8, 0, 0.2, 0.8, 1, "Provides you with a selection of textures to paint with", game);
		Texture[][] textures = TextureHandler.texture;
		int spaceSize = (int)(sizex * 0.03);
		double	sizePerButton = 1.0 * sizex / columns - 1.0 * spaceSize * (columns + 1),
				sizePerButtonx = sizex / sizePerButton,
				sizePerButtony = sizePerButtonx * (1.0 * sizey / 1.0 * sizex);
		while(sizePerButton <= 0){
			columns -= 1;
			sizePerButton = 1.0 * sizex / columns - 1.0 * spaceSize * (columns + 1);
		}
		int g = 0,
			v = 0,
			t = 0,
			added = 0,
			maximumNumberOfRows = (int) ((sizey - spaceSize) / (sizePerButton + spaceSize));
		for(int i = 0; i < textures.length; i++){
			for(int j = 0; j < textures[g].length; j++, added++){
				System.out.println(textures.length + "  " + textures[g].length + "  " + i + "  " + j);
				System.out.println(textures[2][0]);
			BtnSelectTexture btn = new BtnSelectTexture(spaceSize * (added % 3 + 1) + sizePerButton * added % 3, spaceSize * (added / 3 + 1) + sizePerButton * added / 3, sizePerButtonx, sizePerButtony, textures[i][j], cursor, game);												
			}
		}
	}

	@Override
	public void onUpdate(int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		outline(g, 2);
	}

}
