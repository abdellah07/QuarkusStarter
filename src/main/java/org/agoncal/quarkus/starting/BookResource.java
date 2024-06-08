package org.agoncal.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
public class BookResource {

  @Inject
  BookRepository books;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Book> getBooks() {
    return books.getBooks();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  public Optional<Book> getBook(@PathParam("id") int id) {
    return books.getBook(id);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addBook(Book book) {
    books.addBook(book);
    return Response.status(Response.Status.CREATED).entity(book).build();
  }

  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public int getCount() {
    return books.getCount();
  }
}
