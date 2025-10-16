#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

void processA(int);
void processB(int);

void processA(int writefd)
{
    int len;
    char buff[80];
    printf("Enter a string: ");
    fgets(buff, 80, stdin);
    len = strlen(buff);
    if (buff[len - 1] == '\n')
    {
        len--;
    }
    write(writefd, buff, len);
}

void processB(int readfd)
{
    int n, i, j;
    char str[80], temp;
    n = read(readfd, str, 80);
    str[n] = '\0';
    i = 0;
    j = strlen(str) - 1;
    while (i < j)
    {
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        i++;
        j--;
    }
    printf("Reversed string: %s\n", str);
}

int main(void)
{
    int pipe1[2];
    pid_t childpid;
    pipe(pipe1);
    childpid = fork();
    if (childpid == 0)
    {
        close(pipe1[1]);
        processB(pipe1[0]);
    }
    else
    {
        close(pipe1[0]);
        processA(pipe1[1]);
    }
    return EXIT_SUCCESS;
}

/* OUTPUT:
Enter a string: Pooja
Reversed string: ajooP
*/

/* Compilation and Execution:
gcc ipcpipe.c
./a.out
*/
