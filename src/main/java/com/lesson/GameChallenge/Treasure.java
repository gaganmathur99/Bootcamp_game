package com.lesson.GameChallenge;

import java.util.concurrent.ThreadLocalRandom;

public class Treasure {

	public static int[] treasure_position = new int[2];

	public Treasure() {
		treasure_position = initialize_treasure();
		stats.setcharactersinGame("Treasure", treasure_position);
	}

	private int[] initialize_treasure() {
		int[] player_position = Player.getposition();
		int grid_size = App.globalGridSize;
		
		treasure_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
		treasure_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);

		while (treasure_position[0] == player_position[0] || treasure_position[1] == player_position[1]) {
			treasure_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
			treasure_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);
		}
		return treasure_position;
	}

	public static int[] getTreasurePosition() {
		return treasure_position;
	}

	public static void player_distance() {
		int[] player_local = new int[2];
		player_local = Player.getposition();
		double distance;
		double distance_x = treasure_position[0] - player_local[0];
		double distance_y = treasure_position[1] - player_local[1];
		distance = Math.sqrt(Math.pow(distance_y, 2) + Math.pow(distance_x, 2));
		System.out.println("Distance from Treasure: " + distance);
	}
}
