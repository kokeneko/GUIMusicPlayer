package musicPlayer;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

public class SubButtonController {

	@FXML private ToggleButton loopToggle, shuffleToggle;

	public static boolean loop, shuffle;

	@FXML
	private void initialize() {
		loop = false;
		shuffle = false;
	}

	@FXML
	private void toggle() {
		if (loopToggle.isSelected()) {
			loopToggle.setText("loopON");
			loop = true;
		}
		else {
			loopToggle.setText("loopOFF");
			loop = false;
		}
	}

	public boolean loop() {

		return loop;
	}



}