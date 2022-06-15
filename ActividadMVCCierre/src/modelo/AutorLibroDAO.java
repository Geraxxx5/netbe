package modelo;

import conexion.Conector;
import java.util.ArrayList;
import java.sql.ResultSet;

public class AutorLibroDAO implements ConsultasJoin{

    @Override
    public ArrayList<AutorLibroVO> consultaJoin(ArrayList<String> datos) {
        ArrayList<AutorLibroVO> list = new ArrayList<>();
        Conector c = new Conector();
        String cadena = "SELECT ";
        int count = 0;
        int largo = datos.size();
        for(String data : datos){
            if(data == "a.id_autor"){
                cadena+="a.id_autor";
            }
            if(data == "a.nombre_autor"){
                cadena+="a.nombre_autor";
            }
            if(data == "a.seudonimo_autor"){
                cadena+="a.seudonimo_autor";
            }
            if(data == "a.edad_autor"){
                cadena+="a.edad_autor";
            }
            if(data == "a.genero_autor"){
                cadena+="a.genero_autor";
            }
            if(data == "l.id_libro"){
                cadena+="l.id_libro";
            }
            if(data == "l.id_autor_fk"){
                cadena+="l.id_autor_fk";
            }
            if(data == "l.nombre_libro"){
                cadena+="l.nombre_libro";
            }
            if(data == "l.fecha_publicacion_libro"){
                cadena+="l.fecha_publicacion_libro";
            }
            if(data == "l.numero_paginas_libro"){
                cadena+="l.numero_paginas_libro";
            }
            if(data == "l.genero_principal_libro"){
                cadena+="l.genero_principal_libro";
            }
            if((count+1) != largo){
                cadena+=", ";
            }else{
                cadena+=" ";
            }
            count++;
        }
        cadena+="FROM bdactividadf.autor a INNER JOIN bdactividadf.libro l ON a.id_autor = l.id_autor_fk";
        try {
            c.conectar();
            ResultSet rs = c.consultaDatos(cadena);
            while(rs.next()){
                AutorLibroVO alvo = new AutorLibroVO();
                for(String data : datos){
                    if(data == "a.id_autor"){
                        alvo.setIdAutor(rs.getInt("id_autor"));
                    }
                    if(data == "a.nombre_autor"){
                        alvo.setNombreAutor(rs.getString("nombre_autor"));
                    }
                    if(data == "a.seudonimo_autor"){
                        alvo.setSeudonimoAutor(rs.getString("seudonimo_autor"));
                    }
                    if(data == "a.edad_autor"){
                        alvo.setEdadAutor(rs.getInt("edad_autor"));
                    }
                    if(data == "a.genero_autor"){
                        alvo.setGeneroAutor(rs.getString("genero_autor"));
                    }
                    if(data == "l.id_libro"){
                        alvo.setIdLibro(rs.getInt("id_libro"));
                    }
                    if(data == "l.id_autor_fk"){
                        alvo.setIdAutorFk(rs.getInt("id_autor_fk"));
                    }
                    if(data == "l.nombre_libro"){
                        alvo.setNombreLibro(rs.getString("nombre_libro"));
                    }
                    if(data == "l.fecha_publicacion_libro"){
                        alvo.setFechaPublicacionLibro(rs.getDate("fecha_publicacion_libro"));
                    }
                    if(data == "l.numero_paginas_libro"){
                        alvo.setNumeroPaginasLibro(rs.getInt("numero_paginas_libro"));
                    }
                    if(data == "l.genero_principal_libro"){
                        alvo.setGeneroPrincipalLibro(rs.getString("genero_principal_libro"));
                    }
                }
                list.add(alvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error [MCJ]: "+e);
            c.desconectar();
        }
        return list;
    }
    
}
