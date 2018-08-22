## Scripting

### Clear the air, First

__Bash v/s Shell scripting, what is the difference ?__

Bash stands for "Bourne Again SHell", and is a replacement/improvement of the original Bourne shell (sh).
Shell scripting is for any shell that is there but bash is for bash shell only. 

Default scripting shell in Ubuntu is Dash,  
while the default interactive shell (what you get if you pull up a terminal) is Bash. So, Bourne again Shell is discussed in detail here.


---

### Introduction

Shell scripts should have clean layout & not containing unnecessary commands which will reduce the speed of commands.
Understandable & simple scripts are preferred. These are mainly used as Common Gateway Interface programs.

Take following commands for comparison `cat /tmp/myfile | grep "mystring"` which runs faster than `grep "mystring" /tmp/myfile`. Why ?

OS has to load up the /bin/grep executable, which is a reasonably small 75600 bytes, open a pipe in memory for the transfer, load and run
the /bin/cat executable, which is an even smaller 9528 bytes, attach it to the input of the pipe, and let it run.  

If this command were in a loop being run many times over, the saving of not locating and loading the cat executable,
setting up and releasing the pipe, makes difference when compared to first one.  



[Reference Link](https://www.shellscript.sh/philosophy.html)

---

### Commands

* __chmod basics:__ Files & Directories in Unix have access of r,w,x for user, group & others. Each permission can be set or unset.  

```
ls -lg filename, will give descriptive information about permissions.

The string of 10 characters on the left shows the mode.
The initial character ('-' in this case) indicates what type of file it is.
    A '-' indicates that the file is a plain file. The character 'd' means it is a directory.
Character 2-4, 5-7, 8-10 shows permission granted for user, group & others.
The second string shows the number of links that exist to the file.
The third string identifies the owner of the file.
The fourth string tells what group the owner of the file is in.
```
Basic discussion on changing permissions for chmod command: 

```
chmod X@Y file_a file_b file_c ...  
    where, X = u,g,o and a(all) || @ = +, - ||  Y = r, w, x

Note:
  * chmod +x is equal to chmod ugo+x
  * chmod 755 is equal to chmod u=rwx,go=rx
```

* __cat command:__

```
cat [OPTION] [FILE1] [FILE2]...
  display content of files
  [ | more, less] commands for displaying information related to a file. 
  [OPTION: -n] display all of lines
  [OPTION: -e] displays '$' sign if there is gap b/w paragraphs
  [OPTION: -T] displays '^I' sign if there is gap b/w tabs
  
cat > file2, creates new file & awaits input from user, press CTRL+D to exit out.
cat file > file1, Output redirection to another file & '>>' appending to given file.

cat < file1, is used as input & output is displayed in terminal.
```

* __cut command:__ command for cutting sections from each line of files. Cut parts of a line by byte(-b) position, character(-c), as some character might contain more than one byte and delimiter(-d).

```
echo 'baz' | cut -b 2, Output: a
echo 'baz' | cut -b 1-2, Output: ba
echo 'baz' | cut -b 1,3, Output: bz

cut -d ',' -f 1 names.csv  # -d specifies cut along with ',' and f is for conjunction specification. 
```

* __grep command:__ searches input files for lines containing a match to a given pattern list.

```
Basic Regex for grep:
  . means "any character".
  * means "any number of this".
  .* therefore means an arbitrary string of arbitrary length.
  ^ indicates the beginning of the string.
  $ indicates the end of the string.

cat dict/words | grep "Eng.*" # All words starting with Eng
cat dict/words | grep ".*ant?" # All words starting with ant
cat dict/words | grep "q."  | grep -v "qu" # All patterns which starts with q and doesn’t follow by u

Recursively search for a keyword and also get filename using -H (filename), -R (recursive), -i (case-insensitive) flag 
grep -HRi "json" * # seaches for keyword & also gives filename
```

* __Piping:__ send the output of one program to another program for further processing.

```
for i in {1..30}; do echo $i; done | cut -c 2 | sort | uniq
# this will print numbers from 0 to 9 in sorted manner after uniq's execution
```

* __Sort & Uniq command: __

```
Sorting alphabetically ( Flag -k used to select field for sorting)
cat words.txt | sort -k 2

Filer out unique lines
Select unique lines along with their count using -c (count) flag
cat nums.txt | uniq -c # also prints occurance of each value
```

* __Head, Tail and Tr command:__

```
head & tail: Head and tail are used to print n top or bottom lines respectively.

# Get lines from 345 to 360
cat dict/words | head -360 | tail -15 

# tr: Replacing or removing specific characters from the input.
cat data.csv | tr '[a-z][A-Z]' '[A-Z][a-z]'  # Reverse the case
cat data.csv | tr '[0-9]' 'x' # Replace digits with 'x' 
cat data.csv | tr -s '[0-9A-Za-z]' # Remove consecutive duplicate alphanumerics using -s (squash) flag
cat data.csv | tr -d '[0-9]' # Remove all digits using -d (delete) flag
```
