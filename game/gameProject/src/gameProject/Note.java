 package gameProject;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteImage = new ImageIcon(GameDriver.class.getResource("/Images/Note.png")).getImage();
	private int x, y = 580 - (1000 / GameDriver.SLEEP_TIME * GameDriver.NOTE_SPEED) * GameDriver.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("LEFT")) {
			x = 434;
		}
		else if(noteType.equals("UP")) {
			x = 538;
		}
		else if(noteType.equals("DOWN")) {
			x = 642;
		}
		else if(noteType.equals("RIGHT")) {
			x = 746;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteImage,x, y, null);
	}
	
	public void drop() {
		y += GameDriver.NOTE_SPEED;
		if(y>620) {
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(GameDriver.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void judge() {
		if(y <= 613 && y >= 550) {
			GameDriver.SCORE++;
			close();
		}
	}
}
