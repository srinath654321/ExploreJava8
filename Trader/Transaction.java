package com.Trader;

import java.util.*;
import java.util.stream.Collectors;

public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {

        this.trader = trader;
        this.year = year;
        this.value = value;
    }


    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }


    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan  = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                 new Transaction(brian,2011,300),
                 new Transaction(raoul,2012,1000),
                 new Transaction(raoul,2011,400),
                 new Transaction(mario,2012,710),
                 new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );


       List<Integer> trasactionsIn2011 = transactionList.stream().filter(t->t.getYear()==2011).map(Transaction::getValue).sorted().collect(Collectors.toList());
       trasactionsIn2011.forEach(System.out::println);

       System.out.println("========================");

       Set<String> Uniquecities= transactionList.stream()
                                                  .map(T -> T.getTrader().getCity())
                                                  .collect(Collectors.toCollection(TreeSet::new));
       Uniquecities.forEach(System.out::println);

       System.out.println("================================");

       List<String> tradersByname= transactionList.stream()
                                                  .filter(T ->T.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                                                  .map(T ->T.getTrader().getName())
                                                  .distinct()
                                                  .sorted()
                                                  .collect(Collectors.toList());
        tradersByname.forEach(System.out::println);

        System.out.println("===================================");

        List<String> tradersnames= transactionList.stream().map(t->t.getTrader().getName()).distinct().sorted().collect(Collectors.toList());

        tradersnames.forEach(System.out::println);

        System.out.println("===============================");

        boolean isMilanTrader = transactionList.stream().anyMatch(T->T.getTrader().getCity().equalsIgnoreCase("Milan"));

        System.out.println(isMilanTrader);

        System.out.println("==============================");

        List<Integer> TrasactionValuesofCambridge = transactionList.stream().filter(T->T.getTrader().getCity().equalsIgnoreCase("cambridge"))
                                                                            .map(Transaction::getValue)
                                                                            .collect(Collectors.toList());

         TrasactionValuesofCambridge.forEach(System.out::println);


        System.out.println("===============================");

        OptionalInt maxvalue = transactionList.stream().mapToInt(T->T.getValue()).max();

        System.out.println(maxvalue.orElse(0));

        System.out.println("===============================");

        OptionalInt minValue = transactionList.stream().mapToInt(T->T.getValue()).min();

        System.out.println(minValue.orElse(0));

        System.out.println("===========================");

    }
}

