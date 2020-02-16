package pl.sda.carmanager.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carmanager.entity.UserEntity;
import pl.sda.carmanager.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String postSaveProduct(@ModelAttribute UserEntity userEntity) {
        //przyjmie UserEntity ktorego ktos wpisze-mail i haslo
        userService.save(userEntity);
        return "redirect:/car/front";
        //??
    }

    @GetMapping("/save")
    public ModelAndView getSaveProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userRegister");//ustaw widok userRegister-nowy uzytkownik,mail i haslo
        modelAndView.getModel().put("user", new UserEntity());//przekazujemy stringa
        //moge przekazac stringa i widok
        return modelAndView;
    }
}

