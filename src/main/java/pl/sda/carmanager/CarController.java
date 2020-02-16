package pl.sda.carmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {


    private CarRepository carRepository;

    @Autowired //podstawia CarRepository z entitymanager
    //wstrzykiwanie zaleznosci z carrepository
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/front") //bedzie wywolana ta metoda
    public String ok() {
        return "front"; // zwracaj wszystko co mam w indexie
    }

    @GetMapping("/index") //bedzie wywolana ta metoda
    public String index() {
        return "index"; // zwracaj wszystko co mam w indexie
    }


    @PostMapping
    public String saveCar(@RequestParam("name") String name) { //car?name=abc-wstawi stringa
        CarEntity prd = new CarEntity(); //prd byl to skrot od product
        prd.setName(name);
        carRepository.save(prd); // odpowiedzialne za zapisanie do bazy
        System.out.println("Nowy samochód id: " + prd.getId());
        return "somepage";
        //zapisal do bazy danych renault bo nacisnieciu submit tylko w pasku adresu url
    }
//    @PostMapping
//    public String createCar(@RequestParam("press") String press) { //car?name=abc-wstawi stringa
//        CarEntity prd1 = new CarEntity(); //prd byl to skrot od product
//        prd1.setName(press);
//        carRepository.save(prd1); // odpowiedzialne za zapisanie do bazy
//        System.out.println("Nowy samochód id: " + prd1.getId());
//        return "somepage";
//    }


    @GetMapping //pobieranie/wyszukanie po id, wyswietlanie listy po id
    public String getCar(@RequestParam("id") Integer id) {
        carRepository.findById(id)
                .ifPresent(prd -> System.out.println(prd.getName()));
        return "somepage";
    }

    @GetMapping("/list") //lista na stronie
    public ModelAndView getCar() {
        Map<String, Object> model = new HashMap<>();
        model.put("cars", carRepository.findAll());
        return new ModelAndView("car", model);
    }

    @PostMapping("/save") //wystwietla car created
    public ModelAndView postSaveProduct(@ModelAttribute CarEntity car) {
        //modelatribute-przenoszenie z htlm tego co wpisze ,ustawia model
        carRepository.save(car);
        Map<String, Object> model = new HashMap<>();
        model.put("created", car);
        //created;name,id
        return new ModelAndView("carCreated", model);
    }

    @GetMapping("/save")//wyswietli to co dodam,wysiwtela formularz carform1
    public ModelAndView getSaveProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("carform1");
        modelAndView.getModel().put("car", new CarEntity());
        // car-moze byc dowolne
        //zwraca NewCarEntity

        return modelAndView;
        //zwraca strone carform1
    }

//    @GetMapping("/created")//wyswietli to co dodam
//    public ModelAndView getCreateProduc() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("fuelform");
//        modelAndView.getModel().put("car", new CarEntity());
//
//        return modelAndView;
//    }
}

