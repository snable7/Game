package gameProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GGame extends Thread {
	
	private Image jugementImage = new ImageIcon(GameDriver.class.getResource("/Images/juImage.png")).getImage();
	private Image gameInfoImage = new ImageIcon(GameDriver.class.getResource("/Images/GameInfo.png")).getImage();
	private Image noteRouteUPImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRoute.png")).getImage();
	private Image noteRouteDOWNImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRoute.png")).getImage();
	private Image noteRouteRIGHTImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRoute.png")).getImage();
	private Image noteRouteLEFTImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRoute.png")).getImage();

	private Image noteRouteLineImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRouteLine.png")).getImage();
	
	private String titleName;
	private String MusicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public GGame(String titleName, String MusicTitle) {
		this.titleName = titleName;
		this.MusicTitle = MusicTitle;
		gameMusic = new Music(this.MusicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteLEFTImage, 434, 30, null);
		g.drawImage(noteRouteUPImage, 538, 30, null);
		g.drawImage(noteRouteDOWNImage, 642, 30, null);
		g.drawImage(noteRouteRIGHTImage, 746, 30, null);
		
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(jugementImage, 0, 580, null);

		g.drawImage(noteRouteLineImage, 430, 30, null);
		g.drawImage(noteRouteLineImage, 534, 30, null);
		g.drawImage(noteRouteLineImage, 638, 30, null);
		g.drawImage(noteRouteLineImage, 742, 30, null);
		g.drawImage(noteRouteLineImage, 846, 30, null);
		
		for(int i = 0; i<noteList.size();i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		
		g.setColor(Color.WHITE);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.setColor(Color.DARK_GRAY);
		g.drawString("ก็", 474, 609);
		g.drawString("ก่", 578, 609);
		g.drawString("ก้", 682, 609);
		g.drawString("กๆ", 786, 609);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(GameDriver.SCORE.toString(), 565, 702);
		
	}
	
	public void pressUP() {
		judge("UP");
		noteRouteUPImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRouted.png")).getImage();
	}
	public void releseUP() {
		noteRouteUPImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRoute.png")).getImage();
	}
	public void pressDOWN() {
		judge("DOWN");
		noteRouteDOWNImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRouted.png")).getImage();
	}
	public void releseDOWN() {
		noteRouteDOWNImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRoute.png")).getImage();
	}
	public void pressRIGHT() {
		judge("RIGHT");
		noteRouteRIGHTImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRouted.png")).getImage();
	}
	public void releseRIGHT() {
		noteRouteRIGHTImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRoute.png")).getImage();
	}
	public void pressLEFT() {
		judge("LEFT");
		noteRouteLEFTImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRouted.png")).getImage();
	}
	public void releseLEFT() {
		noteRouteLEFTImage = new ImageIcon(GameDriver.class.getResource("/Images/NoteRoute.png")).getImage();
	}
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null; 
		if(titleName.equals("JingleBell")) {
			int startTime = 1000 -  GameDriver.REACH_TIME*1000;
			int gap = 500;
			int gap2 = 1000;
			int gap4 = 100;
			beats = new Beat[] {
						new Beat(startTime + 9000, "UP"),
						new Beat(9500 + gap * 1, "LEFT"),
						new Beat(9500 + gap * 2, "DOWN"),
						new Beat(9500 + gap * 3, "UP"),
						new Beat(9500 + gap * 4, "UP"),
						new Beat(9500 + gap * 5, "RIGHT"),
						new Beat(9500 + gap * 6, "DOWN"),
						new Beat(9500 + gap * 7, "UP"),
						new Beat(9500 + gap * 8, "RIGHT"),
						new Beat(9500 + gap * 9, "UP"),
						new Beat(9500 + gap * 10, "LEFT"),
						new Beat(9500 + gap * 11, "DOWN"),
						new Beat(9500 + gap * 12, "DOWN"),
						new Beat(9500 + gap * 13, "UP"),
						new Beat(9500 + gap * 14, "RIGHT"),
						new Beat(9500 + gap * 15, "UP"),
						new Beat(9500 + gap * 16, "LEFT"),
						new Beat(9500 + gap * 17, "UP"),
						new Beat(9500 + gap * 18, "RIGHT"),
						new Beat(9500 + gap * 19, "UP"),
						new Beat(9500 + gap * 20, "DOWN"),
						new Beat(9500 + gap * 21, "LEFT"),
						new Beat(9500 + gap * 22, "DOWN"),
						new Beat(9500 + gap * 23, "UP"),
						new Beat(9500 + gap * 24, "UP"),
						new Beat(9500 + gap * 25, "RIGHT"),
						new Beat(9500 + gap * 26, "DOWN"),
						new Beat(9500 + gap * 27, "UP"),
						new Beat(9500 + gap * 28, "RIGHT"),
						new Beat(9500 + gap * 29, "UP"),
						new Beat(9500 + gap * 30, "LEFT"),
						new Beat(9500 + gap * 31, "DOWN"),
						new Beat(9500 + gap * 32, "DOWN"),
						new Beat(9500 + gap * 33, "UP"),
						new Beat(9500 + gap * 34, "RIGHT"),
						new Beat(9500 + gap * 35, "UP"),
						new Beat(9500 + gap * 36, "LEFT"),
						new Beat(9500 + gap * 37, "UP"),
						new Beat(9500 + gap * 38, "RIGHT"),
						new Beat(9500 + gap * 39, "UP"),
						new Beat(9500 + gap * 40, "DOWN"),
						new Beat(9500 + gap * 41, "LEFT"),
						new Beat(9500 + gap * 42, "DOWN"),
						new Beat(9500 + gap * 43, "UP"),
						new Beat(9500 + gap * 44, "UP"),
						new Beat(9500 + gap * 45, "RIGHT"),
						new Beat(9500 + gap * 46, "DOWN"),
						new Beat(9500 + gap * 47, "UP"),
						new Beat(9500 + gap * 48, "RIGHT"),
						new Beat(9500 + gap * 49, "UP"),
						new Beat(9500 + gap * 50, "LEFT"),
						new Beat(9500 + gap * 51, "DOWN"),
						new Beat(9500 + gap * 52, "DOWN"),
						new Beat(9500 + gap * 53, "UP"),
						new Beat(9500 + gap * 54, "RIGHT"),
						new Beat(9500 + gap * 55, "UP"),
						new Beat(9500 + gap * 56, "LEFT"),
						new Beat(9500 + gap * 57, "UP"),
						new Beat(9500 + gap * 58, "RIGHT"),
						new Beat(9500 + gap * 59, "UP"),
						new Beat(9500 + gap * 60, "DOWN"),
						new Beat(9500 + gap * 61, "UP"),
						new Beat(9500 + gap * 62, "RIGHT"),
						new Beat(9500 + gap * 63, "UP"),
						new Beat(9500 + gap * 64, "DOWN"),
						new Beat(9500 + gap * 65, "DOWN"),
						new Beat(42000 + gap2 * 1, "UP"),
						new Beat(42000 + gap2 * 2, "LEFT"),
						new Beat(42000 + gap2 * 3, "DOWN"),
						new Beat(42000 + gap2 * 4, "UP"),
						new Beat(42000 + gap2 * 5, "DOWN"),
						new Beat(42000 + gap2 * 6, "RIGHT"),
						new Beat(42000 + gap2 * 7, "UP"),
						new Beat(42000 + gap2 * 8, "LEFT"),
						new Beat(42000 + gap2 * 9, "LEFT"),
						new Beat(42000 + gap2 * 10, "DOWN"),
						new Beat(42000 + gap2 * 11, "UP"),
						new Beat(42000 + gap2 * 12, "RIGHT"),
						new Beat(42000 + gap2 * 13, "UP"),
						new Beat(42000 + gap2 * 14, "LEFT"),
						new Beat(42000 + gap2 * 15, "UP"),
						new Beat(42000 + gap2 * 16, "RIGHT"),
						new Beat(42000 + gap2 * 17, "UP"),
						new Beat(42000 + gap2 * 18, "LEFT"),
						new Beat(42000 + gap2 * 19, "DOWN"),
						new Beat(42000 + gap2 * 20, "LEFT"),
						new Beat(42000 + gap2 * 21, "UP"),
						new Beat(42000 + gap2 * 22, "UP"),
						new Beat(42000 + gap2 * 23, "DOWN"),
						new Beat(42000 + gap2 * 24, "UP"),
						new Beat(42000 + gap2 * 25, "RIGHT"),
						new Beat(42000 + gap2 * 26, "UP"),
						new Beat(42000 + gap2 * 27, "RIGHT"),
						new Beat(42000 + gap2 * 28, "UP"),
						new Beat(42000 + gap2 * 29, "LEFT"),
						new Beat(42000 + gap2 * 30, "RIGHT"),
						new Beat(42000 + gap2 * 31, "LEFT"),
						new Beat(42000 + gap2 * 32, "UP"),
						new Beat(74000 + gap * 1, "DOWN"),
						new Beat(74000 + gap * 2, "UP"),
						new Beat(74000 + gap * 3, "DOWN"),
						new Beat(74000 + gap * 4, "UP"),
						new Beat(74000 + gap * 5, "LEFT"),
						new Beat(74000 + gap * 6, "UP"),
						new Beat(74000 + gap * 7, "RIGHT"),
						new Beat(74000 + gap * 8, "LEFT"),
						new Beat(74000 + gap * 9, "UP"),
						new Beat(74000 + gap * 10, "DOWN"),
						new Beat(74000 + gap * 11, "DOWN"),
						new Beat(74000 + gap * 12, "UP"),
						new Beat(74000 + gap * 13, "DOWN"),
						new Beat(74000 + gap * 14, "UP"),
						new Beat(74000 + gap * 15, "LEFT"),
						new Beat(74000 + gap * 16, "UP"),
						new Beat(74000 + gap * 17, "RIGHT"),
						new Beat(74000 + gap * 18, "LEFT"),
						new Beat(74000 + gap * 19, "UP"),
						new Beat(74000 + gap * 20, "DOWN"),						
						new Beat(74000 + gap * 21, "DOWN"),
						new Beat(74000 + gap * 22, "UP"),
						new Beat(74000 + gap * 23, "DOWN"),
						new Beat(74000 + gap * 24, "UP"),
						new Beat(74000 + gap * 25, "LEFT"),
						new Beat(74000 + gap * 26, "UP"),
						new Beat(74000 + gap * 27, "RIGHT"),
						new Beat(74000 + gap * 28, "LEFT"),
						new Beat(74000 + gap * 29, "UP"),
						new Beat(74000 + gap * 30, "DOWN"),
						new Beat(74000 + gap * 31, "UP"),
						new Beat(74000 + gap * 32, "RIGHT"),
						new Beat(74000 + gap * 33, "UP"),
						new Beat(74000 + gap * 34, "LEFT"),
						new Beat(74000 + gap * 35, "RIGHT"),
						new Beat(91500 + gap4 * 1, "DOWN"),
						new Beat(91500 + gap4 * 2, "UP"),
						new Beat(91500 + gap4 * 3, "DOWN"),
						new Beat(91500 + gap4 * 4, "RIGHT"),
						new Beat(91500 + gap4 * 5, "UP"),
						new Beat(91500 + gap4 * 6, "DOWN")
						
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.gettime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i= 0; i< noteList.size();i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
}
