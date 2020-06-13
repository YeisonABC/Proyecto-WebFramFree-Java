package Dao;

import Dto.productosDTO;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import modelo.conexion;

public class productoDAO extends conexion {

    public ArrayList<productosDTO> listaProducto() {
        conexion miConexion = new conexion();
        ArrayList<productosDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM productos";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                productosDTO productos = new productosDTO();
                productos.setCodigoProducto(rs.getInt(1));
                productos.setCodigoEstante(rs.getInt(2));
                productos.setNombreProducto(rs.getString(3));
                productos.setTipoProduccion(rs.getString(4));
                productos.setDescripcionProducto(rs.getString(5));
                productos.setFoto(rs.getBinaryStream(6));
                productos.setCantidadExisteneProducto(rs.getDouble(7));
                productos.setPrecioProducto(rs.getInt(8));
                productos.setUnidadMedidaProduccion(rs.getString(9));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaProducto DAO" + ex);
        }
        return miLista;
    }

    //consulta de los nombres de los campos de la tabla productos
    public String nombreTablas() throws SQLException {
        String nombresTablas = null;
        try {
            this.conectandoBBDD();
            DatabaseMetaData Mt = this.miConexion.getMetaData();
            ResultSet rs = Mt.getColumns(null, null, "productos", null);
            while (rs.next()) {
                nombresTablas = rs.getString("COLUMN_NAME");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en nombres tablas productosDAO " + ex);
        }
        return nombresTablas;

    }

    public void listarImg(int id, HttpServletResponse response) throws ClassNotFoundException { //Metodo en DAOproducto
        conectandoBBDD();
        InputStream inputStream = null;
        OutputStream outputStram = null;
        BufferedInputStream bufferedInputStram = null;
        BufferedOutputStream bufferedOutputStream = null;
        String sql = "select * from productos where Id_Productos =" + id;
        try {
            outputStram = response.getOutputStream();
            ps = miConexion.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStram = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStram);
            int i = 0;
            while ((i = bufferedInputStram.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (IOException | SQLException e) {
            System.out.println("Error al mostrar img " + e);
        }
    }

    public productosDTO listaId(int id) throws ClassNotFoundException {//metodo en el productoDAO
        conectandoBBDD();
        String sql = "select * from productos where  id_Productos= " + id;
        productosDTO productos = new productosDTO();
        try {
            ps = miConexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                productos.setCodigoProducto(rs.getInt(1));
                productos.setCodigoEstante(rs.getInt(2));
                productos.setNombreProducto(rs.getString(3));
                productos.setTipoProduccion(rs.getString(4));
                productos.setDescripcionProducto(rs.getString(5));
                productos.setFoto(rs.getBinaryStream(6));
                productos.setCantidadExisteneProducto(rs.getDouble(7));
                productos.setPrecioProducto(rs.getInt(8));
                productos.setUnidadMedidaProduccion(rs.getString(9));

            }
        } catch (SQLException e) {
            System.out.println("Error en producto DAO lista Id" + e);
        }
        return productos;
    }

    public int insertProducto(int codigoEstante, String nombre, String tipo, String descripcion, InputStream foto,  int precioInicial, String unidadMedida) {
        int insert = 1;
        try {
            this.conectandoBBDD();
            if (insert == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO productos (Id_Estante, Nombre, Tipo, Descripcion, foto, Precio, UnidadMedida)"
                        + "VALUES (?,?,?,?,?,?,?)");
                st.setInt(1, codigoEstante);
                st.setString(2, nombre);
                st.setString(3, tipo);
                st.setString(4, descripcion);
                st.setBinaryStream(5, foto);
                st.setInt(6, precioInicial);
                st.setString(7, unidadMedida);
                insert = st.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return insert;
    }

    public int updateProducto(int codigoProducto, String nombre, int precioInicial, String unidadMedida, int cantidad, String descripcion, String tipo) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE productos SET  Nombre=?, Tipo=?, Descripcion=?, CantidadExistente=?, precio=?, UnidadMedida=?  WHERE Id_Productos = '" + codigoProducto + "'");
                st.setString(1, nombre);
                st.setString(2, tipo);
                st.setString(3, descripcion);
                st.setInt(4, cantidad);
                st.setInt(5, precioInicial);
                st.setString(6, unidadMedida);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error updateProducto DAO " + e);
        }
        return update;
    }

    public int updateProductoSinProduccion(int codigoProducto, int codigoEstante, String nombre, int precioInicial, String unidadMedida) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE productos SET Id_Estante=?, Nombre=?, Precio_Inicial=?, Unidad_Medida=? WHERE Id_Productos = '" + codigoProducto + "'");
                st.setInt(1, codigoEstante);
                st.setString(2, nombre);
                st.setInt(3, precioInicial);
                st.setString(4, unidadMedida);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return update;
    }

    public ResultSet borrandoitemsCarrito(int id) throws ClassNotFoundException {
        this.conectandoBBDD();
        try {
            String sql = "select * from productos where id_Productos =" + id;
            st = miConexion.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("metodo borrandoitemsCarrito " + ex);

        }
        return rs;
    }

}
