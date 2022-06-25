package lab090_Exception_File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

// =========== Программа ===============================================================================================
// =====================================================================================================================
class MyRun {
    public static void myRun () {
        String bfr; // Буфер ввода-вывода

        // Имена файлов
        String testFileNameStr0 = MyEnv.myHomePath + MyEnv.mySL + "testFile0.txt";
        String testFileNameStr1 = MyEnv.myHomePath + MyEnv.mySL + "testFile1.txt";

        // Разбираемся с файлами
        if ( !MyIO.myCheckCreateFile(testFileNameStr0) ) return;
        if ( !MyIO.myCheckCreateFile(testFileNameStr1) ) return;

        try {
            FileInputStream fis = new FileInputStream(testFileNameStr0);
            FileOutputStream fos = new FileOutputStream(testFileNameStr1);

            System.out.println("Читаем из файла " + testFileNameStr0);
            System.out.println("Пишем в файл " + testFileNameStr1);

            Scanner sc = new Scanner(fis, "Cp1251"); // открываем файл на чтение
            PrintStream ps = new PrintStream(fos);              // открываем файл на запись
            sc.useDelimiter(MyEnv.myCR);                        // Устанавливаем признак конца строки

            while (sc.hasNextLine()) {
                bfr = sc.nextLine();
                bfr += " [длина была: " + bfr.length() + "]";
                ps.println(bfr);
                System.out.println("Читаем-пишем: " + bfr);
            }
            fis.close(); sc.close();
            fos.close(); ps.close();
        }
        catch ( Exception err ) {
            // Ошибку - в консоль и лог
            // Второй параметр - шапка собщения об ошибке
            if ( !MyExc.echoExc2console2log (err,
                "-7010: Сбой файла  [\"" + testFileNameStr1 + "\" или \"" + testFileNameStr1 + "\"]") ) {
                return;
            }
        }

        // --- ДЕЛИМ НА НОЛЬ ---
        System.out.println("=== А сейчас мы разделим на ноль!");
        int iii = 1/0;
        System.out.println("=== Мир после деления на ноль: " + iii);
    }
}


