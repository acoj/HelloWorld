package com.example.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testException {
    public static void main(String[] args) throws IOException {
        /*try{
            int i = 1/0;            // uncheckedException runtime
        } catch(Exception e){
            e.printStackTrace();
        }

        File f = new File("/Users/xinfengchen/a.txt");
        try{
            f.createNewFile();      // checkedException compile
        } catch(Exception e){
            e.printStackTrace();
        }
*/
        FileReader reader = null;
        /*try{
            reader = new FileReader("/users/xinfengchen/aaaa.txt");
            char c = (char) reader.read();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            if(reader != null){
                try{
                    reader.close();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
//            reader.close();
        }*/
        reader = new FileReader("/users/xinfengchen/a.txt");

        char c = (char) reader.read();
        System.out.println(c);
    }
}
