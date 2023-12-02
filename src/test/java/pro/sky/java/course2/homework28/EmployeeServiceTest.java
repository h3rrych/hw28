package pro.sky.java.course2.homework28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.homework28.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework28.exception.EmployeeIllegalNameOrLastNameException;
import pro.sky.java.course2.homework28.exception.EmployeeNotFoundException;
import pro.sky.java.course2.homework28.model.Employee;
import pro.sky.java.course2.homework28.service.EmployeeService;
import pro.sky.java.course2.homework28.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    EmployeeServiceImpl out = new EmployeeServiceImpl();

    public static Stream<Arguments> provideParamsForTest() {
        return Stream.of(
                Arguments.of("Антон", "Антонов", 25000.0, 4),
                Arguments.of("Тарас", "Тарасов", 33000, 3));
    }

    @Test
    public void testCreateList() {
        assertNotNull(out.createList());
    }


    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void testAddWillThrowExceptionWhenContains(String firstName, String lastName, double salary, int department) {
        out.add(firstName, lastName, salary, department);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> {
                    out.add(firstName, lastName, salary, department);
                });


    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    public void testAddOnContains(String firstName, String lastName, double salary, int department) {
        Employee emp = new Employee(firstName, lastName, salary, department);
        out.add(firstName, lastName, salary, department);
        assertEquals(out.find(firstName, lastName), emp);

    }

    @Test
    public void testAddWillThrowExceptionWhenIllegalName() {

        assertThrows(EmployeeIllegalNameOrLastNameException.class,
                () -> {
                    out.add("Антон!", "Антонов", 25000.0, 4);
                });


    }

    @Test
    public void testRemoveNotContains() {
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.remove("Винни", "Пух");
                });

    }

    @Test
    public void testFindOnContains() {
        assertNotNull(out.find("Сергей",
                "Сергеев"));

    }

    @Test
    public void testFindWhenNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.find("Винни", "Пух");
                });
    }

    @Test
    public void testFindAllNotNull() {
        assertNotNull(out.findAll());
    }

}

