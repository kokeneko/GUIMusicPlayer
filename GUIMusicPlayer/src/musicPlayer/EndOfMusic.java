package musicPlayer;

import javazoom.jlgui.basicplayer.BasicPlayerException;

public class EndOfMusic {

	private int index;
	private String nextName;

	public void nextMusic(String musicName) {
		try {
			if (!SubButtonController.loop) {
				index = PlayerController.musicList.indexOf(musicName);
				if (index + 1 == PlayerController.musicList.size()) {
					nextName = PlayerController.musicList.get(0);
				}
				else {
					nextName = PlayerController.musicList.get(index + 1);
				}

				PlayerController.music = new MusicManagement(nextName);
			}

			PlayerController.music.playMusic();

		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}
}
