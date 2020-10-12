package org.academiadecodigo.tailormoons.HotelSimulation;

public class Main {


    public static void main(String[] args) {
        Hotel pestana = new Hotel();
        String[] personNames = {"João", "Juliana", "Cássio", "Almeida", "Tiago", "Érica", "Giselle", "Carlos", "Vitor", "Hugo", "Edgar", "Dias", "Marco", "Pedro", "Luís", "Bruno", "João", "Juliana", "Cássio", "Almeida", "Tiago", "Érica", "Giselle", "Carlos", "Vitor", "Hugo", "Edgar", "Dias", "Marco", "Pedro", "Luís", "Bruno", "João", "Juliana", "Cássio", "Almeida", "Tiago", "Érica", "Giselle", "Carlos", "Vitor", "Hugo", "Edgar", "Dias", "Marco", "Pedro", "Luís", "Bruno", "João", "Juliana", "Cássio", "Almeida", "Tiago", "Érica", "Giselle", "Carlos", "Vitor", "Hugo", "Edgar", "Dias", "Marco", "Pedro", "Luís", "Bruno", "João", "Juliana", "Cássio", "Almeida", "Tiago", "Érica", "Giselle", "Carlos", "Vitor", "Hugo", "Edgar", "Dias", "Marco", "Pedro", "Luís", "Bruno", "João", "Juliana", "Cássio", "Almeida", "Tiago", "Érica", "Giselle", "Carlos", "Vitor", "Hugo", "Edgar", "Dias", "Marco", "Pedro", "Luís", "Bruno"};
        Person[] personArray = new Person[50];

        for(int i = 0; i<50; i++) {

            personArray[i] = new Person(personNames[i], pestana);
        }
        for(int i = 0; i<50; i++) {

            personArray[i].iWantToCheckIn();
        }
        Person teste = new Person("Coiso", pestana);
        teste.iWantToCheckIn();
      // Hotel pestana = new Hotel();
        Person test = new Person("Almeida", pestana);
        Person person1 = new Person("João", pestana);
        Person person2 = new Person("Juliana", pestana);
        Person person3 = new Person("Luís", pestana);
        Person person4 = new Person("Sidónio", pestana);



        person1.iWantToCheckIn();
        person2.iWantToCheckIn();
        person3.iWantToCheckIn();
        person4.iWantToCheckIn();
        System.out.println(person3.getRoomNumber());
        person3.iWantToCheckOut(person3.getRoomNumber());
        person3.iWantToCheckIn();

        /*
        System.out.println(person4.getCheckInStatus());

        person4.iWantToCheckOut(person4.getRoomNumber());
        person1.iWantToCheckOut(person1.getRoomNumber());
*/
pestana.displayRoomComposition();




    }
}
