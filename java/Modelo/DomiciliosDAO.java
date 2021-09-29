package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DomiciliosDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs; 
    int r;
    public int guardarDomicilio(Domicilios dm){
     String sql="Insert into domicilios(idCliente, Telefono , Ciudad, FechaReserva, HoraReserva, Estado ,Dirrecion, Email)values(?,?,?,?,?,?,?,?)";
        try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql); 
        ps.setInt(1, dm.getIdcliente());
        ps.setString(2, dm.getTelefono());
        ps.setString(3, dm.getCiudad());
        ps.setString(4, dm.getFecha());
        ps.setString(5, dm.getHora());
        ps.setString(6, dm.getEstado());
        ps.setString(7, dm.getDir());
        ps.setString(8, dm.getCorreo());
        ps.executeUpdate();
        }catch(Exception e){
    }
        return r;
}
    public int guardardtDomicilio(DetalleDomicilio dt){
    String sql="Insert into detalle_domicilio(fechaEntrega, horaEntrega, Valor_domicilio, Estado)values(?,?,?,?)";
try{
    con= cn.Conexion();
    ps = con.prepareStatement(sql);
    ps.setString(1, dt.getFechaentrega());
    ps.setString(2, dt.getHoraentrega());
    ps.setDouble(3, dt.getValordomiiclio());
    ps.setString(4, dt.getEstado());
   
    
    ps.executeUpdate();

}   catch(Exception e){
    
} 
return r;
    }
    
    public List misDomicilios(int id){
        List lista = new ArrayList();
        String sql="select * from domicilios where idCliente=" + id;
        try{
         con = cn.Conexion();
         ps =  con.prepareStatement(sql);
         rs = ps.executeQuery(); 
         while(rs.next()){
           Domicilios dom = new Domicilios();
           dom.setId(rs.getInt(1));
           dom.setIdcliente(rs.getInt(2));  
           dom.setFecha(rs.getString(5));
           dom.setHora(rs.getString(6));
           dom.setEstado(rs.getString(7));
           dom.setDir(rs.getString(8));
           dom.setCorreo(rs.getString(9));
           lista.add(dom);
         }
        }catch(Exception e){
            
        }
    return lista;
    }
 
}