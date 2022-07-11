package com.example.collection;

import java.io.File;

public class Recurrence {
    public static void main(String[] args) {
        File f = new File("/Users/xinfengchen/MEGAsync/Java");
        printFile(f, 0);
    }
    public static void printFile(File f, int level){
        for(int i = 0; i < level; ++i){
            System.out.print("      ");
        }
        System.out.println(f.getName());
        if(f.isDirectory()){
            File[] files = f.listFiles();
            for(File file : files){
                printFile(file, level+1);
            }
        }
    }
}
