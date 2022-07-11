
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
