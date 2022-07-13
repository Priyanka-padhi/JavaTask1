import java.math.BigDecimal;

interface Bank {
    public void deposit( BigDecimal balance);
    public void withdraw( BigDecimal balance) throws  InsufficientBalanceException;


}
