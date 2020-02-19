package AssgmentJava5.Controller;

import AssgmentJava5.Dao.StaffsDao;
import AssgmentJava5.Model.StaffsEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class StaffController {


    @RequestMapping("/list-staff")
    public String listDepart(Model model) {
        model.addAttribute("staff", StaffsDao.findAll());
        return "staff-list";
    }

    @RequestMapping("/save-pageStaff")
    public String savePage(Model model) {
        model.addAttribute("staff", new StaffsEntity());
        return "staff-save";
    }

    @RequestMapping(value = "/saveStaff", method = RequestMethod.POST)
    public String doSaveDepart(@ModelAttribute("Staff") StaffsEntity staffsEntity, Model model, @RequestParam("file") MultipartFile file) throws IOException {
        File newFile = new File("C:\\Users\\nguye\\Downloads\\ASSJ5\\src\\main\\webapp\\resources\\logos\\"+ file.getOriginalFilename());
        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(newFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        if (file.getOriginalFilename() != null) {
            staffsEntity.setPhoto(file.getOriginalFilename());
        }
        StaffsDao.create(staffsEntity);
        model.addAttribute("staff", StaffsDao.findAll());
        return "staff-list";
    }

    @RequestMapping("/update-pageStaff/{id}")
    public String updatePage(Model model, @PathVariable int id) {
        StaffsEntity staffsEntity = StaffsDao.findId(id);
        model.addAttribute("staff", staffsEntity);
        return "staff-update";
    }

    @RequestMapping("/updateStaff")
    public String doUpdateStaff(@ModelAttribute("Staff") StaffsEntity staffsEntity, @RequestParam("file") CommonsMultipartFile file, Model model) throws IOException {
        File newFile = new File("C:\\Users\\nguye\\Downloads\\ASSJ5\\src\\main\\webapp\\resources\\logos\\"+ file.getOriginalFilename());
        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(newFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        if (file.getOriginalFilename() != null) {
            staffsEntity.setPhoto(file.getOriginalFilename());
        }
        StaffsDao.update(staffsEntity);
        model.addAttribute("staff", StaffsDao.findAll());
        return "staff-list";
    }

    @RequestMapping("/removeStaff/{id}/{photo}/")
    public String removeStaff(@PathVariable(name = "id") int id,@PathVariable(name = "photo") String photo, Model model) {
        File file =
                new File("C:\\Users\\nguye\\Downloads\\ASSJ5\\src\\main\\webapp\\resources\\logos\\" + photo);
        if(file.delete())
        {   
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
        StaffsDao.delete(id);
        model.addAttribute("staff", StaffsDao.findAll());
        return "staff-list";
    }

    @RequestMapping("/searchStaff")
    public String searchStaff(@ModelAttribute("Staff") StaffsEntity staffsEntity,@RequestParam(name = "nameStaff") String name, Model model){
        model.addAttribute("staff",StaffsDao.searchStaff(name));
        return "staff-list";
    }
}
