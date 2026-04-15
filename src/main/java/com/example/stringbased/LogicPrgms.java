public class Anagram {
 
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

 //

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
 
    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));   // true
        System.out.println(isAnagram("earth", "heart"));     // true
        System.out.println(isAnagram("hello", "world"));     // false
    }
}
