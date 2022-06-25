package lab030_arr_cycle;
public class Main {
    public static void main(String[] args) {
        int[] intArr = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10};
        long result = intArr[0];
        for (int i = 1; i < 9; i++) { result = result * intArr[i]; }
        System.out.println("Результат: " + result);
    }
}
