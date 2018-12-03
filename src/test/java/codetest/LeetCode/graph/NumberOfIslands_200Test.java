package codetest.LeetCode.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslands_200Test {

    @Test
    public void numIslands() {
        NumberOfIslands_200 s = new NumberOfIslands_200();
        char[][] grid = new char[][]
                {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                };
        System.out.println("NumberOfIslands : " + s.numIslands(grid));
    }
}