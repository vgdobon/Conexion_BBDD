import java.sql.*;

public class Listado {
    public static void main(String[] args) {

        Connection cn = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Clase cargada correctamente");

        } catch (ClassNotFoundException e) {
            System.out.println("Error chungo" + e.toString());

        }


        try {
            cn = DriverManager.getConnection("jdbc:postgresql://192.168.56.2/geografia", "censo", "620312786");
            String consulta = "SELECT * FROM ccaa ORDER BY código";
            Statement sentencia = cn.createStatement();
            ResultSet registros = sentencia.executeQuery(consulta);

            while(registros.next()){
                String codigo = registros.getString("código");
                String nombre = registros.getString("nombre");
                System.out.println("codigo " +codigo);
                System.out.println("nombre " + nombre);
            }
            System.out.println("Conexion extablecida.");
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }



        System.out.println("PROGRAMA FINALIZADO");
    }
}
