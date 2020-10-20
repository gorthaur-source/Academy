package org.academiadecodigo.tailormoons.priorityqueue;
import org.academiadecodigo.tailormoons.priorityqueue.ToDoList.ToDo;

import java.util.Iterator;
import java.util.PriorityQueue;


    public class ToDoList implements Iterable<ToDo> {


        private final PriorityQueue<ToDo> toDoList;

        public ToDoList() {
           toDoList = new PriorityQueue<>();
        }

        public void add(Importance high, int priority, String descript) {
            toDoList.add(new ToDo(high, priority, descript));
        }

        public boolean isEmpty() {
            Iterator<ToDo> iterator = iterator();
            return !iterator.hasNext();
        }

        public ToDo remove() {
            return toDoList.poll();
        }

        @Override
        public Iterator<ToDo> iterator() {
            return toDoList.iterator();
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

         /*   if (importance != o.importance) {
                switch (importance) {
                    case LOW:
                        return 1;
                    case MEDIUM:
                       return o.importance == Importance.HIGH ? 1:-1;
                    case HIGH:
                        return -1;
                }
            }
                return this.priority > o.priority ? 1 : -1;
*/
            if (importance == o.importance) {
                return priority - o.priority;
            }
            return importance.compareTo(o.importance);
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

