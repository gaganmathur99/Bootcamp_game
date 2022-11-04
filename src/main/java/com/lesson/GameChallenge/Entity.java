package com.lesson.GameChallenge;

public class Entity {
	
	Monster monster = new Monster("","");
	Player player = new Player();
	Treasure treasure = new Treasure();
	
	public Entity(String player_name) {
		// TODO Auto-generated constructor stub
		
		System.out.print("test");
	}
	
	public void getMonsterPos() {
		monster.getMonsterPosition();
	}

}
