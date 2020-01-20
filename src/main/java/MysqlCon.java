import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MysqlCon {

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");

            Statement stmt=con.createStatement();

            //input values fromm user

            System.out.println("For Insert Enter 1");
            System.out.println("For Read Enter 2");

            Scanner in = new Scanner(System.in);

            int choice = in.nextInt();
            if(choice == 1) {
                //insert
                //String dummy = in.nextLine();
                System.out.print("Name of Employee: ");
                String name = in.nextLine();
                System.out.print("Salary of Employee: ");
                int salary = in.nextInt();
                System.out.print("Designation of Employee: ");
                String designation = in.nextLine();
                //String dummy1 = in.nextLine();


                String insertEmp1 = "insert into employee (name,salary,designation) values(?,?,?)";

                PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(insertEmp1,Statement.RETURN_GENERATED_KEYS);


            //    pstmt.setInt(1,emp_id);
                pstmt.setString(1, name);
                pstmt.setInt(2, salary);
                pstmt.setString(3, designation);

                int rowAffected = pstmt.executeUpdate();
                if (rowAffected==1)
                {
                    System.out.println("Row Affected...!!");
                }
            }
            else if (choice==2)
            {
                ResultSet rs=stmt.executeQuery("select * from employee");

                while(rs.next())

                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));

            }
            else
                System.out.println("Wrong Choice...!");

            con.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
