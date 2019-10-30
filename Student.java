import java.util.*;

public class Student extends Person
{
  private Course course;
  ArrayList<Integer> certificates = new ArrayList<Integer>();
  private boolean isFree = true;
  
  public Student(String name, char gender, int age){
      super(name, gender, age);
  }
  
  public void graduate(Subject subject){
    certificates.add(subject.getID());
    course = null;
    isFree = true;
  }
  
  public ArrayList<Integer> getCertificates(){
    return certificates;
  }
  
  public boolean hasCertificate (Subject subject){
    if(certificates.contains(subject.getID())) return true;
    else return false;
  }
  
  public Course getCourse(){
    return course;
  }
  
  public void setCourse(Course course){
    if(isFree == true && course.getStudents().size() < 3){
      this.course = course;
      isFree = false;
    }
  }
  
  public boolean isFree(){
    return isFree;
  }
  
}
