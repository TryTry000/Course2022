package lab010_Arith_if_switch;

import java.util.Scanner;
// Класс статических методов
class NoObj {
    // Печать в консоль
    // boolean lf     - есть ли возврат каретки в начале строки
    // String outLine - печатаемая строка
    static void preOut(boolean lf, String outLine) {
        String cr = "";
        if (lf) cr = "\n";
        System.out.print(cr + "СУММАТОРИЩЕ > " + outLine);
    }
    // Закрыть консоль
    static void closeConsole () {
        Scanner console = new Scanner (System.in);
        console.close();
    }
}
// Ввод операнда и проверка, что это, действительно, short
// int .outIndex  - индекс операнда по порядку
// short .inValue - введённый операнд
// boolean .code  - true если введён short
class ShortInput {
    int outIndex;
    short inValue;
    boolean code = true;
    void getShort () {
        NoObj.preOut ( outIndex == 1, "Введите A" +  outIndex + ": ");
        Scanner console = new Scanner (System.in);
        Scanner str = new Scanner (console.nextLine());
        if ( str.hasNextShort() ) inValue = str.nextShort();
        else code = false;
    }
}

// Складываем 3 short-числа
public class Main {
    public static void main(String[] args) {
        NoObj.preOut ( false, "---------------------------------------------------------");
        NoObj.preOut ( true, "Нынче тут \"А\" - число от -32768 до 32767. И не спорьте!");
        NoObj.preOut ( true, "---------------------------------------------------------");
        ShortInput shortInput;

        short[] oprnd = new short[3];

        for ( short i = 0; i < 3; i++ ) {
            shortInput = new ShortInput();
            shortInput.outIndex = i+1;
            shortInput.getShort();
            if (shortInput.code) {
                oprnd[i] = shortInput.inValue;
            } else {
                NoObj.preOut(false, "Сиё - ни разу не \"число\" в нашем нынешнем понимании.");
                NoObj.preOut(true, "Суммирование отменяется. Повнимательнее, братцы!");
                NoObj.closeConsole ();
                return;
            }
        }
        NoObj.closeConsole();
        NoObj.preOut ( false, "---------------------------------------------------------");
        NoObj.preOut(true, oprnd[0] + " + " + oprnd[1] + " + " + oprnd[2] + " = " +
                (oprnd[0] + oprnd[1] + oprnd[2]));
        NoObj.preOut( true, "Ша!");
    }
}
