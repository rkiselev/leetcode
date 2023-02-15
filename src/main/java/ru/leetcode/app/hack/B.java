
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            int repeats = Integer.parseInt(reader.readLine());
            String[] arr = new String[repeats];
            for(int i = 0; i < repeats; i++) {
                reader.readLine();
                arr[i] = reader.readLine();
            }
            for (String input: arr) {
                List<Sprinter> sprinters = new ArrayList<>();
                var seconds = input.split(" ");
                for (int i = 0; i < seconds.length; i++) {
                    sprinters.add(new Sprinter(i, Integer.parseInt(seconds[i])));
                }
                Collections.sort(sprinters);
                Map<Integer, Integer> indexToPosition = new HashMap<>();
                Sprinter prev = sprinters.get(0);
                int position = 1;
                int saved = 0;
                for (int i = 1; i < sprinters.size(); i++) {
                    if (sprinters.get(i).seconds - prev.seconds <= 1) {
                        saved++;
                    } else {
                        int backup = saved;
                        while(saved >= 0) {
                            indexToPosition.put(sprinters.get(i - saved - 1).index, position);
                            saved--;
                        }
                        position +=backup + 1;
                        saved = 0;
                    }
                    prev = sprinters.get(i);
                }
                if (sprinters.size() != indexToPosition.size()) {
                    int backup = saved;
                    while(saved >= 0) {
                        indexToPosition.put(sprinters.get(sprinters.size() - saved - 1).index, position);
                        saved--;
                    }
                    position +=backup + 1;
                    saved = 0;
                }
                List<String> result = new ArrayList<>();
                for (int j = 0; j < seconds.length; j++) {
                    result.add(String.valueOf(indexToPosition.get(j)));
                }
                System.out.println(String.join(" ", result));
            }
        } catch (Exception e) {
            System.out.println("I am a sinner");
        }
    }

    static class Sprinter implements Comparable<Sprinter>{
        int index;
        int seconds;
        public Sprinter(int index, int seconds) {
            this.index = index;
            this.seconds = seconds;
        }

        @Override
        public int compareTo(Sprinter o) {
            return Integer.compare(seconds, o.seconds);
        }
    }
}
