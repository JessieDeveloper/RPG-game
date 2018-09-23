package dev.jezbot.TwoDGame.tile;

import java.awt.image.BufferedImage;

import dev.jezbot.TwoDGame.gfx.Assets;

public class RockTile extends Tile{

	public RockTile( int id) {
		super(Assets.stone, id);
	
	}
	
	public boolean isSolid() {
		return true;
	}

}
