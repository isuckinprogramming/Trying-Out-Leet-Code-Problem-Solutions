
package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {

    public static void main(String [] args){

        String testString = "aab";

        String contentsToTest = "The longest substring of " + testString +
            "\nThe length of the longest substring is "  + lengthOfLongestSubstring(testString);

        System.out.println( contentsToTest );
    }


    private static String turnCharContainerIntoString( HashMap< Character, Character > charContainerToConvert ){
        
        String stringConversionOfContainer = "";
        for( Character charInside  : charContainerToConvert.values() ) {
            stringConversionOfContainer += charInside;
        }
        
        return stringConversionOfContainer;
    }

    private static HashMap<Character, Character> getBiggerCharContainer (
            HashMap<Character, Character> firstContainer,
            HashMap<Character, Character> secondContainer
            )   {

        return ( firstContainer.size() >= secondContainer.size() ) ?
                firstContainer :
                secondContainer ;
    }
    private static HashMap<Character, Character> getSmallerCharContainer (
            HashMap<Character, Character> firstContainer,
            HashMap<Character, Character> secondContainer
    )   {

        return ( firstContainer.size() >= secondContainer.size() ) ?
                secondContainer:
                firstContainer ;
    }


    public static int lengthOfLongestSubstring( String stringToCheck ){

        char[] arrayOfChar = stringToCheck.toCharArray() ;

        HashMap< Character, Character > charContainerForFirstSubstring = new HashMap<>();

        HashMap< Character, Character > charContainerForSecondSubstring = new HashMap<>();

        boolean isFirstContainerReady = true;

        boolean isSecondContainerReady = true;

        boolean isCharRejectedFromEntry = false;

//        int iterationCounter = 0;
        
        String longestSubstring = "";

        for ( int charSelector = 0; charSelector < arrayOfChar.length; charSelector++ ){


            char charInside = arrayOfChar[ charSelector ];

            if( isFirstContainerReady ) {

                if( charContainerForFirstSubstring.containsKey( charInside ) ){

                    isFirstContainerReady = false;
                    isCharRejectedFromEntry = true;

                } else {

                    charContainerForFirstSubstring.put( (Character) charInside, (Character) charInside);

                    isCharRejectedFromEntry =  false ;

                    continue;
                }
            }


            if( isSecondContainerReady ) {


                if( charContainerForSecondSubstring.containsKey( charInside ) ){

                    isSecondContainerReady = false;
                    isCharRejectedFromEntry = true;

                } else {

                    charContainerForSecondSubstring.put( (Character) charInside, (Character) charInside );

                    isCharRejectedFromEntry =  false;

                    continue;
                }
            }

            if ( ! ( charSelector == arrayOfChar.length - 1) ){

                getSmallerCharContainer( charContainerForFirstSubstring, charContainerForSecondSubstring ).clear();

                if ( charContainerForFirstSubstring.isEmpty() ){
                    isFirstContainerReady = true;
                } else {
                    isSecondContainerReady = true;
                }

                continue;
            }

            charSelector -= (isCharRejectedFromEntry ) ? 1 : 0 ;
        }

        longestSubstring = turnCharContainerIntoString(
            getBiggerCharContainer(
                charContainerForFirstSubstring,
                charContainerForSecondSubstring
            )
        );

        return longestSubstring.length();
    }
}
