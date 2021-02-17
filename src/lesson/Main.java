package lesson;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee Roman = new Employee("Petrov", "Roman", "Romanovich", "Manager", 8898, 50000, 30);
        System.out.println(Roman.getSurname() + " " + Roman.getName() + " " + Roman.getPatronymic() + ", " + Roman.getPosition());

        Employee[] employees = {
                Roman,
                new Employee("Gorbunov", "Oleg", "Petrovich", "Director", 1111, 150000, 45),
                new Employee("Tutina", "Elena", "Borisovna", "Accountant", 2222, 80000, 41),
                new Employee("Rediskin", "Pavel", "Danilovich", "Manager", 9656, 55000, 35),
                new Employee("Grigoreva", "Mariya", "Sergeevna", "Secretary", 3435, 40000, 26),
        };

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.println(employees[i].getAllInfo());
            } else {
                System.out.println("Сотруднику меньше 40 лет");
            }
        }

        for (Employee e: employees) {
            System.out.println(e.getAllInfo());
        }
        increaseSalary(employees);
        System.out.println("-----");
        for (Employee e: employees) {
            System.out.println(e.getAllInfo());
        }
    }
    private static void increaseSalary (Employee[] emp) {
        for (int x = 0; x < emp.length; x++) {
            if (emp[x].getAge() > 35) {
                emp[x].increaseSalaryBy(10000);
            }
        }
    }
}
