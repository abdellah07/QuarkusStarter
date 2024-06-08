package org.agoncal.quarkus.starting;

public class Book {
  public int id;
  public String title;
  public String genre;

  public Book() {
    this(0, "default", "none");
  }

  public Book(int id, String title, String genre) {
    this.id = id;
    this.title = title;
    this.genre = genre;
  }

}
