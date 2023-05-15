import java.util.ArrayList;

abstract class User{
    private String id;
    private String name;

    //encapsulation
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    
        public void setName(String name){
            this.name = name;
        }

    public String getName(){
        return name;
    }

    abstract void display();
}

class Member extends User{

 public ArrayList<Book> borrowedBooks = new ArrayList<Book>();
   
  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }

  public Book getBookById(String bookId) {
    for (Book book : this.borrowedBooks) {
      if (book.getId().equals(getId())) {
        return book;
      }
    }
    return null;
  }  

  @Override
  void display(){
     System.out.println("ID " + getId() + " on behalf of " + getName());
  }
}