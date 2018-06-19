package musicPlayer;

import java.util.List;

import javazoom.jlgui.basicplayer.BasicPlayerException;

public class EndOfMusic {

	private String nextName;

	public void nextMusic(String musicName) {
		try {
			//LoopがOFFだった場合
			if (!SubButtonController.loop) {
				//ShuffleがONだった場合
				if (SubButtonController.shuffle) {
					//ShuffleONのときの処理
					nextName = nextLoopOff(PlayerController.shuffleMusicList, musicName);
				}
				else {
					//LoopOFFの時の処理
					nextName = nextLoopOff(PlayerController.musicList, musicName);
				}
				//取得した名前でインスタンスを生成
				PlayerController.music = new MusicManagement(nextName);
			}
			//再生
			PlayerController.music.playMusic();
			System.out.println(nextName);

		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	private String nextLoopOff(List<String> musicList, String musicName) throws BasicPlayerException {
		int index;
		String nextName;

		//現在再生している音楽の番号を取得
		index = musicList.indexOf(musicName);
		//最後の音楽だった場合は、0番目
		if (index + 1 == musicList.size()) {
			nextName = musicList.get(0);
		}
		//それ以外の場合は、次の音楽の名前を取得
		else {
			nextName = musicList.get(index + 1);
		}

		return nextName;
	}

}
