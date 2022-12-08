import java.math.BigDecimal;
import java.time.LocalDate;

public class Student {
    private static StudentInterfaceImpl studentInterface = new StudentInterfaceImpl();
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private BigDecimal money;

    public Student(String name, LocalDate dateOfBirth, Gender gender, BigDecimal money) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "\nStudent: " +
                "\nname = " + name +
                "\ndateOfBirth = " + dateOfBirth +
                "\ngender = " + gender +
                "\nmoney = " + money + "\n";
    }
}
