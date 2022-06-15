package modelo;

import conexion.Conector;
import java.util.ArrayList;
import java.sql.ResultSet;

public class LibroDAO implements ConsultasLibro{

    @Override
    public boolean insertarLibro(LibroVO lvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO libro(id_autor_fk,nombre_libro,fecha_publicacion_libro,numero_paginas_libro,genero_principal_libro) "+
                    "VALUES("+lvo.getIdAutorFk()+", '"+lvo.getNombreLibro()+"', '"+lvo.getFechaPublicacionLibro()+"', "+lvo.getNumeroPaginasLibro()+", '"+lvo.getGeneroPrincipalLibro()+"')";
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MInserarL]: "+e);
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<LibroVO> consultarLibro() {
        ArrayList<LibroVO> list = new ArrayList<>();
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "SELECT * FROM bdactividadf.libro l";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                LibroVO lvo = new LibroVO();
                lvo.setIdLibro(rs.getInt("id_libro"));
                lvo.setIdAutorFk(rs.getInt("id_autor_fk"));
                lvo.setNombreLibro(rs.getString("nombre_libro"));
                lvo.setFechaPublicacionLibro(rs.getDate("fecha_publicacion_libro"));
                lvo.setNumeroPaginasLibro(rs.getInt("numero_paginas_libro"));
                lvo.setGeneroPrincipalLibro(rs.getString("genero_principal_libro"));
                list.add(lvo);
            }
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MConsultas]: "+e);
        }
        return list;
    }

    @Override
    public boolean eliminarLibro(LibroVO lvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "DELETE FROM bdactividadf.libro WHERE id_libro = "+lvo.getIdLibro();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MEliminar]: "+e);
            return false;
        }
        return true;
    }

    @Override
    public boolean actualizarLibro(LibroVO lvo) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "UPDATE bdactividadf.libro l SET l.id_autor_fk = "+lvo.getIdAutorFk()+", l.nombre_libro = '"+lvo.getNombreLibro()+"', l.fecha_publicacion_libro = '"+lvo.getFechaPublicacionLibro()+"', l.numero_paginas_libro = "+lvo.getNumeroPaginasLibro()+", l.genero_principal_libro = '"+lvo.getGeneroPrincipalLibro()+"' WHERE l.id_libro = "+lvo.getIdLibro();
            c.consultasMultiples(query);
            c.desconectar();
        } catch (Exception e) {
            c.desconectar();
            System.err.println("Error [MActualiza]: "+e);
            return false;
        }
        return true;
    }


    
    
}
