package io.week1;

import java.io.*;
import java.util.*;

public class CamelCase4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        while (true) {
            print(word);
            if (!sc.hasNextLine())
                break;
            word = sc.nextLine();
        }

        sc.close();

    }

    //My solution
    private static void print(String str) {
        String[] words = str.split(";");
        if (words[0].equals("S")) {
            String word = words[2];
            if (words[1].equals("M")) {
                word = word.replace("()", "");
                String s = "";
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        s += " " + Character.toLowerCase(ch);
                    } else
                        s += ch;
                }
                System.out.println(s);
                //  word.split("[A-Z]");
            } else if (words[1].equals("V")) {
                String s = "";
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        s += " " + Character.toLowerCase(ch);
                    } else
                        s += ch;
                }
                System.out.println(s);
            } else if (words[1].equals("C")) {
                String s = Character.toString(word.charAt(0)).toLowerCase();
                for (int i = 1; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        s += " " + Character.toLowerCase(ch);
                    } else
                        s += ch;
                }
                System.out.println(s);
            }
        } else if (words[0].equals("C")) {
            String wordCombine = words[2];
            String wordsCombine[] = wordCombine.split(" ");
            if (words[1].equals("M")) {
                String s = "";
                for (int i = 0; i < wordsCombine.length; i++) {
                    if (i == 0) {
                        s += wordsCombine[i];
                    } else
                        s += wordsCombine[i].substring(0, 1).toUpperCase() + wordsCombine[i].substring(1);
                }
                System.out.println(s + "()");
            } else if (words[1].equals("V")) {
                String s = "";
                for (int i = 0; i < wordsCombine.length; i++) {
                    if (i == 0) {
                        s += wordsCombine[i];
                    } else
                        s += wordsCombine[i].substring(0, 1).toUpperCase() + wordsCombine[i].substring(1);
                }
                System.out.println(s);
            } else if (words[1].equals("C")) {
                String s = "";
                for (int i = 0; i < wordsCombine.length; i++) {
                    s += wordsCombine[i].substring(0, 1).toUpperCase() + wordsCombine[i].substring(1);
                }
                System.out.println(s);
            }
        }
    }
}