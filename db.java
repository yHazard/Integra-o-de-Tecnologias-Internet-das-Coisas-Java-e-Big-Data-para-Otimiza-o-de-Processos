import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "LM";
        String password = "CaoS$28";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO temperature_readings (temperature, timestamp) VALUES (?, NOW())";
            stmt = conn.prepareStatement(sql);
            
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
