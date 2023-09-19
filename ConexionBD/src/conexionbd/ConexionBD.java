package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConexionBD {
    Connection con;
    public ConexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/p2_14al","root","12345678");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }
    public static void main(String[] args) {
        ConexionBD cn=new ConexionBD();
        Statement st;
        ResultSet rs;
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from pago");
            while (rs.next()) {                
                System.out.println(rs.getInt("id_pago")+" " +rs.getString("descripcion")+" " +rs.getString("precio"));
            }
            cn.con.close();
        } catch (Exception e) {
        }
        
    }
    
}
