//import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

public class Main {
    private static final  String USERNAME = "root";
    private static final  String PASSWORD = "1234";
    private static final  String URL = "jdbc:mysql://localhost:3306/hospital"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";

    public static void main(String[] args) throws SQLException {
        DBProcessor dbProcessor = new DBProcessor();
        Connection connection = dbProcessor.getConnection(URL, USERNAME, PASSWORD);
        String query = "select * from hospital.doctors";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){ // пока таблица не закончилась
            int id = resultSet.getInt("iddoc");
            String fn = resultSet.getString("first_name");
            String ln = resultSet.getString("last_name");
            String speciality = resultSet.getString("speciality");
            int cabinet = resultSet.getInt("cabinet");
            String phone_number = resultSet.getString("phone_number");
            Doctor doctor = new Doctor(id, fn, ln, speciality,cabinet,phone_number);
            System.out.println(doctor);
        }
        statement.close();
        connection.close();
    }
}
