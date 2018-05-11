package musicPlayer;

import java.io.File;

public class FileManagement {

	//Musicフォルダ内のnumber番目のファイルの名前を返す
	public String musicName(int number) {
		File file = new File(".\\src\\Music");
		String[] musicList = file.list();

		return musicList[number];
	}


	//Musicフォルダ内のファイル数を返す
	public int musicNumber() {
		File file = new File(".\\src\\Music");
		String[] musicList = file.list();

		return musicList.length;
	}

}
