#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define NO_WINNER 0
#define T_WINS 1
#define H_WINS 2
#define TIE 3

#define FINISH_LINE 70

void start_race();
int who_won(int t_loc, int h_loc);
void gen_t_move(int *num_spaces);
void gen_h_move(int *num_spaces);
void move_animal(int *a_loc, int num_spaces);
void print_race(int t_loc, int h_loc);
int printOuch(int loc);
void declare_winner(int winner);


/* The main function will run the fabled race between the tortoise and
 * the hare.  The amount that the tortoise and hare move at each tick
 * of the clock will be determined by a random number generator. */
int main()
{
   int t_loc = 1, h_loc = 1;
   int winner = NO_WINNER;
   int num_spaces;

   /* seed the random number generator */
   srand(time(NULL));

   /* Start the race */
   start_race();

   /* Run the race.  This entire loop could be its own function as well. */
   do {
      /* Each time through the loop, the tortoise and hare need to move */
      /* First, generate how many spaces the tortoise gets to move,
       * then move him */
      gen_t_move(&num_spaces);
      move_animal(&t_loc, num_spaces);
      
      /* Then, generate how many spaces the hare gets to move,
       * then move him */
      gen_h_move(&num_spaces);
      move_animal(&h_loc, num_spaces);

      print_race(t_loc, h_loc);


   } while ( (winner = who_won(t_loc, h_loc)) == NO_WINNER );
   
   /* Declare the winner */
   declare_winner(winner);

   return 0;
}

/* start the race by shooting a gun and having the announcer speak */
void start_race()
{
   printf("BANG !!!!!\n");
   printf("AND THEY'RE OFF !!!!!\n");
}

/* who_won() determines who, if anyone, won the race */
int who_won(int t_loc, int h_loc)
{
   /* Determine who is at or past the finish line */
   if (t_loc >= FINISH_LINE && h_loc >= FINISH_LINE)
      return TIE;
   else if (t_loc >= FINISH_LINE)
      return T_WINS;
   else if (h_loc >= FINISH_LINE)
      return H_WINS;
   else
      return NO_WINNER;
}

/* gen_t_move() uses a random number generator to move the tortoise as follows:
 * - generate a random number between 1 and 10
 * rand #  : spaces moved
 * 1-5: 3 squares forward (fast plod)
 * 6-7: 6 squares backward (slip)
 * 8-10: 1 square forward (slow plod)
 */
void gen_t_move(int *num_spaces)
{
   int rand_n = rand() % 10 + 1;

   if (rand_n <= 5)
      // fast plod
      *num_spaces = 3;
   else if (rand_n <= 7)
      //slip
      *num_spaces = -6;
   else
      // slow plod
      *num_spaces = 1;
}

/* gen_h_move() uses a random number generator to move the hare as follows:
 * - generate a random number between 1 and 10
 * rand #  : spaces moved
 * 1-2: no move (sleep)
 * 3-4: 9 squares forward (big hop)
 * 5: 12 squares backward (big slip)
 * 6-8: 1 square forward (small hop)
 * 9-10: 2 squares backward (small slip)
 */
void gen_h_move(int *num_spaces)
{
   int rand_n = rand() % 10 + 1;

   switch (rand_n)
   {
      case 1:
      case 2:
         // sleep
         *num_spaces = 0;
         break;
      case 3:
      case 4:
         // big hop
         *num_spaces = 9;
         break;
      case 5:
         // big slip
         *num_spaces = -12;
         break;
      case 6:
      case 7:
      case 8:
         // small hop
         *num_spaces = 1;
         break;
      case 9:
      case 10:
         // small slip
         *num_spaces = -2;
         break;
      default:
         printf("Random number not between 1 and 10!\n");
   }
}

/* move_animal() moves either the tortoise or the hare to its next spot.
 * It does this by adding num_spaces to the value pointed to by a_loc.
 * Also, if the animal slips before the start line, it gets moved back
 * to location 1. */
void move_animal(int *a_loc, int num_spaces)
{
   *a_loc += num_spaces;

   /* check that the animal hasn't slipped before the start line */
   if (*a_loc < 1)
      *a_loc = 1;
}

/* Print out the current race situation */
void print_race(int t_loc, int h_loc)
{
   int i;
   
   /* For each location in the race, print the appropriate character */
   for (i = 1; i <= FINISH_LINE; i++)
   {
      if (i == t_loc && i == h_loc)
         i = printOuch(i);
      else if (i == t_loc)
         printf("T");
      else if (i == h_loc)
         printf("H");
      else if (i == FINISH_LINE)
         /* This only gets printed if the tortoise or hare is not on it! */
         printf("X\n");
      else
         printf("-");
   }
   printf("\n");
}

/* Only print as much of "OUCH!!!" as will fit before the finish line */
int printOuch(int loc)
{
   char ouch_str[] = "OUCH!!!";
   int i = 0;

   /* as long as we haven't hit the finish line, print the next character
    * in "OUCH!!!" */
   while (FINISH_LINE - loc > 0)
   {
      printf("%c", ouch_str[i]);
      i++;
      loc++;

      /* see if we've finished printing the string */
      if (ouch_str[i] == '\0')
         break;
   }

   /* loc should be at the location of the last printed letter */
   return --loc;
}

/* declare_winner() prints out a message saying who won */
void declare_winner(int winner)
{
   switch (winner)
   {
      case NO_WINNER:
         printf("Problem!  There should be a winner here!\n");
         break;
      case T_WINS:
         printf("TORTOISE WINS!!! YAY!!!\n");
         break;
      case H_WINS:
         printf("Hare wins. Yuck.\n");
         break;
      case TIE:
         printf("It's a tie.\n");
   }
}
