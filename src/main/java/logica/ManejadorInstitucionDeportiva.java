package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityTransaction;

import persistencia.Conexion; // Asegúrate de importar tu clase personalizada de conexión.

public class ManejadorInstitucionDeportiva {
    private static final Logger LOGGER = Logger.getLogger(ManejadorInstitucionDeportiva.class.getName());

    private static ManejadorInstitucionDeportiva instancia = null;
    private Map<String, InstitucionDeportiva> instituciones = new HashMap<>();
    private Conexion conexion; // Uso mi clase de conexión

    private ManejadorInstitucionDeportiva() {
        conexion = Conexion.getInstancia();
    }

    public static ManejadorInstitucionDeportiva getInstancia() {
        if (instancia == null)
            instancia = new ManejadorInstitucionDeportiva();
        return instancia;
    }

    public void agregarInstitucion(String nombre_institucion, InstitucionDeportiva institucion) {
        instituciones.put(nombre_institucion, institucion);

        EntityManager em = conexion.getEntityManager(); // Obtenemos el EntityManager

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
            // No cerramos el EntityManager aquí para mantenerlo abierto para otras operaciones.
        }
    }

    public InstitucionDeportiva getInstitucion(String nombre) {
        EntityManager em = conexion.getEntityManager(); // Obtenemos el EntityManager

        try {
            InstitucionDeportiva instituciondep = em.find(InstitucionDeportiva.class, nombre);
            return instituciondep;
        } finally {
            // No cerramos el EntityManager aquí para mantenerlo abierto para otras operaciones.
        }
    }

    public boolean existeInstitucion(String nombre) {
        EntityManager em = conexion.getEntityManager(); // Obtenemos el EntityManager

        try {
            InstitucionDeportiva instituciondep = em.find(InstitucionDeportiva.class, nombre);
            return instituciondep != null;
        } finally {
            // No cerramos el EntityManager aquí para mantenerlo abierto para otras operaciones.
        }
    }

    public void removerInstitucion(String nombre) {
        EntityManager em = conexion.getEntityManager(); // Obtenemos el EntityManager
        EntityTransaction tx = em.getTransaction();

        InstitucionDeportiva instituciondep = em.find(InstitucionDeportiva.class, nombre);

        if (instituciondep != null) {
            tx.begin();
            em.remove(instituciondep);
            tx.commit();
        }
    }

    public ArrayList<String> getNombres() {
        EntityManager em = conexion.getEntityManager(); // Obtenemos el EntityManager

        try {
            LOGGER.info("Iniciando transacción para obtener nombres de instituciones.");
            em.getTransaction().begin(); // Inicia la transacción

            Query query = em.createQuery("select i from InstitucionDeportiva i");
            List<InstitucionDeportiva> listInsti = (List<InstitucionDeportiva>) query.getResultList();

            LOGGER.info("Transacción para obtener nombres de instituciones completada.");
            em.getTransaction().commit(); // Completa la transacción

            ArrayList<String> aRetornar = new ArrayList<>();
            for (InstitucionDeportiva i : listInsti) {
                aRetornar.add(i.getNombre());
            }

            return aRetornar;
        } catch (Exception e) {
            LOGGER.severe("Error al obtener nombres de instituciones: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            // No cerramos el EntityManager aquí para mantenerlo abierto para otras operaciones.
        }
    }
}
