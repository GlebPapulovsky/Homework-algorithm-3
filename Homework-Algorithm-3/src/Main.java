
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
            {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
            {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
            {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        //int[] nationalTeam = mergeAll(teams);
        //System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]

        //test another sorts
        int[] testMas={1,5,-1,2,1,-4,5,6,7,1,6,-5,4,-3,2,1};
        System.out.println(Arrays.toString(quickSortAll(testMas)));


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
        int Acounter = 0;
        int Bcounter = 0;
        for (int i = 0; i < 10; i++) {
            if (teamA[Acounter] > teamB[Bcounter]) {
                top10[i] = teamA[Acounter];
                Acounter++;
            } else if (teamA[Acounter] < teamB[Bcounter]) {
                top10[i] = teamB[Bcounter];
                Bcounter++;
            } else {
                top10[i] = teamA[Acounter];
                i++;
                if (i == 10) {
                    break;
                
                }  
                top10[i]=teamB[Bcounter];
                Acounter++;
                Bcounter++;
            }
        }
        return top10;
    }

    //quick sort test
    public static int[] quickSortAll(int[] team){

        if (team.length==1)return team;
        if (team.length==0)System.err.println("!!!!!!!!!!!!!!!!!!!");
        int pi=team.length/2;
        int border=pivoting(team,pi);
        quickSortAll( Arrays.copyOfRange(team, 0, border));
        quickSortAll( Arrays.copyOfRange(team, border, team.length-1));
        return team;
    }
    public static int pivoting(int[] mas,int pi){
        int left=0;
        int right=mas.length-1;
        int pivot=mas[pi];
        while(true){
            while(mas[left]<pivot){
                left++;
            }
            while(mas[right]>pivot){
                right--;
            }
            if(left>=right){
                return left;
            }
            mas=swap(mas,left,right);
            left++;
            right--;

        }

           
    }
    public static int[] swap(int[]mas,int left, int right){
        if (right<mas.length && left<mas.length){
            int swapMemory=mas[left];
            mas[left]=mas[right];
            mas[right]=swapMemory;
        }
        return  mas;

    }
    

}