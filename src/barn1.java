/*
ID: roshan1
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.ArrayList;

public class barn1 {

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("barn1.in")));
            PrintWriter writer = new PrintWriter(new File("barn1.out"));

            String firstLine = bufferedReader.readLine();
            ArrayList<Integer> entries = new ArrayList<>();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                entries.add(Integer.parseInt(line));
            }
            sort(entries);
            System.out.println(entries);

            int existingBoards = countBoards(entries);
            int limit = Integer.parseInt(firstLine.split(" ")[0]);

            for (int i = 0; i < existingBoards - limit; i++) {
                block(entries);
            }


            writer.println(entries.size());

            writer.close();
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void block(ArrayList<Integer> entries) {

        int shortestGap = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < entries.size() - 1; i++) {
            if (entries.get(i) + 1 != entries.get(i + 1) && entries.get(i + 1) - entries.get(i) <= shortestGap) {
                shortestGap = entries.get(i + 1) - entries.get(i);
                index = i;
            }
        }

        if (index == -1) {
            System.out.println("can't restrict");
            return;
        }

        for (int i = entries.get(index + 1) - 1; i >= entries.get(index) + 1; i--) {
            entries.add(index + 1, i);
        }
    }

    public static int countBoards(ArrayList<Integer> entries) {
        if (entries.size() == 0) return 0;
        int boards = 1;
        for (int i = 0; i < entries.size() - 1; i++) {
            if (entries.get(i) + 1 != entries.get(i + 1)) {
                boards++;
            }
        }
        return boards;
    }

    public static void sort(ArrayList<Integer> arr) {

        for (int i = 0; i < arr.size(); i++) {

            int smallest = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(smallest)) smallest = j;
            }

            int temp = arr.get(i);
            arr.set(i, arr.get(smallest));
            arr.set(smallest, temp);

        }
    }

}
