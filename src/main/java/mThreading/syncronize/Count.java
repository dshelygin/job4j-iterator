package mThreading.syncronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Count {
        @GuardedBy("this")
        private int value;

        synchronized void increment() {
            this.value++;
        }

        public synchronized  int get() {
            return this.value;
        }
}