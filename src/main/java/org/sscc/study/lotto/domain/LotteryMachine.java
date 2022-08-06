package org.sscc.study.lotto.domain;

import java.util.Set;

public class LotteryMachine {
    private static final int PRICE = 1000;
    private int number;
    private LotteryTickets lotteryTickets;
    private WinningStat winningStat;
    private final NumberStrategy numberStrategy = new RandomLottoNumberGenerator();

    public void pay(int money) {
        this.number = money / PRICE;
        lotteryTickets = new LotteryTickets();
        winningStat = new WinningStat();
    }

    public void drawNumbers() {
        for (int i = 0; i < number; i++) {
            lotteryTickets.addLotteryTicket(numberStrategy);
        }
    }

    public String getString() {
        return lotteryTickets.getString();
    }

    public int getNumber() {
        return number;
    }

    public WinningStat getStat(Set<LottoNumber> winningNumbers) {
        lotteryTickets.duplicateNumbers(winningNumbers).forEach(x -> winningStat.add(x));
        return winningStat;
    }
}
