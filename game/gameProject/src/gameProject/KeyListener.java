package gameProject;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	@Override
	public void keyPressed(KeyEvent e) {
		if(Game.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Game.game.pressUP();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Game.game.pressRIGHT();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Game.game.pressLEFT();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Game.game.pressDOWN();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Game.game.releseUP();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Game.game.releseRIGHT();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Game.game.releseLEFT();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
	
		}Game.game.releseDOWN();
	}
}
