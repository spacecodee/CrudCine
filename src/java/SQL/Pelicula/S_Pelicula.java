package SQL.Pelicula;

import Modelo.Pelicula.M_ComboCategoria;
import Modelo.Pelicula.M_Pelicula;
import Modelo.Pelicula.M_RPelicula;
import SQL.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class S_Pelicula extends Conexion {

    private Connection Con = null;
    private CallableStatement callSt = null;
    private ResultSet Res = null;
    String SQL;
    int r;

    M_Pelicula mMPelicula = new M_Pelicula();
    M_ComboCategoria mComboCategoria = new M_ComboCategoria();

    public List listar() {
        Con = getConexion();
        callSt = null;
        Res = null;

        List<M_Pelicula> lista = new ArrayList<>();
        try {
            SQL = "CALL spMostrarPelicula()";
            callSt = Con.prepareCall(SQL);
            Res = callSt.executeQuery();

            while (Res.next()) {
                mMPelicula = new M_Pelicula();
                mMPelicula.setId(Res.getInt(1));
                mMPelicula.setTitulo(Res.getString(2));
                mMPelicula.setDuracion(Res.getInt(3));
                mMPelicula.setCategoria(Res.getString(4));
                lista.add(mMPelicula);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.toString());
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.toString());
            }
        }

        return lista;
    }

    public List listar(String txtBuscar) {
        Con = getConexion();
        callSt = null;
        Res = null;

        List<M_Pelicula> lista = new ArrayList<>();
        try {
            SQL = "CALL spBuscarPelicula(?)";
            callSt = Con.prepareCall(SQL);
            callSt.setString(1, txtBuscar);
            Res = callSt.executeQuery();

            while (Res.next()) {
                mMPelicula = new M_Pelicula();
                mMPelicula.setId(Res.getInt(1));
                mMPelicula.setTitulo(Res.getString(2));
                mMPelicula.setDuracion(Res.getInt(3));
                mMPelicula.setCategoria(Res.getString(4));
                lista.add(mMPelicula);
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.toString());
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.toString());
            }
        }

        return lista;
    }

    public ArrayList<M_ComboCategoria> mComboCate() {
        Con = getConexion();
        callSt = null;
        Res = null;

        ArrayList<M_ComboCategoria> mComboIn = new ArrayList<>();

        try {
            SQL = "CALL spComboCategoria()";
            callSt = Con.prepareCall(SQL);
            Res = callSt.executeQuery();
            mComboCategoria = new M_ComboCategoria();

            mComboCategoria.setId(0);
            mComboCategoria.setDescripcion("Selecciona");
            mComboIn.add(mComboCategoria);

            while (Res.next()) {
                mComboCategoria = new M_ComboCategoria();
                mComboCategoria.setId((Res.getInt(1)));
                mComboCategoria.setDescripcion(Res.getString(2));

                mComboIn.add(mComboCategoria);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return mComboIn;
    }
    
    public void agregar(M_RPelicula mRPelicula) {
        Con = getConexion();
        callSt = null;
        Res = null;
        SQL = "CALL spInsertarPelicula(?, ?, ?)";

        try {
            callSt = Con.prepareCall(SQL);
            callSt.setString(1, mRPelicula.getTitulo());
            callSt.setInt(2, mRPelicula.getDuracion());
            callSt.setInt(3, mRPelicula.getCategoria());
            callSt.executeQuery();

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                Con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
