package CompositeDesignPatterns.FileSystems;

import java.io.*;
import java.util.InputMismatchException;

public class Files implements FileSystem {
    String fileName;
    String path;
    File f;
    FileOps fops;

    public Files(String name, Directory d){ //bina directory ke files mat banao
        fileName = name;
        this.path = d.path+"/" +name;
        fops = new FileOps();
    }

    public void init(){
        f = new File(this.path);
        try {
            boolean res = f.createNewFile();
            if(res==false) throw new InputMismatchException();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean isDirectory(){
        return false;
    }

    public void ls(){
        System.out.println("File: "+fileName);
    }

    public void delete(){
        if(f==null) f = new File(path);
        boolean ans = f.delete();
        if(ans) System.out.println("File got deleted");
    }

    public void FileOperations(FileOperations operation, String content){
        switch(operation){
            case READ:
                fops.read(path);
                break;
            case WRITE:
                fops.write(path,content);
                break;
        }
    }

    public File getFile(){
        return f;
    }
}

class FileOps{
    public void read(String path){
        FileInputStream fin=null;
        try{
            fin = new FileInputStream(path);
            int i = 0;
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
            fin.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
//      finally {
//            fin.close();
//      }
    }

    public void write(String path, String content){
        try{
            FileOutputStream fout = new FileOutputStream(path);
            byte[] b = content.getBytes();
            fout.write(b);
            fout.close();
            System.out.println("Success!");
        }
        catch(Exception e){
            //System.out.println("Hello");
            e.printStackTrace();
        }
    }
}
