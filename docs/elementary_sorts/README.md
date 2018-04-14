# Elementary Sorts

*Elementary Sorts* rearranges *N* items into ascending order.


## [Selection Sort](../../src/main/java/com/rehmanz/sort/SelectionSort.java)


Given *N* items, for each iteration *i*
* find index *min* of smallest remaining entry
* swap *a[i]* and *a[min]*
* increment *i*

**SelectionSort Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `void sort(Comparable[] a)` | Sort the items array | N<sup>2</sup> |

Selection sort is **too expensive** as it takes *N<sup>2</sup>/2* compares and *N* exchanges


## [Insertion Sort](../../src/main/java/com/rehmanz/sort/InsertionSort.java)

Given *N* items, for each iteration *i*
* reset index *j* = *i*
* move index *j* from right to left while *j* > 0
* swap if *a[j]* > *a[j-1]*
* increment *i*

**SelectionSort Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `void sort(Comparable[] a)` | Sort the items array | N<sup>2</sup> |

Insertion sort is **too expensive** as it takes *N<sup>2</sup>/4* compares and *N<sup>2</sup>/4* exchanges on average.
However, insertion sort is linear for an items array that is mostly sorted (i.e. Best case scenario).


## [Shell Sort](../../src/main/java/com/rehmanz/sort/ShellSort.java)

Given *N* items
* move entries more than one position at a time by *h*-sorting the array


**SelectionSort Class**

| Operation | Description | Complexity |
| ----------| ----------- | ---------- |
| `void sort(Comparable[] a)` | Sort the items array | N<sup>3/2</sup> |

Shell sort can also be **expensive** as it takes *N<sup>3/2</sup>* for the worst case to sort the array. Useful for an
array that is already mostly sorted.