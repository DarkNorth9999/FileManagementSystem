package CompositeDesignPatterns.FileSystems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.File;

public class Directory implements FileSystem {
    String directoryName;
    String path;
    File f;
    List<FileSystem> fileList;

    private static Directory dirInstance;

    private Directory(String name, String path) {
        this.directoryName = name;
        this.path = path + "/" + name;
    }

    public static Directory getInstance(){
        String root = "/Users/darknorth/IdeaProjects/LowLevelDesign/src/CompositeDesignPatterns/FileSystems";
        if(dirInstance==null){
            dirInstance = new Directory("main",root);
        }
        return dirInstance;
    }

    public void init(){
        f = new File(path);
        boolean bool = f.mkdir();
        if (bool == false)
            throw new InputMismatchException(); //kyu nahi handle kar raha mein isse because I want user to see this exception
        fileList = new ArrayList<>();
    }

    public boolean isDirectory(){
        return true;
    }

    public Files addFile(String filename){
        Files fileObj = new Files(filename,this);
        this.fileList.add(fileObj);
        return fileObj;
    }

    public Directory addDirectory(String dirName){
        Directory dir = new Directory(dirName,this.path);
        this.fileList.add(dir);
        return dir;
    }

    public void ls() {
        System.out.println("The Directory is: " + this.directoryName);
        for (FileSystem itr : fileList) {
            if(itr==null) break;
            itr.ls();
        }
    }

    public void delete(){
        if(f==null) f = new File(path);
        try{
            deleteDirectory(this);
            f.delete();
        }
        catch(SecurityException e){
            e.printStackTrace();
        }
    }

    private void deleteDirectory(Directory d){
        for(FileSystem FSObj: d.fileList){
            File subfile = FSObj.getFile();
            if(subfile.isDirectory()) {
                deleteDirectory((Directory)FSObj);
            }
            subfile.delete();
        }
    }

    public File getFile(){
        return this.f;
    }

//    private void deleteDirectory(File f1){
//        for(File subfile: f1.listFiles()){
//            //System.out.println(subfile.isDirectory()+" iter ");
//            if(subfile.isDirectory()) deleteDirectory(subfile);
//            subfile.delete();
//        }
//    }

}