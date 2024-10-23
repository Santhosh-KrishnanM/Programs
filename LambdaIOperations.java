import java.util.*;
import java.util.function.Function;
//import java.util.function.Consumer;

class LambdaOperations {

   public static List<String> getInput(Scanner scan) {
      System.out.print("Enter no.of strings: ");
      int n = scan.nextInt();
      scan.nextLine();
      List<String> l = new ArrayList<>();
      System.out.println("Enter string elements: ");
      for (int i = 0; i < n; i++) {
         l.add(scan.nextLine());
      }
      return l;
   }

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      List<String> list = getInput(scan);

      Function<List<String>, List<String>> convertCase = (List) -> {
         List<String> res = new ArrayList<>();
         for (String s : List) {
            if (s.length() % 2 == 0) {
               res.add(s.toUpperCase());
            } else {
               res.add(s.toLowerCase());
            }
         }
         return res;
      };

      Function<List<String>, List<String>> sort = (List) -> {
         for (int i = 0; i < List.size() - 1; i++) {
            for (int j = i + 1; j < List.size(); j++) {
               if (List.get(i).length() > List.get(j).length()) {
                  String temp = List.get(i);
                  List.set(i, List.get(j));
                  List.set(j, temp);
               }
            }
         }
         return List;
      };

      Function<List<String>, List<String>> remDup = (List) -> {
         List<String> res1 = new ArrayList<>();
         for (String s1 : List) {
            if (!res1.contains(s1)) {
               res1.add(s1);
            }
         }
         return res1;
      };
 
      System.out.println("After case conversion: " + convertCase.apply(list));
      System.out.println("After sorting by length: " + sort.apply(list));
      System.out.println("After removing duplicates: " + remDup.apply(list));
   }
}
