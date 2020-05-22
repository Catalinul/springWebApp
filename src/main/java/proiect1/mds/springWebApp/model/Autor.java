package proiect1.mds.springWebApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nume;
    private String prenume;

    @ManyToMany(mappedBy = "autori")
    private Set<Carte> carti = new HashSet<>();

    public Autor() {
    }

    public Autor(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Set<Carte> getCarti() {
        return carti;
    }

    public void setCarti(Set<Carte> carti) {
        this.carti = carti;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Autor autor = (Autor) o;

        return id != null ? id.equals(autor.id) : autor.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
