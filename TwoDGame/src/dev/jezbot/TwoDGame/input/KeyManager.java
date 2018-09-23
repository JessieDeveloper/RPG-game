package dev.jezbot.TwoDGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right; //Directions for player movement; 
	
	public KeyManager() {
		//256 refers to corresponding keys on a keyboard
		keys = new boolean[256];
	}
	
	public void tick() {
		
		//If problems with keyboard input occur, check this code
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}
	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]= false;
		
		
		
	}

}
