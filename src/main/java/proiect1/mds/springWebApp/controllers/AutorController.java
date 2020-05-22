package proiect1.mds.springWebApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proiect1.mds.springWebApp.repositories.AutorRepository;

@Controller
public class AutorController {

    private final AutorRepository autorRepo;

    public AutorController(AutorRepository autorRepo) {
        this.autorRepo = autorRepo;
    }

    @RequestMapping("autori")
    public String getAutori(Model model){

        model.addAttribute("autori",autorRepo.findAll());

        return "autori/list";
    }

}
