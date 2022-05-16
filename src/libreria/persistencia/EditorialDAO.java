package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }




    public List<Editorial> listarTodos() {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        desconectar();
        return editoriales;
    }

    public Editorial buscarPorNombre(String nombre) throws Exception {
        try {
                    conectar();
        Editorial editorial = (Editorial) em.createQuery(
                "SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();

        desconectar();
        return editorial;
        } catch (Exception e) {
            System.out.println("No se han encontrado editoriales");
            return null;
        }


    }

    public Editorial buscarPorID(Integer id) throws Exception {
        conectar();
        Editorial editorial = (Editorial) em.createQuery(
                "SELECT e FROM Editorial e WHERE e.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();


        desconectar();
        return editorial;

    }

    public void modificarEditorial(Editorial editorial) throws Exception {
        try {
            if (editorial == null) {
                throw new Exception("El proceso de modificación de la editorial falló.");
            }
            super.editar(editorial);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: " + e.toString());
        }
    }
}
