package proiect1.mds.springWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import proiect1.mds.springWebApp.model.Autor;
import proiect1.mds.springWebApp.model.Carte;
import proiect1.mds.springWebApp.model.Editura;
import proiect1.mds.springWebApp.repositories.AutorRepository;
import proiect1.mds.springWebApp.repositories.CarteRepository;
import proiect1.mds.springWebApp.repositories.EdituraRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AutorRepository autorRepo;
    private final CarteRepository carteRepo;
    private final EdituraRepository edituraRepo;

    public BootStrapData(AutorRepository autorRepo, CarteRepository carteRepo, EdituraRepository edituraRepo) {
        this.autorRepo = autorRepo;
        this.carteRepo = carteRepo;
        this.edituraRepo = edituraRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Autor ion = new Autor("Popuescu", "Ion");
        Carte povesti = new Carte("Basme", "1234567");

        ion.getCarti().add(povesti); //aducam cartea la autor
        povesti.getAutori().add(ion); //adaugam autorul la carte

        //salvam datele in baza de date H2
        autorRepo.save(ion);
        carteRepo.save(povesti);

        //cream o editrua
        Editura carturesti = new Editura();
        carturesti.setNume("Carturesti");
        carturesti.setAdresa("Verona nr 50");

        povesti.setEditura(carturesti);
        carturesti.getCarti().add(povesti);
        edituraRepo.save(carturesti);


        //cream inca o noua carte + autor
        Autor john = new Autor("Jameson", "John");
        Carte nuvele = new Carte("Nuvele", "88888");

        john.getCarti().add(nuvele);
        nuvele.getAutori().add(john);
        autorRepo.save(john);
        carteRepo.save(nuvele);

        nuvele.setEditura(carturesti);
        carturesti.getCarti().add(nuvele);
        edituraRepo.save(carturesti);



        System.out.println("Bootstrap a pornit... ");
        System.out.println("Numarul de carti: " + carteRepo.count());
        System.out.println("Numarul de edituri: " + edituraRepo.count());
        System.out.println("Numarul de carti al editurii: " + carturesti.getCarti().size());
    }
}
