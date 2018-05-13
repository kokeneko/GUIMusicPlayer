package musicPlayer;

import java.io.File;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class MusicManagement {

	BasicPlayer player;

	//曲名を受け取ってインスタンスを生成
	public MusicManagement(String name) throws BasicPlayerException {
		System.out.println(name);

		player = new BasicPlayer();
		File file = new File(".\\src\\Music\\" + name);

		player.open(file);

		player.play();
	}

	//再生
	public void playMusic() throws BasicPlayerException {
		player.play();
	}
	//一時停止
	private void pauseMusic() throws BasicPlayerException {
		player.pause();
	}
	//再開
	private void resumeMusic() throws BasicPlayerException {
		player.resume();
	}
	//停止
	private void stopMusic() throws BasicPlayerException {
		player.resume();
	}



}
