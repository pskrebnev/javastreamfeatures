package newfeatures.java9.collections;

import java.util.AbstractMap;
import java.util.Map;

public class CollectionEnhancements {
    public static void main(String[] args) {

//        List<String> oldStyleList = new ArrayList<>();
//        oldStyleList.add("Old Style");
//        oldStyleList = Collections.unmodifiableList(oldStyleList);
//        System.out.println("List, old style: " + oldStyleList);
//
//        List<String> emptyList = List.of();
//        System.out.println(emptyList);
//        List<String> stringList = List.of("Eazy", "Bytes", "Java 9");
//        System.out.println(stringList);
//        List<Integer> numList = List.of(1, 4, 5, 8);
//        System.out.println(numList);

//        Set<String> oldStyleSet = new HashSet<>();
//        oldStyleSet.add("Old Style");
//        oldStyleSet =Collections.unmodifiableSet(oldStyleSet);
//        System.out.println("Set, old style: " + oldStyleSet);
//
//        Set<String> emptySet = Set.of();
//        System.out.println(emptySet);
//        Set<String> stringSet = Set.of("Eazy", "Bytes", "Java 9");
//        System.out.println(stringSet);
//        Set<Integer> numSet = Set.of(1, 4, 5, 8);
//        System.out.println(numSet);

//        Map<String, String> oldStyleMap = new HashMap<>();
//        oldStyleMap.put("Old", "Style");
//        System.out.println(oldStyleMap);
//        oldStyleMap =Collections.unmodifiableMap(oldStyleMap);

//        Map<String, String> emptyMap = Map.of();
//        Map<String, String> emptyMapEntries = Map.ofEntries(Map.entry("Key1", "Value1"),
//                Map.entry("Key2", "Value2"),
//                Map.entry("Key3", "Value3"));
//        System.out.println(emptyMap);
//        System.out.println(emptyMapEntries);

        Map<String, String> inputMap = Map.of("Eazy", "Bytes", "Java9", "Great");
        System.out.println("Input map: " + inputMap);

        Map<Integer, String> inputEntryMap = Map.ofEntries(new AbstractMap.SimpleEntry<>(1, "Hello"),
                new AbstractMap.SimpleEntry<>(2, "Eazy Bytes"));

        System.out.println("Input entry map" + inputEntryMap);
    }

}
