# Lab2: CPU Scheduling Simulation

* Author: Dominik Huffield
* Class: CS 321

## Overview

This program is meant to simulate a CPUs processing via a priority 
queue. The queue uses a heap data structure that uses an array list 
to hold the processes. 

## Compiling and Using

Compile the program:
$ javac CPUScheduling.java

Run the program:
$ java CPUScheduling <maxProcessTime> <maxPriorityLevel> <timeToIncrementPriority> <simulationTime> <processArrivalRate> 

Integer Value: <maxProcessTime>,<maxPriorityLevel>,<timeToIncrementPriority>,<simulationTime>
Double from 0.0-1.0: <simulationTime>

maxProcessTime: largest possible time units required to finish a process. That is, any process arrived will require at least 1 time unit and at most maxPriorityLevel time units to finish.
maxPriorityLevel: highest possible priority in this simulation. That is, a process can have a priority, ranging from 1, 2, . . . , maxPriorityLevel.
timeToIncrementPriority: if a process didn’t get any CPU time for this timeToIncrementPriority time units, the process’s priority will be increased by one.
simulationTime: the total time units for the simulation.
processArrivalRate: using this rate to decide whether to generate a new process in each time unit.


## Discussion

This project was interesting it really helped me to understand how a priority queue works and gave me a better grasp of a heap structure. I struggled at first getting my types to work because 
I initially gave my heap an array list of type T but changed it to type process so that when I generated a new process my array list would hold the class as an object. I also began to build my 
priority queue wrong. The project asked that we store our priority in type T and use compareTo to compare the priorities however I began building my priority with the keys held separately as an
array of integers and had to rewrite the class. 


## Testing

Creating the new processes required random variables for the process. This made testing difficult but the professor gave us testing classes. These classes allowed me to compare my output to the 
correct output. This showed me if I wasn't adding processes or if aspects of my process or my queue was wrong so that I could fix them in my classes

