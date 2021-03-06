/******************************************************************************
 *
 * File name: cos_approx.c
 *
 * Author:  Glenn Briones
 *          09175057
 *          gbriones@ucsd.edu
 *
 *
 *     Lab #: 3
 * Problem #: 1
 *
 * Submission Date: Feb 27, 2011
 *
 ******************************************************************************/



/*-----------------------------------------------------------------------------
  Include files
  -----------------------------------------------------------------------------*/

#include <stdio.h>



/*=============================================================================
  Constants and definitions
  =============================================================================*/

// put all #defines and typedefs (if any) here



/*=============================================================================
  Global variables
  =============================================================================*/

// define/declare all global variables (if any) here



/*=============================================================================
  Forward function declarations
  =============================================================================*/

// put forward declarations of all functions here
double cos_N(double x, int N);
double cos_delta(double x, double delta);
int factorial(int n);
double power(double x, int n);




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function:
  The function calculates the cosine of various values written in a data file.
  The first line of the file dictates how many test cases there will be.
  The remaining lines contain the approximation type, value of x, and accuracy
  parameter.
  If the approximation type is 1, then a fixed number of terms in the taylor
  series expansion of cosine is used. The main function calls the function
  cos_N by taking in the value of x and the number of terms to evaluate from 
  the data file. The function then returns the cosine value and the main
  function prints it.
  If the approximation type is 2, the next two numbers are the value of x and
  the required precision. The main function uses cos_delta to find the cosine
  of x to the required precision.
  The function prints all the values of the cosine into an output file.

  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
   int m; // m = number of test cases
   int approx_type, N;
   double x, delta;

   //Open input file for reading
   FILE *input;
   if( (input = fopen("cos_input.dat","r")) == NULL)
   {
      fprintf(stderr, "Unable to read file cos_input.dat!\n");
      return 1;
   }

   fscanf(input, "%d", &m); //scan for number of test cases m

   //Open output file for writing
   FILE *output;
   if( (output = fopen("cos_output.dat","w")) == NULL)
   {
      fprintf(stderr, "Could not open cos_output.dat for writing\n");

      //File was opened before this point. Must close it.
      fclose(input);
      return 1;
   }

   int i;
   for(i = 1; i <= m; i++)
   {
      //Checks the approximation type
      fscanf(input, "%d ", &approx_type);

      //Approx type 1: fixed number of terms
      if(approx_type == 1)
      {
         fscanf(input, "%lf %d", &x, &N);
         fprintf(output, "Case %d: cos(%.3lf) = %.12lf\n",i,x,cos_N(x,N));
      }
      //Approx type 2: required precision delta
      else if (approx_type == 2)
      { 
         fscanf(input, "%lf %lf", &x, &delta); 
         fprintf(output,"Case %d: cos(%.3lf) = %.12lf\n",i,x,cos_delta(x,delta));
      }
      else fprintf(output, "Case %d: Invalid cos approximation type!\n",i);
   }


   //Closes the input and output files
   fclose(input); fclose(output);

   return 0;
}




/*=============================================================================
  Function definitions
  =============================================================================*/

// define (implement) all the functions here; document each function

// The function factorial calculates the factorial of an integer n.
int factorial(int n)
{
   int i, factorial_rslt = 1;

   if(n == 0 || n == 1) return 1; // 0! = 1! = 1
   else
   { 
      for(i = 2; i <= n; i++) factorial_rslt *= i;
      return factorial_rslt;
   }
} /* end of factorial() */


// The function power calculates the value of x to the n power.
double power(double x, int n)
{
   double power_rslt = 1.0;
   int i;

   if(n == 0) return 1; //x^0 = 1
   else
   {
      for(i = 1; i<=n; i++) power_rslt *= x;
      return power_rslt;
   }
} /* end of power() */


// The function cos_N calculates the cosine of a real number x
// using a fixed number of terms on the taylor expansion of cosine.
double cos_N(double x, int N)
{
   int i; 
   double cos_approx = 0;
   for(i = 0; i < N; i++)
      cos_approx += power(-1,i) * power(x,2*i) / factorial(2*i);
   return cos_approx;
} /* end of cos_N() */


//The function cos_delta calculates the cosine of x within
//the required precision delta.
double cos_delta(double x, double delta)
{
   double previous_eval = 0.0, current_eval = 0.0, difference;

   int i = 0;
   do{
      previous_eval = current_eval;
      current_eval += power(-1,i)*power(x,2*i)/factorial(2*i);
      difference = current_eval - previous_eval;
      difference = (difference < 0) ? -difference : difference; //Takes abs value
      i++;
   }
   while(difference >= delta);

   return current_eval;
}

/******************************************************************************
  End of file
 ******************************************************************************/


