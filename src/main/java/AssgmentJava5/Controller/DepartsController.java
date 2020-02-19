package AssgmentJava5.Controller;

import AssgmentJava5.Dao.DepartsDao;
import AssgmentJava5.Model.DepartsEntity;
import AssgmentJava5.Service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartsController extends Service {

    @RequestMapping("/list-depart")
    public String listDepart(Model model){
        model.addAttribute("depart", DepartsDao.findAll());
        return "depart-list";
    }

    @RequestMapping("/save-pageDepart")
    public String savePage(Model model){
        model.addAttribute("depart",new DepartsEntity());
        return "depart-save";
    }
    @RequestMapping("/saveDepart")
    public String dosaveDepart(@ModelAttribute("Depart") DepartsEntity departsEntity ,Model model){
        DepartsDao.create(departsEntity);
        model.addAttribute("depart", DepartsDao.findAll());
        return "depart-list";
    }

    @RequestMapping("/update-pageDepart/{id}")
    public String updatePage(Model model, @PathVariable int id){
        DepartsEntity departsEntity = DepartsDao.findId(id);
        model.addAttribute("depart",departsEntity);
        return "depart-update";
    }

    @RequestMapping("/updateDepart")
    public String doUpdateDepart(@ModelAttribute("Depart") DepartsEntity departsEntity, Model model){
        DepartsDao.update(departsEntity);
        model.addAttribute("depart", DepartsDao.findAll());
        return "depart-list";
    }

    @RequestMapping("/removeDepart/{id}")
    public String removeDepart(@PathVariable int id,Model model){
        DepartsDao.delete(id);
        model.addAttribute("depart", DepartsDao.findAll());
        return "depart-list";
    }
}
