package com.lesson.GameChallenge;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class player {

	public static int[] player_position = new int[2];
	// public static boolean game_win;
	private int health;
	private String name = "unknown";
	public int strength = 0;
	public int grid_size = 5;

	public player() {
		System.out.println("Player initiated -- without -- name");
		this.health = 100;
		setPlayerPosition(grid_size);
	}

	public player(String newName) {
		name = newName;
		this.health = 100;
		//System.out.println(name + " initiated...");
		setPlayerPosition(grid_size);
		stats.setcharactersinGame(name, player_position);
	}

	public static int[] setPlayerPosition(int grid_size) {
		// TODO Auto-generated method stub
		// System.out.println(player_position[0]);
		player_position[0] = ThreadLocalRandom.current().nextInt(0, grid_size);
		player_position[1] = ThreadLocalRandom.current().nextInt(0, grid_size);
		return player_position;
	}

	public static void updatePlayerPosition(int grid_size) {
		Scanner movement = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter 1 to move right, 2 to move left, 3 to move up and 4 to move down ");
		int userMove = movement.nextInt();

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
		treasure_local = treasure.treasure_position;
		if (player_position[0] == treasure_local[0] && player_position[1] == treasure_local[1]) {
			System.out.println("game win!!");
			return true;
		} else {
			return false;
		}
	}

	public static boolean game_lose() {
		int[] monster_local = new int[2];
		monster_local = Monster_1.getMonsterPosition();
		if (player_position[0] == monster_local[0] && player_position[1] == monster_local[1]) {
			System.out.println("Game Over!!");
			return true;
		} else {
			return false;
		}
	}
}
