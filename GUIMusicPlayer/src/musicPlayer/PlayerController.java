package musicPlayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class PlayerController {

	@FXML private Button playButton, pauseButton, resumeButton, stopButton;
	@FXML private ListView<String> musicList;

	public static MusicManagement music;

	@FXML
	private void initialize() throws BasicPlayerException {
		FileManagement filemanage = new FileManagement();
		int number = filemanage.musicNumber();

		for (int i = 0; i < number; i++) {
			musicList.getItems().add(filemanage.musicName(i));
		}

		music = new MusicManagement();
	}


	@FXML
	private void playMusic() throws BasicPlayerException {

		if (music.musicStatus == BasicPlayer.PLAYING) {
			music.stopMusic();
		}

		String musicName = musicList.getSelectionModel().getSelectedItem();

		music = new MusicManagement(musicName);

		music.playMusic();
	}

	@FXML
	private void pauseMusic() throws BasicPlayerException {
		music.pauseMusic();
	}

	@FXML
	private void resumeMusic() throws BasicPlayerException {
		music.resumeMusic();
	}

	@FXML
	private void stopMusic() throws BasicPlayerException {
		music.stopMusic();
	}
}
