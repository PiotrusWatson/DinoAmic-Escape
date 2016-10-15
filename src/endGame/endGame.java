package endGame;

import java.io.*;
import java.util.*;

public class endGame {

	public static void finish(String score) {

		// Initialising variables and files
		String userScore = score;
		//String userScore = "2800";

		List<String[]> scores = new ArrayList<String[]>();
		List<String[]> sortedScores = new ArrayList<String[]>();

		String fileName = "src/res/highScores.txt";
		String line = null;
		String printLeaderboard;

		// try and except to input the highscore from a .txt file and outputs it
		// to a list of arrays.
		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			line = bufferedReader.readLine();
			while (line != null) {
				String[] splitList = line.split(",");
				scores.add(splitList);

				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

		// This should sort the array in ascending order, by sorting the list
		// and appending to another list.
		int iniSize = scores.size();
		for (int p = 0; p < iniSize; p++) {
			int largestValue = Integer.parseInt(scores.get(p)[1]);
			int largestIndex = p;
			for (int q = 0; q < scores.size(); q++) {
				if (largestValue < Integer.parseInt(scores.get(q)[1])) {
					largestValue = Integer.parseInt(scores.get(q)[1]);
					largestIndex = q;

				}
			}
			String lvString = Integer.toString(largestValue);
			String[] tempList = { scores.get(largestIndex)[0], lvString };
			scores.get(largestIndex)[1] = "-1";
			sortedScores.add(tempList);
		}

		// this prints the leaderboard with a maximum of 10 entries.
		System.out.println("Name " + "Score" + "\n");
		int outputLength;
		if (sortedScores.size() > 10) {
			outputLength = 10;
		} else {
			outputLength = sortedScores.size();
		}

		for (int i = 0; i < outputLength; i++) {
			printLeaderboard = sortedScores.get(i)[0] + " " + sortedScores.get(i)[1] + "\n";
			System.out.println(printLeaderboard);
		}

		// Allows the user to enter their username.
		Scanner standardInput = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String userName = standardInput.nextLine();
		standardInput.close();

		// the username and score are then appended onto the leaderboard
		String[] appendArray = { userName, userScore };
		sortedScores.add(appendArray);

		// this try and except writes the list of arrays back to a .txt file.
		try {
			File file = new File("src/res/highScores.txt");

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (int k = 0; k < sortedScores.size(); k++) {
				String outputString = sortedScores.get(k)[0] + "," + sortedScores.get(k)[1];
				bw.write(outputString);
				bw.newLine();
			}

			System.out.println("Done");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	}
