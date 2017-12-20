 package gameProject;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(GameDriver.class.getResource("/Images/Exit2.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(GameDriver.class.getResource("/Images/Exit1.png"));
	private ImageIcon startButtonImage = new ImageIcon(GameDriver.class.getResource("/Images/StartButton.png"));
	private ImageIcon quitButtonImage = new ImageIcon(GameDriver.class.getResource("/Images/QuitButton.png"));
	private ImageIcon gameStartButtonImage = new ImageIcon(GameDriver.class.getResource("/Images/button.png"));
	private ImageIcon backButtonImage = new ImageIcon(GameDriver.class.getResource("/Images/BackButton.png"));
	private ImageIcon EndButtonImage = new ImageIcon(GameDriver.class.getResource("/Images/EndButton.png"));


	private Image ScorebackGround = new ImageIcon(GameDriver.class.getResource("/Images/ScorebackGround.png")).getImage();
	private Image backGround = new ImageIcon(GameDriver.class.getResource("/Images/image1.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(GameDriver.class.getResource("/Images/MenuBar.png")));
	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonImage);
	private JButton quitButton = new JButton(quitButtonImage);
	private JButton gameStartButton = new JButton(gameStartButtonImage);
	private JButton backButton = new JButton(backButtonImage);
	private JButton EndButton = new JButton(EndButtonImage);

	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	private boolean isEndScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("TeaWalk.mp3", true);
	private int nowSelected = 0;
	
	public static GGame game;
	
	public Game() {
		trackList.add(new Track("title.png", "image3.jpg", "image4.jpg", "JingleBell.mp3", "JingleBell.mp3", "JingleBell"));
		
		setUndecorated(true);
		setTitle("Rythm Game");
		setSize(GameDriver.WIDTH, GameDriver.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListener());

		introMusic.start();
				
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Pressed.mp3",false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				};
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(40, 330, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Pressed.mp3",false);
				buttonEnteredMusic.start();
				introMusic.close();
				enterMain();
			}
		});
		add(startButton);
		
		quitButton.setBounds(40, 460, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Pressed.mp3",false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				};
				System.exit(0);
			}
		});
		add(quitButton);
		
		gameStartButton.setVisible(false);
		gameStartButton.setBounds(515, 580, 250, 67);
		gameStartButton.setBorderPainted(false);
		gameStartButton.setContentAreaFilled(false);
		gameStartButton.setFocusPainted(false);
		gameStartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gameStartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gameStartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected);
			}
		});
		add(gameStartButton);

		backButton.setVisible(false);
		backButton.setBounds(20, 50, 40, 40);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		add(backButton);
		
		EndButton.setVisible(false);
		EndButton.setBounds(60, 50, 40, 40);
		EndButton.setBorderPainted(false);
		EndButton.setContentAreaFilled(false);
		EndButton.setFocusPainted(false);
		EndButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				EndButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				EndButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				gameEnd(nowSelected);
			}
		});
		add(EndButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
	}

	public void paint(Graphics g) {
		screenImage = createImage(GameDriver.WIDTH, GameDriver.HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(backGround, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 20, null);
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		if(isEndScreen) {
			g.drawImage(ScorebackGround, 490, 100, null);
			g.setColor(Color.BLACK);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString(GameDriver.SCORE.toString() + " / 76", 600, 165);	
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		isEndScreen = false;
		titleImage = new ImageIcon(GameDriver.class.getResource("/Images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(GameDriver.class.getResource("/Images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();

	}
	
	public void gameStart(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		gameStartButton.setVisible(false);
		backGround = new ImageIcon(GameDriver.class.getResource("/Images/" + trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		EndButton.setVisible(true);
		isGameScreen = true;
		game = new GGame(trackList.get(nowSelected).gettitleName(), trackList.get(nowSelected).getgameMusic());
		game.start();
		setFocusable(true);
		GameDriver.SCORE = 0;
	}
	
	public void backMain() {
		isMainScreen = true;
		gameStartButton.setVisible(true);
		backGround = new ImageIcon(GameDriver.class.getResource("/Images/image2.jpg")).getImage();
		backButton.setVisible(false);
		EndButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
	}
	
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		backGround = new ImageIcon(GameDriver.class.getResource("/Images/image2.jpg")).getImage();
		isMainScreen = true;
		gameStartButton.setVisible(true);
		introMusic.close();
		selectTrack(0);

	}
	
	public void gameEnd(int nowSelected) {
		game.close();
		backGround = new ImageIcon(GameDriver.class.getResource("/Images/image5.jpg")).getImage();
		backButton.setVisible(false);
		EndButton.setVisible(false);
		isGameScreen = false;
		isEndScreen = true;
		startButton.setVisible(true);
		quitButton.setVisible(true);

	}
}