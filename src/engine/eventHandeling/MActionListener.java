package engine.eventHandeling;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import engine.rendering.components.MActionComponent;

public class MActionListener implements MouseListener{

	MActionComponent[] components = new MActionComponent[0];
	
	public void addComponent(MActionComponent newComponent){
		MActionComponent[] temp = new MActionComponent[components.length + 1];
		for(int i = 0; i < components.length; i++){
			temp[i] = components[i];
		}
		temp[components.length] = newComponent;
		components = temp;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getPoint().x,
			y = e.getPoint().y;
		for(int i = 0; i < components.length; i++){
			if((x > components[i].posx && x < components[i].posx + components[i].sizex) && (y > components[i].posy && y < components[i].posy + components[i].sizey)){
				components[i].onPress();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getPoint().x,
			y = e.getPoint().y;
		for(int i = 0; i < components.length; i++){
			if((x > components[i].posx && x < components[i].posx + components[i].sizex) && (y > components[i].posy && y < components[i].posy + components[i].sizey)){
				components[i].onRelease();
			}
		}
	}
	
}
