package musicPlayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class PlayerController {

	//subButtonのコントローラ
	@FXML private AnchorPane subButton;
	@FXML private SubButtonController subButtonController;

	@FXML private ListView<String> musicList;
	@FXML private Button mainButton;

	public static MusicManagement music;
	String newMusicName, nowMusicName;

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
	private void mainButtonAction() throws BasicPlayerException {
		newMusicName = musicList.getSelectionModel().getSelectedItem();

		switch (music.musicStatus) {
			case BasicPlayer.PLAYING : {
				if (newMusicName.equals(nowMusicName)) {
					music.pauseMusic();
				}
				else {
					music.stopMusic();
					nowMusicName = newMusicName;
					music = new MusicManagement(nowMusicName);
					music.playMusic();
				}
				break;
			}
			case BasicPlayer.PAUSED : {
				if (newMusicName.equals(nowMusicName)) {
					music.resumeMusic();
				}
				else {
					nowMusicName = newMusicName;
					music = new MusicManagement(nowMusicName);
					music.playMusic();
				}
				break;
			}
			case BasicPlayer.STOPPED : {
				nowMusicName = newMusicName;
				music = new MusicManagement(nowMusicName);
				music.playMusic();
				break;
			}
		}
	}
}
