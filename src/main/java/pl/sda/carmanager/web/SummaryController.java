package pl.sda.carmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carmanager.entity.FuelEntity;
import pl.sda.carmanager.repository.FuelRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Controller
@RequestMapping("/summary") //powinno sie nazywac inaczej niz car
public class SummaryController {
    private FuelRepository fuelRepository;

    @Autowired
    public SummaryController(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }


    @GetMapping("/show")//wyswietli to co dodam,wysiwtela formularz carform1
    public ModelAndView getShowRegister() {
        List<FuelEntity> fuelentries = fuelRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
        //sortoanie po dacie
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("summaryview");//wpisujemy co ma wyswietlic

//        // zsumowany koszt
//        // sumaryczna ilosc tankowan
//
//        //1. Utworzyc nowa klasa SummaryEntry z polem costSum (BigDecimal) + gettery, settery
//        //2. Utworzyc metode w FuelRepository, ktora bedzie sluzyla do sumowania kosztu -> powinna zwracac BigDecimal
//        //3. Rezultat z tej metody przypisz do pola costSum nowo utworzonego obiektu typu SummaryEntry
//        //4. Dodac ten obiekt do modelu (getModel().put(klucz, <twojobiekt>)
//        //5. Zrobic nowy widok (summaryview), w ktorym bedziesz wyswietlala pole costSum z modelu
//    }
        SummaryEntry summary1 = new SummaryEntry(); //sumowanie wszystkich kosztow
        BigDecimal sum = fuelRepository.selectTotals();
        summary1.setCostSum(sum);
//1. utworzyc pole averageConsumption w SummaryEntry (+getter, setter)
        //2. Utworzyc metode w FuelRepository, ktora bedzie sumowala zatankowane paliwo -> zwraca BigDecimal
        //3. Utworzyc metode w FuelRepository, ktora bedzie znajdowala min. kilometry -> zwraca BigDecimal
        //4. Utworzyc metode w FuelRepository, ktora bedzie znajdowala max. kilometry -> zwraca BigDecimal
        //5. Wywolac metode do znajdowania min. kilometrow, przepisac do zmiennej min
        //6. Wywolac metode do znajdowania max. kilometrow, przepisac do zmiennej max
        //7. Utworzyc nowa zmienna i ustawic ja na max-min <- to liczba przejechanych kilometrow
        //8. Wywolac metode do sumowania zatankowanego paliwa, przypisac jej rezultat do zmiennej tanked.
        //9. Utworzyc nowa zmienna i ustawic ja na sume zatankowanego paliwa / ilosc przejechanych km * 100 (BigDecimal.valueOf(100))
        //10. Zmienna utworzona wyzej przypisac do pola averageConsumption
        //11. Zmienic w html (dodac wyswietlanie)


        Integer sum2 = fuelRepository.selectCount(); //sumowanie id
        summary1.setIdSum(sum2);


        //przypisujemy do tego samego obiektu
        //nie moze byc 2 razy return-wywalal blad

        BigDecimal sum3 = fuelRepository.selectMin(); //srednie spalanie MIN
        summary1.setAverageConsumption(sum3);


        BigDecimal sum4 = fuelRepository.selectMax(); //srednie spalanie MAX
        summary1.setAverageConsumption(sum4);


        BigDecimal tanked = fuelRepository.selectLitre(); //sumowanie litrow


        BigDecimal result = fuelRepository.selectMax();
//                .subtract(fuelRepository.selectMin());//liczba przejechanych km-najwiekszy licznik


        BigDecimal result2 = tanked.divide(result, MathContext.DECIMAL32).multiply(BigDecimal.valueOf(100)); //dopisane aby koszt sie obliczal
        summary1.setAverageConsumption(result2);//ustawianie wyniku kosztu
        //decimal32-precyzja

        modelAndView.getModel().put("summary", summary1);

        return modelAndView;
    }

}



