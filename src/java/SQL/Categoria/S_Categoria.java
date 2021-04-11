package SQL.Categoria;

import Modelo.Categoria.M_Categoria;
import Modelo.Pelicula.M_Pelicula;
import SQL.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class S_Categoria extends Conexion {
    
    private Connection Con = null;
    private CallableStatement callSt = null;
    private ResultSet Res = null;
    String SQL;
    int r;
    
    M_Categoria mCate = new M_Categoria();
    
    public List listar() {
        Con = getConexion();
        callSt = null;
        Res = null;

        List<M_Categoria> lista = new ArrayList<>();
        try {
            SQL = "CALL spMostrarCategoria()";
            callSt = Con.prepareCall(SQL);
            Res = callSt.executeQuery();

            while (Res.next()) {
                mCate = new M_Categoria();
                mCate.setId(Res.getInt(1));
                mCate.setCategoria(Res.getString(2));
                lista.add(mCate);
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
}
