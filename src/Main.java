import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Set<Integer> setOf(int[] set) {
        return Arrays.stream(set).boxed().collect(Collectors.toSet());
    }

    public static Set<Set<Integer>> powerSet(Set<Integer> set){
        //
        Set<Set<Integer>> powerSet = new HashSet<>();

        //Convert set to list
        List<Integer> setCopy = new ArrayList<>(set);
        int totalSets = 1 << set.size();
        for(int i = 0; i < totalSets; i++){
            Set<Integer> subset = new HashSet<>();
            for(int j = 0; j < set.size(); j++){
                if((i & (i << j)) != 0) {
                    subset.add(setCopy.get(j));
                }
            }
            powerSet.add(subset);
        }

        return powerSet;
    }

    public static List<List<Integer>> cartesianProduct(Set<Integer> setS, Set<Integer> setT) {
        // Convert to lists to maintain order
        List<List<Integer>> cartesianProduct = new ArrayList<>();
        List<Integer> setSCopy = new ArrayList<>(setS);
        List<Integer> setTCopy = new ArrayList<>(setT);
        for(int i = 0; i < setS.size(); i++) {
            for(int j = 0; j < setT.size(); j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add(setSCopy.get(i));
                pair.add(setTCopy.get(j));
                cartesianProduct.add(pair);
            }
        }
        return cartesianProduct;
    }

    //Union of setS and setT
    public static Set<Integer> union(Set<Integer> setS, Set<Integer> setT){
        Set<Integer> unionSet = new HashSet<>(setS);
        unionSet.addAll(setT);
        return unionSet;
    }

    //Intersection of setS and setB
    public static Set<Integer> intersection(Set<Integer> setS, Set<Integer> setT) {
        Set<Integer> intersectionSet = new HashSet<>(setS);
        intersectionSet.retainAll(setT);
        return intersectionSet;
    }

    //Difference of setS and setB
    public static Set<Integer> difference(Set<Integer> setS, Set<Integer> setT) {
        Set<Integer> differenceSet = new HashSet<>(setS);
        differenceSet.removeAll(setT);
        return differenceSet;
    }

    // Complement of set with respect to the universal set (integers from 1 to 100)
    public static Set<Integer> complement(Set<Integer> set) {
        Set<Integer> universalSet = new HashSet<>();
        for (int i = 1; i <= 100; i++) {
            universalSet.add(i);
        }

        Set<Integer> complementSet = new HashSet<>(universalSet);
        complementSet.removeAll(set);
        return complementSet;
    }



    public static void main(String[] args) {
        //Get sets from users
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Set S values with spaces in between values: ");
        String set1Values = scanner.nextLine();
        String[] set1 = set1Values.split(" ");
        int[] set1Ints = new int[set1.length];
        //convert to integers
        for(int i = 0; i < set1.length; i++){
            set1Ints[i] = Integer.parseInt(set1[i]);
        }

        System.out.println("Enter Set T values with spaces in between values: ");
        String set2Values = scanner.nextLine();
        String[] set2 = set2Values.split(" ");
        int[] set2Ints = new int[set2.length];
        for(int i = 0; i < set2.length; i++){
            set2Ints[i] = Integer.parseInt(set2[i]);
        }

        Set<Integer> setS = setOf(set1Ints);
        Set<Integer> setT = setOf(set2Ints);

        System.out.println("Set S: " + setS);
        System.out.println("Set T: " + setT + "\n");

        System.out.println("Power Set of S: " + powerSet(setS));
        System.out.println("Power Set of T: " + powerSet(setT) + "\n");

        System.out.println("Cartesian Product: " + cartesianProduct(setS, setT));

        System.out.println("Union: " + union(setS, setT));
        System.out.println("Intersection: " + intersection(setS, setT));
        System.out.println("Difference: " + difference(setS, setT));

        System.out.println("Complement of Set S: " + complement(setS));
        System.out.println("Complement of Set T: " + complement(setT));
    }
}