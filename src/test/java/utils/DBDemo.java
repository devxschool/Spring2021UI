package utils;

import java.util.Arrays;

public class DBDemo {
    public static String dbPass;
    //Runtime arguments.
    //Runtime environmental variables


    //parameters? => add values to make method dynamic.
    //parameters => are input data for the function
    public static void main(String[] args) {
        System.out.println(ConfigReader.getProperty("dbank.db.username"));
        System.out.println(Arrays.toString(args));
        //Get program args
//        System.out.println(args[0]);
//        dbPass = args[0];



        //Get VM args(options)
       String pass =  System.getProperty("db.pass");
       System.out.println(pass);

       //I also make sure our team is meeting compliance  requirements. one of them is to make sure passwords
        //are not hard coded in the code or configuration files.
        //to overcome this I use VM Option for all passwords like db pass, api pass.
    }
    //program arguments can only be accesed within main method and they are index based
    //VM option can be accessed anywhere and key value based.

}
