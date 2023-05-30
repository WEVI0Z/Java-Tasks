import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Calendar alexHireDate = new GregorianCalendar(2005, Calendar.JANUARY, 31);
        Employee alex = new Employee(
                "Alex",
                3112,
                alexHireDate
        );

        System.out.println(alex.calcService());
    }
}

class Employee {
    String name;
    int salary;
    Calendar hireDate;

    Employee (String name, int salary, Calendar hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    int calcService() {
        Calendar todayDate = new GregorianCalendar();

        return todayDate.get(Calendar.YEAR) - this.hireDate.get(Calendar.YEAR);
    }
}