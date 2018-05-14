package musicPlayer;

import java.io.File;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class MusicManagement {

	public static BasicPlayer player;
	public int musicStatus = 2; //STOPPED

	//曲名を受け取ってインスタンスを生成
	public MusicManagement(String name) throws BasicPlayerException {
		System.out.println(name);

		player = new BasicPlayer();
		File file = new File(".\\src\\Music\\" + name);

		player.open(file);
		musicStatus = BasicPlayer.OPENED;
		System.out.println(musicStatus);
	}

	public MusicManagement() throws BasicPlayerException {

	}

	//再生
	public void playMusic() throws BasicPlayerException {
		player.play();
		musicStatus = BasicPlayer.PLAYING;
		System.out.println(musicStatus);
	}
	//一時停止
	public void pauseMusic() throws BasicPlayerException {
		player.pause();
		musicStatus = BasicPlayer.PAUSED;
		System.out.println(musicStatus);
	}
	//再開
	public void resumeMusic() throws BasicPlayerException {
		player.resume();
		musicStatus = BasicPlayer.PLAYING;
		System.out.println(musicStatus);
	}
	//停止
	public void stopMusic() throws BasicPlayerException {
		player.stop();
		musicStatus = BasicPlayer.STOPPED;
		System.out.println(musicStatus);
	}



}
