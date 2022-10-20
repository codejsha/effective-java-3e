package org.example.demo.chapter6.item34;

import static effectivejava.chapter6.item34.PayrollDay.PayType.*;

// The strategy enum pattern (Page 166)
enum PayrollDay {
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY),
    THURSDAY(WEEKDAY), FRIDAY(WEEKDAY),
    SATURDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    public static void main(String[] args) {
        for (var day : values())
            System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    // The strategy enum type
    enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 :
                        (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        private static final int MINS_PER_SHIFT = 8 * 60;

        abstract int overtimePay(int mins, int payRate);

        int pay(int minsWorked, int payRate) {
            var basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}
