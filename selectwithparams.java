import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectwithparams {

    private Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/newdb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void getMovieWithActor(String leadactor){
               String sql = "SELECT id,moviename,leadactor,actress,yearofrelease,directorname "
                          + "FROM Movies WHERE leadactor == ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            pstmt.setString(1,leadactor);
            ResultSet rs  = pstmt.executeQuery();
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("moviename") + "\t" +
                                   rs.getString("leadactor")+"\t" +
                                    rs.getString("actress")+ "\t" +
                                   rs.getInt("yearofrelease")+ "\t" +
                                   rs.getString("directorname") );
}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
  
    public static void main(String[] args) {
        selectwithparams app = new selectwithparams();

        app.getMovieWithActor("Vikram");
    }

}