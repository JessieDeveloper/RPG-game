package dev.jezbot.TwoDGame.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.jezbot.TwoDGame.Handler;
import dev.jezbot.TwoDGame.Display.Display;
import dev.jezbot.TwoDGame.gfx.Assets;
import dev.jezbot.TwoDGame.gfx.GameCamera;
import dev.jezbot.TwoDGame.gfx.ImageLoader;
import dev.jezbot.TwoDGame.gfx.SpriteSheet;
import dev.jezbot.TwoDGame.input.KeyManager;
import dev.jezbot.TwoDGame.states.GameState;
import dev.jezbot.TwoDGame.states.MenuState;
import dev.jezbot.TwoDGame.states.States;

public class Game implements Runnable {


	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
//States
	private States gameState;
	private States menuState;
	
//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;

	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height= height;
		this.title = title;
		keyManager = new KeyManager();
		
	}
	
	private void init() {
		display = new Display (title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		handler = new Handler(this);
		//States
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		States.setStates(gameState);
		//States.setStates(gameState);
		
	}	

		private void tick () {
			
			keyManager.tick();
			
			if(States.getStates() !=null)
				States.getStates().tick();
		}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw Here!
		
		if(States.getStates() !=null)
			States.getStates().render(g);
		
	//End Drawing!
		bs.show();
		g.dispose();
	}
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				
			tick();
			render();
			ticks++;
			delta--;
			
			}
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}
	//Handler
	
	private Handler handler;
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	
	}
public synchronized void stop() {
	if(!running)
		return;
		running = false;
	try {
		thread.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
