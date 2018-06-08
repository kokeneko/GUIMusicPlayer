package musicPlayer;

import java.io.File;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class MusicManagement {

	public static BasicPlayer player;
	public int musicStatus = BasicPlayer.STOPPED;

	//曲名を受け取ってインスタンスを生成
	public MusicManagement(String name) throws BasicPlayerException {
		player = new BasicPlayer();

		//リスナーの追加
		player.addBasicPlayerListener(new BasicPlayerListener() {
			@Override
			public void opened(Object arg0, Map arg1) {}
			@Override
			public void progress(int arg0, long arg1, byte[] arg2, Map arg3) {}
			@Override
			public void setController(BasicController arg0) {}
			@Override
			public void stateUpdated(BasicPlayerEvent arg0) {
				if(arg0.getCode() == BasicPlayerEvent.EOM) {
					try {
						Thread.sleep(1); //無いと動かない
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					EndOfMusic eom = new EndOfMusic();
					eom.nextMusic(name);
				}
			}
		});
		//後でクラス分けする

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
