package dev.addUsers;

import scenes.DataBase.Hashing;

import java.util.Scanner;

public class AddUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();
        hash(pass);
    }

    private static void hash(String pass) {
        System.out.println(new Hashing().getHash(pass));
    }
}
