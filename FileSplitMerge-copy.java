package com.example.IO;

import java.io.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FileSplitMerge {
    private File src;
    private int blockSize;
    private int size;
    private List<String> destPath = new ArrayList<>();

    public FileSplitMerge(String src, int blockSize) {
        this.src = new File(src);
        this.blockSize = blockSize;
        this.size = (int)(this.src.length()+blockSize-1)/blockSize;
        System.out.println(this.src.length());
        System.out.println(this.size);
        init();
    }
    private void init(){
        for(int i = 0; i < this.size; ++i){
            this.destPath.add("dest/" + i + this.src.getName());
        }
    }

    public void split() throws IOException {
        for(int i = 0; i < this.size; ++i){
            if(i < this.size-1){
                split(i, i*this.blockSize, this.blockSize);
            } else{
                split(i, i*this.blockSize, (int)this.src.length()-i*this.blockSize);
            }

        }
    }

    private void split(int i, int offset, int s) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        raf.seek(offset);
        //OutputStream os = new FileOutputStream(this.destPath.get(i));
        RandomAccessFile raf2 = new RandomAccessFile(this.destPath.get(i), "rw");
        byte[] a = new byte[1024];
        int len;
        while((len = raf.read(a)) != -1){
            if(len <= s){
                raf2.write(a, 0, len);
                s -= len;
            } else {
                raf2.write(a, 0, s);
                break;
            }
        }
        raf.close();
//        raf2.flush();
        raf2.close();
    }

    public void merge(String destPath) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath));
        /*for(int i = 0; i < this.size; ++i){
            InputStream is = new BufferedInputStream(new FileInputStream(this.destPath.get(i)));
            byte[] a = new byte[1024];
            int len;
            while((len = is.read(a)) != -1){
                os.write(a, 0, len);
            }
            is.close();
            os.flush();
        }*/
        Vector<InputStream> v = new Vector<>();
        for(int i = 0; i < this.size; ++i){
            InputStream is = new BufferedInputStream(new FileInputStream(this.destPath.get(i)));
            v.add(is);
        }
        SequenceInputStream sis = new SequenceInputStream(v.elements());
        byte[] a = new byte[1024];
        int len;
        while((len = sis.read(a)) != -1){
            os.write(a, 0, len);
        }
        sis.close();
        os.close();
    }

    public static void main(String[] args) throws IOException {
        FileSplitMerge fsm = new FileSplitMerge("src/com/example/IO/FileSplitMerge.java", 1024);
        fsm.split();
        fsm.merge("FileSplitMerge-copy.java");
    }
}
