import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface StudentInterface {

    String createPerson(List<Student> people);

    String removePerson(String name);

    List<Student> getAll();

    List<Student> findByName(String name);

    String payCars(String name, String carName, BigDecimal summa);

    Map<Integer, Student> getAge(String name);
}
