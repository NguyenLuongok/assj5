package AssgmentJava5.Controller;

import AssgmentJava5.Dao.UserDao;
import AssgmentJava5.Hepler.ShareHelper;
import AssgmentJava5.Model.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private UserDao userDao;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/trangchu", method = RequestMethod.POST)
    public String home(@ModelAttribute("user") @Valid UsersEntity usersEntity, BindingResult result, Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        List<UsersEntity> list = userDao.findAll();
        for (UsersEntity user :list) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                ShareHelper.USERSENTITY = user;
                model.addAttribute("succesLogin", "Dang nhap thanh cong !");
                model.addAttribute("user", user.getFullname());
                return "home";
            }
            if(result.hasErrors()){
                return "login";
            }
        }
        return "login";
    }
}
