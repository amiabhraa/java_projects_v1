
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class urlShortner {
    public static void main(String[] args){        //Main Method
        //Making the Scanner Object
        Scanner sc = new Scanner(System.in);
        //Making PrintStream Class
        PrintStream ps = System.out;

        //Making HashMap to trace Object User objects in pool
        HashMap<String,String> hm = new HashMap<String, String>();
        //putting a Predefined user with pass in Hashmap
        hm.put("abhra", "12345");

        ps.println("---------URL SHORTNER----------");

        //Asking for username in HashMap
        LoginCheck(hm,ps,sc);

    }
    /**
     * Authenticates a user by checking whether the username
     * exists in the user database.
     *
     * If the username exists, the login process begins.
     * Otherwise, the user is prompted to create an account.
     *
     * @param hm the map containing registered usernames and passwords
     * @param ps output stream used for displaying messages
     * @param sc scanner used to receive user input
     */
    public static String LoginCheck(HashMap hm,PrintStream ps, Scanner sc){
        ps.print("Enter Username: ");
        String usernamev1 = sc.nextLine();
         if(hm.containsKey(usernamev1)){
             userLogin(usernamev1,hm,sc,ps);
             ////////////////// // already username exists only password required
         }else{
             ps.println("Invalid username!");
             ps.print("Signup? (Y/N): ");
             String des1 = sc.next();
             if(des1.equalsIgnoreCase("Y")){
                 userSignup(hm,ps,sc);          /* Redirects to
                                                        userSignup */
             } else if(des1.equalsIgnoreCase("N")){
                 ps.print("user Authorisation Revoked!");    /* Authorization revoked
                                                                    logging out*/
             }
         }

        return "404 not found!";
    }

    public static String userLogin(String usernamev1,HashMap hm, Scanner sc, PrintStream ps){
        ps.print("Password: ");
        String pass_v1 = sc.next();
        if(!hm.get(usernamev1).equals(pass_v1)){
            ps.print("Invalid password!");
            ps.print("Signup instead..." + userSignup(hm,ps,sc));

        }else if(hm.get(usernamev1).equals(pass_v1)){
            ps.print("Welcome " + usernamev1 + "!");
        }
        else{
            ps.print("502 Bad gateway!");

        }
        ///////////////
        return null;
    }



    public static String userSignup(HashMap hm,PrintStream ps, Scanner sc){
        /**
         * This terminal is used for signup(method in class)
         * @param username tells about the signup username
         * @param pass tell about the password to get stored in Hashmap*/

        ps.println("---------SIGNUP TERMINAL----------");
        ps.println();

        //taking Username and password for hm.put
        ps.print("Username: ");
        String username_v2 = sc.next();
        ps.print("Password: ");
        String pass_v2 =sc.next();

        //putting username and password
        hm.put(username_v2,pass_v2);

        ps.print("Welcome, "+ username_v2 + "!");
        return null;
    }
}
