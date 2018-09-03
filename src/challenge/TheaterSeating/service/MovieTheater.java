package challenge.TheaterSeating.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MovieTheater {
	int rows = 10;
	int columns = 20;
	int numberOfSeats = rows*columns;
	LinkedHashMap<String, ArrayList<String>> hm = new LinkedHashMap<>();
	String[][] seats = new String[10][20];
	int remainingSeats[] = { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20 };

	public MovieTheater() {
		// FileProcessor fileProcessor = new FileProcessor("output.txt");
	}

	public void bookSeat(String reservation) {
		String[] input = reservation.split(" ");
		String rno = input[0];
		int count = Integer.parseInt(input[1]);
		int group = count;
		if (numberOfSeats >= count) {
			if (group > 20) {
				while (group > 20) {
					allocate(rno, 20);
					group -= 20;
				}
				allocate(rno, group);
			} else {
				allocate(rno, group);
			}

		} else {
			System.out
					.println("Insufficient number of seats available for the group of "
							+ count);
		}
	}

	private void allocate(String rno, int n) {
		int count = n;
		int counter = 1;
		boolean check = true;
		int r = (rows / 2) - 1;
		while (r >= 0 && r < rows) {
			if (remainingSeats[r] >= n) {
				for (int c = 0; c < 20 && n > 0; c++) {
					if (seats[r][c] == null) {
						seats[r][c] = rno;
						if (hm.containsKey(rno)) {
							hm.get(rno).add(
									(char) (r + 65) + Integer.toString(c + 1));
						} else {
							ArrayList<String> list = new ArrayList<>();
							list.add((char) (r + 65) + Integer.toString(c + 1));
							hm.put(rno, list);
						}
						remainingSeats[r]--;
						numberOfSeats--;
						n--;
					}
				}
			}
			if (check) {
				r = r + counter;
				counter++;
				check = false;
			} else {
				r = r - counter;
				counter++;
				check = true;
			}
		}
		if (n == 0) {
			System.out.println(count + " Seats reserved for " + rno);
		} else {
			// find and allocate in the remaining seat
			counter = 1;
			check = true;
			int i = (rows / 2) - 1;
			while (i >= 0 && i < rows) {
				if (remainingSeats[i] > 0) {
					for (int j = 19; seats[i][j] == null; j--) {
						seats[i][j] = rno;
						if (hm.containsKey(rno)) {
							hm.get(rno).add(
									(char) (i + 65) + Integer.toString(j + 1));
						} else {
							ArrayList<String> list = new ArrayList<>();
							list.add((char) (i + 65) + Integer.toString(j + 1));
							hm.put(rno, list);
						}
						n--;
						numberOfSeats--;
						remainingSeats[i]--;
					}
				}
				if (check) {
					i = i + counter;
					counter++;
					check = false;
				} else {
					i = i - counter;
					counter++;
					check = true;
				}
			}
		}
	}
    public ArrayList<String> getList(int row, int columnStart, int columnEnd){
    	ArrayList<String> list = new ArrayList<>();
    	for(int c=columnStart; c<=columnEnd; c++){
    		list.add(seats[row][c]);
    	}
    	return list;
    }
	public LinkedHashMap<String, ArrayList<String>> getResults() {
		return hm;
	}

	public int getNumberOfSeats(){
		return numberOfSeats;
	}
	public void writeToFile() {
		BufferedWriter wr = null;
		try {
			wr = new BufferedWriter(new FileWriter("output.txt"));
			Iterator<Entry<String, ArrayList<String>>> itr = hm.entrySet()
					.iterator();
			while (itr.hasNext()) {
				Entry<String, ArrayList<String>> pairs = itr.next();
				String str = pairs.getKey() + " " + pairs.getValue();
				System.out.print(str + "\n");
				wr.write(str + "\n");
			}
			wr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(hm);
	}

	public void printLayout() {
		System.out
				.println("               ********************* RESERVATIONS **********************");
		for (int r = 0; r < 10; r++) {
			System.out.print((char) (r + 65) + " ");
			for (int c = 0; c < 20; c++) {
				System.out.print(" " + seats[r][c]);
			}
			System.out.println();
		}
	}
}
