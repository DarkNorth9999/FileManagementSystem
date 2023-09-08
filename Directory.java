package CompositeDesignPatterns.FileSystems;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.File;

public class Directory implements FileSystem {
    String directoryName;
    String path;
    File f;
    List<FileSystem> fileList;

    Directory(String name, String path) {
        this.directoryName = name;
        this.path = path + "/" + name;
    }

    public void init(){
        f = new File(path);
        boolean bool = f.mkdir();
        if(bool==false) throw new InputMismatchException();
        fileList = new ArrayList<>();
    }

    public void ls() {
        System.out.println("The Directory is: " + this.directoryName);
        for (FileSystem itr : fileList) {
            itr.ls();
        }
    }

    public void delete(){
        if(f==null) f = new File(path);
        try{
            deleteDirectory(f);
            f.delete();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteDirectory(File f1){
        for(File subfile: f1.listFiles()){
            if(subfile.isDirectory()) deleteDirectory(subfile);
            subfile.delete();
        }
    }

}