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
	public static String nowMusicName;

	//曲名を受け取ってインスタンスを生成
	public MusicManagement(String name) throws BasicPlayerException {
		nowMusicName = name;
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
				//音楽が終了したとき
				if(arg0.getCode() == BasicPlayerEvent.EOM) {
					//1ミリ秒止める(無いと動かない)
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//EOMの処理
					EndOfMusic eom = new EndOfMusic();
					eom.nextMusic(name);
				}
			}
		});
		//後でクラス分けする

		File file = new File(".\\src\\Music\\" + name);

		player.open(file);
		musicStatus = BasicPlayer.OPENED;
	}

	public MusicManagement() throws BasicPlayerException {

	}

	//再生
	public void playMusic() throws BasicPlayerException {
		player.play();
		musicStatus = BasicPlayer.PLAYING;
		player.setGain(SubButtonController.volume);
	}

	//一時停止
	public void pauseMusic() throws BasicPlayerException {
		player.pause();
		musicStatus = BasicPlayer.PAUSED;
	}

	//再開
	public void resumeMusic() throws BasicPlayerException {
		player.resume();
		musicStatus = BasicPlayer.PLAYING;
	}

	//停止
	public void stopMusic() throws BasicPlayerException {
		player.stop();
		musicStatus = BasicPlayer.STOPPED;
	}

}
