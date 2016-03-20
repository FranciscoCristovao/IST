#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>
#include <sys/wait.h>
#include "commandlinereader.h"
#include <pthread.h>
#include <semaphore.h>
#include "list.h"
#include "time.h"
#include <fcntl.h>
#include <readline/readline.h>
#include <readline/history.h>


int main(int argc, char** argv) {
	int fd;
	int fd2;
	char * line;
	char buffer[100];
	char statpipe[100];
	char statpipename[10];
	//const char *pipe_file = argv[1];

	if((fd = open(argv[1], O_WRONLY)) < 0) perror("Error on open");

	sprintf(buffer, "START %d\n", getpid());
	if(write(fd, buffer, 100) < 0) perror("Error on write");

	while(1) {
		line = readline("Command >> ");
		if(!strcmp(line, "exit"))
			break;
		else if(!strcmp(line, "stats")) {
			sprintf(buffer, "stats %d\n", getpid());
			if(write(fd, buffer, 100) < 0) perror("Error on write");
			sprintf(statpipename, "/tmp/%d", getpid());
			if((fd2 = open(statpipename, O_RDONLY)) < 0) perror("Error on open");
			if(read(fd2, statpipe, 100) < 0) perror("Error on read");
			printf("%s", statpipe);
			fflush(stdout);
		}
		else {
			if(write(fd, line, 100) < 0) perror("Error on write");
		}
	}

	sprintf(buffer, "STOP %d\n", getpid());
	if(write(fd, buffer, 100) < 0) perror("Error on write");

	return 0;
}
