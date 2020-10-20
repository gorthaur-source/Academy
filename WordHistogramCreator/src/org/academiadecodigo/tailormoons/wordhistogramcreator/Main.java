package org.academiadecodigo.tailormoons.wordhistogramcreator;

public class Main {

    public static void main(String[] args) {
        WordHistogramCreatorComposition histo = new WordHistogramCreatorComposition();

        histo.addToHash("As batatas sao as melhores batatas batatas. melhores!");

        histo.printStuff();

        WordHistogramCreatorInheritance histo1 = new WordHistogramCreatorInheritance();

        histo1.addToHash("As batatas sao as melhores batatas batatas. melhores!");
        histo1.addToHash("As batatas sao as melhores batatas batatas. melhores!");


        histo1.printStuff();

        }
    }

