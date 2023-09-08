package CompositeDesignPatterns.FileSystems;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Directory d = new Directory("IAmADirectory", "/Users/darknorth/IdeaProjects/LowLevelDesign/src/CompositeDesignPatterns/FileSystems");
        d.init();
        Files f = new Files("YoFile1.txt", d.path);
        f.init();

        f.FileOperations("write", "Hello World");
        f.FileOperations("read","");

//        int i = 1;
//        while(i==1){
//            i = scn.nextInt();
//        }
//          d.delete();
    }
}
