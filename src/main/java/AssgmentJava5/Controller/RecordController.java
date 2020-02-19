package AssgmentJava5.Controller;

import AssgmentJava5.Dao.RecordsDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecordController {

    @RequestMapping("list-record")
    public String listRecord(Model model){
        model.addAttribute("record", RecordsDao.findAll());
        return "record-list";
    }

//    @RequestMapping("/list-geneger-record")
//    public String listGenegerRecord(){
//        RecordsDao.
//    }
}
