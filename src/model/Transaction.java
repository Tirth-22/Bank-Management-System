package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
        private String type;
        private double amount;
        private LocalDateTime dateTime;

        public Transaction(String type, double amount) {
                this.type = type;
                this.amount = amount;
                this.dateTime = LocalDateTime.now();
        }

        @Override
        public String toString() {
                return type + " of ₹" + amount + " on " + dateTime;
        }
}
