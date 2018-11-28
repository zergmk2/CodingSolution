/*
 * [690] Employee Importance
 *
 * https://leetcode.com/problems/employee-importance/description/
 *
 * algorithms
 * Easy (51.92%)
 * Total Accepted:    33.4K
 * Total Submissions: 64.2K
 * Testcase Example:  '[[1,2,[2]], [2,3,[]]]\n2'
 *
 * You are given a data structure of employee information, which includes the
 * employee's unique id, his importance value and his direct subordinates'
 * id. 
 * 
 * For example, employee 1 is the leader of employee 2, and employee 2 is the
 * leader of employee 3. They have importance value 15, 10 and 5, respectively.
 * Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has
 * [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3
 * is also a subordinate of employee 1, the relationship is not direct.
 * 
 * Now given the employee information of a company, and an employee id, you
 * need to return the total importance value of this employee and all his
 * subordinates.
 * 
 * Example 1:
 * 
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates:
 * employee 2 and employee 3. They both have importance value 3. So the total
 * importance value of employee 1 is 5 + 3 + 3 = 11.
 * 
 * 
 * 
 * Note:
 * 
 * One employee has at most one direct leader and may have several
 * subordinates.
 * The maximum number of employees won't exceed 2000.
 * 
 * 
 */


import java.util.*;
// Employee info
//class Employee {
//    // It's the unique id of each node;
//    // unique id of this employee
//    public int id;
//    // the importance value of this employee
//    public int importance;
//    // the id of direct subordinates
//    public List<Integer> subordinates;
//
//    public Employee(int id, int importance, List<Integer> subordinates)
//    {
//        this.id = id;
//        this.importance = importance;
//        this.subordinates = subordinates;
//    }
//}

class Solution {
    public int getImportance(List<Employee> employees, int id) {
           Collections.sort(employees, new Comparator<Employee>() {
               @Override
               public int compare(Employee o1, Employee o2) {
                   return o1.id - o2.id;
               }
           });

           Queue<Employee> queue = new LinkedList<>();
           queue.offer(BinarySearchById(employees, id));
           int importance = 0;
           while (!queue.isEmpty())
           {
               int size = queue.size();
               for (int i = 0; i < size; i++) {
                   Employee e = queue.poll();
                   importance += e.importance;
                   for (Integer sub : e.subordinates)
                   {
                       queue.offer(BinarySearchById(employees, sub));
                   }
               }
           }
           return importance;
    }

    private Employee BinarySearchById(List<Employee> employees, int id)
    {
        if (employees == null || employees.size() == 0)
        {
            return null;
        }
//        for (Employee e : employees)
//        {
//            if (e.id == id)
//            {
//                return e;
//            }
//        }
        int start = 0;
        int end = employees.size() - 1;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (employees.get(mid).id == id)
            {
                return employees.get(mid);
            }

            if (employees.get(mid).id < id)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return null;
    }

}
