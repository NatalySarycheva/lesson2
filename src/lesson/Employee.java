package lesson;

public class Employee {

    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private int phone;
    private int salary;
    private int age;
    private int uid;

    Employee (String surname,
            String name,
            String patronymic,
            String position,
            int phone,
            int salary,
            int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.uid = ++id;
    }

    String getSurname() {
        return surname;
    }
    String getName() {
        return name;
    }
    String getPatronymic() {
        return patronymic;
    }
    String getPosition() {
        return position;
    }
    int getPhone() {
        return phone;
    }
    int getSalary() {
        return salary;
    }
    int getAge() {
        return age;
    }
    void increaseSalaryBy (int diff) {
        this.salary += diff;
    }


    String getAllInfo () {
        return this.uid + " " + this.surname + " " + this.name + " " + this.patronymic + ", " +
                this.position + ", Phone number: " +
                this.phone + ", Salary: " +
                this.salary + ", Age: " + this.age;
    }

    private static int id = 0;

}
