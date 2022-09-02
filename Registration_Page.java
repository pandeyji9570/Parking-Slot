import java.util.*;
import java.sql.*;
import java.time.LocalTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class searching {
    static Scanner sc = new Scanner(System.in);
    static String area, s,exit;

    public static void parameter(String location, String ss) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Parking_Slot", "root", "12345678");

            String sql = "INSERT INTO user " + " (Area,Parking_area,Entry_Date,Entry_Time,Exit_Time) VALUES " + "(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, location);
            pstmt.setString(2, ss);
            pstmt.setString(3, date());
            pstmt.setString(4, time());
            pstmt.setString(5, exittime());
            pstmt.executeUpdate();

            System.out.println("\nBooking Date:- " + date());
            System.out.println("Time Of Booking:- " + time());
            System.out.println("Valid Till:- " + exit);
        }
        catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();

            } catch (SQLException se) {
                se.printStackTrace();

            }
        }
    }
    static String date () {
        LocalDateTime a = LocalDateTime.now();
        DateTimeFormatter b = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date1 = a.format(b);
//            System.out.println("Booking Date:- " + date1);
        return date1;
    }

    static String time () {
        LocalDateTime a = LocalDateTime.now();
        DateTimeFormatter c = DateTimeFormatter.ofPattern("hh-mm a");
        String time1 = a.format(c);
//            System.out.println("Time Of Booking:- " + time1);
        return time1;

    }
    static String exittime () {
        System.out.print("Enter Exit Time:- ");
        int n= sc.nextInt();
        int m =sc.nextInt();
        LocalTime a = LocalTime.of(n,m);
        DateTimeFormatter c = DateTimeFormatter.ofPattern("hh-mm a");
        exit = a.format(c);
        return exit;

    }
    //database connectivity part /////////

    public static void search (){
        System.out.println("Enter the area or location :- ");
        System.out.println("press 1 for mohali");
        System.out.println("press 2 for chandigrah");
        System.out.println("press 3 for rajpura");
        System.out.println("press 4 for patiala");

        int input1 = sc.nextInt();
        switch (input1) {
            case 1:
                area = "mohali";
                System.out.println("select your parking area name :- ");
                System.out.println("press 1 for IT park mohali");
                System.out.println("press 2 for sector 53 mohali");
                System.out.println("press 3 for Sector 24 mohali");
                System.out.println("press 4 for Sector 12 mohali");

                int parking_area = sc.nextInt();
                switch (parking_area) {
                    case 1:
                        System.out.println("you selected IT park mohali");
                        s = "IT park";
                        parameter(area, s);
                        break;
                    case 2:
                        System.out.println("you selected sector 53 mohali");
                        s = "sector 53";
                        parameter(area, s);
                        break;
                    case 3:
                        System.out.println("you selected Sector 24 mohali");
                        s = "Sector 24";
                        parameter(area, s);
                        break;
                    case 4:
                        System.out.println("you selected Sector 12 mohali");
                        s = "Sector 12";
                        parameter(area, s);
                        break;
                }
                break;
            case 2:
                area = "chandigrah";
                System.out.println("select your parking area name :- ");
                System.out.println("press 1 for sector 17C");
                System.out.println("press 2 for sector 34 A");
                System.out.println("press 3 for sector 17 D");
                System.out.println("press 4 for GMCH 32 ");
                int parking_area1 = sc.nextInt();
                switch (parking_area1) {
                    case 1:
                        System.out.println("you selected 17C");
                        s = "sector 17c";
                        parameter(area, s);
                        break;
                    case 2:
                        System.out.println("you selected sector 34A");
                        s = "sector 34A";
                        parameter(area, s);
                        break;
                    case 3:
                        System.out.println("you selected sector 17D");
                        s = "sector 17D";
                        parameter(area, s);
                        break;
                    case 4:
                        System.out.println("you selected GMCH 32");
                        s = "GMCH 32";
                        parameter(area, s);
                        break;
                }
                break;
            case 3:
                area = "Rajpura";
                System.out.println("select your parking area name :- ");
                System.out.println("press 1 for RTTC Bsnl parking");
                System.out.println("press 2 for railway parking");
                System.out.println("press 3 for chahal parking");
                System.out.println("press 4 for bypass parking ");
                int parking_area2 = sc.nextInt();
                switch (parking_area2) {
                    case 1:
                        System.out.println("you selected RTTC Bsnal parking");
                        s = "RTTC Bsnal parking";
                        parameter(area, s);
                        break;
                    case 2:
                        System.out.println("you selected sector railway parking");
                        s = "railway parking";
                        parameter(area, s);
                        break;
                    case 3:
                        System.out.println("you selected chahal parking");
                        s = "chahal parking";
                        parameter(area, s);
                        break;
                    case 4:
                        System.out.println("you selected bypass parking");
                        s = "bypass parking";
                        parameter(area, s);
                        break;
                }
                break;
            case 4:
                area = "patiala";
                System.out.println("select your parking area name :- ");
                System.out.println("press 1 for court parking");
                System.out.println("press 2 for Atam's car parking");
                System.out.println("press 3 for tagore parking");
                System.out.println("press 4 for Gurdwara parking ");

                int parking_area3 = sc.nextInt();
                switch (parking_area3) {
                    case 1:
                        System.out.println("you selected Court4 parking");
                        s = "court4";
                        parameter(area, s);
                        break;
                    case 2:
                        System.out.println("you selected Atam's car parking");
                        s = "Atam's parking";
                        parameter(area, s);
                        break;
                    case 3:
                        System.out.println("you selected tagore parking");
                        s = "tagore parking";
                        parameter(area, s);
                        break;
                    case 4:
                        System.out.println("you selected Gurdwara parking");
                        s = "Gurdwara parking";
                        parameter(area, s);
                        break;
                }
                break;
        }
    }
}


