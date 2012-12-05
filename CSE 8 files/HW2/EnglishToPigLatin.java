/* Name:	Glenn Briones
 * Account:	cs8wfs
 * HW:		Homework 2 - EnglishToPigLatin
 * Date:	April 13, 2011
 *
 * File:	EnglishToPigLatin.java	
 *
 * Sources of Help: Powerpoint from discussion, Java API for String class.
 *
 * This Java application translates English words into pig latin.
 *
 */

import java.util.*;

/**
 * class EnglishToPigLatin
 * 	This class contains a main method that asks the user for
 *	some English text, which calls the method englishToPigLatin
 *	to translate the text.
 *
 */

public class EnglishToPigLatin
{
   /**
    * main() is the driver for this application.
    *
    * The main method prompts a user to enter text to be converted into
    * pig latin. It then calls the method englishToPigLatin to convert
    * all of the text into pig latin.
    * It then asks for more text until the user quits.
    *
    *
    * Params: None
    * Return Value: void
    */

   public static void main( String[] args )
   {
      Scanner line_input, word_input;

      line_input = new Scanner(System.in);

      System.out.println("Enter the text to be converted to Pig Latin,"
	    + " EOF to quit:");

      //Translate the text to pig latin while there is another line.
      while( line_input.hasNextLine() )
      {
	 word_input = new Scanner( line_input.nextLine() );

	 System.out.println("In Pig Latin that is:");

	 //Print the pig latin translation for each word
	 while( word_input.hasNext() )
	 {
	    System.out.print( englishToPigLatin(word_input.next()) + " ");
	 }
	 System.out.println("\n");

	 System.out.println("Enter more text to be converted to Pig Latin, "
	       + "EOF to quit:");
      }

   } // end main()


   /**
    * englishToPigLatin
    * 
    * This method takes in a string, parses the string accordingly,
    * and concatenates the word together into the pig latin translation.
    * It then returns the translated string.
    *
    */
   public static String englishToPigLatin( String word )
   {
      String pigLatin, firstLetter, suffix = "ay";
      //Determine the index of the first vowel
      int firstVowelIndex = indexOfFirstVowel(word);

      if(firstVowelIndex == -1) // Word contains no vowels
      {
	//Capitalize first word, preserve cases of all other letters
	pigLatin = word.substring(0,1).toUpperCase() +
	            word.substring(1, word.length());
      }
      else if(firstVowelIndex == 0) //Word starts with vowel
      {
	 firstLetter = word.substring(0,1);
	 pigLatin = firstLetter.toUpperCase() // Capitalize first letter
	            + word.substring(1,word.length()) //Add rest of word
	            + "-" + suffix; // Append "-ay"

      }
      else // word begins with consonant
      {
	 firstLetter = word.substring(firstVowelIndex,firstVowelIndex+1);
	 pigLatin = firstLetter.toUpperCase() + //Capitalize first letter
	            // Add subsequent letters
		    word.substring(firstVowelIndex+1, word.length()) +
		    // Append "-" and first consonants
		    "-" + word.substring(0,1).toLowerCase() +
		    // Append "ay"
		    word.substring(1, firstVowelIndex) + suffix;
      }

      return pigLatin; // The translated word

   } // end englishToPigLatin()



   /**
    * isVowel
    *
    * This method takes in two parameters, a character and a boolean
    * value that flags whether that letter corresponds to the first letter
    * of a word.
    * The funtion returns true if the letter is a vowel, including y if it is
    * not the first letter. Otherwise it returns false.
    */
   public static boolean isVowel(char letter, boolean firstLetter)
   {
      if(letter == 'a' || letter == 'A' ||
	 letter == 'e' || letter == 'E' ||
	 letter == 'i' || letter == 'I' ||
	 letter == 'o' || letter == 'O' ||
	 letter == 'u' || letter == 'U' )
      {
	 return true;
      }
      else if( (letter == 'y' || letter == 'Y') && !firstLetter)
      {
	 return true;
      }
      else return false;
   } // end isVowel()


   /**
    * indexOfFirstVowel
    * 
    * This method takes in a string and returns the index of the first
    * vowel. If the string has no vowels, then it returns -1.
    */
   public static int indexOfFirstVowel(String str)
   {
      int index = -1, i;

      if( isVowel(str.charAt(0), true) )
      {
	 index = 0;
      }
      else
      {
	 // Loop through letters of word to find first vowel, if any
	 for(i=1; i < str.length() && !(isVowel(str.charAt(i), false)); i++);
	 if(i < str.length()) index  = i;
      }

      return index;
      //index = -1 indicates that there were no vowels in string


   } // end indexOfFirstVowel()

} // end class HWTemplate
