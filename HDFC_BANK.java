import java.math.BigDecimal;

public class HDFC_BANK extends Account implements Bank {

    HDFC_BANK(String OwnerName, BigDecimal balance ,Acc_Type acc_type , BigDecimal minBal) throws MinimumBalanceException {
        super(OwnerName, balance , acc_type, minBal);
        super.setMinBal(BigDecimal.valueOf(3000));
       super.setOverDrafLimit(BigDecimal.valueOf(0.2));
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
        System.out.println(amount+ " Deposited to " +getOwnerName());
        System.out.println("Available amount is " +getBalance());
    }

    @Override
    public void withdraw(BigDecimal amount) throws InsufficientBalanceException  {
        try{
            super.withdraw(amount);
            System.out.println(amount+ " Withdraw from " +getOwnerName());
            System.out.println("Available amount is "+getBalance());
        }
        catch(InsufficientBalanceException e){
            e.getMessage();
            throw new InsufficientBalanceException("Oops!! Insufficient Balance!!");

        }
    }
}
