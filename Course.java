import java.util.*;

public class Course
{
  private Subject subject;
  private String name;
  private int daysUntilStarts;
  private int daysToRun;
  private boolean hasInstructor;
  private boolean hasCreatedNew;
  private boolean isCancelled;
  private ArrayList<Student> students = new ArrayList<Student>();
  Instructor instructor;
  
  public Course(Subject subject, int daysUntilStarts){
    this.subject = subject;
    this.daysUntilStarts = daysUntilStarts;
    daysToRun = subject.getDuration();
  }
  
  public Subject getSubject(){
    return subject;
  }
  
  public int getStatus(){
    if(daysUntilStarts > 0) 
    return (0 - daysUntilStarts);
    else if (daysToRun > 0) 
    return daysToRun;
    else return 0;
  }
  
  public void aDayPasses(){
    if(daysUntilStarts==0 && (hasInstructor == false || students.size() == 0)){
      isCancelled = true;
      daysToRun = 0;
      instructor.unassignCourse();
      students.clear();
    }
    else if(daysUntilStarts>0)
    daysUntilStarts--;
    else if(daysToRun>0)
    daysToRun--;
    if(daysToRun == 0 && isCancelled == false){
      instructor.unassignCourse();
      for(Student student: students){
        student.graduate(subject);
      }
    }
  }
  
  public boolean enrolStudent(Student student){
    if(daysUntilStarts == 0 || students.size() == 3) return false;
    else{
      students.add(student);
      student.setCourse(this);
      return true;
    }
  }
  
  public int getSize(){
    return students.size();
  }
  
  public ArrayList<Student> getStudents(){
    return students;
  }
  
  public boolean setInstructor (Instructor instructor){
    if(instructor.canTeach(subject) && instructor.hasAssignedCourse() == false){
      instructor.assignCourse(this);
      this.instructor = instructor;
      hasInstructor = true;
      return true;
    }
    else return false;
  }
  
  public Instructor getInstructor(){
    return instructor;
  }
  
  public boolean hasInstructor(){
    return hasInstructor;
  }
  
  public boolean isCancelled(){
    return isCancelled;
  }
  
  public void setName(String newName){
    name = newName;
  }
  
  public String getName(){
    return name;
  }
  
  public void createNew(){
    hasCreatedNew = true;
  }
  
  public boolean hasCreatedNew(){
    return hasCreatedNew;
  }
  
}