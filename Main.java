public class Main
{
  public static void main(String[] args)
  {
      School school = new School("my school");
      Subject sub1 = new Subject(1,1,5);
      Subject sub2 = new Subject(2,2,2);
      Subject sub3 = new Subject(3,3,4);
      Course course1 = new Course (sub1, 1);
      course1.setName("Maths");
      // Course course2 = new Course (sub2, 2);
      // course2.setName("English");
      Course course3 = new Course (sub3, 3);
      course3.setName("Physics");
      Student stu1 = new Student("Peter",'M',60);
      Student stu2 = new Student("John",'M',22);
      Student stu3 = new Student("Annabelle",'F',31);
      Student stu4 = new Student("Maggie",'F',58);
      Student stu5 = new Student("Alex",'M',23);
      Teacher t1 = new Teacher("Yvonne",'F',55);
      Demonstrator d1 = new Demonstrator("Beth", 'F', 45);
      OOTrainer oo1 = new OOTrainer("Chris", 'M', 62);
      GUITrainer gui1 = new GUITrainer("Sarah", 'F', 48);
      school.add(sub1);
      school.add(sub2);
      school.add(sub3);
      school.add(course1);
      // school.add(course2);
      school.add(course3);
      school.add(stu1);
      school.add(stu2);
      school.add(stu3);
      school.add(stu4);
      school.add(stu5);
      school.add(t1);
      school.add(d1);
      school.add(oo1);
      school.add(gui1);
      System.out.println(school.getInstructors());
      System.out.println(school.toString() + "\n\n\n");
      school.aDayAtSchool();
      System.out.println(school.toString() + "\n\n\n");
      school.aDayAtSchool();
      System.out.println(school.toString() + "\n\n\n");
      school.aDayAtSchool();
      System.out.println(school.toString());
      school.aDayAtSchool();
      System.out.println(school.toString());
      school.aDayAtSchool();
      System.out.println(school.toString());
      school.aDayAtSchool();
      System.out.println(school.toString());
  }
}
