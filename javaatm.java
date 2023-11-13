import javax.swing.*;
import java.awt.*;

class ATM {
    private double balance = 500;
    private int pin = 5674;

    public void checkPin(int enteredPin) {
        if (enteredPin == pin) {
            showMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect PIN. Please try again.");
        }
    }

    public void showMenu() {
        String[] options = { "Check Bank Balance", "Withdraw Money", "Deposit Money", "Exit" };
        int choice = JOptionPane.showOptionDialog(null, "Please select an option", "ATM Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                checkBalance();
                break;
            case 1:
                withdrawMoney();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Thank You");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice");
                break;
        }
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null, "Balance: ₹" + balance);
        showMenu();
    }

    public void withdrawMoney() {
        String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
        try {
            double amount = Double.parseDouble(amountStr);

            if (amount > balance) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
            } else {
                balance -= amount;
                JOptionPane.showMessageDialog(null, "Money withdrawn successfully");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
        showMenu();
    }

    public void depositMoney() {
        String amountStr = JOptionPane.showInputDialog("Enter the amount to deposit:");
        try {
            double amount = Double.parseDouble(amountStr);
            balance += amount;
            JOptionPane.showMessageDialog(null, "Money deposited successfully");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
        showMenu();
    }
}

public class javaatm {
    public static void main(String[] args) {
        ATM atm = new ATM();

        String pinStr = JOptionPane.showInputDialog("Enter the PIN:");
        try {
            int enteredPin = Integer.parseInt(pinStr);
            atm.checkPin(enteredPin);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid PIN.");
        }
    }
}
