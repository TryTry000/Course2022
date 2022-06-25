package lab020_BykiKorovy;

import java.util.Scanner;
import java.util.Random;

// Класс статических методов
class NoObj {
    // Печать в консоль
    // boolean lf     - есть ли возврат каретки в начале строки
    // String outLine - печатаемая строка
    static void preOut(boolean lf, String outLine) {
        String cr = "";
        if (lf) cr = "\n";
        System.out.print(cr + "БЫКИ & КОРОВЫ: > " + outLine);
    }
    // Закрыть консоль
    static void closeConsole () {
        Scanner console = new Scanner (System.in);
        console.close();
    }
}
// Ввод операнда и проверка, что это, действительно, 4-значное положительное целое число
// String .inValue - введённый операнд
// boolean .code   - true если число введено нормально
class Val4digits {
    boolean code = true;
    String inValue;
    void getVal () {
        NoObj.preOut ( true, "Введите число: ");
        Scanner console = new Scanner (System.in);
        inValue = console.nextLine();
        if ( !(inValue.length() == 4 ) ||
             !Character.isDigit( inValue.charAt(0) ) ||
             !Character.isDigit( inValue.charAt(1) ) ||
             !Character.isDigit( inValue.charAt(2) ) ||
             !Character.isDigit( inValue.charAt(3) )   ) { code = false; }
    }
}

// Складываем 3 short-числа
public class Main {
    public static void main(String[] args) {
        int byki;    // Быки
        int korovy;  // Коровы

        NoObj.preOut ( false, "-----------------------------------------------------------------------------");
        NoObj.preOut ( true, "Игра \"Быки\" и \"Коровы\", которую нынешние");
        NoObj.preOut ( true, "не помнящие родства иваны кличут \"игрой в числа\".");
        NoObj.preOut ( true, "-----------------------------------------------------------------------------");
        NoObj.preOut ( true, "ПРАВИЛА:");
        NoObj.preOut ( true, "Компьютер загадывает 4-х положительное значное число (цифры могут повторяться).");
        NoObj.preOut ( true, "Задача - угадать это число. Если цифра и Вашего числа присутствует в загаданном");
        NoObj.preOut ( true, "и стоит на верном месте, то компьютер обозначит её \"Быком\". Если присутствует,");
        NoObj.preOut ( true, "но стоит на неверном том месте, компьютер обозначит её \"Kоровой\". Если вы");
        NoObj.preOut ( true, "ввели не цифру, ожидайте \"Кролика\". Задача - угадать побыстрее. Для малышей");
        NoObj.preOut ( true, "Задача - угадать побыстрее. Для малышей цель игры - умно развить логику. Для");
        NoObj.preOut ( true, "взрослых - тупо убить время. ЗЫ: Ежели надоест, жмите \"q\".");
        NoObj.preOut ( true, "ВАЖНО!!! Если загадано 1232, а введено 4520, то коров будет 2, ибо 2 - двоит!!!");
        NoObj.preOut ( true, "УДАЧИ!");
        NoObj.preOut ( true, "-----------------------------------------------------------------------------");
        NoObj.preOut ( true, "Я число загадал: ХХХХ. Отгадайте!");
        NoObj.preOut ( true, "-----------------------------------------------------------------------------");

        Random rnd = new Random();
        int[] zagadal = new int[4];
        String zagadalStr;
        for ( int i = 0; i < 4; i++ ) {
            zagadal[i] = rnd.nextInt(9) + 1;
        }

        System.out.print("\nА загадал я: " + zagadal[0] + zagadal[1] + zagadal[2] + zagadal[3]);

        zagadalStr = "" + zagadal[0] + zagadal[1] + zagadal[2] + zagadal[3];
        while ( true ) {
            Val4digits val4digits = new Val4digits();
            val4digits.getVal();
            // куит нафиг
            if (val4digits.inValue.equals("q")) {
                NoObj.preOut(false, "А загадал я: " + zagadal[0] + zagadal[1] + zagadal[2] + zagadal[3]);
                NoObj.preOut(true, "Спасибо. Было приятно пообщаться. Умаетесь от безделья, - заходите!");
                NoObj.closeConsole ();
                return;
            }
            // не то ввели
            if (!val4digits.code) {
                NoObj.preOut(false, "Дык КРОЛИК же... Чо вводим?!! Аккуратнее!!!");
            }
            // угадали
            else if (val4digits.inValue.equals(zagadalStr)) {
                NoObj.preOut(false, "Угадали: " + zagadal[0] + zagadal[1] + zagadal[2] + zagadal[3] + "!!!");
                NoObj.preOut(true, "Спасибо. Было приятно пообщаться. Умаетесь от безделья, - заходите!");
                NoObj.closeConsole ();
                return;
                // считаем быков-коров
            } else {
                byki = 0;
                korovy = 0;
                for (int i = 0; i < 4; i++) {
                    if ( val4digits.inValue.charAt(i) == zagadalStr.charAt(i) ) byki++;
                    for (int j = 0; j < 4; j++) {
                        if ( val4digits.inValue.charAt(i) == zagadalStr.charAt(j) ) korovy++;
                    }
                }
                NoObj.preOut(false, "Введено: " + val4digits.inValue + ", КОРОВ: " + korovy + ", БЫКОВ: " + byki);
            }
        }
    }
}

