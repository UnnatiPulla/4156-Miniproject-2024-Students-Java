package dev.coms4156.project.individualproject;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a course within an educational institution. This class stores information
 * about the course, like its instructor name, course location, time slot, capacity, etc.
 */
public class Course implements Serializable {

  /**
   * Constructs a new Course object with the given parameters. Initial count starts at 0.
   *
   * @param instructorName The name of the instructor teaching the course.
   * @param courseLocation The location where the course is held.
   * @param timeSlot       The time slot of the course.
   * @param capacity       The maximum number of students that can enroll in the course.
   */
  public Course(String instructorName, String courseLocation, String timeSlot, int capacity) {
    this.courseLocation = courseLocation;
    this.instructorName = instructorName;
    this.courseTimeSlot = timeSlot;
    this.enrollmentCapacity = capacity;
    this.enrolledStudentCount = 0;
  }

  /**
   * Enrolls a student in the course if there is space available.
   *
   * @return true if the student is successfully enrolled, false otherwise.
   */
  public boolean enrollStudent() {
    if (!isCourseFull()) {
      enrolledStudentCount++;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Drops a student from the course if a student is enrolled.
   *
   * @return true if the student is successfully dropped, false otherwise.
   */
  public boolean dropStudent() {
    if (enrolledStudentCount > 0) {
      enrolledStudentCount--;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Gets the course's location.
   *
   * @return string containing the location where the course meets.
   */
  public String getCourseLocation() {
    return this.courseLocation;
  }

  /**
   * Gets the course's instructor name.
   *
   * @return string containing the instructor of the course.
   */
  public String getInstructorName() {
    return this.instructorName;
  }

  /**
   * Gets the course's time slot.
   *
   * @return string containing the time slot of the course.
   */
  public String getCourseTimeSlot() {
    return this.courseTimeSlot;
  }

  @Override
  public String toString() {
    return "\nInstructor: " + instructorName + "; Location: " + courseLocation
        + "; Time: " + courseTimeSlot;
  }

  /**
   * Changes instructor of the course to a new instructor.
   *
   * @param newInstructorName name of the new instructor.
   */
  public void reassignInstructor(String newInstructorName) {
    this.instructorName = newInstructorName;
  }

  /**
   * Changes location of the course.
   *
   * @param newLocation new location of the course.
   */
  public void reassignLocation(String newLocation) {
    this.courseLocation = newLocation;
  }

  /**
   * Changes time slot of the course.
   *
   * @param newTime new time of the course.
   */
  public void reassignTime(String newTime) {
    this.courseTimeSlot = newTime;
  }

  /**
   * Sets the number of students enrolled in the course.
   *
   * @param count number of students enrolled in the course.
   */
  public void setEnrolledStudentCount(int count) {
    this.enrolledStudentCount = count;
  }

  /**
   * Gets the number of students enrolled in the course.
   *
   * @return number of students enrolled in the course.
   */
  public int getEnrolledStudentCount() {
    return this.enrolledStudentCount;
  }

  /**
   * Gets number of students that can be enrolled in the course (capacity).
   *
   * @return capacity of course.
   */
  public int getCapacity() {
    return this.enrollmentCapacity;
  }

  /**
   * Tells whether a course is full/at capacity.
   *
   * @return true if course is full, and false if course still has space for more students.
   */
  public boolean isCourseFull() {
    return getCapacity() <= getEnrolledStudentCount();
  }

  @Serial
  private static final long serialVersionUID = 123456L;
  private final int enrollmentCapacity;
  private int enrolledStudentCount;
  private String courseLocation;
  private String instructorName;
  private String courseTimeSlot;
}
