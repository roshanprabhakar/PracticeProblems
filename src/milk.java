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

            ArrayList<Farmer> farmers = new ArrayList<>();
            for (int i = 0; i < numFarmers; i++) {
                String[] line = br.readLine().split(" ");
                farmers.add(new Farmer(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            }
            sort(farmers);

            int farmer = 0;
            int units = 0;
            int cost = 0;
            while (units < requirement && farmer < farmers.size()) {
                Farmer thisFarmer = farmers.get(farmer);
                if (units + thisFarmer.getSupply() > requirement) {
                    int unitsLeft = requirement - units;
                    cost += thisFarmer.getPrice() * unitsLeft;
                    units = requirement;
                } else {
                    cost += thisFarmer.getPrice() * thisFarmer.getSupply();
                    units += thisFarmer.getSupply();
                }
                farmer++;
            }

            out.println(cost);

            out.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void sort(ArrayList<Farmer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int smallest = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j).getPrice() < arr.get(smallest).getPrice()) smallest = j;
            }
            swap(arr, i, smallest);
        }
    }

    public static void swap(ArrayList<Farmer> arr, int i, int j) {
        Farmer temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    static class Farmer extends Object {
        private int price;
        private int supply;

        public Farmer(int price, int supply) {
            this.price = price;
            this.supply = supply;
        }

        public int getPrice() {
            return price;
        }

        public int getSupply() {
            return supply;
        }

        public String toString() {
            return "(" + price + ", " + supply + ")";
        }
    }
}
