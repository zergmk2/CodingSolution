package interview_test;

import java.lang.reflect.Array;
import java.util.Stack;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/*
 * [665] Non-decreasing Array
 *
 * https://leetcode.com/problems/non-decreasing-array/description/
 *
 * algorithms
 * Easy (19.91%)
 * Total Accepted:    31.8K
 * Total Submissions: 159.7K
 * Testcase Example:  '[4,2,3]'
 *
 * 
 * Given an array with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 * 
 * 
 * 
 * We define an array is non-decreasing if array[i]  holds for every i (1 
 * 
 * Example 1:
 * 
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing
 * array.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one
 * element.
 * 
 * 
 * 
 * Note:
 * The n belongs to [1, 10,000].
 * 
 */
class Solution {
//    public void solution(int N) {
//        // write your code in Java SE 8
//        for (int i = 1; i < N; i++)
//        {
//            StringBuilder content = new StringBuilder();
//            if (i % 2 == 0)
//            {
//                content.append("Codility");
//            }
//
//            if (i % 3 == 0)
//            {
//                content.append("Test");
//            }
//
//            if (i % 5 == 0)
//            {
//                content.append("Coders");
//            }
//
//            String result = content.toString();
//
//            if (result.length() > 0)
//            {
//                System.out.println(result);
//            }
//            else
//            {
//                System.out.println(i);
//            }
//        }
//    }
    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Integer> stack = new Stack<>();
        if (S == null || S.length() ==0)
        {
            return 0;
        }

        String[] operations = S.trim().split(" ");

        for(int i = 0; i < operations.length; i++)
        {
            int foo = 0;
            try {

                foo = Integer.parseInt(operations[i]);
                stack.push(foo);

            } catch (NumberFormatException e) {
                if (operations[i].equalsIgnoreCase("POP"))
                {
                    if (stack.size() == 0) {
                        return  -1;
                    }
                    stack.pop();
                }
                else if (operations[i].equalsIgnoreCase("DUP"))
                {
                    if (stack.size() == 0) {
                        return  -1;
                    }
                    int tmp = stack.peek();
                    stack.push(tmp);
                }
                else if (operations[i].equalsIgnoreCase("+"))
                {
                    if (stack.size() < 2) {
                        return  -1;
                    }
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = a + b;
                    stack.push(c);
                }
                else if (operations[i].equalsIgnoreCase("-"))
                {
                    if (stack.size() < 2) {
                        return  -1;
                    }
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = a - b;
                    stack.push(c);
                }
            }
        }

        if (stack.size() == 0)
        {
            return 0;
        }

        return  stack.peek();
    }


    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        m = A.length;
        n = A[0].length;
        int islandsNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    dfs(A, i, j);
                    islandsNum++;
                }
            }
        }
        return islandsNum;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }
        int color = grid[i][j];
        grid[i][j] = 0;
        for (int[] d : direction) {
            checkNeiborColor(grid, i + d[0], j + d[1], color);
        }
    }

    private void checkNeiborColor(int[][] grid, int i, int j, int color)
    {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return;
        }
        if (grid[i][j] == color)
        {
            grid[i][j] = 0;
            for (int[] d : direction) {
                checkNeiborColor(grid, i + d[0], j + d[1], grid[i][j]);
            }
        }
    }

//    public static void main(String[] args)
//    {
//        Solution s = new Solution();
//        int[][] test = new int[][] {{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
//        System.out.println(s.solution(test));
//    }



    // Complete the topMostFrequentWords function below.
    static List<String> topMostFrequentWords(String words, int rank) {
        List<String> retList = new ArrayList<>();
        if (words == null)
            return retList;

        String[] inputList = words.split("\\s+");

        Map<String, Integer> frequentList = new HashMap<>();
        int maxfrequency = 0;
        for (String item : inputList)
        {
            int fre = frequentList.getOrDefault(item, 0) + 1;
            if (fre > maxfrequency)
            {
                maxfrequency = fre;
            }
            frequentList.put(item, fre);
        }

        List<String>[] buckets = new ArrayList[maxfrequency + 1];

        for (String key : frequentList.keySet()) {
            if (buckets[frequentList.get(key)] == null) {
                buckets[frequentList.get(key)] = new ArrayList<>();
            }
            buckets[frequentList.get(key)].add(key);
        }

        for (int i = maxfrequency; i > 0 && rank > 0; i--)
        {
            if(buckets[i] != null)
            {
                java.util.Collections.sort(buckets[i]);

                for (String num : buckets[i])
                {
                    retList.add(num);
                    rank--;
                }
            }
        }

        return  retList;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.log"));

        String words = bufferedReader.readLine();

        int rank = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> res = topMostFrequentWords(words, rank);

        bufferedWriter.write(
                res.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}
