/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Gloriana
 */
public class PoolConexionMySql {

    MysqlDataSource ds_con;
//     MysqlConnectionPoolDataSource ds_con;
    public PoolConexionMySql() {
        //ds_con = new MariaDbPoolDataSource("jdbc:mariadb://172.16.252.11:3306/matriculainveniouniversidad2?user=usr_sist_mat&password=$invenio2k17$&maxPoolSize=10");
        ds_con = new MysqlConnectionPoolDataSource();
        //ds_con = new MariaDbPoolDataSource();
        ds_con.setServerName("localhost");
        ds_con.setPort(3306);
        ds_con.setDatabaseName("examen");
        ds_con.setUser("root");
        ds_con.setPassword("root");

    }

    PoolConexionMySql(int servidor) {
        try {
            ds_con = new MysqlConnectionPoolDataSource();
            switch (servidor) {
               case 1:
                    //ds_con.setServerName("201.203.230.249");
                    //Solo Invenio
                    ds_con.setServerName("localhost");
                    ds_con.setPort(3306);
                    ds_con.setLoginTimeout(20);
                    ds_con.setDatabaseName("examen");
                    ds_con.setUser("root");
                    ds_con.setPassword("root");
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            System.out.println("Unica conexión establecida");
        } catch (SQLException ex) {
            Logger.getLogger(PoolConexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        try {
            return ds_con.getConnection();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Se perdio la conexión con el servidor :(", "Conexion al servidor", JOptionPane.ERROR_MESSAGE);
            System.err.println(ex);
        }
        return null;
    }
}
