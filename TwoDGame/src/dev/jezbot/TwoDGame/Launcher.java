package dev.jezbot.TwoDGame;

import dev.jezbot.TwoDGame.Display.Display;
import dev.jezbot.TwoDGame.Game.Game;

public class Launcher {
	
	public static void main(String[] args) {
		Game game = new Game("Title!",640,320);
		game.start();
	}
}
