public class Subject
{
  private int id;
  private int specialism;
  private int duration;
  private String description;
  
  public Subject(int id, int specialism, int duration){
      this.id = id;
      this.specialism = specialism;
      this.duration = duration;
  }
  
  public int getID(){
    return id;
  }
  
  public int getSpecialism(){
    return specialism;
  }
  
  public int getDuration(){
    return duration;
  }
  
  public String getDescription(){
      return description;
  }
  
  public void setDescription(String newDescription){
    description = newDescription;
  }
  
}
