public class Teacher extends Instructor
{
    public Teacher(String name, char gender, int age){
      super(name, gender, age);
  }
  
  public boolean canTeach(Subject subject){
    if (subject.getSpecialism() == 2 || subject.getSpecialism() == 1) return true;
    else return false;
  }
}
