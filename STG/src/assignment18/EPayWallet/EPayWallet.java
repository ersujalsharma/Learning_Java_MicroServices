package assignment18.EPayWallet;

public class EPayWallet {
    public static void main(String[] args) {
        User user = new User(1001, "Jack", "jack@infy.com",1000);
        User kycuser = new KYCUser(201,"Jill","jill@infy.com",3000);
        processPayment(user, 700);
        processPayment(kycuser,1500);
        processPayment(kycuser,800);
        processPayment(kycuser,1200);
    }
    public static void processPayment(User user, double billAmount) {
        if (user.makePayment(billAmount)) {
            System.out.println("Congratulations "+user.getUsername()+", payment of "+billAmount+" was successful");
            System.out.println("Wallet balance: " + user.getWalletBalance());
            if(user instanceof KYCUser kycUser){
                System.out.println("Reward points: " + kycUser.getRewardPoints());
            }
        } else {
            System.out.println("Insufficient balance");
        }
        System.out.println("-------------------------------------------------");
    }
}
