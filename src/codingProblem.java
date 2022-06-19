import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class codingProblem {
    public static void main(String[] args) {
        int expected=100;
        while(1>0){
        Random rand= new Random();
        int[][] matrix= createMatrix();
        int a = rand.nextInt(10);
        int b = rand.nextInt(10);
        matrix[a][b]=1;
        int result=movementMatrix(matrix,a,b);
            System.out.println("Result is " + result);
        if(expected==result){
            System.out.println("Maximum score is reached: " + result);
            break;
            }
        }
    }

    private static int movementMatrix(int[][] matrix, int a, int b) {
        Random rand= new Random();
        int result=0;
        for (int i=2;i<=101;i++){
            List<Integer> list = availability(matrix,a,b);
            int listSize= list.size();
            int move;
            if(listSize>1) {
                move = rand.nextInt(listSize);
            }
            else if(listSize==1){
                move=0;
            }
            else{
                printMatrix(matrix);
                result=i-1;
                break;

            }

            switch (list.get(move)) {
                case 1:
                    matrix[a + 3][b] = i;
                    a += 3;
                    continue;

                case 2:
                    matrix[a - 3][b] = i;
                    a -= 3;
                    continue;

                case 3:
                    matrix[a][b + 3] = i;
                    b += 3;
                    continue;

                case 4:

                    matrix[a][b - 3] = i;
                    b -= 3;
                    continue;

                case 5:
                    matrix[a + 2][b + 2] = i;
                    a += 2;
                    b += 2;
                    continue;
                case 6:
                    matrix[a - 2][b + 2] = i;
                    a -= 2;
                    b += 2;
                    continue;

                case 7:
                    matrix[a + 2][b - 2] = i;
                    a += 2;
                    b -= 2;
                    continue;

                case 8:
                    matrix[a - 2][b - 2] = i;
                    a -= 2;
                    b -= 2;
                    continue;


            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    private static int[][] createMatrix() {
        int[][] matrix = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
       return matrix;
    }

    private static List<Integer> availability(int[][] matrix, int tempA, int tempB) {
        List<Integer> list = new ArrayList<Integer>();
        if (tempA+3<matrix[0].length && matrix[tempA+3][tempB]==0){
            list.add(1);
        }
        if (tempA-3>=0 && matrix[tempA-3][tempB]==0){
            list.add(2);
        }
        if (tempB+3<matrix[1].length && matrix[tempA][tempB+3]==0){
            list.add(3);
        }
        if (tempB-3>=0 && matrix[tempA][tempB-3]==0){
            list.add(4);
        }
        if (tempA+2<matrix[0].length && tempB+2<matrix[1].length && matrix[tempA+2][tempB+2]==0){
            list.add(5);
        }
        if (tempA-2>-1 && tempB+2<matrix[1].length && matrix[tempA-2][tempB+2]==0){
            list.add(6);
        }
        if (tempB-2>-1 && tempA+2<matrix[0].length && matrix[tempA+2][tempB-2]==0){
            list.add(7);
        }
        if (tempA-2>-1 && tempB-2>-1 && matrix[tempA-2][tempB-2]==0){
            list.add(8);
        }

        return list;


    }
}












