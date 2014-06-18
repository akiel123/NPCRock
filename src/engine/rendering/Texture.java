package engine.rendering;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public class Texture{

	private String name;
	
	public BufferedImage img;
	
	public Texture(BufferedImage image){
		img = image;
	}
	
	public void setName(String newName){
		name = newName;
	}
	public String getName(){
		return name;
	}
}
