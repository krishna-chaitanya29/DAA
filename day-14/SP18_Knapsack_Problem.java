/*
 * You are given n items, each with a specific weight and value. 
You are also given a knapsack that can hold a maximum weight W. 
The goal is to maximize the total value in the knapsack by selecting items to add.

NOTE: You can take fractions of items instead of having to take the whole item. 
You need to calculate the maximum possible value that can be achieved.

Input Format:
-------------
Line-1: Two integers n and W representing the number of items and the maximum weight capacity of the knapsack, respectively.
Line-2 to n: Each line contains two integers value and weight for each item.

Output Format:
--------------
Line-1: Printing the maximum total value that can be obtained in the knapsack, rounded to two decimal places.

Constraints:
-------------
1 <= n <= 10^5
0 <= W <= 10^9
1 <= value, weight <= 10^9

Sample Input-1:
---------------
3 50
60 10
100 20
120 30

Sample Output-1:
----------------
240.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 10).
The second item can be added in full (value = 100, weight = 20).
The third item can be added partially, using only 20 out of 30 weight capacity, which gives a value of (120/30) * 20 = 80.
Thus, the total value is 60 + 100 + 80 = 240.

Sample Input-2:
---------------
2 50
60 20
100 50

Sample Output-2:
----------------
160.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 20).
From the second item, only 30 weight units can be used, so the value will be (100/50) * 30 = 60.
Thus, the total value is 60 + 60 = 160.

Sample Input-3:
---------------
1 10
500 30

Sample Output-3:
----------------
166.67

Explanation:
------------
The item has a value of 500 and a weight of 30. Since the knapsack can only hold 10 units of weight, we take a fraction of the item.
The value of 10 units from the first item is (500/30) * 10 = 166.67.
Thus, the total value is 166.67
 */



import java.util.Arrays;
import java.util.Scanner;

class Item implements Comparable<Item> {
    int value, weight;
    double ratio;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }

    @Override
    public int compareTo(Item other) {
        // Sort in descending order of value-to-weight ratio
        return Double.compare(other.ratio, this.ratio);
    }
}

public class SP18_Knapsack_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of items and the knapsack capacity
        int n = sc.nextInt();
        int W = sc.nextInt();

        // Create an array to store the items
        Item[] items = new Item[n];

        // Read the value and weight of each item
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        // Sort the items by value-to-weight ratio
        Arrays.sort(items);

        double maxValue = 0.0;
        int remainingCapacity = W;

        // Add items to the knapsack
        for (Item item : items) {
            if (remainingCapacity == 0) break; // If knapsack is full, stop

            if (item.weight <= remainingCapacity) {
                // Take the full item
                maxValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Take a fraction of the item
                maxValue += item.ratio * remainingCapacity;
                remainingCapacity = 0;
            }
        }

        // Print the maximum value, rounded to 2 decimal places
        System.out.printf("%.2f\n", maxValue);

        sc.close();
    }
}
