import java.math.BigDecimal;

public class Upi {
    int UpiId;
    Account account;

    public Upi(Account account, int UpiId) {
        this.account = account;
        this.UpiId = UpiId;
    }

    public void transfer(BigDecimal amount, Upi destination ) throws  InsufficientBalanceException  {
        if(this == destination){
            System.out.println("Alert!! Cannot transfer to same account");
        }
        else{
            try {
                this.account.withdraw(amount);
                destination.account.deposit(amount);
            } catch (InsufficientBalanceException e) {
                throw new InsufficientBalanceException("Oops!! Insufficient Balance");
            }

        }
    }
    public int getUpiId() {
        return UpiId;
    }

    public void setUpiId(int upiId) {
        UpiId = upiId;
    }
}
