package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for Department class.
 */
public class DepartmentUnitTests {

  /**
   * Set up before each test method in this class runs.
   */
  @BeforeEach
  public void setupDepartmentForTesting() {
    Course biol1105 = new Course("Waseem Noor", "428 PUP", "8:40-9:55", 210);
    biol1105.setEnrolledStudentCount(187);
    Course biol2257 = new Course("Tamrat Gashaw", "428 PUP", "8:40-9:55", 125);
    biol2257.setEnrolledStudentCount(63);
    HashMap<String, Course> courses = new HashMap<>();
    courses.put("1105", biol1105);
    courses.put("2257", biol2257);
    testDepartment = new Department("BIOL", courses, "George Washington", 250);
  }

  @Test
  public void getNumberOfMajorsTest() {
    int expectedResult = 250;
    assertEquals(expectedResult, testDepartment.getNumberOfMajors());
  }

  @Test
  public void getDepartmentChairTest() {
    String expectedResult = "George Washington";
    assertEquals(expectedResult, testDepartment.getDepartmentChair());
  }

  @Test
  public void incrementMajorCountTest() {
    // initial major count = 250
    testDepartment.incrementMajorCount();
    assertEquals(251, testDepartment.getNumberOfMajors());
  }

  @Test
  public void decrementMajorCountTest_doesNotDecrement1() {
    testDepartment.setNumberOfMajors(0);
    testDepartment.decrementMajorCount();
    assertEquals(0, testDepartment.getNumberOfMajors());
  }

  @Test
  public void decrementMajorCountTest_decrements1() {
    testDepartment.setNumberOfMajors(1);
    testDepartment.decrementMajorCount();
    assertEquals(0, testDepartment.getNumberOfMajors());
  }

  @Test
  public void decrementMajorCountTest_decrements2() {
    testDepartment.setNumberOfMajors(-1);
    testDepartment.decrementMajorCount();
    assertEquals(-1, testDepartment.getNumberOfMajors());
  }

  @Test
  public void decrementMajorCountTest_decrements3() {
    testDepartment.setNumberOfMajors(4);
    testDepartment.decrementMajorCount();
    assertEquals(3, testDepartment.getNumberOfMajors());
  }





  /** The test department instance used for testing. */
  public static Department testDepartment;
}
