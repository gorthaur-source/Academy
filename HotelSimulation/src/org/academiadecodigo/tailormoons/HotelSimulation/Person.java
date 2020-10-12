package org.academiadecodigo.tailormoons.HotelSimulation;

public class Person {

    private final String name;
    private Hotel hotel;
    private int roomNumber = -1;


    public Person(String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;

    }

    public void iWantToCheckIn() {

       if(roomNumber >= 0) {

           System.out.println("I'm already checked in");
           return;
       }
       roomNumber = hotel.checkIn(getName());
    }

    public void iWantToCheckOut(int roomNumber) {

        hotel.checkOut(roomNumber, getName());
        this.roomNumber = -1;
    }


    public String getName() {

        return name;
    }

    public int getRoomNumber() {

        return roomNumber;
    }

}
