package com.practice.Easy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    int count = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        List<Employee> lst = employees.stream().filter(x->x.id == id).collect(Collectors.toList());
        if(lst == null || lst.size() <= 0) return 0;

        Employee emp = lst.get(0);
        count += emp.importance;

        // easy to make an error by passing y.id instead of y
        emp.subordinates.forEach(y -> getImportance(employees, y));

        return count;
    }


    /** borrowed from yilongwang
     * @param employees
     * @param id
     * @return
     */
    public int getImportance_J8(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(e -> e.id, e -> e));
        return helper(map, id);
    }

    private int helper(Map<Integer, Employee> map, int id) {
        return map.get(id).importance
                + map.get(id)
                    .subordinates
                    .stream()
                    // identity, accumulator, combine
                    .reduce(0, (s1, s2) -> s1 + helper(map, s2), (s1, s2) -> s1 + s2);
    }
}
