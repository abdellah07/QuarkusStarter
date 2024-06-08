package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class BookRepository {
  private final List<Book> books = new ArrayList<>();

  @Inject
  Logger logger;

  public List<Book> getBooks() {
    logger.info("Getting the book list");
    return books;
  }

  public void addBook(Book book) {
    logger.info("Book added successfully");
    books.add(book);
  }

  public int getCount() {
    logger.info("Book Repo contains "+books.size()+" books");
    return books.size();
  }

  public Optional<Book> getBook(int id) {
    return books.stream().filter(book -> book.id == id).findFirst();
  }
}
