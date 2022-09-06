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
            actual.add(scanner.nextInt());
        }
        for (int i = 0; i<n; i++)
        {
            expected.add(scanner.nextInt());
        }
        boolean[] isRightPlace = new boolean[actual.size()];
        Arrays.fill(isRightPlace, false);
        for(int i = 0; i<n; ++i){
            if(!isRightPlace[i]){
                int minWeightLoop = 999999;
                int loopScore = 0;
                int currentIndex = i;
                int steps = 0;
                for(;;)
                {
                    minWeightLoop = Math.min(minWeightLoop, weights.get(currentIndex));
                    loopScore += weights.get(currentIndex);
                    currentIndex = expected.get(currentIndex);
                    isRightPlace[currentIndex] = true;
                    steps++;
                    if((currentIndex==i)) break;
                }
                score += Math.min(loopScore+(steps-2)*minWeightLoop, loopScore+minWeightLoop+(steps+1)*minWeight);
            }
            System.out.println(score);
        }


/*

        long wynik = 0;
        for (int pocz = 0; pocz<N; ++pocz)
            if (!vis[pocz])
            {
                int minc = INF; // minimalna waga w cyklu
                long suma = 0; // suma wag w cyklu
                int cur = pocz;
                int dl = 0; // dlugosc cyklu
                for (;;)
                {
                    minc = Math.min(minc, wagi[cur]);
                    suma += wagi[cur];
                    cur = perm[cur];
                    vis[cur] = true;
                    ++dl;
                    if (cur==pocz)
                        break;
                }
                wynik += Math.min(suma+(dl-2)*(long)minc, suma+minc+(dl+1)*(long)minw);
            }
        System.out.println(wynik);*/
    }
}