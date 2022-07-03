import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJDBC {
    public static void main(String[] args) {

        List<String>surnames = new ArrayList<>();

        try {
            //LOCAL
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","developer","123456");
            //REMOTE
            //Connection connection = DriverManager.getConnection("jdbc:mysql://dakkar01.altervista.org:3306/my_dakkar01/newdb","dakkar01","");
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("select * from students");
            System.out.println("Query for extract name and surname:");
                while (resultSet.next()){
                    surnames.add(resultSet.getString("last_name"));
                    System.out.println(resultSet.getString("first_name") + " - " +  resultSet.getString("last_name"));
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("-----------------------------------");
        System.out.println("All surname from arrayList:");
        System.out.println(surnames);


    }
}
