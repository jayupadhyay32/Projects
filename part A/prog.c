#include <stdio.h>
#include <unistd.h>
#include <dirent.h>

int main() {

char *directory = "/home/jay/Downloads";
struct dirent *de;
int ret;

ret = chdir(directory); /* This will change the directory */

if(ret==0) {  /* If the value is 0, then the change was succesful */
printf("Directory change was succesful, test_directory created under /home/jay/Downloads \n");
int dir = mkdir("/home/jay/Downloads/test_directory.txt", 0777); 
/* make a new directory */

/* Here we will list everything underneath /Downloads */

printf("*************** LISTING DIRECTORIES ****************** \n");

DIR *dr = opendir(".");

while((de = readdir(dr)) != NULL)
printf("%s\n", de->d_name);
closedir(dr);

printf("******************* LISTING COMPLETE ****************** \n");

}
else  { /* If the value returned is -1, or not 0, we know an error occured */

printf("An error has occured.\n");

}


return 0; /* close program */ 

}
