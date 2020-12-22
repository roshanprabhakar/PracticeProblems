/*
ID: roshan1
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.HashMap;

public class namenum {

//    public static final HashMap<Integer, char[]> map = new HashMap<Integer, char[]>() {{
//        put(2, new char[]{'A', 'B', 'C'});
//        put(3, new char[]{'D', 'E', 'F'});
//        put(4, new char[]{'G', 'H', 'I'});
//        put(5, new char[]{'J', 'K', 'L'});
//        put(6, new char[]{'M', 'N', 'O'});
//        put(7, new char[]{'P', 'R', 'S'});
//        put(8, new char[]{'T', 'U', 'V'});
//        put(9, new char[]{'W', 'X', 'Y'});
//    }};

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("namenum.in")));
            String serial = br.readLine();
            br.close();

            PrintWriter writer = new PrintWriter(new File("namenum.out"));

            BufferedReader dictionary = new BufferedReader(new FileReader(new File("dict.txt")));

            String line;
            boolean found = false;
            while ((line = dictionary.readLine()) != null) {
                if (line.length() == serial.length()) {
                    boolean add = true;
                    int t = 0;
                    while (add && t < line.length()) {
                        if (Integer.parseInt(serial.substring(t, t + 1)) != map(line.charAt(t))) {
                            add = false;
                        }
                        t++;
                    }
                    if (add) {
                        writer.println(line);
                        found = true;
                    }
                }
            }
            if (!found) {
                writer.println("NONE");
            }


            dictionary.close();
            writer.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //input: character to be mapped
    public static int map(char c) {
        int mapped;
        if ((int) c >= 83) mapped = ((((int) c - 1) - 65) / 3) + 2;
        else mapped = (((int) c - 65) / 3) + 2;
        return mapped;
    }
}
