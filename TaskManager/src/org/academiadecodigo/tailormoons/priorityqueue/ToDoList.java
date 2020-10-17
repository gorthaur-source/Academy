package org.academiadecodigo.tailormoons.priorityqueue;
import org.academiadecodigo.tailormoons.priorityqueue.ToDoList.ToDo;

import java.util.PriorityQueue;


    public class ToDoList extends PriorityQueue<ToDo> {


        public void add(Importance high, int priority, String descript) {
            super.add(new ToDo(high, priority, descript));
        }

        static class ToDo implements Comparable<ToDo> {

            String string;
            Integer priority;
            final Importance importance;

        public ToDo(Importance importance, Integer priority, String string) {
            this.importance = importance;
            this.priority = priority;
            this.string = string;
        }

        @Override
        public int compareTo(ToDo o) {
            if (importance != o.importance) {
                switch (importance) {
                    case LOW:
                        return 100000;
                    case MEDIUM:
                        switch (o.importance) {
                            case HIGH:
                                return 100;
                            case LOW:
                                return -100;
                        }
                    case HIGH:
                        return -1000000;
                }
            }
                return this.priority > o.priority ? 1 : -1;

        }

        @Override
        public String toString() {
            return importance + " " + priority + " " + string;
        }
    }

    enum Importance {

        HIGH,
        MEDIUM,
        LOW
    }
}

