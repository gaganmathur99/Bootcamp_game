package com.lesson.GameChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.println("Enter Your player name to continue - ");
		Scanner name = new Scanner(System.in); // Create a Scanner object
		String player_name = name.nextLine();
		System.out.println("Welcome to the Game " + player_name + "!");
		int grid_size=5;
		
		
		player p1 = new player(player_name);

		int[] test = p1.getposition();
		// System.out.println( "Grr x position " + test[0] + " Grr y position " +
		// test[1] );
		// System.out.println( test[0] );
		// getposition
		// game start_game = new game("game");

		treasure tres = new treasure();
		// int[] test2 = tres.getTreasurePosition();
		// System.out.println( "Treasure x position " + test2[0] + " Treasure y position
		// " + test2[1] );

		Monster_1 Grinch = new Monster_1("Grinch",
				"You're gonna die! I'm going to throw up, and then You're gonna die!");
//		Monster_1 frank = new Monster_1("frank",
//				"You're gonna die! I'm going to throw up, and then You're gonna die!");
		// int[] test3 = Grinch.getMonsterPosition();
		// System.out.println( "Monster x position " + test3[0] + " Monster y position "
		// + test3[1] );

		 Board b1 = new Board();
		// Board.updateBoard(test,test2,test3);
//
//		while (player.game_win() != true && player.game_lose() != true) {
//			treasure.player_distance();
//			p1.updatePlayerPosition(grid_size);
//			// b1.updateBoard(player.getposition(),
//			// treasure.getTreasurePosition(),Monster_1.getMonsterPosition());
//			// treasure.player_distance();
//		}
		
		stats s1 = new stats();
		
		//s1.setcharactersinGame("player",p1.getposition());
		
		System.out.println( Arrays.equals(p1.getposition(),Monster_1.getMonsterPosition() ));
		s1.newCharacter("c1", 5);
		s1.newCharacter("c2", 5);
		s1.newCharacter("c3", 5);
		s1.getcharactersinGame();
	}
}
