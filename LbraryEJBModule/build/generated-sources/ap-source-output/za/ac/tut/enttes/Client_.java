package za.ac.tut.enttes;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.enttes.Address;
import za.ac.tut.enttes.Book;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-12T20:01:37")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, Address> address;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, String> username;
    public static volatile ListAttribute<Client, Book> booksOwned;

}