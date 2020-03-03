package pl.sda.carmanager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.carmanager.entity.FuelEntity;
import pl.sda.carmanager.repository.FuelRepository;

import java.util.ArrayList;
import java.util.List;

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
        //sortoanie po dacie
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registerview");//wpisujemy co ma wyswietlic
        //tworzy sie nowy model, fuelRepository-mamy tam info o licznik itp, findAll-wyszukujemy wszystko
        //k-klucz jest dowolny ,fuelentries-zwraca wszystko co mam w car repository
        //ascenting-sortowanie rosnace
        List<RegistryEntry> registryList=new ArrayList<RegistryEntry>();
        Integer result= 0;

        if(!fuelentries.isEmpty()){
            FuelEntity fuel =   fuelentries.get(0); //pobranie konkretnej rzeczy w liscie,index 0
            RegistryEntry registryEntry2=new RegistryEntry();
            registryEntry2.setCounter(fuel.getCounter());
            registryEntry2.setLitre(fuel.getLitre());
            registryEntry2.setDate(fuel.getDate());
            registryEntry2.setPrice(fuel.getPrice());
            registryEntry2.setCost(fuel.getCost());
            registryEntry2.setId(fuel.getId());
            registryEntry2.setDifference(fuel.getCounter());

            registryList.add(registryEntry2);
        }



        for (int i = 0; i < fuelentries.size()-1; i++) {//lista
            RegistryEntry registryEntry = new RegistryEntry();
            FuelEntity entity1=   fuelentries.get(i); //pobranie konkretnej rzeczy w liscie,index 0



            FuelEntity entity2=   fuelentries.get(i+1);// nastepny counter,pobranie,index 1,poranie obiektu z listy

            registryEntry.setCounter(entity2.getCounter());
            registryEntry.setLitre(entity2.getLitre());
            registryEntry.setDate(entity2.getDate());
            registryEntry.setPrice(entity2.getPrice());
            registryEntry.setCost(entity2.getCost());
            registryEntry.setId(entity2.getId());


            Integer counter1 = entity1.getCounter();////dzialanie na obiekcie
            Integer counter2 = entity2.getCounter();
            result=counter2-counter1;
            registryEntry.setDifference(result);
            registryList.add(registryEntry);
        }


        //1. Utworzyc klase z takimi samymi polami jak FuelEntity, bez id (nazwac np RegistryEntry)
        //2. Dodac do tej klasy pole difference - Integer - w tym polu bedziesz przechowywala roznice
        //3. W klasie RegisterController w metodzie getShowRegister utworzyc pusta Liste RegistryEntry
        //4. W forze (tym, ktory istnieje) przepisac z FuelEntity pole po polu do RegistryEntry
        //5. Do pola difference (w RegistryEntry) przypisac roznice counterow
        //6. Zwrocic liste zawieracjaca RegistryEntry do modelu (tak jak linjke nizej)
        //7. W HTML dodac prd.difference (tak samo jak jest na przyklad prd.cost)

        modelAndView.getModel().put("register", registryList);





            return modelAndView;
        }
    }

