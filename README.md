# SpellCheck
Spellchecker using Trie tree and Binary search tree. Imports a text file called input.txt and writes suggested words into output.txt

1) bin stores all class files
2) src stores all source code
3) text is all the text files need.


Runtime Analysis:
The runtime of BST insert and find is O(N), where N is the height of the tree since the dictionary is sorted.
The runtime of Trie insert and find is O(N), where N is the length of the word.
Since both trees use the same suggestion runtime (which is O(N+M), N being string length and M being the total number of ascii letters), so that does not factor into runtime.
The runtime of Trie is significatnly faster as BST needs to travel down the whole tree, therefore Trie tree is the faster tree for spellchecking.
