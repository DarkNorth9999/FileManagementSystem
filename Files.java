package CompositeDesignPatterns.FileSystems;

import java.io.*;
import java.util.InputMismatchException;

public class Files implements FileSystem {
    String fileName;
    String path;
    File f;
    FileOps fops;

    Files(String name, String path){
        fileName = name;
        this.path = path+"/" +name;
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

    public void ls(){
        System.out.println("File: "+fileName);
    }

    public void delete(){
        if(f==null) f = new File(path);
        boolean ans = f.delete();
        if(ans) System.out.println("File got deleted");
    }

    public void FileOperations(String operation, String content){
        switch(operation){
            case "read":
                fops.read(path);
                break;
            case "write":
                fops.write(path,content);
                break;
        }
    }
}

class FileOps{
    public void read(String path){
        try{
            FileInputStream fin = new FileInputStream(path);
            int i = 0;
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
            fin.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

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
