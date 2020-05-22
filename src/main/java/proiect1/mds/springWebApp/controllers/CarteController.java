package proiect1.mds.springWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proiect1.mds.springWebApp.repositories.CarteRepository;

@Controller
public class CarteController {

    private final CarteRepository carteRepo;

    public CarteController(CarteRepository carteRepo) {
        this.carteRepo = carteRepo;
    }

    @RequestMapping("/carti")
    public String getCarti(Model model)
    {

        model.addAttribute("carti",carteRepo.findAll());

        return "carti/list";
    }
}
