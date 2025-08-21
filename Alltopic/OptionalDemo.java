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
      }
    }

