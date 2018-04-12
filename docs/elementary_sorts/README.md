# Elementary Sorts

*Elementary Sorts* rearranges *N* items into ascending order.

## Implementation


### [Selection Sort](../../src/main/java/com/rehmanz/sort/SelectionSort.java)


Given *N* items, for each iteration *i*
* find index *min* of smallest remaining entry
* swap *a[i]* and *a[min]*
* increment *i*

**SelectionSort Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `void sort(Comparable[] a)` | Sort the items array | N<sup>2</sup> |

Selection sort is **too expensive** as it takes *N<sup>2</sup>/2* compares and *N* exchanges