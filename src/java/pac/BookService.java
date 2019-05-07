/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/BookService")
@ApplicationPath("rest")
public class BookService extends Application {

    private static BookDaoNonPersistent bookDao = new BookDaoNonPersistent();
    private static List<Book> bookList = bookDao.getAllBooks();

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_XML)
    public List<Book> getBooks() {
        return bookList;
    }

    @GET
    @Path("/booksJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooksJSON() {
        return bookList;
    }

    @GET
    //För att metoden ska kunna hantera REST parametrar:   
    @Path("/book/{id}")
    @Produces(MediaType.APPLICATION_XML)
//specificera vilken del av URL som blir inparameter till metoden
    public Book getBookById(@PathParam("id") int id) {
        Book res = new Book();
        for (Book b : bookList) {
            if (b.getId() == id) {
                res = b;
            }
        }
        return res;
    }

    @GET
    //För att metoden ska kunna hantera REST parametrar:   
    @Path("/bookj/{id}")
    @Produces(MediaType.APPLICATION_JSON)
//specificera vilken del av URL som blir inparameter till metoden
    public Book getBookByIdJSON(@PathParam("id") int id) {
        Book res = new Book();
        for (Book b : bookList) {
            if (b.getId() == id) {
                res = b;
            }
        }
        return res;
    }

      @GET 
  @Path("/book/{idFrom}/{idTo}")
   @Produces(MediaType.APPLICATION_XML) 
   public List<Book> getBookByIdInterval(@PathParam("from") int from,
            @PathParam("to") int to
){ 
       List<Book> res = new ArrayList<Book>();
       for (Book b : bookList){
           if (b.getId() >= from && b.getId() <= to){
               res.add(b);
           }
       }
      return res;
   } 
    
       @GET 
   @Path("/book/interval") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<Book> getBookByIdInterval2(@QueryParam("from") int from, 
                                            @QueryParam("to") int to){ 
       List<Book> res = new ArrayList<Book>();
       for (Book b : bookList){
           if (b.getId() >= from && b.getId() <= to){
               res.add(b);
           }
       }
      return res;
   } 
   
   @GET 
   @Path("/book/{id}/delete") 
   @Produces(MediaType.APPLICATION_XML) 
   public Response deleteBookById(@PathParam("id") int id){ 
       Response res = new Response("Book deleted", Boolean.FALSE);
       
       int indexToRemove = -1;
       for (int i = 0; i < bookList.size(); i++){
           if (bookList.get(i).getId() == id){
               indexToRemove = i;
           }
       }

       if (indexToRemove != -1){
            bookList.remove(indexToRemove);
            res.setStatus(Boolean.TRUE);
       }

       //bookDao.persistBooks(bookList);      
       return res;
   }
   
     @POST
   @Path("/book/add") 
   public Response addBook(Book b){ 
       Response res = new Response("Book added", Boolean.FALSE);
       bookList.add(b);
       res.setStatus(Boolean.TRUE);
       //bookDao.persistBooks(bookList);
       return res;
   }

}
