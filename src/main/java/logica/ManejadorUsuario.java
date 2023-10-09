package logica;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;

import persistencia.Conexion;

public class ManejadorUsuario {

    private static ManejadorUsuario instancia = null;
    private Conexion conexion;

    private ManejadorUsuario() {
        conexion = Conexion.getInstancia();
    }

    public static ManejadorUsuario getInstancia() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void agregarUsuario(Usuario usuario) {
        EntityManager em = conexion.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(usuario);
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

    public Usuario buscarUsuario(String nickname) {
        EntityManager em = conexion.getEntityManager();

        try {
            return em.find(Usuario.class, nickname);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // No cerramos el EntityManager aquí para mantenerlo abierto para otras operaciones.
        }
    }

    public ArrayList<String> getUsuarios() {
        EntityManager em = conexion.getEntityManager();

        try {
            em.getTransaction().begin();

            Query query = em.createQuery("select u from Usuario u");
            List<Usuario> listUsuario = (List<Usuario>) query.getResultList();

            em.getTransaction().commit();

            ArrayList<String> aRetornar = new ArrayList<>();
            for (Usuario u : listUsuario) {
                aRetornar.add(u.getNickname());
            }

            return aRetornar;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            // No cerramos el EntityManager aquí para mantenerlo abierto para otras operaciones.
        }
    }

    public ArrayList<String> getSocios() {
        EntityManager em = conexion.getEntityManager();

        try {
            em.getTransaction().begin();

            Query query = em.createQuery("select s from Socio s");
            List<Socio> listSocio = (List<Socio>) query.getResultList();

            em.getTransaction().commit();

            ArrayList<String> aRetornar = new ArrayList<>();
            for (Socio s : listSocio) {
                aRetornar.add(s.getNickname());
            }

            return aRetornar;
        } catch (Exception e) {
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
