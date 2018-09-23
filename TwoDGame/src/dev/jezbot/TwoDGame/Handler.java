package dev.jezbot.TwoDGame;

import dev.jezbot.TwoDGame.Game.Game;
import dev.jezbot.TwoDGame.gfx.GameCamera;
import dev.jezbot.TwoDGame.input.KeyManager;
import dev.jezbot.TwoDGame.worlds.World;

public class Handler {

	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
public int getWidth() {
	return game.getWidth();
}

public int getHeight() {
	return game.getHeight();
}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
