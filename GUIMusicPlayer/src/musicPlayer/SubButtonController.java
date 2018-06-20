package musicPlayer;

import java.util.Collections;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class SubButtonController {

	@FXML private ToggleButton loopToggle, shuffleToggle;
	@FXML private Slider volumeBar = new Slider(0, 100, 50.0);
	@FXML private Slider seekBar;
	@FXML private Text volumeText;
	@FXML private Button nextButton, previousButton;

	public static boolean loop, shuffle;
	public static double volume;

	@FXML
	private void initialize() {
		loop = false;
		shuffle = false;
		volume = 0.5;
		volumeBar.adjustValue(50.0);
	}

	@FXML
	private void loopToggle() {
		if (loopToggle.isSelected()) {
			loopToggle.setText("LoopON");
			loop = true;
		}
		else {
			loopToggle.setText("LoopOFF");
			loop = false;
		}
	}

	@FXML
	private void shuffleToggle() {
		if (shuffleToggle.isSelected()) {
			//トグルボタンが押されるたびに中身をシャッフルする
			Collections.shuffle(PlayerController.shuffleMusicList);
			shuffleToggle.setText("ShuffleON");
			shuffle = true;
		}
		else {
			shuffleToggle.setText("ShuffleOFF");
			shuffle = false;
		}
	}

	@FXML
	public void getVolume() throws BasicPlayerException {
		volume = volumeBar.getValue() / 100;
		MusicManagement.player.setGain(volume);
		//ボリュームが0の場合はアイコンを変える
		if (volume == 0) {
			volumeText.setText("🔇");
		}
		else {
			volumeText.setText("🔊");
		}
	}

	@FXML
	private void nextMusic() throws BasicPlayerException {
		MusicManagement player = new MusicManagement();
		player.stopMusic();
		MusicTransition mt = new MusicTransition();
		mt.musicTransition(MusicManagement.nowMusicName, "NEXT");
	}

	@FXML
	private void previousMusic() throws BasicPlayerException {
		MusicManagement player = new MusicManagement();
		player.stopMusic();
		MusicTransition mt = new MusicTransition();
		mt.musicTransition(MusicManagement.nowMusicName, "PREVIOUS");
	}

}