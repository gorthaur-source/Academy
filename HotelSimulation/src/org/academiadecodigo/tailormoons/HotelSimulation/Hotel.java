package org.academiadecodigo.tailormoons.HotelSimulation;

import java.util.Arrays;

public class Hotel {


    private int numberOfRooms = 3;
    private Room[] rooms = new Room[numberOfRooms];
    private Room[] temp = new Room[numberOfRooms*2];
    public Hotel() {

      /*  for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room();
            rooms[i].setRoomNumber(i); // self generating hotel rooms
        } */
    }

    public int checkIn(String name) {
            for (int i = 0; i < rooms.length; i++) {

                if (rooms[i] == null) {

                    rooms[i] = new Room();
                    rooms[i].setOccupied();
                    System.out.println(("Greetings " + name + ". Your room is room number " + (i + 1) + " sir."));
                    return i;

                } else if (!rooms[i].isOccupied()) {

                    rooms[i].setOccupied();
                    System.out.println(("Greetings " + name + ". Your room is room number " + (i + 1) + " sir."));
                    return i;
                }
            }

            for(int i = 0; i < rooms.length; i++) {
                temp[i] = rooms[i]; }

        for (int i = rooms.length; i < temp.length; i++) {

            if (temp[i] == null) {

                temp[i] = new Room();
                temp[i].setOccupied();
                numberOfRooms = temp.length;
                rooms = temp;
                temp = new Room[numberOfRooms * 2];
                System.out.println(("Greetings " + name + ". Your room is room number " + (i + 1) + " sir."));
                return i;

            }
        }
        // will never come to this in self generating iteration
        System.out.println("I'm sorry sir, there is no space.");
        return -1;
    }

    public void checkOut(int roomNumber, String name) {

        if (roomNumber < 0) { // band aid

            System.out.println("Sir, you haven't checked in.");
            return;
        }
        rooms[roomNumber].setUnoccupied();
        System.out.println(("Thank you for your business " + name + ". Come again!"));
    }

    void displayRoomComposition() {

        for (Room value : rooms) {
            System.out.println(value.isOccupied());
                }

            }
        }


