package com.lesson.GameChallenge;

import java.util.Scanner;

public class App {
	public static int globalGridSize;
	
	public static void main(String[] args) {
		
		
		System.out.print("Enter Your player name to continue - ");
		Scanner name = new Scanner(System.in); // Create a Scanner object
		String player_name = name.nextLine();
		System.out.println("Welcome to the Game " + player_name + "!");
		
		System.out.print("Enter the grid size to continue (between 3 and 10) - ");
		Scanner scan = new Scanner(System.in);
		globalGridSize = scan.nextInt();
		

		
		System.out.println(globalGridSize + " - grid size initilaized");

		Player p1 = new Player(player_name);
		Treasure tres = new Treasure();
		Monster Grinch = new Monster("mon", "mons");
		Board b1 = new Board();
		
		int count = 0;

		while (Player.game_win() != true && Player.game_lose() != true) {

//			count++;
//			if (count % 3 == 0) {
//				Grinch.setMonsterPosition();
//			}
			Grinch.killPlayer();
			p1.updatePlayerPosition(globalGridSize);

			Treasure.player_distance();

		}
		name.close();
		scan.close();
		
	}

}
