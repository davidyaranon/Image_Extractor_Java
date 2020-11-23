package comm.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertImageInFolder {

    public static void main(String[] args){
        String folder;
        String extension;
        String write_folder;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter type of image we are going to extract: (JPEG (JPG), PNG, GIF, etc.) ");
        extension = scanner.nextLine();


        System.out.println("Enter folder which we will extract images from: ");
        folder = scanner.nextLine();

        System.out.println("Enter folder which we will write images to: ");
        write_folder = scanner.nextLine();

        IMG IMG = new IMG(folder, extension);
        ArrayList<BufferedImage> listOfImages = IMG.getListOfImages();

        int i = 0;
        for(BufferedImage img : listOfImages){
            try {
                File directory = new File(write_folder + "/IMAGE_NAME" + i + ".png");
                i++;
                ImageIO.write(img, extension, directory);
                System.out.println("SUCCESS");
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("An error occurred.");
            }
        }
    }


}
