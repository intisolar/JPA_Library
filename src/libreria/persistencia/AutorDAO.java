package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    public Autor buscarPorID(Long id) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return autor;
    }

    public List<Autor> listarTodos() {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
    }

    public Autor buscarPorNombre(String nombre) {
        conectar();

            Autor autor = (Autor) em.createQuery(
                    "SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                    .setParameter("nombre", nombre)
                    .getSingleResult();
            desconectar();
            
            return autor;
            

    }

}
