package com.lesson.GameChallenge;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

	public static int[] player_position = new int[2];
	// public static boolean game_win;
	private String name = "unknown";
	public int strength = 0;
	public int global_grid_size;

	public Player() {

	}

	public Player(String newName) {
		name = newName;
		System.out.println(name + " initiated...");
		setPlayerPosition(App.globalGridSize);
	}

	public static int[] setPlayerPosition(int grid_size) {
		player_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
		player_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);
		return player_position;
	}

	public static void updatePlayerPosition(int grid_size) {
		Scanner movement = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter 1 to move right, 2 to move left, 3 to move up and 4 to move down ");
		int userMove = movement.nextInt();
		System.out.println("here: " + userMove);

		if (userMove == 1) {
			if (player_position[1] != grid_size - 1) {
				player_position[1] += 1;
			}
		} else if (userMove == 2) {
			if (player_position[1] != 0) {
				player_position[1] -= 1;
			}
		} else if (userMove == 3) {
			if (player_position[0] != 0) {
				player_position[0] -= 1;
			}
		} else if (userMove == 4) {
			if (player_position[0] != grid_size - 1) {
				player_position[0] += 1;
			}

		} else {
			System.out.println("Invalid Move");
		}

	}

	public static int[] getposition() {
		return player_position;
	}

	public static boolean game_win() {
		int[] treasure_local = new int[2];
		treasure_local = Treasure.treasure_position;
		if (player_position[0] == treasure_local[0] && player_position[1] == treasure_local[1]) {
			System.out.println("Congratulations! You have found the treasure, well done!");
			return true;
		} else {
			return false;
		}
	}

	public static boolean game_lose() {
		int[] monster_local = new int[2];
		monster_local = Monster.getMonsterPosition();
		if (player_position[0] == monster_local[0] && player_position[1] == monster_local[1]) {
			System.out.println("You come across a massive monster");
			System.out.println("The monster gobbles you up! Game Over!");
			return true;
		} else {
			return false;
		}
	}
}
