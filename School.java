import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class School
{
  private String name;
  private ArrayList<Student> students = new ArrayList<Student>();
  private ArrayList<Instructor> instructors = new ArrayList<Instructor>();
  private ArrayList<Subject> subjects = new ArrayList<Subject>();
  private ArrayList<Course> courses = new ArrayList<Course>();
  private ListIterator<Course> myCourses = courses.listIterator();
//  private File myFile = new File("school.txt");
  Course newCourse;
  
  public School(String name){
    this.name = name;
  }
  
  public void add(Student student){
    students.add(student);
  }
  
  public void remove(Student student){
    students.remove(student);
  }
  
  public ArrayList<Student> getStudents(){
    return students;
  }
  
  public void add(Instructor instructor){
    instructors.add(instructor);
  }
  
  public void remove(Instructor instructor){
    students.remove(instructor);
  }
  
  public ArrayList<Instructor> getInstructors(){
    return instructors;
  }
  
  public void add(Subject subject){
    subjects.add(subject);
  }
  
  public void remove(Subject subject){
    subjects.remove(subject);
  }
  
  public ArrayList<Subject> getSubjects(){
    return subjects;
  }
  
  public void add(Course course){
    courses.add(course);
  }
  
  public void remove(Course course){
    courses.remove(course);
  }
  
  public ArrayList<Course> getCourses(){
    return courses;
  }
  
  public String toString() 
  {
    String myString = "school:" + name + "\n";
    for(Subject subject: subjects){
      myString += "subject:" + subject.getID() + "," + subject.getSpecialism() + "," + subject.getDuration() + "\n";
    }
    
    for(Student student: students){
      myString += "student:" + student.getName() + "," + student.getGender() + "," + student.getAge() + "\n";
      if(student.getCourse() != null && student.getCourse().getInstructor() != null){
        myString += "Taught by:" + student.getCourse().getInstructor() + "\n";
      }
    }
    
    for(Instructor instructor: instructors){
      myString += "Instructor" + ":" + instructor.getName() + "," + instructor.getGender() + "," + instructor.getAge() + "\n";
      if(instructor.getAssignedCourse() != null && instructor.getAssignedCourse().getStudents() != null){
        myString += "Instructor to:" + instructor.getAssignedCourse().getStudents() + "\n";
      }
    }
    
    for(Course course: courses){
      myString += "course:" + course.getName() + "," + course.getStatus() + ",";
      if(course.hasInstructor()) myString += course.getInstructor().getName() + ",";
      myString += course.getStudents() + "\n";
    }
    
    return myString;
  }
  
  public void aDayAtSchool(){
    myCourses = courses.listIterator();
    while(myCourses.hasNext()){
      Course thisCourse = myCourses.next();
      if(thisCourse.isCancelled() == false && thisCourse.hasCreatedNew() == false){
        if((thisCourse.getStudents().size() == 3) || (thisCourse.getStatus() == thisCourse.getSubject().getDuration() && (thisCourse.getStudents().size() == 0 || thisCourse.hasInstructor() == false))){
          thisCourse.createNew();
          newCourse = new Course(thisCourse.getSubject(), 2);
          newCourse.setName(thisCourse.getName());
          myCourses.add(newCourse);
        }
      }
      
      if(thisCourse.hasInstructor() == false && thisCourse.isCancelled() == false){
        for(Instructor instructor: instructors){
          if(instructor.canTeach(thisCourse.getSubject()) == true && instructor.hasAssignedCourse() == false){
            thisCourse.setInstructor(instructor);
            break;
          }
        }
        for(Student student: students){
          if(student.isFree() == true && student.getCertificates().contains(thisCourse.getSubject().getID()) == false && thisCourse.getStudents().size()<3){
              student.setCourse(thisCourse);
              thisCourse.enrolStudent(student);
          }
        }
      }
      
        System.out.println("1------------------"+thisCourse.getName()+thisCourse.hasCreatedNew());
      thisCourse.aDayPasses();
      if(thisCourse.getStatus() == 0){
          System.out.println("2------------------"+thisCourse.getName()+thisCourse.hasCreatedNew());
        myCourses.remove();
      }
    }
  }
}
