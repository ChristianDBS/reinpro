/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Fecha;
import Modelo.DetalleDomicilio;
import Modelo.Domicilios;
import Modelo.DomiciliosDAO;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EnvioDomicilios extends HttpServlet {

  DetalleDomicilio dtd= new DetalleDomicilio();
  
  Domicilios dml = new Domicilios();

  Fecha fechaSistem = new Fecha();
  DomiciliosDAO dldao = new DomiciliosDAO();
  Usuario  u = new Usuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String accion = request.getParameter("accion");
                        switch(accion){
                            
                case "AgregarEnvio":
               
             
                dtd.setHoraentrega(fechaSistem.getHoraActual());
                
                
                double preciod =Double.parseDouble(request.getParameter("txtValor"));
                String estado = request.getParameter("txtEstado");
                String fecha =request.getParameter("txtFecha");
            
                dtd.setValordomiiclio(preciod);
                dtd.setEstado(estado);
                dtd.setFechaentrega(fecha);
                
                dldao.guardardtDomicilio(dtd);
                
                request.getRequestDispatcher("ListadoD?accion=ListarDomicilios").forward(request, response);  
                request.getRequestDispatcher("Vistas/ListarDomicilios.jsp").forward(request, response);  
                break;
            
            default:
        }
       request.getRequestDispatcher("Vistas/ListarDomicilios.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
