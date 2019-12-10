


# SpellCheck by Dennis Dang
Spellchecker using Trie tree and Binary search tree. Imports a text file called input.txt and writes suggested words into output.txt

1) bin stores all class files
2) src stores all source code
3) text is all the text files need.

# HOW TO USE:
- Make sure all files are in the same directory or else the text files will not be found. This is for the input.txt, storage.txt, and english.o files
- Change the storage.txt file is change to the right data structure you wish to use
- Compile and run the code as " java CS245A1 (input file) (output file).
- Input file must be line by line.


# Runtime Analysis:
The runtime of BST insert and find is O(N), where N is the height of the tree since the dictionary is sorted.
The runtime of Trie insert and find is O(N), where N is the length of the word.
Since both trees use the same suggestion runtime (which is O(N^2 + (N*M)), N being string length and M being the total number of ascii letters), so that does not factor into different runtimes between the two data structures.
The runtime of Trie is significatnly faster because BST needs to travel down the whole tree rather than a word's length.
Therefore Trie tree is the data structure for spellchecking.


# TODO
- Implement a BETTER SPELL CHECK using Levenshtein distance! \
- Implement a hashtable to store most used words \
- Start autocorrecting words in terminal as they go. Live Suggestions \
- Reading the dictionary directly off github 
