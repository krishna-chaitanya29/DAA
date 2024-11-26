// You are part of a team developing a climate monitoring system that records temperature readings 
// from various sensors placed across different regions. 
// The temperature data is recorded every hour and stored in a sorted list, 
// where each entry represents the temperature at a specific time.

// The system occasionally needs to analyze periods of extreme weather, 
// such as heatwaves or cold spells. 
// To do this, it must identify the first and last occurrences of a specific temperature 
// within the recorded data, which helps in understanding the duration of these extreme conditions.

// Your task is to implement a module 
// that finds the first and last positions of a given temperature in the sorted list of temperature readings.

// NOTE:
// If the target temperature is not found in the list, the function should return [-1, -1].
// The solution should be efficient, as the temperature data could be extensive.

// Input Format:
// -------------
// Line-1 : Comma(,) separated list of numbers, represents temperature
// Line-2 : A number, target value

// Output Format:
// --------------
// Line-1 : Comma(,) seperated numbers, represents indexes, check sample output

// Sample input1:
// -------------
// 15, 18, 18, 21, 21, 21, 24, 30
// 21

// Sample output1:
// --------------
// [3, 5]
// x
// Sample input2:
// -------------
// 10, 20, 30, 40, 50, 60, 70, 80
// 60

// Sample output2:
// --------------
// [5, 5]

import java.util.Scanner;
import java.util.Arrays;

public class TempertaureAndTarget {
    public static int[] findmark(int[] temp, int t) {
        int first = -1, last = -1;

        // Find the first occurrence
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == t) {
                first = i;
                break;
            }
        }

        // Find the last occurrence
        for (int j = temp.length - 1; j >= 0; j--) {
            if (temp[j] == t) {
                last = j;
                break;
            }
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // System.out.println("Enter the comma-separated list of temperatures:");
            String[] temperaturesString = scanner.nextLine().split(",");
            int[] temperatures = Arrays.stream(temperaturesString).mapToInt(Integer::parseInt).toArray();

            // System.out.println("Enter the target temperature:");
            int targetTemperature = Integer.parseInt(scanner.nextLine());

            // Find the first and last position of the target temperature
            int[] result = findmark(temperatures, targetTemperature);

            // Print the result
            System.out.println(Arrays.toString(result));
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
