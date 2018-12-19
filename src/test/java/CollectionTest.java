import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollectionTest {

    @Test
    public void testListEqual_원시형() {
        List<String> listA = new ArrayList<>();
        listA.add("park");
        listA.add("lee");

        List<String> listB = new ArrayList<>();
        listB.add("park");
        listB.add("lee");

        assertEquals("리스트비교",listA, listB);
    }

    @Test
    public void testListEqual_객체() {
        List<Employee> list1 = new ArrayList<>();
        list1.add(new Employee("park"));
        list1.add(new Employee("lee"));

        List<Employee> list2 = new ArrayList<>();
        list2.add(new Employee("park"));
        list2.add(new Employee("lee"));

        assertEquals("리스트비교", list1.toString(), list2.toString());
    }
}
