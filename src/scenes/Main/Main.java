package scenes.Main;

import scenes.DataBase.DataBaseMain;
import scenes.TitleScene.MainTitle;

public class Main {
    public static void main(String[] args) {
        try {
            new MainTitle();
            System.out.println("Starting program: true");
            new DataBaseMain();
            MainTitle.MTmain(args);
        } catch (Exception e) {
            System.err.println("Starting program: false");
        }
    }
}
