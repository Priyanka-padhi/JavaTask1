import java.math.BigDecimal;

public class Bank_Demo_Main {
    public static void main(String[] args) throws InsufficientBalanceException, MinimumBalanceException {

        HDFC_BANK hdfc = new HDFC_BANK("priya", BigDecimal.valueOf(3500),Acc_Type.CURRENT_ACCOUNT,BigDecimal.valueOf(500));
        ICICI_BANK icici = new ICICI_BANK("neelam",BigDecimal.valueOf(5500),Acc_Type.SAVING,BigDecimal.valueOf(300));
        Upi priya = new Upi(hdfc,12574);
        Upi neelam = new Upi(icici,22574);

        priya.transfer(BigDecimal.valueOf(1000),neelam);


    }
}
