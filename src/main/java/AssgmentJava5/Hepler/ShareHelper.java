package AssgmentJava5.Hepler;

import AssgmentJava5.Model.UsersEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ShareHelper {

    public static UsersEntity USERSENTITY = null;


    public static void logoff(){
        ShareHelper.USERSENTITY = null;
    }

    public static boolean authenticated(){
        return ShareHelper.USERSENTITY != null;
    }


    public static boolean saveImages(MultipartFile file){
        File dir = new File("Images");

        if(!dir.exists()){
            dir.mkdir();
        }
        File newFile = new File(dir,file.getName());
        try{
            Path souPath = Paths.get(file.getOriginalFilename());
            Path dePath = Paths.get(newFile.getAbsolutePath());
            Files.copy(souPath,dePath, StandardCopyOption.REPLACE_EXISTING);
            return  true;
        }
        catch (Exception e){
            return false;
        }
    }
}
