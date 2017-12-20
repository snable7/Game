package gameProject;
public class Track {
	private String titleImage;
	private String startImage;
	private String gameImage;
	private String startMusic;
	private String gameMusic;
	private String titleName;
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String gettitleName() {
		return titleName;
	}
	public void settitleName(String titleName) {
		this.titleName = titleName;
	}
	public String getgameMusic() {
		return gameMusic;
	}
	public void setgameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gmaeMusic, String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gmaeMusic;
		this.titleName = titleName;
	}
}
