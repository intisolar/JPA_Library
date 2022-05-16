package libreria.servicios;

import java.util.List;
import java.util.Optional;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicio {

    private final LibroDAO DAO;
    private EditorialServicio editorialServicio;

    public LibroServicio() {
        this.DAO = new LibroDAO();
    }

    public Libro crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares,
            Editorial editorial, Autor autor) {
        Libro libro = new Libro();

        try {
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setAutor(autor);
//            Editorial editorial = editorialServicio.crearEditorial(editorialNombre);
            libro.setEditorial(editorial);

            libro.setAlta(Boolean.TRUE);

            DAO.guardar(libro);
            return libro;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error creando libros");
            System.out.println(e.toString());
            return null;
        }

    }

    public List<Libro> listarLibros() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }



}
