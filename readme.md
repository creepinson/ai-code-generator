This program continuously writes suedo-random classes. 
It compiles the classes when they are created.
If they did not compile, they are discarded.
If they did compile, they are added to a compiled pool.
Then the program starts over in the loop.
If there is atleast 1 item in the compiled loop, 
then there is a 50 percent chance that an existing "known-to-compile"
string is used, and random mutations are applied to it. The other 50
percent chance is that a completely new random class is attempted.
The result is compiled, and the loop continues.
Successful compilations are output to the out.txt file, only if they are the new
longest successful "known-to-compile" string.
