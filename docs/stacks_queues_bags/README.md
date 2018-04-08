# Stacks

## Requirements & Assumptions
Given an *item*, provide a consistent interface to

* insert (i.e. push or enqueue)
* remove (i.e. pop or dequeue)


Typical applications include

* Undo mechanism in a text editor is accomplished by keeping all text changes in a stack
* Program fetches tasks to perform one by one from the queue. 


## Implementation


### [Linked Stack of Strings](../../src/main/java/com/rehmanz/stack/LinkedStackOfStrings.java)



**LinkedStackOfStrings Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `LinkedStackOfStrings()` | Initialize data structure | 1 |
| `void push(int item)` | Push an item on stack | 1 |
| `String pop(int item)` | Pop an item from stack | 1 |

LinkedStackOfStrings apprach
* maintains a Linked List structure
* each *push* and *pop* operation takes constant time
* extra space needed for maintaining the overhead (i.e. each Linked List object, the inner node class and the 
reference to next node)


### [Linked Stack of Strings](../../src/main/java/com/rehmanz/stack/ResizingArrayStackOfStrings.java)



**ResizingArrayStackOfStrings Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `ResizingArrayStackOfStrings()` | Initialize data structure | 1 |
| `void push(int item)` | Push an item on stack | N (Worst), 1 (Amortized) |
| `String pop(int item)` | Pop an item from stack | N (Worst), 1 (Amortized) |

ResizingArrayStackOfStrings approach
* maintains an array that automatically doubles when it reaches it's capacity
* shrinks to half when the array is quarter full
* Constant *push* and *pop* operation (i.e. Best case scenario) without the overhead of a Linked List
* Worst case when *push* reaches max array size or when the array is only quarter full 

