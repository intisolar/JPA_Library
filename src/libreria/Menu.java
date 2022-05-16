package libreria;

import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.entidades.Editorial;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

public class Menu {

    private final LibroServicio libroServicio = new LibroServicio();
    private final AutorServicio autorServicio = new AutorServicio();
    private final EditorialServicio editorialServicio = new EditorialServicio();

    public void ejecucion() {

        //CREO AUTORES
        try {

            autorServicio.crearAutor("Enriquez, Mariana");
            autorServicio.crearAutor("Cortazar, Julio");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        System.out.println("ESTA ES LA LISTA DE AUTORES QUE SE CREARON");
        autorServicio.listarAutores().forEach((a) -> System.out.println(a.toString()));

        //CREO EDITORIALES
        try {

            editorialServicio.crearEditorial("Anagrama");
            editorialServicio.crearEditorial("Editorial Sudamericana");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        System.out.println("ESTA ES LA LISTA DE EDITORIALES QUE SE CREARON");
        editorialServicio.listarEditoriales().forEach((a) -> System.out.println(a.toString()));

        System.out.println(editorialServicio.buscarPorNombre("Anagrama").toString());
        System.out.println(editorialServicio.buscarPorNombre("Editorial Sudamericana"));
        //CREO LIBROS
        try {

            
            libroServicio.crearLibro(
                    12345678L,
                    "Las cosas que perdimos en el fuego",
                    2016,
                    20,
                    editorialServicio.buscarPorNombre("Anagrama"),
                    autorServicio.buscarPorNombre("Enriquez, Mariana"));

            libroServicio.crearLibro(
                    87654321L,
                    "Todos los fuegos el fuego",
                    1966,
                    15,
                    editorialServicio.buscarPorNombre("Editorial Sudamericana"),
                    autorServicio.buscarPorNombre("Cortazar, Julio"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        System.out.println("ESTA ES LA LISTA DE LIBROS QUE SE CREARON");
        libroServicio.listarLibros().forEach((a) -> System.out.println(a.toString()));

//        MODIFICO Editorial
        try {
            editorialServicio.modificarNombre();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El error fue " + e.toString());
        }

        
        try {
            //DAR DE ALTA
            editorialServicio.darAlta();
            
            //DAR DE BAJA
            
            editorialServicio.darBaja();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }



    }

}