class Taking_Inputs
{
    static String vehicle_number,address,vehicle_type,first_name,last_name,password,mobileno;
    static long mobile_number;
    static Scanner input= new Scanner(System.in);
    public static void inputs()
    {
        System.out.println("\tRegistration Page");
        System.out.print("First Name - ");
        first_name= input.nextLine();          // Taking First Name

        System.out.print("Last Name - ");
        last_name= input.nextLine();           // Taking Last Name

        System.out.print("Address - ");
        address= input.nextLine();             // Taking Address

        System.out.print("Mobile Number - ");
        mobileno= input.nextLine();       // Taking Mobile Number
        mobile_number=Long.valueOf(mobileno);

        System.out.print("Vehicle Type (Two-Wheeler/Four-Wheeler) - ");
        vehicle_type= input.nextLine();        // Taking Vehicle Type

        System.out.print("Vehicle Number - ");
        vehicle_number= input.nextLine();      // Taking Vehicle Number

        System.out.print("Create Password - ");
        password= input.nextLine();

        System.out.println("\n\tYour Details");
        System.out.print("Your Name- " +first_name+ " " +last_name+
                "\nYour Address- " +address+
                "\nYour Mobile No: " +mobile_number+
                "\nVehicle Type- " +vehicle_type+
                "\nVehicle No: " +vehicle_number+
                "\nPassword: *********\n");
    }
}
public class Registration_Page extends connection
{
    static Scanner input= new Scanner(System.in);

    public static void main(String[] args)
    {
        Taking_Inputs repeat= new Taking_Inputs();
        repeat.inputs();

        searching object=new searching();

        Registration_Page obj = new Registration_Page();

        System.out.println("\nPress 1 To Confirm ");
        System.out.println("Press 2 To Edit Details ");
        System.out.println("Press 9 To Exit ");

        Integer choice=input.nextInt();
        switch (choice)
        {
            case 1:
                obj.sql(Taking_Inputs.first_name,Taking_Inputs.last_name,Taking_Inputs.address,Taking_Inputs.mobile_number,
                        Taking_Inputs.vehicle_type,Taking_Inputs.vehicle_number,Taking_Inputs.password);
                System.out.println("\tCongratulations Your Registration Is Done");

                System.out.println("\nPress 1 For Searching & Booking");
                System.out.println("Press 9 To Exit");
                Integer i=input.nextInt();
                switch (i)
                {
                    case 1:
                        object.search();
                        break;
                        case 9:
                            System.out.println("\tThank You For Using Our Service");
                            break;

                }
                break;
            case 2:
                repeat.inputs();
                obj.sql(Taking_Inputs.first_name,Taking_Inputs.last_name,Taking_Inputs.address,Taking_Inputs.mobile_number,
                        Taking_Inputs.vehicle_type,Taking_Inputs.vehicle_number,Taking_Inputs.password);
                System.out.println("\tCongratulations Your Registration Is Done");
                break;
            case 9:
                System.out.println("\tThank You For Using Our Service");
                break;
        }
    }
}