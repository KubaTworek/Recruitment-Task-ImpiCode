import java.util.*;

public class Slonie {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n, score = 0, minWeight = 999999;
        List<Integer> weights = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        n = scanner.nextInt();
        for (int i = 0; i<n; i++)
        {
            weights.add(scanner.nextInt());
            minWeight = Math.min(minWeight, weights.get(i));
        }
        for (int i = 0; i<n; i++)
        {
            actual.add(scanner.nextInt()-1);
            expected.add(null);
        }
        for (int i = 0; i<n; i++)
        {
            expected.set(scanner.nextInt()-1, actual.get(i));
        }

        boolean[] isRightPlace = new boolean[actual.size()];
        Arrays.fill(isRightPlace, false);
        for(int i = 0; i<n; i++){
            if(!isRightPlace[i]){
                int minWeightLoop = 999999, loopScore = 0, currentIndex = i, steps = 0;

                do {
                    minWeightLoop = Math.min(minWeightLoop, weights.get(currentIndex));
                    loopScore += weights.get(currentIndex);
                    currentIndex = expected.get(currentIndex);
                    isRightPlace[currentIndex] = true;
                    steps++;
                } while(currentIndex!=i);

                score += Math.min(loopScore+(steps-2)*minWeightLoop, loopScore+minWeightLoop+(steps+1)*minWeight);
            }
        }
        System.out.println(score);
    }
}