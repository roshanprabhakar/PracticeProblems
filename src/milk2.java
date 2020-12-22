/*
ID: roshan1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.Arrays;

public class milk2 {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("milk2.in")));
            PrintWriter writer = new PrintWriter(new File("milk2.out"));

            int buffer = Integer.parseInt(br.readLine());
            if (buffer == 0) return;

            int[] start = new int[buffer];
            int[] end = new int[buffer];

            //read all ranges
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] range = line.split(" ");
                start[i] = Integer.parseInt(range[0]);
                end[i] = Integer.parseInt(range[1]);
                i++;
            }

            //sort all ranges
            int[] order = sort(start);
            end = fit(end, order);

            //cumulative range
            int x1 = start[0];
            int z1 = end[0];

            int maxRange = z1 - x1;
            int maxNone = 0;

            for (int j = 1; j < buffer; j++) {
                int x2 = start[j];
                int z2 = end[j];

                if (x2 > z1) {
                    if (x2 - z1 > maxNone) maxNone = x2 - z1;
                    if (x2 - x1 > maxRange) maxRange = z1 - x1;

                    x1 = x2;
                    z1 = z2;

                } else {
                    if (z2 > z1) z1 = z2;
                }
            }

            writer.println(maxRange + " " + maxNone);

            writer.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] sort(int[] arr) {

        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = i;
        }

        for (int i = 0; i < arr.length; i++) {

            int smallest = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) smallest = j;
            }

            swap(arr, i, smallest);
            swap(out, i, smallest);
        }

        return out;
    }

    public static int[] fit(int[] arr, int[] fit) {
        assert arr.length == fit.length;

        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = arr[fit[i]];
        }

        return out;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
