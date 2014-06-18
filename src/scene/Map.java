package scene;

import java.io.File;

import engine.rendering.TextureHandler;

public class Map {
	
	
	
	public int[][][] map = {{{TextureHandler.texture_empty, 0}}};
	
	public Map(String destination){ //Creates a map from the location
		
	}
	
	public Map(File mapFile){ //Creates a map from the file
		
	}
	
	public Map(){	//creates an empty map;
		
	}
	
	public void test(){
		System.out.println("not getting it");
	}
	
	public void expandRight(){
		System.out.println("here");
		int[][][] temp = new int[map.length + 1][map[0].length][2];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				for(int k = 0; k < map[i][j].length; k++){
					temp[i][j][k] = map[i][j][k];
				}
			}
		}
		for(int i = 0; i < map[map.length - 1].length; i++){
			for(int j = 0; j < map[map.length - 1][i].length; j++){
				temp[map.length][i][j] = 0;
			}
		}
		map = temp;
	}
	public void expandLeft(){
		int[][][] temp = new int[map.length + 1][map[0].length][2];
		for(int i = 1; i < temp.length; i++){
			for(int j = 0; j < map[i - 1].length; j++){
				for(int k = 0; k < map[i - 1][j].length; k++){
					temp[i][j][k] = map[i - 1][j][k];
				}
			}
		}
		for(int i = 0; i < map[map.length - 1].length; i++){
			for(int j = 0; j < map[map.length - 1][i].length; j++){
				temp[0][i][j] = 0;
			}
		}
		map = temp;
	}
	public void expandUp(){
		int[][][] temp = new int[map.length][map[0].length + 1][2];
		for(int i = 0; i < map.length; i++){
			for(int j = 1; j < temp[i].length; j++){
				for(int k = 0; k < map[i][j - 1].length; k++){
					temp[i][j][k] = map[i][j - 1][k];
				}
			}
		}
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i][0].length; j++){
				temp[i][0][j] = 0;
			}
		}
		map = temp;
	}
	public void expandDown(){
		int[][][] temp = new int[map.length][map[0].length + 1][2];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				for(int k = 0; k < map[i][j].length; k++){
					temp[i][j][k] = map[i][j][k];
				}
			}
		}
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i][map[i].length - 1].length; j++){
				temp[i][map[i].length - 1][j] = 0;
			}
		}
		map = temp;
	}
}
