package dev.addShops;

import scenes.DataBase.ShopList;
import scenes.DataBase.ShopTable;

import java.util.Scanner;

public class AddShops {

    /**
     *  This methods using for development or testing of different part of program
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("How much shops would u like to add?");
        try {
            count = sc.nextInt();
        }catch (Exception e) {
            System.err.println("Please, input Integer (int) values");
        }
        addShopsToDB(count);
    }

    private static void addShopsToDB(int size) {
        ShopTable st = new ShopTable();
        ShopList sl = new ShopList("test","test","test/test",
                "test", "test","0000","0000","test");
        for (int i = 0; i < size; i++) {
            st.addShop(sl);
        }
    }
}
