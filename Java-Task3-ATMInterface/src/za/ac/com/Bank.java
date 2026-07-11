/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.com;

/**
 *
 * @author User
 */
public class Bank {

    private Account account;

    public Bank() {

        account = new Account("1001", "1234", 5000);

    }

    public boolean login(String userId, String pin) {

        return account.getUserId().equals(userId)
                && account.getPin().equals(pin);

    }

    public Account getAccount() {
        return account;
    }

}
