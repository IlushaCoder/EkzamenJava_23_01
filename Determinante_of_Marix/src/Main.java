public class Main {
    public static int determinant(int[][] matrix)
    {
        int n = matrix.length; //порядок матрицы
        if(n==1) return matrix[0][0];//если матрица один на один, то возвращаем ее единственный элемент
        int res = 0; //результат, который будет суммироваться с минорами
        int minor[][] = new int[n-1][n-1]; //минор порядка n-1
        int l = 1; // множитель перед алгебраическим дополнением
        for(int i = 0; i < n; ++i){

            int x = 0, y = 0; //координаты элемента первой строки, первого столбца
            for(int j = 1; j < n; ++j){
                for(int k = 0; k < n; ++k){
                    if(i == k) continue;
                    minor[x][y] = matrix[j][k];
                    ++y;
                    if(y == n - 1){
                        y = 0;
                        ++x;
                    }
                }
            }
            res += l * matrix[0][i] * determinant(minor); // рекурсивно вызывает функцию, поскольку в какой-то момент порядок будет равен 1;
            l *= (-1);
        }
        return res;
    }


    public static void main(String[] args) {
        int A[][]={{1,0,0},
                {0,4,3},
                {0,2,3}};//det|A|=6
        System.out.println(determinant(A));

    }
}