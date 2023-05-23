import java.util.ArrayList;

class Library {
  private ArrayList<Book> books = new ArrayList<Book>();
  private ArrayList<Book> jurnal = new ArrayList<Book>();
  private ArrayList<Member> members = new ArrayList<Member>();

  public ArrayList<Book> getBooks(){
    return this.books;
  }

  public void setBooks(ArrayList<Book> books){
    this.books = books;
  }

  public ArrayList<Member> getMembers(){
    return this.members;
    }

  public void setMembers(ArrayList<Member> members){
    this.members = members;
    }

  public void addBook(Book book) {
    if (!isBookIdExist(book.getId())) {
      this.books.add(book);
}
  }
	  public Boolean isBookIdExist(String id) {
	    Boolean isExist = false;
	    for (Book book : this.books) {
	      if (book.getId().equals(id)) {
	        isExist = true;
          System.out.println("ID buku ini sudah terdaftar");
	      }
	    }
      for (Book book : this.jurnal) {
	      if (book.getId().equals(id)) {
	        isExist = true;
          System.out.println("ID buku ini sudah terdaftar");
	      }
	    }
	    return isExist;
	  }

  
  public void addMember(Member member) {
    if (!isMemberIdExist(member.getId())) {
      this.members.add(member);
}
  }


  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    for (Member member : this.members) {
      if (member.getId().equals(id)) {
        isExist = true;
        System.out.println("Id member ini sudah terdaftar");
      }
    }
    return isExist;
  }

  public void giveBook(String memberId, String bookId) {
    Book book = this.getBookById(bookId);

    Member member = this.getMemberById(memberId);
    if (member != null){
      this.jurnal.add(book);
      this.books.remove(book);
      int memberIndex = this.getMemberIndex(member);
      this.members.get(memberIndex).borrowedBooks.add(book);
    }

  }

  public void receiveBook(String bookId, String memberId) {
  try {
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);

    Book book = this.members.get(memberIndex).getBookById(bookId);
  if (book != null){
    this.jurnal.remove(book);
    this.books.add(book);
  }
    this.members.get(memberIndex).borrowedBooks.remove(book);
    System.out.println("Buku ini tidak dipinjam oleh member dengan ID " +memberId);
  } catch (IndexOutOfBoundsException e) {
  System.out.println("ID member tidak ada");
  }
    System.out.println("Buku ini berhasil dikembalikan");
  }

  

  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.getId().equals(id)) {
        return member;
        }
      }
    return null;
  }

  public Book getBookById(String id) {
    for (Book book : this.books) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }
}