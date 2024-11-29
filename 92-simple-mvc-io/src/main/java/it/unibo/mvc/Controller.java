package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;

    public Controller(){
        currentFile = new File(System.getProperty("user.home")+ System.getProperty("file.separator") +"output.txt");
    }

    public void setFile(File f) {
        currentFile = f;
    }

    public File getFile() {
        return currentFile;
    }

    public String getPath() {
        return currentFile.getAbsolutePath();
    }

    public void write(String s) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile));
        bw.write(s);
        bw.close();
    }
}
