package Exercise_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CreateCMD {
	File defaut;
	boolean quit = false;
	BufferedReader useIn;

	public CreateCMD(String init) {
		this.defaut = new File(init);
		this.useIn = new BufferedReader(new InputStreamReader(System.in));
	}

	public void start() throws IOException {
		// show prompt
		String line, res;
		System.out.print(getPrompt());

		while (!quit) {
			line = getCommand();

			res = exCommand(line);

			System.out.print(getPrompt());

		}

	}

	private String exCommand(String line) {
		if (line.isBlank()) {
			return "";
		}
		String res = "";
		StringTokenizer st = new StringTokenizer(line);
		String com, parament = "";
		com = st.nextToken().toUpperCase();
		if (st.hasMoreElements()) {
			parament = st.nextToken();
		}
		switch (com) {
		case "EXIT":
			quit = true;
			break;
		case "CD":
			res = change(parament);
			break;

		}
		return res;
	}

	private String change(String parament) {
		if (parament.isBlank()) {
			return defaut.getAbsolutePath();

		}
		// chuan form, luon dung con lam para.equal neu para null thi nhay exception
		if ("..".equalsIgnoreCase(parament)) {

			File parent = defaut.getParentFile();
			if (parent != null) {
				defaut = parent;
			}
		} else {
			File temp = new File(defaut, parament);
			if (temp.exists()) {
				defaut = temp;
			}
		}
		return defaut.getAbsolutePath();
	}

	private String getCommand() throws IOException {
		// noi chuoi useIn
		return useIn.readLine();
	}

	private String getPrompt() {
		return defaut.getAbsolutePath() + ">";
	}

	public static void main(String[] args) throws IOException {
		String test = "D:/Test";
		new CreateCMD(test).start();
		;
	}

}
