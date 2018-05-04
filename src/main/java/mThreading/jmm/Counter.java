package mThreading.jmm;

public class Counter {
        private Integer counter = 0;

        public void increase() {
            counter++;
        }

        public Integer getValue() {
            return counter;
        }
}
