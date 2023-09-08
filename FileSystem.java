package CompositeDesignPatterns.FileSystems;

import java.io.File;

public interface FileSystem {
    public void ls();
    public void delete();
    public boolean isDirectory();
    public File getFile();

}
