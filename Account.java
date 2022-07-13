import java.math.BigDecimal;

public abstract class Account implements Bank {

    private String OwnerName;
    private  BigDecimal balance;
    private final Acc_Type acc_type;
    private BigDecimal minBal = new BigDecimal(0);
    private BigDecimal overDrafLimit = new BigDecimal(0);

    //Constructor
    public Account(String OwnerName, BigDecimal balance, Acc_Type acc_type,BigDecimal minBal) throws MinimumBalanceException{
        this.OwnerName =  OwnerName;
        this.acc_type = acc_type;
        this.minBal = minBal;
        try{
            if(balance.compareTo(this.minBal) >=0){
                this.balance = balance;
            }
            else{
                throw new MinimumBalanceException("Alert!! Minimum Balance is require.");
            }
        }
        catch(MinimumBalanceException e){
            //e.getMessage();
            throw new MinimumBalanceException("Alert!! Minimum Balance is require.");
        }
    }

    public void deposit(BigDecimal amount){
        balance = this.balance.add(amount);
    }
    public void withdraw(BigDecimal amount) throws InsufficientBalanceException{
        try{
            if(CheckBal(amount)){
                this.balance = this.balance.subtract(amount);
            }
            else{
                throw  new InsufficientBalanceException("Oops!! Insufficient Balance.");
            }
        }
        catch(InsufficientBalanceException e){
            e.getMessage();
            throw new InsufficientBalanceException("Oops!! Insufficient Balance.");
        }

    }
    public boolean CheckBal(BigDecimal amount){
   if(this.acc_type == Acc_Type.CURRENT_ACCOUNT){
       BigDecimal overDraft = overDrafLimit.multiply(this.balance);
       BigDecimal temp_bal = this.balance.add(overDraft);
       return temp_bal.compareTo(amount) >= 0;
   }
   else{
       return this.balance.compareTo(amount) >= 0;
   }
    }
    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setMinBal(BigDecimal minBal) {
        this.minBal = minBal;
    }

    public void setOverDrafLimit(BigDecimal overDrafLimit) {
        this.overDrafLimit = overDrafLimit;
    }

    public Acc_Type getAcc_type() {
        return acc_type;
    }
}
