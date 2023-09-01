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

    public InstitucionDeportiva getInstitucion(String nombre) {
        return instituciones.get(nombre);
    }

    public boolean existeInsttitucion(String nombre) {
        return instituciones.containsKey(nombre);
    }

    public void removerInstitucion(String nombre) {
        instituciones.remove(nombre);
    }

    public ArrayList<String> getNombres(){
        ArrayList<String> res = new ArrayList<>();
        for (String nombre: instituciones.keySet()) {
            res.add(nombre);
        }
        return res;
    }
}
