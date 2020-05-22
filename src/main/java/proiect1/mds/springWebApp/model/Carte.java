package proiect1.mds.springWebApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Carte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titlu;
    private String isbn;

    @ManyToOne
    private Editura editura;


    @ManyToMany
    @JoinTable(name = "autor_carte", joinColumns =  @JoinColumn(name = "carte_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private Set<Autor> autori = new HashSet<>();

    public Carte() {
    }

    public Carte(String titlu, String isbn) {
        this.titlu = titlu;
        this.isbn = isbn;
    }

    public Editura getEditura() {
        return editura;
    }

    public void setEditura(Editura editura) {
        this.editura = editura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Autor> getAutori() {
        return autori;
    }

    public void setAutori(Set<Autor> autori) {
        this.autori = autori;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carte carte = (Carte) o;

        return id != null ? id.equals(carte.id) : carte.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
