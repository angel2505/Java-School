import java.util.*;

abstract class Instructor extends Person
{
  private Course assignedCourse = null;
  private boolean hasAssignedCourse = false;
  //private String type;
  
  public Instructor(String name, char gender, int age){
      super(name, gender, age);
  }
  
  public void assignCourse(Course course){
    if(hasAssignedCourse == true) System.out.println("");
    else {
      assignedCourse = course;
      hasAssignedCourse = true;
    }
  }
  
  public boolean hasAssignedCourse(){
    return hasAssignedCourse;
  }
  
  public void unassignCourse(){
    assignedCourse = null;
  }
  
  public Course getAssignedCourse(){
    return assignedCourse;
  }
  
  public abstract boolean canTeach(Subject subject);
    
  /*public String getType(){
    return type;
  }*/
  
}