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
