package comm.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class IMG {

    //Class variables...
    protected File directory;
    protected String[] fileExtensions;
    protected FilenameFilter imgFilter;
    protected ArrayList<BufferedImage> listOfImages = new ArrayList<>();

    //Constructor...
    public IMG(String path, String extension) {
        Objects.requireNonNull(path, "Please enter valid path");
        Objects.requireNonNull(extension, "Please enter valid extension");
        this.directory = new File(path);
        this.fileExtensions = new String[]{extension};
    }

    //Method which reads through a specific folder and returns an image of a specific type
    public ArrayList<BufferedImage> getListOfImages(){
        this.imgFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for(String fileType : fileExtensions){
                    if(name.endsWith("." + fileType))
                        return true;
                }
                return false;
            }
        };
        if(this.directory.isDirectory()){
            for(File file : Objects.requireNonNull(directory.listFiles(imgFilter))){
                BufferedImage image = null;
                try{
                    image = ImageIO.read(file);
                    listOfImages.add(image);
                } catch (IOException e){
                    System.out.println("ERROR OCCURRED");
                }
            }
        }

        return listOfImages;
    }
}

