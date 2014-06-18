package engine.rendering;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureHandler {
	public static Texture[][] texture;
	public static int	numberOfTextureGroups = 3,
						totalTextures;
	public static int	texture_empty	= 0,
						texture_grass	= 1,
						texture_road	= 2;
	public static int	emptyVariations	= 1,
						grassVariations	= 1,
						roadVariations	= 0;
	
	public static void assignTextureValues(){
		int arrayValue = 1;
		texture = new Texture[3][];
		try{
			if(emptyVariations > 0){
				texture[texture_empty] = new Texture[emptyVariations];
				texture[texture_empty]	= importTextureVariations("graphics/groundTextures/misc/", "Empty", "png", emptyVariations);
				System.out.println("empty " + texture[texture_empty].length);
				arrayValue++;
			} else removeGroup(texture_empty);
			if(grassVariations > 0){
			texture[texture_grass] = new Texture[grassVariations];
			texture[texture_grass]	= importTextureVariations("graphics/groundTextures/grass/", "Grass", "png", grassVariations);
			System.out.println("grass  " + texture[texture_empty].length);
			arrayValue++;
			} else removeGroup(texture_grass);
			if(roadVariations > 0){
				texture[texture_road] = new Texture[roadVariations];
				texture[texture_road]	= importTextureVariations("graphics/groundTextures/road/", "Road", "png", roadVariations);
				arrayValue++;			
			} else removeGroup(texture_road);
		}
		catch (ArrayIndexOutOfBoundsException error){ //Not functioning
			System.out.println("Invalid array size for textures. Goto src.scene.Map.String[] texture... Fixing");
			texture = new Texture[arrayValue][];
			assignTextureValues();
			return;
		}
		for(int i = 0; i < texture.length; i++){
			for(int j = 0; j < texture[i].length; j++){
				System.out.println(texture[i].length);
				totalTextures++;
			}
		}
	}
	public static void removeGroup(int d){
		Texture[][] temp = new Texture[texture.length - 1][];
		boolean found = false;
		for(int i = 0; i < texture.length; i++){
			if(i == d){
				found = true;
				i++;
			} 
			else if(!found) temp[i] = texture[i];
			else temp[i - 1] = texture[i];
			
			texture = temp;
		}
	}
	public static Texture[] importTextureVariations(String destination, String texturePrefix, String fileFormat, int numberOfVariations){
		Texture[] graphics = new Texture[numberOfVariations];
		
		for(int i = 0; i < numberOfVariations; i++){
			graphics[i] = importTexture(destination + texturePrefix + Integer.toString(i), texturePrefix + Integer.toString(i), fileFormat);
		}
		
		return graphics;
	}
	
	public static Texture importTexture(String string, String name, String fileFormat){
		Texture graphics = null;
		try {                
	         graphics = new Texture(ImageIO.read(new File(string + "." + fileFormat)));
	         graphics.setName(name);
	         System.out.println("Graphical component added to: " + name + " texture");
		} catch (IOException ex) {
	         System.out.println("Invalid graphics object being importet for: " + name + " texture");
	    }
		return graphics;
	}
}
