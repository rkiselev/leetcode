package ru.leetcode.app.yandex;

import java.util.*;

public class FunctionOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<String, List<String>> dependencies = new HashMap<>();
        Set<String> functions = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String names = scanner.next();
            int numDependencies = scanner.nextInt();
            List<String> dependentFunctions = new ArrayList<>();
            for (int j = 0; j < numDependencies; j++) {
                dependentFunctions.add(scanner.next());
            }
            dependencies.put(names, dependentFunctions);
            functions.add(names);
        }

        List<String> ordered = getOrder(dependencies, functions);
        System.out.println(String.join(" ", ordered));
    }

    private static List<String> getOrder(Map<String, List<String>> dependencies, Set<String> allFunctions) {
        var orderedFunctions = new ArrayList<String>();
        var visited = new HashSet<String>();
        for (String functionName : allFunctions) {
            if (!visited.contains(functionName)) {
                dfs(functionName, dependencies, visited, orderedFunctions);
            }
        }
        return orderedFunctions;
    }

    private static void dfs(String functionName, Map<String, List<String>> dependencies, Set<String> visited, List<String> orderedFunctions) {
        visited.add(functionName);
        List<String> functions = dependencies.get(functionName);
        if (functions != null) {
            for (String dependent : functions) {
                if (!visited.contains(dependent)) {
                    dfs(dependent, dependencies, visited, orderedFunctions);
                }
            }
        }
        orderedFunctions.add(functionName);
    }
}
