package ru.netology.comparison;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    @Test
    public void shouldCompareTicketByPrice() {
        Ticket ticket1 = new Ticket("Казань", "Москва", 3000, 9, 10);
        Ticket ticket2 = new Ticket("Москва", "Стамбул", 20000, 9, 13);

        int expected = -1;
        int actual =  ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketByPrice() {
        Ticket ticket1 = new Ticket("Казань", "Москва", 3000, 9, 10);
        Ticket ticket2 = new Ticket("Москва", "Стамбул", 20000, 9, 13);
        Ticket ticket3 = new Ticket("Казань", "Новосибирск", 9000, 19, 24);
        Ticket ticket4 = new Ticket("Нью-Йорк", "Москва", 150000, 1, 14);
        Ticket ticket5 = new Ticket("Стамбул", "Казань", 23000, 8, 13);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket1, ticket3, ticket2, ticket5, ticket4};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchAndSortTicketByPrice() {
        Ticket ticket1 = new Ticket("Казань", "Москва", 3000, 9, 10);
        Ticket ticket2 = new Ticket("Москва", "Стамбул", 20000, 9, 13);
        Ticket ticket3 = new Ticket("Казань", "Москва", 1000, 19, 24);
        Ticket ticket4 = new Ticket("Казань", "Москва", 150000, 1, 14);
        Ticket ticket5 = new Ticket("Стамбул", "Казань", 23000, 8, 13);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket3, ticket1, ticket4};
        Ticket[] actual = aviaSouls.search("Казань", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareTicketByFlightTime() {
        Ticket ticket1 = new Ticket("Казань", "Москва", 3000, 9, 10);
        Ticket ticket2 = new Ticket("Москва", "Стамбул", 20000, 9, 13);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = -1;
        int actual =  timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketByFlightTime() {
        Ticket ticket1 = new Ticket("Казань", "Москва", 3000, 9, 14);
        Ticket ticket2 = new Ticket("Москва", "Стамбул", 20000, 9, 13);
        Ticket ticket3 = new Ticket("Казань", "Новосибирск", 9000, 4, 7);
        Ticket ticket4 = new Ticket("Нью-Йорк", "Москва", 150000, 1, 3);
        Ticket ticket5 = new Ticket("Стамбул", "Казань", 23000, 8, 9);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket5, ticket4, ticket3, ticket2, ticket1};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchAndSortTicketByFlightTime() {
        Ticket ticket1 = new Ticket("Казань", "Москва", 3000, 9, 14);
        Ticket ticket2 = new Ticket("Москва", "Стамбул", 20000, 9, 13);
        Ticket ticket3 = new Ticket("Казань", "Москва", 1000, 1, 24);
        Ticket ticket4 = new Ticket("Казань", "Москва", 150000, 12, 14);
        Ticket ticket5 = new Ticket("Стамбул", "Казань", 23000, 8, 13);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket4, ticket1, ticket3};
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] actual = aviaSouls.searchAndSortBy("Казань", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
