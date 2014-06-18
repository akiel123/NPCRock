package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objects.buttons.DummyButton;
import scene.Map;
import scene.mapEditor.Overview;
import scene.mapEditor.PalletePanel;
import scene.mapEditor.ToolWindow;
import engine.eventHandeling.MActionListener;
import engine.rendering.MComponent;
import engine.rendering.TextureHandler;
import engine.rendering.components.MActionComponent;
import engine.rendering.components.MCursor;


public class GameInstance extends JPanel{

	public JFrame frame;
	private int sizex,
				sizey;
	public boolean	running = false;
	private boolean[][]	pixelHasBeenPainted;
	public MActionListener actionListener;
	
	private MComponent[] components = new MComponent[0];
	private Map[] instances = new Map[0];

	public GameInstance(JFrame frame){
		this.frame = frame;
		sizex = frame.getWidth();
		sizey = frame.getHeight();
		pixelHasBeenPainted = new boolean[sizex][sizey];
		addActionListener(new MActionListener());
	}
	
	protected void addActionListener(MActionListener listener){
		actionListener = listener;
		this.addMouseListener(listener);
	}
	
	protected void addMap(Map map){
		Map[] temp = new Map[instances.length + 1];
		for(int i = 0; i < instances.length; i++){
			temp[i] = instances[i];
		}
		temp[instances.length] = map;
		instances = temp;
	}
	
	protected void addComponent(MComponent component){
		component.setPositionRelativeTo(null);
		component.sizeRelativeToComponent = false;
		component.calculateActualPosition();
		MComponent[] temp = new MComponent[components.length + 1];
		//Add component at appropriate priority position
		boolean componentHasBeenAdded = false;
		for(int i = 0; i < components.length; i++){
			if(!componentHasBeenAdded){
				if(component.priority >= components[i].priority){
					temp[i] = component;
					temp[i + 1] = components[i];
					componentHasBeenAdded = true;
				}
				else temp[i] = components[i];
			}
			else temp[i + 1] = components[i];
		}
		if(!componentHasBeenAdded)temp[components.length] = component;
		components = temp;
		
		//Check if actioncomponent and add to MActionListener
		if(component instanceof MActionComponent) actionListener.addComponent((MActionComponent)(component));
	}
	
	protected void updateComponents(int time){
		for(int i = 0; i < components.length; i++){
			components[i].allwaysDoOnUpdate(time);
		}
	}
	
	public void paintComponents(Graphics2D g){
		for(int i = 0; i < components.length; i++){
			components[i].allwaysDoOnPaint(g);
		}
	}
	
	public void paint(Graphics g) {
		//################## Necessary Stuff ##########################//
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		//################## Necessary Stuff ##########################//		
		BufferedImage graphics = null;
		
		paintComponents(g2d);
	}
	
	public void start(){
		running = true;
		DummyButton btn = new DummyButton(this);
		addMap(new Map());
		Overview ovv = new Overview(this, instances[0]);
		ToolWindow tools = new ToolWindow(this, instances[0]);
		MCursor cursor = new MCursor(40, this);
		PalletePanel pallet = new PalletePanel(2, cursor, this);
		cursor.setTexture(TextureHandler.texture[TextureHandler.texture_grass][0]);
		ovv.setName("Overview");
		this.addComponent(ovv);
		this.addComponent(tools);
		this.addComponent(pallet);
		this.addComponent(cursor);
		long lastFrame = System.currentTimeMillis();
		long thisFrame = System.currentTimeMillis();
		while(running){
			lastFrame = System.currentTimeMillis();
			updateComponents((int)(thisFrame - lastFrame));
			this.repaint();
			try {
				Thread.sleep((int)(1.0*1000/60));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			thisFrame = System.currentTimeMillis();
		}
	}
	
}
