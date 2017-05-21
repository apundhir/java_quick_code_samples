Thread:
 
    - Single sequential flow of control within a program to perform a task.
    - Each Application has at least one thread called main.

Thread States:

    - New: Not yet started
    - Runnable: The thread is in runnable state after invocation of start() method, but the thread scheduler has not selected it to be the running thread.
    - Running: The thread is in running state if the thread scheduler has selected it.
    - Blocked: Waiting for resource or event to happen 
    - Terminated: dead state, can no longer execute
 
Thread priorities:

    - Integer value from 1 to 10
    - Higher value means high preference.
    - Child has priority at least same as parent.
    - Default priority is 5
    - Context Switch
    - CPU dependent
 
Thread Creation:

    - Extend Thread class
    - Implement Runnable interface
 
 ThreadGroup:
 
    Each thread belongs to a group.
 
 Synchronization:

    Race condition occure when multiple threads tries to accress same object and returns unexpected result.
    Can be avoided by synchronizing threads to access shared resources. 
 
