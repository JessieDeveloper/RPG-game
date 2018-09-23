package dev.jezbot.TwoDGame.states;

import java.awt.Graphics;

import dev.jezbot.TwoDGame.Handler;
import dev.jezbot.TwoDGame.Game.Game;

public abstract class States {
	
	private static States currentState = null;
	

	public static void setStates(States state) {
		currentState = state;
	}
	
	public static States getStates() {
		return currentState;
	}
	//CLASS
	
	protected Handler handler;
	public States(Handler handler) {
		this.handler = handler;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
}
