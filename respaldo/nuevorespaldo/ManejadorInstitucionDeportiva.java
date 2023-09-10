package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManejadorInstitucionDeportiva {

    private static ManejadorInstitucionDeportiva instancia = null;
    private Map<String,InstitucionDeportiva> instituciones = new HashMap<>();
    private ManejadorInstitucionDeportiva(){}

    public static ManejadorInstitucionDeportiva getInstancia() {
        if (instancia == null)
            instancia = new ManejadorInstitucionDeportiva();
        return instancia;
    }

     public void agregarInstitucion(String nombre, InstitucionDeportiva institucion) {
        instituciones.put(nombre,institucion);
    }
    /* public void agregarInstitucion(InstitucionDeportiva institucion) {
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(institucion); // Persistir la entidad institución
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(); 
        } finally {
            em.close();
        }
    } */

   
     public InstitucionDeportiva getInstitucion(String nombre) {
        return instituciones.get(nombre);
    }

    /*  public InstitucionDeportiva getInstitucion(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		InstitucionDeportiva instituciondep = em.find(InstitucionDeportiva.class, nombre);
		return instituciondep;
	} */

    public boolean existeInsttitucion(String nombre) {
        return instituciones.containsKey(nombre);
    }

    /*  public boolean existeInstitucion(String nombre) {
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        
        InstitucionDeportiva instituciondep = em.find(InstitucionDeportiva.class, nombre);
        return instituciondep != null;
    }
 */
   

    public void removerInstitucion(String nombre) {
        instituciones.remove(nombre);
    }

    /*  public void removerInstitucion(String nombre) {
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        InstitucionDeportiva instituciondep = em.find(InstitucionDeportiva.class, nombre);
        
        if (instituciondep != null) {
            tx.begin();
            em.remove(instituciondep);
            tx.commit();
        }
    } */

    public ArrayList<String> getNombres(){
        ArrayList<String> res = new ArrayList<>();
        for (String nombre: instituciones.keySet()) {
            res.add(nombre);
        }
        return res;
    }
    /*
     * public ArrayList<String> getNombres() {
        Conexion conexion = Conexion.getInstancia();
        EntityManager em = conexion.getEntityManager();

        Query query = em.createQuery("SELECT i FROM InstitucionDeportiva i");

        @SuppressWarnings("unchecked")
        List<InstitucionDeportiva> instituciones =  query.getResultList();
        
        ArrayList<String> nombres = new ArrayList<>();
        for (InstitucionDeportiva institucion : instituciones) {
            nombres.add(institucion.getNombre());
        }
        return nombres;
    }
     */
}
