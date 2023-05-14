import java.util.ArrayList;

interface Borrower {
  void receiveBook(Book book);
  void giveBook(Book book);
  Book getBookById(String bookId);
}

class Member implements Borrower {
  public String id;
  public String name;
  public ArrayList<Book> borrowedBooks = new ArrayList<Book>();

  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }

  public Book getBookById(String bookId) {
    for (Book book : this.borrowedBooks) {
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }  
}