package SortingAlgorithmsPractice;

public class MergeSortAlgorithm {

    public static void main(String [] args){

        int[] testArray = {13,144,56,7,8,9,905,567,35};

        String message = "original : " + convertArrayToString(testArray);

        mergeSortRecursionImplementationMosh( testArray );

        message += "\nSorted : " + convertArrayToString(testArray);

        System.out.println(
                message
        );


    }
    public static String convertArrayToString(int[] numberContainer ){

        String contents = "";
        for( int numInside: numberContainer )  {
            contents += numInside +  ", ";
        }
        return contents;
    }



    public static void mergeSortAlgorithm( int[] numberContainer ){


        int low = 0;
        int high = numberContainer.length - 1;
        int middle = numberContainer.length / 2;

        int[] leftSideArray = new int[ middle ];

        int[] rightSideArray = new int[ middle - 1 ];


        arrayDivider(
        leftSideArray, numberContainer, 0, middle  );


        arrayDivider(
        rightSideArray, numberContainer,
    middle + 1, numberContainer.length - 1
        );


    }
//
//    private static int[] getLeftSideArray( int[] numberContainer ){
//
//        int startIndex = 0;
//
//        int middleIndex = numberContainer.length / 2;
//
//        int[] rightSideArray = new int[ middleIndex ];
//
//        int[] leftSideArray = new int[ middleIndex - 1 ];
//
//
//        if ( numberContainer[middleIndex] < numberContainer[ middleIndex - 1 ] ){
//
//            for( int i = 0; i < middleIndex; i++){
//
//                rightSideArray[i] = numberContainer[ middleIndex + i ];
//
//
//
//            }
//
//        }
//
//
//
//    }

    private static void arrayDivider(
        int[] arrayToBeDivided, int[] arrayDestination, int start, int end ) {

        for ( int i = 0; i < end; i++ ){

            if ( i == 0 ) {

                arrayDestination[ i ] = arrayToBeDivided[i + start];
                continue;
            }

//          arrayDestination[ i - 1 ] < arrayToBeDivided[ i + start ];

            if( arrayDestination[ i - 1 ] < arrayToBeDivided[ i + start ] ){

                arrayDestination[ i ] = arrayToBeDivided[ i + start ];

                continue;
            }


            int temp = arrayDestination[i - 1];

            arrayDestination[ i - 1 ] = arrayToBeDivided[ i + start ];

            arrayDestination[i] = temp;
        }
    }

    private static void arrayMerger(){

    }


    public static void  mergeSortRecursionImplementationMosh(
        int[] inputArray
        ) {

        int arrayLength = inputArray.length;

        if( arrayLength < 2 ){

            return;
        }

        int middleIndex = arrayLength / 2;

        int[] leftSideArray = new int[middleIndex];

        int[] rightSideArray = new int[ arrayLength - middleIndex ];


        for( int i = 0; i < middleIndex; i++ ){

            leftSideArray[i] = inputArray[i];
        }

        for( int i = middleIndex; i < arrayLength; i++ ){

            rightSideArray[ i - middleIndex ] = inputArray[ i ];
        }

        //call this method again to
        mergeSortRecursionImplementationMosh( leftSideArray );

        mergeSortRecursionImplementationMosh( rightSideArray );

        arrayMerger( inputArray,leftSideArray, rightSideArray);

    }

    private static void arrayMerger( int[] inputArray, int[] leftArray, int[] rightArray ){

        int leftSize = leftArray.length;
        int rightSize = rightArray.length;


        int leftIterator = 0;
        int rightIterator = 0;
        int loopIterator = 0;


        while( leftIterator <  leftSize && rightIterator < rightSize  ){


            if(  leftArray[leftIterator] <= rightArray[rightIterator] ){

                inputArray[loopIterator] = leftArray[leftIterator];

                leftIterator++;
                loopIterator++;

                continue;
            }

            inputArray[loopIterator] = rightArray[rightIterator];

            rightIterator++;
            loopIterator++;

        }



        while (
                leftIterator < leftSize ||
            rightIterator < rightSize
        ){

            if ( leftIterator < leftSize ){

                inputArray[loopIterator] = leftArray[leftIterator];

                loopIterator++;
                leftIterator++;

                continue;
            }

            inputArray[loopIterator] = rightArray[rightIterator];

            rightIterator++;
            loopIterator++;
        }
    }
}
