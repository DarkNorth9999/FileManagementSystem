package CompositeDesignPatterns.FileSystems;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Directory d = Directory.getInstance();
        //Directory d = new Directory("IAmADirectory", "/Users/darknorth/IdeaProjects/LowLevelDesign/src/CompositeDesignPatterns/FileSystems");
        d.init();
        Directory d1 = d.addDirectory("DirChild");
        d1.init();
        Files f = d.addFile("YoFilly1.txt"); //or you may do: new Files(string filename, Directory obj)
        f.init();
        //Directory d2 = new Directory()

//        Files f = new Files("YoFile1.txt", d.path);
//        f.init();
//
//        f.FileOperations("write", "Hello World");
//        f.FileOperations("read","");

        int i = 1;
       // for(FileSystem x:d.fileList)
        d.ls();
        while(i==1){
            i = scn.nextInt();
        }
        //System.out.println(d.f.isDirectory());
          d.delete();
    }
}


// ls implement
// use ls in delete