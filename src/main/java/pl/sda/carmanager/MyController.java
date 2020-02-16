package pl.sda.carmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller //klasa odpowiedzialna za odczytywanie zadan od klienta
@RequestMapping("/test") //pod adresem obslujguje zadania
public class MyController {
    @GetMapping //bedzie wywolana ta metoda
    public String test() {
        return "somepage"; // zwracaj wszystko co mam w indexie
    }


    @GetMapping("/other") //trzeba wpisac test/other,kolejne mapowanie
    public ModelAndView other() {
        Map<String, String> model = new HashMap<>();
        model.put("test", "Jav1a!");
        return new ModelAndView("someotherpage", model);
    }

    @GetMapping("/path-params/{input}") //to co sami wpiszemy po locahost sie wyswietli
    public ModelAndView paramsTest(@PathVariable("input") String input) {
        Map<String, String> model = new HashMap<>();
        model.put("test", input);
        return new ModelAndView("someotherpage", model);
    }

    @GetMapping("/request-params")
    public ModelAndView requestParamsTest(@RequestParam("klucz") String input) {
        Map<String, String> model = new HashMap<>();
        model.put("test", input);
        return new ModelAndView("someotherpage", model);
    }


}
