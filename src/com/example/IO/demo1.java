package com.example.IO;

import java.io.File;

public class demo1 {
    public static void main(String[] args) {
        System.out.println(File.separator);

        File src = new File("/Users/xinfengchen/MEGAsync/Java/code/HelloWorld/src/com/example/IO/plane.png");
        System.out.println(src.length());
        src = new File("/Users/xinfengchen/MEGAsync/Java/code/HelloWorld/src/com/example/IO/", "plane.png");
        src = new File("/Users/xinfengchen/MEGAsync/Java/code/HelloWorld/src/com", "/example/IO/plane.png");
        System.out.println(src.length());
        src = new File(new File("/Users/xinfengchen/MEGAsync/Java/code/HelloWorld/src/com"), "/example/IO/plane.png");
        System.out.println(src.length());
        System.out.println(src.getAbsolutePath());
        System.out.println(src.getPath());
        src = new File(new File("src/com"), "/example/IO/plane.png");
        System.out.println(src.getPath());
        System.out.println(src.length());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperties());

        System.out.println("getParentFile.getName: " + src.getParentFile().getName());
        System.out.println("getParent: " + src.getParent());

        System.out.println(src.exists());
        System.out.println(src.isFile());
        System.out.println(src.isDirectory());

        System.out.println("---------------------");
        File dir = new File("src/com/example");
        /*System.out.println(dir.mkdir());
        System.out.println(dir.mkdirs());*/

        String[] sub = dir.list();
        for(String s : sub){
            System.out.println(s);
        }
        File[] subFiles = dir.listFiles();
        for(File f : subFiles){
            System.out.println(f.getPath());
        }
        File[] roots = dir.listRoots();
        for(File r : roots){
            System.out.println(r.getAbsolutePath());
        }
    }
}
