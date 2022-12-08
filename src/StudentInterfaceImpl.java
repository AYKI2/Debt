import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class StudentInterfaceImpl implements StudentInterface{
    public static Scanner scanner =new Scanner(System.in);

    private List<Student> students = new ArrayList<>();

    @Override
    public String createPerson(List<Student> students) {
        this.students.addAll(students);
        return "Successfully created!";
    }

    @Override
    public String removePerson(String name) {
        boolean isRemoved = this.students.removeIf(person -> person.getName().equals(name));
        return isRemoved ? "Successfully removed!" : "Removed failed!";
    }

    @Override
    public List<Student> getAll() {
        return this.students;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> studentList = new ArrayList<>();
        if(name.matches("[a-zA-Z]")){
            for (Student person : this.students) {
                if (person.getName().equals(name)) {
                    studentList.add(person);
                }
            }
        }else {
            System.out.println("Incorrect input!");
        }
        return studentList;
    }
    @Override
    public String payCars(String firstStudent, String secondStudent, BigDecimal summa) {
        if (firstStudent.matches("[a-zA-Z]") && secondStudent.matches("[a-zA-Z]")) {
            for (Student student1 : this.students) {
                if (firstStudent.equals(student1.getName())) {
                    for (Student student2 : this.students) {
                        if (secondStudent.equals(student2.getName())) {
                            boolean number = student2.getMoney().intValue() >= summa.intValue();
                            if (number) {
                                student1.setMoney(student1.getMoney().add(summa));
                                student2.setMoney(student2.getMoney().subtract(summa));
                                return "Successfully!";
                            } else {
                                return "Not enough money";
                            }
                        }
                    }
                }
            }
        }else {
            System.out.println("Incorrect input!");
        }
        return "No such student";
    }

    @Override
    public Map<Integer, Student> getAge(String name) {
        Map<Integer, Student> studentMap = new TreeMap<>();
        if(name.matches("[a-zA-Z]")) {
            for (Student student : this.students) {
                if (student.getName().equals(name)) {
                    int age = Period.between(student.getDateOfBirth(), LocalDate.now()).getYears();
                    studentMap.put(age, student);
                }
            }
        }else {
            System.out.println("Incorrect input!");
        }
        return studentMap;
    }
}
