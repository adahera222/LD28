package com.ld28.controls;

import org.lwjgl.input.Keyboard;

import com.ld28.entity.EntityPlayer;
import com.ld28.handler.GameHandler;
import com.ld28.input.Input;
import com.ld28.menu.PauseMenu;
import com.ld28.tile.Tile;

public class GameControls implements Controls {

	private GameHandler game;
	
	public GameControls(GameHandler game) {
		
		this.game = game;
	}

	@Override
	public void check() {
		
		if (Input.isKeyDown(Keyboard.KEY_D) && !game.level.isKeyPressed(Keyboard.KEY_D)) {
			
			game.player.accelerateXTo(EntityPlayer.MAX_SPEED);
			game.player.accelerateYTo(0);
		}
		
		else if (Input.isKeyDown(Keyboard.KEY_A) && !game.level.isKeyPressed(Keyboard.KEY_A)) {
			
			game.player.accelerateXTo(-EntityPlayer.MAX_SPEED);
			game.player.accelerateYTo(0);
		}
		
		else if (Input.isKeyDown(Keyboard.KEY_W) && !game.level.isKeyPressed(Keyboard.KEY_W)) {
			
			game.player.accelerateYTo(-EntityPlayer.MAX_SPEED);
			game.player.accelerateXTo(0);
		}
		
		else if (Input.isKeyDown(Keyboard.KEY_S) && !game.level.isKeyPressed(Keyboard.KEY_S)) {
			
			game.player.accelerateYTo(EntityPlayer.MAX_SPEED);
			game.player.accelerateXTo(0);
		}
		else {
			
			game.player.accelerateYTo(0);
			game.player.accelerateXTo(0);
		}
		
		if (Input.isKeyDown(Keyboard.KEY_LSHIFT) && game.getCurrentLevel() == 6) {
			
			if (Input.isKeyDown(Keyboard.KEY_LCONTROL)) {
				if (Input.isKeyDown(Keyboard.KEY_TAB)) {
					if (Input.isKeyPressed(Keyboard.KEY_T)) {
						
						game.player.x = 24 * Tile.SIZE + Tile.SIZE / 2;
					}
				}
			}
		}
		
		if (Input.isKeyPressed(Keyboard.KEY_ESCAPE)) {
			
			game.enterMenu(new PauseMenu(game));
		}
		
		if (Input.isKeyPressed(Keyboard.KEY_SPACE) && !game.level.isKeyPressed(Keyboard.KEY_SPACE)) {
			
			game.player.fire();
		}
		
		if (Input.isKeyReleased(Keyboard.KEY_D)) {
			
			game.level.setKeyPressed(Keyboard.KEY_D);
		}
		
		if (Input.isKeyReleased(Keyboard.KEY_A)) {
			
			game.level.setKeyPressed(Keyboard.KEY_A);
		}

		if (Input.isKeyReleased(Keyboard.KEY_S)) {
			
			game.level.setKeyPressed(Keyboard.KEY_S);
		}
		
		if (Input.isKeyReleased(Keyboard.KEY_W)) {
			
			game.level.setKeyPressed(Keyboard.KEY_W);
		}
		
		if (Input.isKeyReleased(Keyboard.KEY_SPACE)) {
			
			game.level.setKeyPressed(Keyboard.KEY_SPACE);
		}
	}
}
