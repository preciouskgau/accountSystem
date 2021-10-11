package za.ac.nwu.ac.domain.persistence;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="ACCOUNT_TRANSACTION",schema="PRESH")
public class AccountTransaction implements Serializable
{
    private static final long serialVersionUID = -3558425166672454092L;

    private Long transactionId;
    private AccountType accountType;
    private Long amount;
    private Long memberId;
    private LocalDate transactionDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionId,AccountType accountType, Long amount, Long memberId, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.amount = amount;
        this.memberId = memberId;
        this.transactionDate = transactionDate;
    }


    @Id
    @SequenceGenerator(name = "PRESHSHABA", sequenceName ="PRESH/PRESHSHABA",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESHSHABA")

    @Column(name = "TX_ID")
    public Long getTransactionId() {
        return transactionId;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(amount, that.amount) && Objects.equals(memberId, that.memberId) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, amount, memberId, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountType=" + accountType +
                ", amount=" + amount +
                ", memberId=" + memberId +
                ", transactionDate=" + transactionDate +
                '}';
    }
}











