/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atminterface;

import za.ac.com.ATM;
import za.ac.com.Account;

/**
 *
 * @author User
 */
public class ATMInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Account account = new Account("user1", "1234", 1000);
        ATM atm = new ATM();
        atm.start();
    }
    
}
