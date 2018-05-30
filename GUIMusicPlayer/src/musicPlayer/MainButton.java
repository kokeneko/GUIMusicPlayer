package musicPlayer;

public class MainButton {

	public boolean compareMusic(String newMusic, String nowMusic) {
		boolean same = true;

		if (newMusic.equals(nowMusic)) {
			same = true;
		}
		else {
			same = false;
		}

		return same;
	}
}
