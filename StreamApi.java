package JavaDemo;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamApi {
      public static void main(String[] args) {
         //list of lists of names
         List<List<String>> names = Arrays.asList(
            Arrays.asList("Reflection", "Collection", "Stream"),
            Arrays.asList("Structure", "Data", "Algorithm"),
            Arrays.asList("Sorting", "Searching", "Hashing")
         );

        // create a set to hold intermediate results
         Set<String> intermediateResults = new HashSet<>();

        //  Stream pipeline demonstrating various intermediate operations
         List<String> result = names.stream()
            .flatMap(List::stream)  // flatten the collection of list into a single stream
            .filter(s -> s.startsWith("S"))  // filter names starting with 's'
            .map(String::toUpperCase)        // transform names to uppercase
            .distinct()                     //remove duplicates
            .sorted()                      //sort the names
            .peek(s -> intermediateResults.add(s)) // add to intermediate results 
            .collect(Collectors.toList());   //collect the final results into a list 



       //print the intermediate results
        System.out.println("intermediate results:");
        intermediateResults.forEach(System.out::println);

        //print the final results
        System.out.println("final results:");
        result.forEach(System.out::println);


        List<String> nm = Arrays.asList(
            "Reflection", "collection", "Stream",
            "Structure", "Data", "Algorithm"
        );

      
        //forEach: print each name
        System.out.println("forEach:");
        nm.stream().forEach(System.out::println);

        //collect: collect names into a set
        List<String> snam = nm.stream()
                                .filter(nam -> nam.startsWith("S"))
                                .collect(Collectors.toList());

            System.out.println("collecting names starting with s:");
            snam.forEach(System.out::println);

        //reduce : concatenate all names into a single string
        String concatenatednam = nm.stream().reduce(
            "", 
            (partialString, element) -> partialString + element + " " + element
        );
        System.out.println("\nreduce (concatenated nam):");
        System.out.println(concatenatednam.trim());

        //count : count the number of names
        long count = nm.stream().count();
        System.out.println("count of nam:");
        System.out.println(count);

        //findFirst: find the first name
        Optional<String> firstName = nm.stream().findFirst();
            System.out.println("\nfindfirst:");
            firstName.ifPresent(System.out::println);

            //all Match: check if all names start with "s"
            boolean allStartWithS = nm.stream()
            .allMatch(sname -> sname.startsWith("S"));

            System.out.println("\n allMatch(all start with 'S'):");
            System.out.println(allStartWithS);

            //anyMatch: check if any name starts with 's'
            boolean anyStartWithS = nm.stream()
                                      .anyMatch(anyname -> anyname.startsWith("S"));
             System.out.println("\nanyMatch ( any start withs 'S'):");
             System.out.println(anyStartWithS);
      }  
}
