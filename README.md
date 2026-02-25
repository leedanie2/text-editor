# CSC 207: Text Editor

**Author**: Daniel, Oscar

## Resources Used

+ _(TODO: fill me in)_
+ ...
+ ...

## Changelog

_(TODO: fill me in with a log of your committed changes)_

## Runtime Analysis of Insert()
1. The relevant input(s) to the method.
Relevant inputs is ch (the char to insert) and the cursor position in buffer, n. 

2. The critical operation(s).
Using substring to iterate through buffer until cursor, then insert ch, then iterate through rest of buffer.

3. A mathematical model of the runtime of insert as a function of the inputs and operations you chose.
substring + substring + concatenate = i + (n-i) + (n+1) = 2n + 1

The first substring copies i characters. The second substring copies (n-i) characters. Since strings are immutable, 
the final concatenation operation copies (n+1) characters. Adding all of those operations together, we get our model. 

4. A Big-O characterization of the model, i.e., “insert is O(…).”
insert is O(n).