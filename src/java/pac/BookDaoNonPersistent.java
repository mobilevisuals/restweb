/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookDaoNonPersistent  {
    
    public List<Book> getAllBooks(){ 
      
      List<Book> bookList = new ArrayList<>(); 
      Book b1 = new Book(1,"Wuthering Heights", "Emily Bronte");
      Book b2 = new Book(2, "Jayne Eyre", "Charlotte Bronte");
      Book b3 = new Book(3, "Crime and Punishment", "Fjodor Dostovjevsky");
      Book b4 = new Book(4, "Madame Bovary", "Gustave Flaubert");
      Book b5 = new Book(5, "Catcher in the Rye", "J.D. Salinger");
      Book b6 = new Book(6, "Pale King", "David Foster Wallace");
      Book b7 = new Book(7, "Sandman, vol 1", "Neil Gaiman");
      
      bookList.add(b1);
      bookList.add(b2);
      bookList.add(b3);
      bookList.add(b4);
      bookList.add(b5);
      bookList.add(b6);
      bookList.add(b7);
      
      return bookList; 
   } 

    
       
}
