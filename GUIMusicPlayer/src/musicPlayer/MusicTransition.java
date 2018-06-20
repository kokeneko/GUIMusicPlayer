package musicPlayer;

import java.util.List;

import javazoom.jlgui.basicplayer.BasicPlayerException;

public class MusicTransition {

	private String nextName;

	public void musicTransition(String musicName, String status) throws BasicPlayerException {
		//shuffleがONの場合
		if (SubButtonController.shuffle) {
			switch (status) {
				//次の曲
				case "NEXT" : nextName = nextMusic(PlayerController.shuffleMusicList, musicName); break;
				//前の曲
				case "PREVIOUS" : nextName = previousMusic(PlayerController.shuffleMusicList, musicName); break;
			}
		}
		//shuffleがOFFの場合
		else {
			switch (status) {
				//次の曲
				case "NEXT" : nextName = nextMusic(PlayerController.musicList, musicName); break;
				//前の曲
				case "PREVIOUS" : nextName = previousMusic(PlayerController.musicList, musicName); break;
			}
		}

		//取得した名前でインスタンスを生成
		PlayerController.music = new MusicManagement(nextName);
		//再生
		PlayerController.music.playMusic();

	}

	private String nextMusic(List<String> musicList, String musicName) throws BasicPlayerException {
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

	private String previousMusic(List<String> musicList, String musicName) throws BasicPlayerException {
		int index;
		String nextName;

		//現在再生している音楽の番号を取得
		index = musicList.indexOf(musicName);
		//最初の音楽だった場合は、最後、
		if (index == 0) {
			nextName = musicList.get(musicList.size() - 1);
		}
		//それ以外の場合は、前の音楽の名前を取得
		else {
			nextName = musicList.get(index - 1);
		}

		return nextName;
	}

}
