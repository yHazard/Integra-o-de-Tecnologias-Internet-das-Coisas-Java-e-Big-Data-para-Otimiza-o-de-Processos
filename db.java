import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            // Conectar ao banco de dados
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO temperature_readings (temperature, timestamp) VALUES (?, NOW())";
            stmt = conn.prepareStatement(sql);
            
            // Simular a inserção de dados
            double temperature = 25.5;
            stmt.setDouble(1, temperature);
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso: " + rowsAffected + " linha(s) afetada(s).");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
