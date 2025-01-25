## TASK 1 - ArrayList  

Write your own class `MyArrayList` as analog to the `ArrayList` class from Java Library.
You can use only 1 Array to store the data. 

Methods to realize:
 - **add(Object value)** - додає елемент в кінець
 - **remove(int index)** - видаляє елемент із вказаним індексом
 - **clear()** - очищає колекцію
 - **size()** - повертає розмір колекції
 - **get(int index)** - повертає елемент за індексом

## Завдання 2 - LinkedList
Write your own class `MyLinkedList` as analog to the `LinkedList` class.
You can't use Array. Every element must be a separate intermediary object (Node), that contains links to the previous and next element of collection ().

Methods to realize:
 - **add(Object value)** - додає елемент в кінець
 - **remove(int index)** - видаляє елемент із вказаним індексом
 - **clear()** - очищає колекцію
 - **size()** - повертає розмір колекції
 - **get(int index)** - повертає елемент за індексом

## Завдання 3 - Queue
Write your own class `MyQueue` as analog to the `Queue` class, that will work according to the FIFO principle (first-in-first-out).
You can use Nodes or Array.

Methods to realize:
 - **add(Object value)** - додає елемент в кінець
 - **clear()** - очищає колекцію
 - **size()** - повертає розмір колекції
 - **peek()** - повертає перший елемент з черги
 - **poll()** - повертає перший елемент з черги і видаляє його з колекції

## Завдання 4 - Stack
Write your own class `MyStack` as analog to the `Stack` class, that will work according to the LIFO principle (last-in-first-out).
You can use Nodes or Array.

Methods to realize:
 - **push(Object value)** - додає елемент в кінець
 - **remove(int index)** - видаляє елемент за індексом
 - **clear()** - очищає колекцію
 - **size()** - повертає розмір колекції
 - **peek()** - повертає перший елемент стеку
 - **pop()** - повертає перший елемент стеку та видаляє його з колекції

## Завдання 5 - HashMap
Write your own class `MyHashMap` as analog to the `HashMap` class.
Must be done using a single-connected Node.
Cannot store two Nodes with the same keys.

Methods to realize:
 - **put(Object key, Object value)** - додає пару ключ + значення
 - **remove(Object key)** - видаляє пару за ключем
 - **clear()** - очищає колекцію
 - **size()** - повертає розмір колекції
 - **get(Object key)** - повертає значення (Object value) за ключем