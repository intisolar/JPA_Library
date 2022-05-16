package libreria.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIBROS")
public class Libro {

    @Id
    @Column(name = "ISBN")
    private Long isbn;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "ANIO")
    private Integer anio;

    @Column(name = "EJEMPLARES")
    private Integer ejemplares;

    @Column(name = "EJEMPLARES_PRESTADOS")
    private Integer ejemplaresPrestados;

    @Column(name = "EJEMPLARES_RESTANTES")
    private Integer ejemplaresRestantes;

    @Column(name = "ALTA")
    private Boolean alta;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "EDITORIAL_ID")
    private Editorial editorial;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "AUTOR_ID")
    private Autor autor;

    public Libro() {
    }

    public Libro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Editorial autor, Autor editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.editorial = autor;
        this.autor = editorial;
    }

    /**
     * @return the isbn
     */
    public Long getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    /**
     * @return the ejemplares
     */
    public Integer getEjemplares() {
        return ejemplares;
    }

    /**
     * @param ejemplares the ejemplares to set
     */
    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    /**
     * @return the ejemplaresPrestados
     */
    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    /**
     * @param ejemplaresPrestados the ejemplaresPrestados to set
     */
    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    /**
     * @return the ejemplaresRestantes
     */
    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    /**
     * @param ejemplaresRestantes the ejemplaresRestantes to set
     */
    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    /**
     * @return the alta
     */
    public Boolean getAlta() {
        return alta;
    }

    /**
     * @param alta the alta to set
     */
    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    /**
     * @return the autor
     */
    public Editorial getEditorial() {
        return editorial;
    }

    /**
     * @param autor the autor to set
     */
    public void setEditorial(Editorial autor) {
        this.editorial = autor;
    }

    /**
     * @return the editorial
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setAutor(Autor editorial) {
        this.autor = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", anio=" + anio + ", ejemplares=" + ejemplares + ", ejemplaresPrestados=" + ejemplaresPrestados + ", ejemplaresRestantes=" + ejemplaresRestantes + ", alta=" + alta + ", editorial=" + editorial.getNombre() + ", autor=" + autor.getNombre() + '}';
    }

}
