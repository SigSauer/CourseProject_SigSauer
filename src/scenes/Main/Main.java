package scenes.Main;

import scenes.DataBase.DataBaseMain;
import scenes.TitleScene.MainTitle;

public class Main {
    public static void main(String[] args) {


        System.out.print("Starting program: ");
        try {
            new MainTitle();
            System.out.println("true");
            new DataBaseMain();
            MainTitle.MTmain(args);
        } catch (Exception e) {
            System.out.println("false");
        }
    }
}
