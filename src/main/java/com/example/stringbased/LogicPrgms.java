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
 
    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));   // true
        System.out.println(isAnagram("earth", "heart"));     // true
        System.out.println(isAnagram("hello", "world"));     // false
    }
}
