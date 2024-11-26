/*
 * You are given an array prices where prices[i] represents the price of a given stock on the i-th day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Input Format:
-------------
Line-1: A single line containing an integer array prices where prices[i] represents the stock price on day i.

Output Format:
--------------
Line-1: Return an integer representing the maximum profit possible. If no profit is possible, return 0.

Constraints:
------------
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4

Explanation:
You can perform one transaction (buy one stock and sell one stock later). You need to determine the maximum difference between a future price and a past price, with the constraint that the sell date must be after the buy date.

Note:
You are allowed only one transaction (i.e., buy one and sell one).

Sample Input-1:
---------------
7 1 5 3 6 4

Sample Output-1:
5

Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5. Note that buying on day 2 and selling on day 3 would also result in a profit of 4, but 5 is the maximum.

Sample Input-2:
---------------
7 6 4 3 1

Sample Output-2:
----------------
0

Explanation: In this case, no transaction is done, and the maximum profit is 0.


Sample Input-3:
---------------
2 4 1

Sample Output-3:
----------------
2

Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4 - 2 = 2.
 */
public class DAA_Day16_SP20_Stock_Buy_Sell {

    public static int maxProfit(int[] prices) {
        int buyprice = prices[0];
        int profit = 0;
        for(int i=0 ; i<prices.length ; i++)
        {
            if(prices[i] < buyprice ){
                buyprice = prices[i];
            }
            else if(prices[i]-buyprice > profit){
                profit = prices[i]- buyprice;
            }
        }
        return profit ;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); 
        String input = sc.nextLine();
        String[] priceStrings = input.split(" ");

        int[] prices = new int[priceStrings.length];
        for (int i = 0; i < priceStrings.length; i++) {
            prices[i] = Integer.parseInt(priceStrings[i]);
        }
        System.out.println(maxProfit(prices));
    }
    
}
