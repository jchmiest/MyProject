package pl.sda.carmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/register") //powinno sie nazywac inaczej niz car
public class RegisterController {
    private FuelRepository fuelRepository;

    @Autowired
    public RegisterController(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }


    @GetMapping("/show")//wyswietli to co dodam,wysiwtela formularz carform1
    public ModelAndView getShowRegister() {
        List<FuelEntity> fuelentries = fuelRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerview");//wpisujemy co ma wyswietlic
        modelAndView.getModel().put("register", fuelentries);
        //tworzy sie nowy model, fuelRepository-mamy tam info o licznik itp, findAll-wyszukujemy wszystko
        //k-klucz jest dowolny ,fuelentries-zwraca wszystko co mam w car repository

        //ascenting-sortowanie rosnace
        Integer result= 0;
        for (int i = 0; i < 2; i++) {//lista

          FuelEntity entity1=   fuelentries.get(i); //pobranie konkretnej rzeczy w liscie,index 0
          FuelEntity entity2=   fuelentries.get(i+1);// nastepny counter,pobranie,index 1,poranie obiektu z listy
            Integer counter1 = entity1.getCounter();////dzialanie na obiekcie
            Integer counter2 = entity2.getCounter();
            result=counter1-counter2;
            }

        modelAndView.getModel().put("result",result); //dodanie do widoku




            return modelAndView;
        }
    }

