package com.anattoly.witchkeeper;

import java.util.List;

interface MoneyAcceptor {

    Long coinAccepting();

    Long amountParseToCoins(long amount, List<Integer> denominationsCoins);

}
