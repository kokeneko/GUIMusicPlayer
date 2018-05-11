package musicPlayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class PlayerController {

	@FXML private Button playButton;
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
	private void playMusic() {
		String musicName = musicList.getSelectionModel().getSelectedItem();

		MusicManagement music = new MusicManagement();

		music.playMusic(musicName);
	}
}
