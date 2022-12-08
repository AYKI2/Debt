import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static StudentInterfaceImpl studentInterface = new StudentInterfaceImpl();
    public static void main(String[] args) {
        Student student1 = new Student("Iskhak", LocalDate.of(2002, 8,28), Gender.MALE, new BigDecimal(15000));
        Student student2 = new Student("Yntymak", LocalDate.of(2002, 8,28), Gender.MALE, new BigDecimal(20000));
        Student student3 = new Student("Aijamal", LocalDate.of(1995, 8,28), Gender.FEMALE, new BigDecimal(5000));
        List<Student> students = new ArrayList<>(List.of(student1,student2,student3));
        commands(students);

    }
    public static void commands(List<Student> students) {
        boolean isTrue = true;
        try {
            while (isTrue) {
                System.out.println("""
                        1 -> Create,
                        2 -> Remove,
                        3 -> ShowAll,
                        4 -> Find by name,
                        5 -> Debt,
                        6 -> Show student age,
                        0 -> Exit;
                        """);
                int number = scanner.nextInt();
                switch (number) {
                    case 1 -> System.out.println(studentInterface.createPerson(students));
                    case 2 -> {
                        System.out.println("Enter student name: ");
                        System.out.println(studentInterface.removePerson(scanner.next()));
                    }
                    case 3 -> System.out.println(studentInterface.getAll());
                    case 4 -> {
                        System.out.println("Enter student name: ");
                        System.out.println(studentInterface.findByName(scanner.next()));
                    }
                    case 5 -> {
                        System.out.println("Enter first student name: ");
                        String firstStudent = scanner.next();
                        System.out.println("Enter second student name: ");
                        String secondStudent = scanner.next();
                        System.out.println("Summa: ");
                        System.out.println(studentInterface.payCars(firstStudent, secondStudent, scanner.nextBigDecimal()));
                    }
                    case 6 -> {
                        System.out.println("Enter student name: ");
                        System.out.println(studentInterface.getAge(scanner.next()));
                    }
                    case 0 -> isTrue = false;
                    default -> System.out.println("Incorrect input!");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Incorrect input!");
        }
    }
}