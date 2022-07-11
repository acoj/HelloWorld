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
                split(i, i*this.blockSize, (int)this.src.leng