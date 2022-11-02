package com.lesson.GameChallenge;

import java.util.Arrays;
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
		for (String i : characters.keySet()) {
		      System.out.println("key: " + i + " value: " + Arrays.toString(characters.get(i)));
		    }
		for(int[] i : characters.values()) {
			System.out.println("value " + Arrays.toString(i));
		}
		return characters;
	}
	
	public static int[] newCharacter(String key, int grid_size) {
		int[] character_position = new int[2];
		character_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
		character_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);
//		for(int[] i : characters.values()) {
//			while(Arrays.equals(character_position, i)) {
//				System.out.println("same " + Arrays.equals(character_position, i));
//			}
//		}
		
		while(characters.containsValue(character_position)) {
			character_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
			character_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);
		}
		setcharactersinGame(key, character_position);
		return character_position;
	}

}
