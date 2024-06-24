
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] teams = {
            {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
            {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
            {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]

    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        int[] top10 = teams[0];
        for (int i = 0; i < teams.length - 1; i++) {
            top10 = merge(top10, teams[i + 1]);
        }
        return top10;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int[] top10 = new int[10];
        int aCounter = 0;
        int bCounter = 0;
        int counter = 0;
        while (true) {

            if (teamA[aCounter] >= teamB[bCounter]) {
                top10[counter] = teamA[aCounter];
                aCounter++;
                counter++;
            } else if (teamA[aCounter] < teamB[bCounter]) {
                top10[counter] = teamB[bCounter];
                bCounter++;
                counter++;
            }
            if (aCounter + bCounter == 10) {
                break;
            }
        }
        return top10;
    }
}
