package Algorithm;

import java.util.*;

public class PyramidTransition {
     static Map<String, List<Character>> map = new HashMap<>();

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s.charAt(2));
        }
        return dfs(bottom + "#", new HashSet<>());
    }

    static boolean dfs(String curr, HashSet<String> visited) {

        if(curr.length() == 1) return true;
        if(visited.contains(curr)) return false;

        String key = curr.substring(0, 2);
        if(key.charAt(1) == '#') return dfs(curr.substring(2) + "#", visited);

        for(Character c: map.getOrDefault(key, new ArrayList<>())) {
            if(dfs(curr.substring(1) + c, visited)) return true;
        }

        visited.add(curr);
        return false;
    }

    public static void main(String[] args) {
        String bottom = "BCD";
        String[] allowed = {"BCC","CDE","CEA","FFF"};
        List<String> allowedList = Arrays.asList(allowed);
        pyramidTransition(bottom, allowedList);
    }
}
