package org.academiadecodigo.tailormoons.HotelSimulation;

public class Room {

    private boolean occupied = false;
    private int roomNumber; // not used in self generating iteration



    public boolean isOccupied() {

        return occupied;
    }

    public void setOccupied() {

        occupied = true;
    }

    public void setUnoccupied() {

        occupied = false;
    }

    public void setRoomNumber(int Index) { // not used in self generating iteration

        roomNumber = Index +1;
    }

}
