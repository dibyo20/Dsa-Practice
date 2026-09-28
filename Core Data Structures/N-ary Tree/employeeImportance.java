import java.util.*;

public class employeeImportance {
    public static class Employee {
        int id;
        int importance;
        List<Integer> subordinates;

        public Employee() {
        }

        public Employee(int id, int importance) {
            this.id = id;
            this.importance = importance;
        }

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id, map);
    }

    private static int dfs(int id, Map<Integer, Employee> map) {
        Employee employee = map.get(id);
        int importance = employee.importance;
        for (int subId : employee.subordinates) {
            importance += dfs(subId, map);
        }   
        return importance;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, Arrays.asList()));
        employees.add(new Employee(3, 3, Arrays.asList()));
        int id = 1;
        System.out.println(getImportance(employees, id));
    }
}
