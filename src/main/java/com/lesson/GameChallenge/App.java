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

		player p1 = new player(player_name);

		treasure tres = new treasure();
		Monster_1 Grinch = new Monster_1("mon", "mons");
		Board b1 = new Board();
		
		b1.setBoard();

		while (player.game_win() != true && player.game_lose() != true) {


			p1.updatePlayerPosition(globalGridSize);

			treasure.player_distance();

		}
		name.close();
		scan.close();
		
	}

}
