package lab060_matrix;

/*
Создать класс "Матрица".
Класс должен иметь следующие переменные:
- двумерный массив вещественных чисел;
- количество строк и столбцов в матрице.
Класс должен иметь следующие методы:
- сложение с другой матрицей;    *** поэлементное сложение матриц одинаковой размерности
- умножение на число;
- вывод на печать;
- умножение матриц - по желанию; *** C(i,j) = Sum[k=1..m] a(i,k)*b(k,j)
                                     для совместных матриц (кол-во строк первой и столбцов второй равны)
========================================================================================================
Умножение матриц делать не буду, ибо ничего нового этот кусок кода не даст.
Матрицы сделаю целочисленными, ибо тратить время на подгон плавающих форматов на печать пока не время.
Проверок на совместность матриц тоже делать не буду по тем же причинам.
*/

// Операции над матрицами
class Matrix {
// Свойства
    // Первый операнд
    int[][] mtrA = { { 1, 22, 13, 71},
                     { 7, -5, 12, 31},
                     { 0, 23, -7, 97} };
    // Результат
    int[][] mtrC = { { 0, 0, 0, 0},
                     { 0, 0, 0, 0},
                     { 0, 0, 0, 0} };
    // Для обнобуквенного имени матрицы
        String matrixName = "A";

// Методы
    // Печать матрицы
    void matrixPrint ( int[][] matr, String matrixName ) {
//        DecimalFormat intF = new DecimalFormat( "####" );
        System.out.println("======= МАТРИЦА \"" + matrixName + "\": =======");
        for ( int i=0; i < matr.length; i++ ) {
            for ( int j =0; j < matr[0].length; j++ ) {
                System.out.print( String.format ("%+7d", matr[i][j] ) );
            }
            System.out.println();
        }
    }
    // Сложение матриц
    void matrixPLUSmatrix ( int[][] mtrB) {
        for ( int i=0; i < mtrA.length; i++ ) {
            for (int j = 0; j < mtrA[0].length; j++) {
                mtrC[i][j] = mtrA[i][j] + mtrB[i][j];
            }
        }
        System.out.println("=======================================================");
        System.out.println("=======================================================");
        System.out.println("============ СКЛАДЫВАЕМ МАТРИЦЫ А + В = С =============");
        matrixPrint ( mtrA, "A" );
        matrixPrint ( mtrB, "B" );
        matrixPrint ( mtrC, "C" );
    }
    // Умножение марицы на коэффициент
    void matrixXmatrix ( int coeff) {
        for ( int i=0; i < mtrA.length; i++ ) {
            for (int j = 0; j < mtrA[0].length; j++) {
                mtrC[i][j] = mtrA[i][j] * coeff;
            }
        }
        System.out.println("=======================================================");
        System.out.println("=======================================================");
        System.out.println("========== УМНОЖАЕМ МАТРИЦУ НА " + coeff + ": А х " + coeff + " = С ==========");
        matrixPrint ( mtrA, "A" );
        matrixPrint ( mtrC, "C" );
    }
}


public class Main {
    public static void main(String[] args) {
        int coeff = 17;
        int[][] mtrB = { { 9, -7, -2, 11},
                { 0, -2, 17, 51},
                { 3, 53, 13, 77} };

        Matrix matrix = new Matrix();
        matrix.matrixPLUSmatrix ( mtrB );
        matrix.matrixXmatrix ( coeff );
    }
}