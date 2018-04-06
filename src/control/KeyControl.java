package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.entity.Joueur;

public class KeyControl implements KeyListener {

	private Joueur player;
	
	public KeyControl(Joueur j) {
		this.player = j;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_Z:
				this.player.top = true;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				this.player.bot = true;
				break;
			case KeyEvent.VK_Q:
			case KeyEvent.VK_LEFT:
				this.player.left = true;
				break;
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				this.player.right = true;
				break;
			case KeyEvent.VK_SPACE:
				this.player.jump();
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_Z:
				this.player.top = false;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				this.player.bot = false;
				break;
			case KeyEvent.VK_Q:
			case KeyEvent.VK_LEFT:
				this.player.left = false;
				break;
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				this.player.right = false;
				break;
	}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
