package engine.rendering;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import scene.mapEditor.buttons.ToolButton;
import engine.GameInstance;
import engine.Launcher;
import engine.rendering.components.MActionComponent;

public abstract class MComponent {

	public BufferedImage graphics;
	public double	priority,	//A component with higher priority will be paintet in front of a component with lower priority
					pposx,		//Where the component should be shown in percentage
					pposy,	
					psizex,		//How large the component should be in percentage of the screen
					psizey;
	
	public int		posx,
					posy,
					sizex,
					sizey;
	
	protected String name;
	
	public GameInstance game;
	
	public boolean	isActionTrigger,
					sizeRelativeToComponent = false;
	
	private MComponent positionRelativeTo;
	
	protected MComponent[] subComponents = new MComponent[0];
	
	public MComponent(double pposx, double pposy, double psizex, double psizey, double priority, String description, GameInstance game){
		this.game = game;
		this.pposx = pposx;
		this.pposy = pposy;
		this.psizex = psizex;
		this.psizey = psizey;
		this.priority = priority;
		name = description;
		calculateActualPosition();
	}

	public MComponent(int posx, int posy, int sizex, int sizey, double priority, GameInstance game){
		this.posx = posx;
		this.posy = posy;
		this.sizex = sizex;
		this.sizey = sizey;
		this.priority = priority;
		this.game = game;
	}
	
	public void setPositionRelativeTo(MComponent component){
		positionRelativeTo = component;
		calculateActualPosition();
		sizeRelativeToComponent = true;
	}
	
	public void addComponent(MComponent component){
		component.setPositionRelativeTo(this);
		component.calculateActualPosition();
		MComponent[] temp = new MComponent[subComponents.length + 1];
		//Add component at appropriate priority position
		boolean componentHasBeenAdded = false;
		for(int i = 0; i < subComponents.length; i++){
			if(!componentHasBeenAdded){
				if(component.priority >= subComponents[i].priority){
					temp[i] = component;
					temp[i + 1] = subComponents[i];
					componentHasBeenAdded = true;
				}
				else temp[i] = subComponents[i];
			}
			else temp[i + 1] = subComponents[i];
		}
		if(!componentHasBeenAdded)temp[subComponents.length] = component;
		subComponents = temp;
		//Check if actioncomponent and add to MActionListener
		if(component instanceof MActionComponent) game.actionListener.addComponent((MActionComponent)(component));
	}

	public void setGraphics(String string){
		try {                
	         graphics = ImageIO.read(new File(string));
	         System.out.println("Graphical component added to: " + name);
		} catch (IOException ex) {
	         System.out.println("Invalid graphics object being importet for: " + name);
	    }
	}
	

	public void setGraphics(Texture texture){
		graphics = texture.img;
	}

	
	public void calculateActualPosition(){
		if(!sizeRelativeToComponent){
			int sx = Launcher.resx,
				sy = Launcher.resy;
			posx = (int) (sx * pposx);
			posy = (int) (sy * pposy);
			sizex = (int) (sx * psizex);
			sizey = (int) (sy * psizey);
			
		} else {
			int bx = positionRelativeTo.posx,
				by = positionRelativeTo.posy,
				sx = positionRelativeTo.sizex,
				sy = positionRelativeTo.sizey;

			posx = (int) (sx * pposx) + bx;
			posy = (int) (sy * pposy) + by;
			sizex = (int) (sx * psizex);
			sizey = (int) (sy * psizey);
		}
	}
	
	public void allwaysDoOnUpdate(int time){
		for(int i = 0; i < subComponents.length; i++){
			subComponents[i].allwaysDoOnUpdate(time);
		}
		onUpdate(time);
	}
	public abstract void onUpdate(int time);
	
	public void allwaysDoOnPaint(Graphics2D g){
		for(int i = 0; i < subComponents.length; i++){
			subComponents[i].allwaysDoOnPaint(g);
		}
		paint(g);	
	}
	public abstract void paint(Graphics2D g);
	
	public void setName(String newName){
		name = newName;
	}
	
	public void outline(Graphics2D g, int lineWidth){
		g.fillRect(posx, posy, sizex, lineWidth);
		g.fillRect(posx, posy, lineWidth, sizey);
		g.fillRect(posx, posy + sizey, sizex, lineWidth);
		g.fillRect(posx + sizex , posy, lineWidth, sizey);
	}

	public void outline(Graphics2D g, int lineWidth, Color color){
		Color current = g.getColor();
		g.setColor(color);
		g.fillRect(posx, posy, sizex, lineWidth);
		g.fillRect(posx, posy, lineWidth, sizey);
		g.fillRect(posx, posy + sizey, sizex, lineWidth);
		g.fillRect(posx + sizex , posy, lineWidth, sizey);
		g.setColor(current);
	}
	
	public String getName(){
		return name;
	}
}
