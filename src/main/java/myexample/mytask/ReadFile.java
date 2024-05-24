package myexample.mytask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadFile {
    private static final List<String> rowResults = new ArrayList<>();

    public static void main(String[] args) {
        initResults(rowResults);
        List<String> winnersList = getWinnersList(rowResults);

        Map<String, Long> winnersMap = winnersList.stream().collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        winnersMap.forEach((team, win) -> System.out.println("Team '" + team + "' with wins = " + win));
    }

    private static List<String> getWinnersList(List<String> rowList) {
        return rowList.stream()
                .map(match -> {
                    String[] game = match.split(",");
                    String[] teams = game[0].split(":");
                    String[] scores = game[1].split(":");
                    String team1 = teams[0].trim();
                    String team2 = teams[1].trim();
                    int s1 = Integer.parseInt(scores[0].trim());
                    int s2 = Integer.parseInt(scores[1].trim());
                    return (s1 != s2 && !team1.equals(team2)) ? (s1 > s2 ? team1 : team2) : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static List<String> initResults(List<String> list) {
        String fileName = "results.txt";
        ClassLoader cl = ReadFile.class.getClassLoader();
        InputStream is = cl.getResourceAsStream(fileName);

        try {
            assert is != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
