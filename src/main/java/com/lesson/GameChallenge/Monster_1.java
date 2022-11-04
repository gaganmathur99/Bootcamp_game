package com.lesson.GameChallenge;

import java.util.concurrent.ThreadLocalRandom;

public class Monster_1 {

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

	public static int[] getMonsterPosition() {
		return monster_position;
	}

}