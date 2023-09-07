package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Schritt 1: Filtert eine Liste von Zahlen und gebt nur die geraden Zahlen aus.
Schritt 2: Verwendet 'map' und verdoppelt jede Zahl in der Liste.
Schritt 3: Sortiert die Liste in aufsteigender Reihenfolge.
Schritt 4: Führt eine 'reduce'-Operation durch, um die Summe aller Zahlen in der Liste zu berechnen.
Schritt 5: Nutzt 'forEach' und gebt jede verarbeitete Zahl aus.
Schritt 6: Sammelt die verarbeiteten Zahlen in einer neuen Liste mit 'collect'.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("---- STREAMS ----");

        //List<Integer> myNumbers = List.of(3,6,9,12,2,4,6,8,10,3);
        List<Integer> myNumbers = List.of(2,1,3,6,5,4,7,10,8,9);
        System.out.println("Origin: "+myNumbers);

        List<Integer> evenNumbers = myNumbers.stream().filter(i -> i % 2 == 0).sorted().toList();
        System.out.println("Even numbers: " + evenNumbers);

        List<Integer> doubledNr = myNumbers.stream().map(i -> i * 2).toList();
        System.out.println("doubled numbers: " + doubledNr);

        List<Integer> sortedNr = myNumbers.stream().sorted().toList();
        System.out.println("Sorted: "+sortedNr);

        int mySum = myNumbers.stream().reduce(0, Integer::sum);
        myNumbers.forEach(System.out::println);
        System.out.println("--------\nSumme: "+mySum);

        List<Integer> zSummen = myNumbers.stream()
                .map(number -> {
                    int sumZ = myNumbers.subList(0, myNumbers.indexOf(number) + 1)
                            .stream()
                            .reduce(0, Integer::sum);
                    return sumZ;
                })
                .collect(Collectors.toList());

        System.out.println("--------\nZwischensummen: "+zSummen);
    }
}