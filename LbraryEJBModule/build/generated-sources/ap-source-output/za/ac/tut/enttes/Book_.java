package za.ac.tut.enttes;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.enttes.Author;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-12T20:01:37")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile ListAttribute<Book, Author> author;
    public static volatile SingularAttribute<Book, Double> price;
    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile SingularAttribute<Book, Date> publishDate;
    public static volatile SingularAttribute<Book, byte[]> bookCopy;
    public static volatile SingularAttribute<Book, Long> id;
    public static volatile SingularAttribute<Book, String> title;

}