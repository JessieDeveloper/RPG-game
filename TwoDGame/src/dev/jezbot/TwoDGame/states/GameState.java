package dev.jezbot.TwoDGame.states;

import java.awt.Graphics;

import dev.jezbot.TwoDGame.Handler;
import dev.jezbot.TwoDGame.Entity.Creature.Player;
import dev.jezbot.TwoDGame.Game.Game;
import dev.jezbot.TwoDGame.gfx.Assets;
import dev.jezbot.TwoDGame.tile.Tile;
import dev.jezbot.TwoDGame.worlds.World;

public class GameState extends States{

	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler,"res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100,100);
	
	
	}
	@Override
	public void tick() {
		world.tick();
	player.tick();
	
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	
	}

}
