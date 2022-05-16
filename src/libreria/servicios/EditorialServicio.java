package libreria.servicios;

import com.sun.istack.internal.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {

    private final EditorialDAO DAO;
    private final Scanner sc;

    public EditorialServicio() {
        this.DAO = new EditorialDAO();
        this.sc = new Scanner(System.in).useDelimiter("\n");
    }

    public Editorial crearEditorial(String nombre) {

        Editorial editorial = new Editorial();
        ///VALIDAR EDITORIAL SI EXISTE
        if (!existeEditorial(nombre)) {

            editorial.setNombre(nombre);
            editorial.setAlta(Boolean.TRUE);

            DAO.guardar(editorial);
            return editorial;
        }
        return editorial;

    }

    public List<Editorial> listarEditoriales() {
        try {
            return DAO.listarTodos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Editorial buscarPorNombre(String nombre) {

        try {
            Editorial editorial = DAO.buscarPorNombre(nombre);
            System.out.println("Se encontró la editorial: "
                    + editorial.getNombre());
            return editorial;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue: " + e.toString());
            System.out.println(
                    "No se devolvió ninguna entrada para esta editorial.");
            return null;
        }
    }

    public Editorial buscarPorID(Integer id) throws Exception {
        try {
            if (id == null || id == 0) {
                throw new Exception("Debe ingresar un ID válido.");
            }
            Editorial editorial = DAO.buscarPorID(id);

            if (editorial == null) {

                throw new Exception("El ID buscado no se encuentra en la base de datos.");
            }

            return editorial;
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer ingresarID() throws Exception {
        try {
            System.out.println("Ingrese el número de id:");
      
            Integer id = sc.nextInt();
            if (id==0) {
                throw new Exception("El id no puede ser 0");
                     
            }
            return id;
        } catch (Exception e) {
            System.out.println("Debe ingresar un número válido");
            e.printStackTrace();
        }
        return null;

    }

    public boolean existeEditorial(String nombre) {

        try {
            Editorial resultado = DAO.buscarPorNombre(nombre);

            if (resultado != null) {
                return true;

            } else {
                return false;

            }
        } catch (Exception e) {
            System.out.println("Sale del método existeEditorial con resultado null");
            e.printStackTrace();
            System.out.println(e.toString());
            return false;
        }

    }

    public void modificarNombre() throws Exception {
        try {
            System.out.println("Va a modificar el nombre de una editorial.");
            Editorial editorial = buscarPorID(ingresarID());
            System.out.println("Ingrese el nuevo nombre de la editorial.");
            String nombre = sc.next();
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre de la editorial.");
            }
            editorial.setNombre(nombre);
            DAO.modificarEditorial(editorial);
            System.out.println("El nombre de la editorial ha cambiado exitosamente a '" + nombre + "'.");
        } catch (Exception e) {
            throw e;
        }

    }

    public void darBaja() throws Exception {

        try {
            System.out.println("Indique la editorial a la que desea dar de baja:");
            Editorial editorial = buscarPorID(ingresarID());
            System.out.println("La editorial es: "+editorial.getNombre()+".");
            
            if (editorial.getAlta()== false) {
                System.out.println("La editorial ya ha sido dada de baja con anterioridad.");
            } else{
             editorial.setAlta(Boolean.FALSE);
            DAO.modificarEditorial(editorial);
            System.out.println("Se ha dado de baja correctamente.");               
            }


        } catch (Exception e) {
            System.out.println("No se ha logrado dar de baja.");
            e.printStackTrace();
        }

    }
    
     public void darAlta() throws Exception {

        try {
            System.out.println("Indique la editorial a la que desea reactivar:");
            Editorial editorial = buscarPorID(ingresarID());
            System.out.println("La editorial es: "+editorial.getNombre()+".");
            
            if (editorial.getAlta()== true) {
                System.out.println("La editorial ya está activa.");
            } else{
             editorial.setAlta(Boolean.TRUE);
            DAO.modificarEditorial(editorial);
            System.out.println("Se ha reactivado correctamente.");               
            }


        } catch (Exception e) {
            System.out.println("No se ha logrado dar de alta.");
            e.printStackTrace();
        }

    }   

}
