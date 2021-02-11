package com.anattoly.witchkeeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

class WitcherCoinAcceptor implements MoneyAcceptor {
    private static final String WITCHER_MAIN_PHRASE = "Witcher: \"- Toss a coin to your Witcher\"";
    private static final String WITCHER_CREDIT_PHRASE = "Witcher: \"- Are you trying to get a credit from The Witcher?\"";
    private static final String WITCHER_WAIT_PHRASE = "Witcher: \"- Ok. The Witcher will wait a few days (3 seconds pause)\"";
    private static final String WITCHER_EXCEPTION_PHRASE = "Witcher: \"- The Witcher also loves to talk, but he loves money more.\"";
    private static final String QUANTITY_DAYS_DEFERRED = "\n============3 DAYS LATER============";

    @Override
    public Long coinAccepting() {
        long moneyAmount = 0;
        BufferedReader readValue = new BufferedReader(new InputStreamReader(System.in));

        boolean correctValue = false;
        while (!correctValue)
            try {
                long inputValue = Long.parseLong(readValue.readLine());

                if (inputValue < 0) {
                    System.out.println(WITCHER_CREDIT_PHRASE + "\n" + WITCHER_MAIN_PHRASE);
                } else if (inputValue == 0) {
                    System.out.println(WITCHER_WAIT_PHRASE);
                    Thread.sleep(3000);
                    System.out.println(QUANTITY_DAYS_DEFERRED + "\n" + WITCHER_MAIN_PHRASE);
                } else {
                    moneyAmount = inputValue;
                    correctValue = true;
                }

            } catch (NumberFormatException | IOException e) {
                System.out.println(WITCHER_EXCEPTION_PHRASE + "\n" + WITCHER_MAIN_PHRASE);
                correctValue = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        try {
            readValue.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return moneyAmount;
    }

    @Override
    public Long amountParseToCoins(long amount, List<Integer> denominationsCoins) {
        long countCoin = 0;

        denominationsCoins.sort(Collections.reverseOrder());

        for (int i = 0; i < denominationsCoins.size() && amount > 0; i++) {
            countCoin += amount / denominationsCoins.get(i);
            amount = amount % denominationsCoins.get(i);
        }

        return countCoin;
    }

}


