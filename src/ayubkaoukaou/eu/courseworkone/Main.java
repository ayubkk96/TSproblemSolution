package ayubkaoukaou.eu.courseworkone;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    /* Please place the correct file path below. */
    static File file = new File("C:\\Users\\kaouk\\\\OneDrive\\\\Documents\\\\test2tsp.txt");

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(file);
        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        /* Scan through the text file and add the data to a list */
        while (input.hasNext()) {
            listOfNumbers.add(input.nextInt());
        }
        input.close();

        System.out.println(listOfNumbers);

        /* Java8+ can use NIO to count how much lines are needed for our two dimensional array*/
        Path path = Paths.get(String.valueOf(file));
        int counter = (int) Files.lines(path).count();

        System.out.println("Lines in text file: " + counter);

        /* Convert the list into a two dimensional array depending on the number on the number of lines (the value of counter) */
        int listIndex = 0;
        int[][] cities = new int[counter][3];
        //loop through each row
        for (int row = 0; row < cities.length; row++) {
            //loop through each column
            for (int col = 0; col < cities[row].length; col++) {
                //populate two dimensional array with values from list
                cities[row][col] = listOfNumbers.get(listIndex++);
                System.out.println(cities[row][col] + " ");
            }
        }

        //Loop through the two dimensional array and calculate the paths in euclidean distance.
        double paths = 0;
        ArrayList listOfPaths = new ArrayList();
        for (int row = 0; row < cities.length; row++) {
            for (int column = 0; column < cities[row].length; column++) {
                paths = Math.sqrt((cities[row][1] - cities[column][1]) * (cities[row][1] - cities[column][1]) +
                        (cities[row][2] - cities[column][2]) * (cities[row][2] - cities[column][2]));
                //A path cannot be 0.
                if (!(paths == 0)) {
                    listOfPaths.add(paths);
                }
            }


        }
        //Print a list of paths found and print the shortest distance
        System.out.println("The paths are: " + listOfPaths);
        System.out.println("The shortest path is: " + findShortestDistance(listOfPaths));

    }

    /**
     * A function that prints the shortest distance on a list of distances
     */
    public static double findShortestDistance(List<Double> list) {


        // Create a new list to store our new sorted list.
        ArrayList sortedList = new ArrayList(list);

        // Perform the action of sorting the list.
        Collections.sort(sortedList);

        //By sorting the list from smallest to largest, the first element would be the shortest distance.
        return (double) sortedList.get(0);
    }

}