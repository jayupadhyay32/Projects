#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int last_threadID;                    /* Global variable which is last_threadID */ 
int successes;                        /*       Counter for the function         */
int count = 1;

pthread_mutex_t lock;                /* Lock variable, so there is no data error from multi- threaded access */

void *function(void *threadid)        /* This is the function pthread_create() calls */
{
   
  int tid = (int)threadid;            /* parameter entered is the ID of the current pthread */
                                      /* Printing the current thread ID */ 
  
  
  pthread_mutex_lock(&lock);          /* Initialize lock here, since data changes will occur */

                                      /*This value should equal to 1, otherwise it is not sequential */
  int difference = tid-last_threadID; /*calculate the difference between current id and last_threadID*/
  
  if(difference != 1) {

             /* If value of difference is not 1, thread access sequence is not in order */ 
             printf("Whoops i am thread #%d, not my turn yet. Last ID was: %d \n",tid,last_threadID);
                                     /*function_counter = function_counter - 1;*/
                      }
  
  else {
  
  printf("%d - %d\n",difference,tid); /* output the difference, and the current ID */
  successes = successes++;
  last_threadID = tid;                /* set the value of last_threadID to the current ID */

  if(last_threadID == 5) {
count++;          
last_threadID = 0;               /* if we reach id #5 which is the maximum, reset to 0 */
if(count<51){
printf("#### Iteration %d ####\n", count);
} 
                         }
  
  if(successes >= 250) {
  printf("Finished. Total prints: %d \n", successes);
  exit(0);       /* Close program */
  pthread_exit(NULL); /* Exit the pthread */ 
  
                             }
  
       }
  pthread_mutex_unlock(&lock); /* unlock the access, data changes are complete */
  pthread_exit(NULL);          /* Close thread */

}


int main() {   /* Create 5 threads and give them labels */

printf(" #### Iteration 1 #### \n"); /* Print out the first iteration */

while(1){      /* Keep trying until 50 iterations of 5 consecutives occur */

pthread_t threads[5]; /* Array of 5 Threads */
last_threadID = 0;
successes = 0;
int rc;
int i;
int k;

while(successes != 250) { /* outer for loop to generate 50 thread attacks */

for(i = 0; i<5; i++){ /*Generate 5 threads, given values 1 through 5 */

rc = pthread_create(&threads[i], NULL, function, (void *)(i+1));

                    }/*for loop ends */

                    }/*outer for loop ends */

pthread_exit(NULL);
}
}






