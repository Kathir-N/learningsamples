public class Anagram {

  public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));   // true
        System.out.println(isAnagram("earth", "heart"));     // true
        System.out.println(isAnagram("hello", "world"));     // false
    }
 
    static boolean isAnagram(String a, String b) {
        // Remove spaces and convert to lowercase
        a = a.replaceAll(" ", "").toLowerCase();
        b = b.replaceAll(" ", "").toLowerCase();
 
        // If lengths differ, not an anagram
        if (a.length() != b.length()) return false;
 
        // Sort both strings and compare
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
 
        return Arrays.equals(arr1, arr2);
    }


//Output?

  List<Student> students = Arrays.asList(
    new Student("Alice"),
    new Student("Alice")
);

List<Student> distinctStudents = students.stream()
    .distinct()
    .toList();

System.out.println(distinctStudents.size());




 //If Student does NOT override equals & hashCode
➡️ Output: Size: 2

Why?

Two new Student("Alice") = two different objects in memory
Default equals() (from Object) = reference comparison (==)
So they are treated as different

👉 If Student overrides equals & hashCode properly
➡️ Output: Size: 1

 // --- Model Classes (assumed) ---
record Item(int id, String name, double price, int quantity) {}
record Order(int id, List<Item> items) {}


// --- Data Setup ---
List<Order> order1 = List.of(
    new Order(1, List.of(
        new Item(1, "comb",   20, 1),
        new Item(2, "brush",  10, 1)
    ))
);

List<Order> order2 = List.of(
    new Order(1, List.of(
        new Item(2, "splcomb",  40, 1),
        new Item(4, "apbrush", 120, 1)
    ))
);

List<Order> allOrders = List.of(order1.get(0), order2.get(0));


// --- Stream Pipeline ---
List<Item> result = allOrders.stream()
    .flatMap(o -> o.items().stream())                            // ✅ flatten all items
    .sorted(Comparator.comparingDouble(i -> i.price() * i.quantity())) // ✅ sort by price × qty
    .limit(3)                                                    // ✅ take top 3
    .collect(Collectors.toList());                               // ✅ collect
 
   ------------------------------------------

Input: [2, 1, 5, 1, 3, 2], k = 3


1. Take first k numbers and add them.
  [2, 1, 5], 1, 3, 2
sum = 2 + 1 + 5 = 8
maxSum = 8
2. Slide one step → add new, subtract old.
  2, [1, 5, 1], 3, 2
       ↑ new (1)
   ↑ old leaving (2)

sum = 8 + 1 - 2 = 7
maxSum = 8  (8 is still bigger)

  2, 1, [5, 1, 3], 2
          ↑ new (3)
      ↑ old leaving (1)

sum = 7 + 3 - 1 = 9
maxSum = 9  ✅ (new biggest!)

  2, 1, 5, [1, 3, 2]
              ↑ new (2)
          ↑ old leaving (5)

sum = 9 + 2 - 5 = 6
maxSum = 9  (9 is still bigger)
  
  3. Keep track of the biggest sum you see. with example

All sums seen: 8, 7, 9, 6
Biggest sum   = 9  ✅
  


  
}
