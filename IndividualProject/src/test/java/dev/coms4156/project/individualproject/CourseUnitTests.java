package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * This class contains unit tests for Course class.
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  /**
   * Set up to perform before each method in this unit test class runs.
   */
  @BeforeEach
  public void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
  }

  @Test
  public void toStringTest() {
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  public void getCourseLocationTest() {
    String expectedResult = "417 IAB";
    assertEquals(expectedResult, testCourse.getCourseLocation());
  }

  @Test
  public void getInstructorNameTest() {
    String expectedResult = "Griffin Newbold";
    assertEquals(expectedResult, testCourse.getInstructorName());
  }

  @Test
  public void getCourseTimeSlotTest() {
    String expectedResult = "11:40-12:55";
    assertEquals(expectedResult, testCourse.getCourseTimeSlot());
  }

  @Test
  public void reassignInstructorTest() {
    testCourse.reassignInstructor("Gail Kaiser");
    String expectedResult = "Gail Kaiser";
    assertEquals(expectedResult, testCourse.getInstructorName());
  }

  @Test
  public void reassignLocationTest() {
    testCourse.reassignLocation("309 HAV");
    String expectedResult = "309 HAV";
    assertEquals(expectedResult, testCourse.getCourseLocation());
  }

  @Test
  public void reassignTimeTest() {
    testCourse.reassignTime("10:10-11:25");
    String expectedResult = "10:10-11:25";
    assertEquals(expectedResult, testCourse.getCourseTimeSlot());
  }

  @Test
  public void setEnrollStudentCountTest() {
    testCourse.setEnrolledStudentCount(109);
    int expectedResult = 109;
    assertEquals(expectedResult, testCourse.getEnrolledStudentCount());
  }

  @Test
  public void isCourseFullTest_true() {
    // capacity of testCourse is 250
    testCourse.setEnrolledStudentCount(251);
    boolean expectedResult = true;
    assertEquals(expectedResult, testCourse.isCourseFull());
  }

  @Test
  public void isCourseFullTest_false() {
    // capacity of testCourse is 250
    testCourse.setEnrolledStudentCount(249);
    boolean expectedResult = false;
    assertEquals(expectedResult, testCourse.isCourseFull());
  }

  @Test
  public void enrollStudentTest_true() {
    // capacity of testCourse is 250
    testCourse.setEnrolledStudentCount(249);
    boolean expectedResult = true;
    assertEquals(expectedResult, testCourse.enrollStudent());
  }

  @Test
  public void enrollStudentTest_falseAtCapacity() {
    // capacity of testCourse is 250
    testCourse.setEnrolledStudentCount(250);
    boolean expectedResult = false;
    assertEquals(expectedResult, testCourse.enrollStudent());
  }

  @Test
  public void enrollStudentTest_falseAboveCapacity() {
    // capacity of testCourse is 250
    testCourse.setEnrolledStudentCount(255);
    boolean expectedResult = false;
    assertEquals(expectedResult, testCourse.enrollStudent());
  }

  @Test
  public void dropStudentTest_true() {
    testCourse.setEnrolledStudentCount(255);
    testCourse.dropStudent();
    boolean expectedResultBoolean = true;
    int expectedEnrolledStudentCount = 254;
    assertEquals(expectedEnrolledStudentCount, testCourse.getEnrolledStudentCount());
    assertEquals(expectedResultBoolean, testCourse.dropStudent());
  }

  @Test
  public void dropStudentTest_false() {
    testCourse.setEnrolledStudentCount(0);
    testCourse.dropStudent();
    boolean expectedResultBoolean = false;
    int expectedEnrolledStudentCount = 0;
    assertEquals(expectedEnrolledStudentCount, testCourse.getEnrolledStudentCount());
    assertEquals(expectedResultBoolean, testCourse.dropStudent());
  }

  /** The test course instance used for testing. */
  public static Course testCourse;
}

