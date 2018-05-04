package scenes.Main;

import java.io.*;

public class CurrentUser {

    /**
     *  The source of the following code is the website "https://devcolibri.com/";
     */

    private static String fileName = "CURRENT_USER.txt";
    private File file = new File(fileName);

    public void addCurrentUser(String username) {
        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                System.err.println("File existence: false");
                file.createNewFile();
                System.out.println("Creating a file: true");
            } else {
                System.out.println("File existence: true");
            }
        }catch (IOException e) {
            System.err.println("Creating a file: false");
        }
        //PrintWriter обеспечит возможности записи в файл
        PrintWriter out = null;
        try {
            out = new PrintWriter(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ///Записываем текст у файл
        out.print(username);

        //После чего мы должны закрыть файл
        //Иначе файл не запишется
        out.close();
    }

    public String getCurrentUser() {
        String username = "";
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            System.out.println("Reading file: true");
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    username = s;
                }
                System.out.println("Reading file: true\n"+"Username: "+username);
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            System.err.println("Reading file: false");
        }
        //Возвращаем полученный текст с файла
        return username;
    }

    public void deleteCurrentUser() {
        addCurrentUser(null);
    }
}


