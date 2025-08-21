package JavaDemo.Alltopic;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {


    //Optional is a container object which may or may not contain a value.
    // It is used to avoid null checks and NullPointerExceptions.
    //It provides methods to handle the presence or absence of a value and handle it safely.

     String[] words = new String[10];

     Optional<String> checkNull = Optional.ofNullable(words[5]);

      //check if the value is present
      if(checkNull.isPresent()) {
         String word = words[5].toLowerCase();
          System.out.println(word);
      } else {
          System.out.println("word is null");
      }



      //java program to illustrate some optional class methods
         
        //creating a string array
          String[] str = new String[5];

          //setting value for 2nd index
           str[2] = "i am ravi kumar";

           // it retuns an non-empty optional 
           Optional<String> value = Optional.of(str[2]);

           //it returns value of an optional. if value is not present, it throws no such exception
            System.out.println(value.get());

            // it returns hashcode of the value
            System.out.println(value.hashCode());

            //it returnss true if value is present, else false
            System.out.println(value.isPresent());
      }
    }

