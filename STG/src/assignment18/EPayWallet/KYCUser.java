package assignment18.EPayWallet;

public class KYCUser extends User{
    private int rewardPoints;
    public KYCUser(int id,String username,String email,double walletBalance){
        super(id,username,email,walletBalance);
    }
    public int getRewardPoints() {
        return rewardPoints;
    }
    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
    @Override
    public boolean makePayment(double billAmount){
        boolean val = super.makePayment(billAmount);
        if(val){
            this.rewardPoints += (int)billAmount/10;
            return true;
        }
        return false;
    }
}
