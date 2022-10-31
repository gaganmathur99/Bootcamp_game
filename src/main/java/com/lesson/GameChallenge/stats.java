package com.lesson.GameChallenge;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class stats {

	
	private static  HashMap<String,int[]> characters = new HashMap<String,int[]>();

	public static int grid_size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void setcharactersinGame(String name, int[] location){
		characters.put(name, location);
	}

	
	public HashMap<String,int[]> getcharactersinGame(){
		for(int[] i : characters.values()) {
			System.out.println("value " + i);
		}
		return characters;
	}
	
	public static int[] newCharacter(String key, int grid_size) {
		int[] character_position = new int[2];
		character_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
		character_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);
		while(characters.containsValue(character_position)) {
			character_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
			character_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);
		}
		return character_position;
	}

}
