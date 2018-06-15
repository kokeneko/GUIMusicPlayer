package musicPlayer;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class SubButtonController {

	@FXML private ToggleButton loopToggle, shuffleToggle;
	@FXML private Slider volumeBar = new Slider(0, 100, 50);
	@FXML private Slider seekBar;
	@FXML private Text volumeText;

	public static boolean loop, shuffle;
	public static double volume;

	@FXML
	private void initialize() {
		loop = false;
		shuffle = false;
		volumeBar.adjustValue(50.0);
	}

	@FXML
	private void loopToggle() {
		if (loopToggle.isSelected()) {
			loopToggle.setText("loopON");
			loop = true;
		}
		else {
			loopToggle.setText("loopOFF");
			loop = false;
		}
	}

	@FXML
	private void shuffleToggle() {

	}

	@FXML
	public void getVolume() throws BasicPlayerException {
		volume = volumeBar.getValue() / 100;
		MusicManagement.player.setGain(volume);
		if (volume == 0) {
			volumeText.setText("🔇");
		}
		else {
			volumeText.setText("🔊");
		}
	}

}