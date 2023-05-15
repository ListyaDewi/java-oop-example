import java.util.InputMismatchException;
import java.util.Scanner;

class Main extends Book{
  //ini merupakan inheritence dari class Book karena akan terjadi polimorfisme dari class Book

  static Scanner scan = new Scanner(System.in);
  static Library library = new Library();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();
      try{
      if (selectedMenu == 1) {
        showBooks();
      } else if (selectedMenu == 2) {
        showMembers();
      } else if (selectedMenu == 3) {
        addMember();
      } else if (selectedMenu == 4) {
        borrowBook();
      } else if (selectedMenu == 5) {
        returnBook();
      } else if (selectedMenu == 6) {
        addBook();
      } else {
        throw new Exception("Pilih opsi di atas!");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
      System.out.print("continue ? ");
      isContinue = scan.next();
    } //ini merupakan try-catch yang digunakan untuk menangkap kesalahan input saat memilih menu yang nantinya akan mengeluarkan pesan message jika input melebihi pilihan yang tersedia
  }

  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. show books list");
    System.out.println("2. show members list");
    System.out.println("3. add member");
    System.out.println("4. borrow book");
    System.out.println("5. return book");
    System.out.println("6. add book");
    System.out.println("================================");
  }

  public static void initLibraryData() {
    Book book1 = new Book();
    book1.id = "1";
    book1.title = "pemrograman java";

    Book book2 = new Book();
    book2.id = "2";
    book2.title = "pemrograman oop";

    Book book3 = new Book();
    book3.id = "3";
    book3.title = "pemrograman android";

    Member member1 = new Member();
    member1.id = "1";
    member1.name = "aka";

    Member member2 = new Member();
    member2.id = "2";
    member2.name = "budi";

    Member member3 = new Member();
    member3.id = "3";
    member3.name = "tono";

    library.getBooks().add(book1);
    library.getBooks().add(book2);
    library.getBooks().add(book3);

    library.getMembers().add(member1);
    library.getMembers().add(member2);
    library.getMembers().add(member3);
  }

  public static int chooseMenu() {
    int pilihan = 0;
    boolean validInput = false;

    while (!validInput){
      try{
        System.out.print("choose menu : ");
        pilihan = scan.nextInt();
        validInput = true;
    }catch (InputMismatchException e){
      System.out.println("Invalid input");
      scan.next();
    }
  }
    return pilihan;
  }

  public static void showBooks() {
    for (Book book : library.getBooks()) {
      System.out.println(book.id + " " + book.title);
    }
  }

//ini adalah commit pertama saya di github

  public static void showMembers() {
    for (Member member : library.getMembers()) {
      System.out.println(member.id + " " + member.name);
    }
  }

  //testt

  public static void addMember() {
    Member member = new Member();

    System.out.print("id : ");
    member.id = scan.next();

    System.out.print("name : ");
    member.name = scan.next();

    library.addMember(member);
  }

  public static void addBook() {
    Book book = new Book();

    System.out.print("id : ");
    book.id = scan.next();

    System.out.print("title : ");
    book.title = scan.next();


    library.addBook(book);
  }

  public static void borrowBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.giveBook(memberId, bookId);
  }

  public static void returnBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.receiveBook(memberId, bookId);
  }
}