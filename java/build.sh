#! /bin/bash
cd "$(dirname "$0")"
mkdir -p bin
javac -d bin fibonacci/FibonacciSequence.java
java -classpath bin fibonacci.FibonacciSequence 1
java -classpath bin fibonacci.FibonacciSequence 2
java -classpath bin fibonacci.FibonacciSequence 6
