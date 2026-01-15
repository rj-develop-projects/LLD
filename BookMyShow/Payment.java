package BookMyShow;

import BookMyShow.Enums.PaymentMode;
import BookMyShow.Enums.PaymentStatus;

public class Payment {
    private int id;
    private int bookingId;
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus status;

    public Payment(int bookingId, int amount, PaymentMode paymentMode, PaymentStatus status) {
        this.id = BookMyShow.generateId();
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.status = status;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public PaymentStatus getPaymentStatus() {
        return status;
    }

    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", bookingId=" + bookingId +
                ", amount=" + amount +
                ", paymentMode=" + paymentMode.toString() +
                ", status=" + status.toString() +
                '}';
    }
}
