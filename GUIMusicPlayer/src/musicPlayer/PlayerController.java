package musicPlayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class PlayerController {

	@FXML private Button playButton, pauseButton, resumeButton, stopButton;
	@FXML private ListView<String> musicList;

	@FXML
	private void initialize() {
		FileManagement filemanage = new FileManagement();
		int number = filemanage.musicNumber();

		for (int i = 0; i < number; i++) {
			musicList.getItems().add(filemanage.musicName(i));
		}
	}


	@FXML
	private void playMusic() throws BasicPlayerException {
		String musicName = musicList.getSelectionModel().getSelectedItem();

		MusicManagement music = new MusicManagement(musicName);

		music.playMusic();
	}

	@FXML
	private void pauseMusic() throws BasicPlayerException {

	}

	@FXML
	private void resumeMusic() throws BasicPlayerException {

	}

	@FXML
	private void stopMusic() throws BasicPlayerException {

	}
}
