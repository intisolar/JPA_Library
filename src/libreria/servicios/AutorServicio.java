package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {

    private final AutorDAO DAO;

    public AutorServicio() {
        this.DAO = new AutorDAO();
    }

    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();

        try {
            autor.setNombre(nombre);
            autor.setAlta(Boolean.TRUE);

            DAO.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<Autor> listarAutores() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Autor buscarPorNombre(String nombre) {

        try {
            Autor autor = DAO.buscarPorNombre(nombre);
            System.out.println("Se encontró el autor: " + autor.getNombre());
            return autor;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: " + e.toString());
            System.out.println("No se devolvió ninguna entrada para este autor.");

            return null;
        }
    }
}
