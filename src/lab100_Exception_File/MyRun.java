package lab100_Exception_File;
import java.io.*;
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

        try
        {   FileReader rd = new FileReader(testFileNameStr0);
            FileWriter wr = new FileWriter(testFileNameStr1);

            String bfrIn = ""; // Буфер ввода всего текста
            String bfrOut; // Буфер построчного вывода
            while (rd.ready()) { bfrIn += (char) rd.read(); } //читаем побайтно пока в потоке ввода есть непрочитанные байты

            Scanner sc = new Scanner(bfrIn); // Прочитанное - в сканнер
            while (sc.hasNextLine()) {
                // Читаем из входной строки построчно и кладём в выходную строку
                bfrOut = sc.nextLine();
                bfrOut += " [длина была: " + bfrOut.length() + "]";
                // Выводим побайтно выходную строку, в клнце - возврат каретки.
                for (int i=0; i<bfrOut.length(); i++) {
                    wr.write(bfrOut.charAt(i));
                }
                wr.write(MyEnv.myCR);
                System.out.println("Читаем-пишем: " + bfrOut);
            }
            sc.close();
            rd.close();
            wr.close();
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
