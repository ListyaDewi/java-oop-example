abstract class Identity {
  private String id;
  private String title;

  public void setId(String id){
    this.id = id;
  }

  public String getId(){
    return id;
  }

  public void setTitle(String title){
    this.title = title;
  }

  String getTitle(){
    return title;
  }
  abstract void display();

  }

  class Book extends Identity{
    void display(){
      System.out.println("ID " +getId() + " the title is " +getTitle());
    }


  }

