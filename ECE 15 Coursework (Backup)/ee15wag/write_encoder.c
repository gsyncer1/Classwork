/******************************************************************************
*
* File name: write_encoder.c
*
* Author:  Glenn Briones
*          09175057
*          gbriones@ucsd.edu
*
*
*     Lab #: 2
* Problem #: 4
*
* Submission Date: January 10, 2011
*
******************************************************************************/



/*-----------------------------------------------------------------------------
   Include files:
-----------------------------------------------------------------------------*/

#include <stdio.h>



/*=============================================================================
  Constants and definitions:
=============================================================================*/

// put your #defines and typedefs here




/*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  The main function (describe what your program does here):

  The program writes an ABRACADABRA encoder C program. Rather than writing
  a program that only allows the user to enter a word of 7 characters in length,
  the integer that the user enters determines the length of the word
  that can be entered in the ABRACADABRA encoder.

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

int main() 
{
  int word_length;

  scanf("%d", &word_length);

  printf("#include <stdio.h>\n");
  printf("#define MIN_CHARS %d\n", word_length);
  printf("\n");

  printf("int main()\n");
  printf("{\n");
  printf("  char natural_abra[5] = {'a', 'b', 'c', 'd', 'r'};\n");
  printf("  char key[5];\n");
  printf("  char input_chars[MIN_CHARS], out_chars[MIN_CHARS];\n");
  printf("  int i, j, valid_chars = 0;\n");
  printf("\n");
  printf("  printf(\"Enter key: \");\n");
  printf("  for (i = 0; i < 5; i++) key[i] = getchar();\n");
  printf("\n");
  printf("  getchar();\n");
  printf("\n");
  printf("  printf(\"Enter word: \");\n");
  printf("  for (i = 0; i < MIN_CHARS; i++) input_chars[i] = getchar();\n");
  printf("  while(getchar() != '\\n');\n");
  printf("  for (j = 0; j < 5; j++)\n");
  printf("     for (i = 0; i < MIN_CHARS; i++)\n");
  printf("        if (natural_abra[j] == input_chars[i]) valid_chars++;\n");
  printf("  if (valid_chars != MIN_CHARS)\n");
  printf("  {\n");
  printf("     printf(\"You did not speak in ABRACADABRA to me!\\n\");\n");
  printf("     return 1;\n");
  printf("  }\n");
  printf("  else\n");
  printf("  {\n");
  printf("     for (j = 0; j < 5; j++)\n");
  printf("        for (i = 0; i < MIN_CHARS; i++)\n");
  printf("           if (input_chars[i] == natural_abra[j])\n");
  printf("              out_chars[i] = key[j];\n");
  printf("\n");
  printf("     printf(\"Encrypted word: \");\n");
  printf("     for (i = 0; i < MIN_CHARS; i++) printf(\"%%c\", out_chars[i]);\n");
  printf("     printf(\"\\n\");\n");
  printf("  }\n");
  printf("  return 0;\n");
  printf("}\n");

  return 0;
}



/******************************************************************************
                                End of file
******************************************************************************/


