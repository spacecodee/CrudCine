package Controlador.Pelicula;

import Modelo.Pelicula.M_ComboCategoria;
import Modelo.Pelicula.M_Pelicula;
import Modelo.Pelicula.M_RPelicula;
import SQL.Pelicula.S_Pelicula;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C_Pelicula extends HttpServlet {

    S_Pelicula sPelicula = new S_Pelicula();
    M_Pelicula mPelicula = new M_Pelicula();
    M_RPelicula mRPelicula = new M_RPelicula();

    String titulo, buscar;
    int idCategoria, id, duracion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menuPelicula");
        String accion = request.getParameter("accionPelicula");

        if (menu.equalsIgnoreCase("menu")) {
            switch (accion) {
                case "Listar":
                    List lista = sPelicula.listar();
                    ArrayList<M_ComboCategoria> mComboIn = sPelicula.mComboCate();
                    request.setAttribute("tablaPeli", lista);
                    request.setAttribute("comboCate", mComboIn);
                    break;

                case "Agregar":
                    titulo = request.getParameter("txtTitulo");
                    duracion = Integer.parseInt(request.getParameter("txtDuracion"));
                    idCategoria = Integer.parseInt(request.getParameter("inte"));

                    mRPelicula.setTitulo(titulo);
                    mRPelicula.setDuracion(duracion);
                    mRPelicula.setCategoria(idCategoria);
                    sPelicula.agregar(mRPelicula);
                    request.getRequestDispatcher("C_Pelicula?menuPelicula=menu&accionPelicula=Listar").forward(request, response);
                    break;

                case "Buscar":
                    buscar = request.getParameter("txtBuscar");

                    List list = sPelicula.listar(buscar);
                    ArrayList<M_ComboCategoria> mComboI = sPelicula.mComboCate();
                    request.setAttribute("tablaPeli", list);
                    request.setAttribute("comboCate", mComboI);

                    request.getRequestDispatcher("pelicula.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("pelicula.jsp").forward(request, response);
        }
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
