package pl.sda.carmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carmanager.entity.FuelEntity;
import pl.sda.carmanager.repository.FuelRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/fuel") //powinno sie nazywac inaczej niz car
public class FuelController {
    private FuelRepository fuelRepository;

    @Autowired
    public FuelController(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    @GetMapping("/fuelform") //bedzie wywolana ta metoda
    public String fuelform() {
        return "fuelform"; // zwracaj wszystko co mam w indexie
    }


    @PostMapping("/save1") //wystwietla car created
    public ModelAndView postSaveProduct(@ModelAttribute FuelEntity fuel) {
        //modelatribute-przenoszenie z htlm tego co wpisze ,ustawia model
        BigDecimal cost = fuel.getPrice().multiply(BigDecimal.valueOf(fuel.getLitre())); //dopisane aby koszt sie obliczal
        //musimy przerobic litry na decimal
        //ctrl+alt+v-przyp do zmiennej cost
        fuel.setCost(cost);//ustawianie wyniku kosztu
        //koszt na decimala
        fuelRepository.save(fuel);
        Map<String, Object> model = new HashMap<>();
        model.put("created", fuel);
        //created;name,id
        return new ModelAndView("fuelCreated", model);
    }

    @GetMapping("/save1")//wyswietli to co dodam,wysiwtela formularz carform1
    public ModelAndView getSaveProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fuelform");
        modelAndView.getModel().put("fuel", new FuelEntity());
        //wyswietlenie fuelform
        //zwraca FuelEntity
        //fuel-dowolne

        return modelAndView;
    }
}
