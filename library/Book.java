import java.util.ArrayList;

class Book {
  private static ArrayList<Book> books = new ArrayList<Book>();
  public String id;
  public String title;
  static ArrayList<Book> getBooks(){
    return books;
  }
  public static void showBooks() {
    for (Book book : Book.getBooks()) {
      System.out.println("Buku yang dipinjam adalah : " + book.title);
    }
  }
}
//dari eclipse