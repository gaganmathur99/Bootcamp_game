package com.lesson.GameChallenge;

import java.util.concurrent.ThreadLocalRandom;

public class Monster {

	public String name;
	public String Greet;
	public static int[] monster_position = new int[2];

	public Monster(String name, String Greet) {
		this.name = name;
		this.Greet = Greet;
		monster_position = setMonsterPosition();
	}

	public int[] setMonsterPosition() {
		int[] player_position = Player.getposition();
		int[] treasure_position = Treasure.getTreasurePosition();
		int grid_size = App.globalGridSize;// stats.grid_size();

		// this.setTreasurePosition();
		monster_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
		monster_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);

		while ((monster_position[0] == player_position[0] || monster_position[1] == player_position[1])
				|| (monster_position[0] == treasure_position[0] && monster_position[1] == treasure_position[1])) {
			monster_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
			monster_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);
		}
		return monster_position;
	}

	
	public int[] killPlayer() {
		int[] player_position = Player.getposition();
		//int[] treasure_position = Treasure.getTreasurePosition();
		int grid_size = App.globalGridSize;// stats.grid_size();
		
		double distance_up;
		double distance_x_up = monster_position[0]-1 - player_position[0];
		double distance_y_up = monster_position[1] - player_position[1];
		distance_up = Math.sqrt(Math.pow(distance_y_up, 2) + Math.pow(distance_x_up, 2));
		
		double distance_down;
		double distance_x_down = monster_position[0]+1 - player_position[0];
		double distance_y_down = monster_position[1] - player_position[1];
		distance_down = Math.sqrt(Math.pow(distance_y_down, 2) + Math.pow(distance_x_down, 2));

		double distance_left;
		double distance_x_left = monster_position[0] - player_position[0];
		double distance_y_left = monster_position[1]-1 - player_position[1];
		distance_left = Math.sqrt(Math.pow(distance_y_left, 2) + Math.pow(distance_x_left, 2));
		
		double distance_right;
		double distance_x_right = monster_position[0] - player_position[0];
		double distance_y_right = monster_position[1]-1 - player_position[1];
		distance_right = Math.sqrt(Math.pow(distance_y_right, 2) + Math.pow(distance_x_right, 2));
		
		if(distance_up < distance_down && distance_up < distance_right && distance_up < distance_left) {
			if (monster_position[0]!=0)
				monster_position[0] -= 1;
		} else if( distance_down < distance_up && distance_down < distance_right && distance_down < distance_left ) {
			if (monster_position[0]<grid_size)
				monster_position[0] += 1;
		} else if( distance_right < distance_up && distance_right < distance_down && distance_right < distance_left ) {
			if (monster_position[1]<grid_size)
				monster_position[1] += 1;
		}  else {
			if (monster_position[1]!=0)
				monster_position[1] -= 1;
		}
	
		return monster_position;
	}
	
	public static int[] getMonsterPosition() {
		return monster_position;
	}

}