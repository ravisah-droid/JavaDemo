package JavaDemo.Alltopic;

import java.sql.*;
import java.util.*;
import java.util.stream.*;


// streams and database -------- connections
// 1. JDBC(Java Database connectivity) is used to talk to relational databases(oracle)
// 2. Normally, we run a query -> get a result set -> iterate through while(rs.next()).
// 3. with streams, we convert database results into stream<T> and use operations like 
//     map, filter,collect .


public class DatabaseOperation {
     public static void main(String[] args)throws Exception{
           Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/testdb", "user", "pass");
    

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM users");

          //convert ResultSet to Stream
          Stream<User> userStream = StreamSupport.stream(
                                                     Spliterators.spliteratorUnknownSize(new Iterator<User>(){
                                                        public boolean hasNext() {
                                                            try{return rs.next();}
                                                            catch(SQLException e) {throw new RuntimeException(e); }
                                                        }
                                                        public User next() {
                        try {
                            return new User(rs.getInt("id"), rs.getString("name"));
                        } catch (SQLException e) { throw new RuntimeException(e); }
                    }
                },
                Spliterator.ORDERED
            ),
            false
          );


          // stream operations
          List<String> names = userStream 
                                       .map(User::getName)
                                       .filter(n -> n.startsWith("R"))
                                       .collect(Collectors.toList());

                //print results
                names.forEach(System.out::println);
             }
}

class User {
    private int id;
    private String name;
    public User(int id, String name) { this.id = id; this.name = name; }
    public String getName() { return name; }
}