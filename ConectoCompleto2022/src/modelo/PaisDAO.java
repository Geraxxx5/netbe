package modelo;

import conexion.Conector;


public class PaisDAO implements ConsultasPais {

    @Override
    public void insertar(PaisVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO pais (nombre_pais, "+
                    "capital_pais,poblacion_pais,fecha_ingreso_pais) "
                    +"VALUES ('"+p.getNombrePais()+"','"+p.getCapitalPais()+"',"
                    +p.getPoblacionPais()+", '"+p.getFechaIngPais()+"')";
            
            c.consultasMultiples(query);
            
        } catch (Exception e) {
            System.err.println("Error [MInsert]: "+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
    }
    
}
