# Stacks

## Requirements & Assumptions
Given an *item*, provide a consistent interface to

* insert (i.e. push)
* remove (i.e. pop)


Typical applications include

* "undo" mechanism is accomplished in a text editor for keeping all text changes in a stack


## Implementation


### [Linked Stack of Generics](../../src/main/java/com/rehmanz/stack/LinkedStackOfGenerics.java)



**LinkedStackOfGenerics Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `LinkedStackOfGenerics()` | Initialize data structure | 1 |
| `void push(Item item)` | Push an item on stack | 1 |
| `Item pop(Item item)` | Pop an item from stack | 1 |

LinkedStackOfGenerics apprach
* maintains a Linked List structure
* each *push* and *pop* operation takes constant time
* extra space needed for maintaining the overhead (i.e. each Linked List object, the inner node class and the 
reference to next node)


### [Linked Stack of Generics](../../src/main/java/com/rehmanz/stack/ResizingArrayStackOfGenerics.java)



**ResizingArrayStackOfGenerics Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `ResizingArrayStackOfGenerics()` | Initialize data structure | 1 |
| `void push(Item item)` | Push an item on stack | N (Worst), 1 (Amortized) |
| `Item pop(Item item)` | Pop an item from stack | N (Worst), 1 (Amortized) |

ResizingArrayStackOfGenerics approach
* maintains an array that automatically doubles when it reaches it's capacity
* shrinks to half when the array is quarter full
* Constant *push* and *pop* operation (i.e. Best case scenario) without the overhead of a Linked List
* Worst case when *push* reaches max array size or when the array is only quarter full 


# Queues

## Requirements & Assumptions
Given an *item*, provide a consistent interface to

* insert (i.e. enqueue)
* remove (i.e. dequeue)


Typical applications include

* *Requestors* submits their tasks in the queue while *Executor* services the requests using First-In-First-Out (FIFO)
strategy

**LinkedQueueOfGenerics Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `LinkedQueueOfGenerics()` | Initialize data structure | 1 |
| `void enqueue(Item item)` | Insert a new item onto queue | 1 |
| `Item dequeue(Item item)` | Remove and return the item least recently added | 1 |
| `boolean isEmpty()` | Is the queue empty? | 1 |

LinkedQueueOfGenerics approach
* maintains a linked list to dynamically add and remove items from the queue
* each *enqueue* and *dequeue* operation takes constant time
* extra space needed for maintaining the overhead (i.e. each Linked List object, the inner node class and the 
reference to next node)