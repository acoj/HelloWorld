package com.example.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        /*long len = FileUtils.sizeOf(new File("src/com/example/commons/Test.java"));
        System.out.println(len);
        len = FileUtils.sizeOf(new File("src/com/example"));
        System.out.println(len);

        Collection<File> files = FileUtils.listFiles(new File("src/com/example"), EmptyFileFilter.NOT_EMPTY, null);
        for(File file : files){
            System.out.println(file.getAbsolutePath());
        }
        files = FileUtils.listFiles(new File("src/com/example"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for(File file : files){
            System.out.println(file.getAbsolutePath());
        }
        files = FileUtils.listFiles(new File("src/com/example"), FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class"), EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
        for(File file : files){
            System.out.println(file.getAbsolutePath());
        }

        String msg = FileUtils.readFileToString(new File("src/com/example/commons/Test.java"), "utf-8");
        System.out.println(msg);

        byte[] b = FileUtils.readFileToByteArray(new File("src/com/example/commons/Test.java"));
        System.out.println(b.length);*/

        /*List<String> msgs = FileUtils.readLines(new File("print.txt"), "UTF-8");
        for(String msg : msgs){
            System.out.println(msg);
        }

        LineIterator it = FileUtils.lineIterator(new File("print.txt"));
        while(it.hasNext()){
            System.out.println(it.nextLine());
        }

        FileUtils.write(new File("print.txt"), "dkfakfjaflkdsklfj\n", "UTF-8");
        FileUtils.writeStringToFile(new File("print.txt"), "dkfakfjaflkdsklfj\n", "UTF-8");
        FileUtils.writeByteArrayToFile(new File("print.txt"), "dkfakfjaflkdsklfj\n".getBytes("UTF-8"));
        List<String> datas = new ArrayList<>();
        datas.add("chenxinfeng");
        datas.add("wo is yi ge sha bi");
        FileUtils.writeLines(new File("print.txt"), datas, "\n", true);
*/
        FileUtils.copyFile(new File("plane.png"), new File("p-copy.jpg"));
        FileUtils.copyFileToDirectory(new File("plane.png"), new File("src"));
        FileUtils.copyDirectoryToDirectory(new File("src"), new File("src2"));
        FileUtils.deleteDirectory(new File("src2"));
        FileUtils.copyURLToFile(new URL("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.closetag.com%2Ftutorial%2Fhtml%2Fhtml-images%2Fwhen-to-use-the-picture-element&psig=AOvVaw2D-aiXq7iBCjPS6ElpI5sZ&ust=1641123722512000&source=images&cd=vfe&ved=2ahUKEwiOz6-1vJD1AhUDR5QKHWwBBiEQjRx6BAgAEAk"),new File("url.png"));
        System.out.println(IOUtils.toString(new URL("https://www.baidu.com"), "UTF-8"));
    }
}
