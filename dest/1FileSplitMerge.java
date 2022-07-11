th()-i*this.blockSize);
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