package com.anattoly.witchkeeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CoinKeeperApplication {
    private static final String TITLE = "===============START APPLICATION===============";
    private static final String WITCHER_MAIN_PHRASE = "\nWitcher: \"- Toss a coin to your Witcher\"";
    private static final List<Integer> DENOMINATIONS_COINS = new ArrayList<Integer>(Arrays.asList(5, 25, 1, 10));

    static void run() {
        System.out.println(TITLE);
        System.out.println(WITCHER_MAIN_PHRASE);

        MoneyAcceptor moneyAcceptor = new WitcherCoinAcceptor();
        Long money = moneyAcceptor.coinAccepting();
        Long countCoin = moneyAcceptor.amountParseToCoins(money, DENOMINATIONS_COINS);

        System.out.println("\nYou gave The Witcher " + countCoin + " coins");

    }
}
