# String-Pattern-Finder
This java program generates a random string of a given length and finds different special patterns in the string using Exception handling.
The program then prints the index of the highest ranking special pattern, based on a hierarchy system, to the user.

The requested length of the random string must be an integer in the legal range of 100 thousand (inclusive) to 1 billion (inclusive),
and the maximum length of the special patterns that the program looks for must be an integer in the legal range of 3 (inclusive) to 15 (inclusive).

Below is the pattern hierarchy:

I. Singleton string: A singleton string is made of only one letter. Examples: mmmmm, qqqqqqq, rr, s, yyy
II. Arithmetic String of Order 1: A string made of subsequent alphabetical letters that appear in the alphabetical order. Examples: bcdef, pqrstuvwx, jk, y
III. Arithmetic String of Order -1: A string made of subsequent alphabetical letters that appear in the reverse alphabetical order. Example: fedcb, xwvutsrqp, kj, y
IV. Balanced Tripartite String: A string made of three identical parts. Example: busbusbus, laptoplaptoplaptop, zzz
V. Balanced Bipartite String: A string made of two identical halves. Examples: ticktick, hophop, tantan, nocknock, nn
VI. Palindrome: A palindrome reads the same backward as forward. Examples: abcba, bob, g

The above list is ranked in the decreasing order of their rarity. If there are two interesting patterns of the same length in the 
random string, the program will report the more infrequent one.
For example, if a palindrome of length 9 (bobbobbob) and a balanced tripartitie of the same length (bobbobbob) are found, the program will report the latter one as it is
higher in the rank of special patterns.

As another example, consider the following random string:
yyyyyyyyycdefghijkl
In this string, there is a sinleton string of length 9 (yyyyyyyyy) and an arithmetic string of order 1 with length 10 (cdefghijkl).
The program reports the latter one as it is longer. When reporting the special pattern, the program specifies the actual pattern (cdefghijkl)
and the index of its occurrence (9)
