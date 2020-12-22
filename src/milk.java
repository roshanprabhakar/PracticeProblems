/*
ID: roshan1
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.ArrayList;

public class milk {

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(new File("milk.in")));
            PrintWriter out = new PrintWriter(new File("milk.out"));

            String[] initial = br.readLine().split(" ");
            int requirement = Integer.parseInt(initial[0]);
            int numFarmers = Integer.parseInt(initial[1]);

            ArrayList<Integer> units = new ArrayList<>();
            for (int i = 0; i < numFarmers; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < Integer.parseInt(line[1]); j++) {
                    units.add(Integer.parseInt(line[0]));
                }
            }
            sort(units);


            int unit = 0;
            int cost = 0;
            while (unit < requirement && unit < units.size()) {
                cost += units.get(unit);
                unit++;
            }

            out.println(cost);

            out.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void sort(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int smallest = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(smallest)) smallest = j;
            }
            swap(arr, i, smallest);
        }
    }

    public static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
