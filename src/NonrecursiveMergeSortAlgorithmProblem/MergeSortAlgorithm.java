package NonrecursiveMergeSortAlgorithmProblem;

public class MergeSortAlgorithm {

    public static void main(String [] args){

        Integer[] testArray = {13,144,56,7,8,9,905,567,35};

        String message = "original : " + convertArrayToString(testArray);

        mergeSortRecursionImplementationMosh( testArray );

        message += "\nSorted : " + convertArrayToString(testArray);

        System.out.println( message );
    }


    public static String convertArrayToString(Integer[] numberContainer ){

        String contents = "";
        for( int numInside: numberContainer )  {
            contents += numInside +  ", ";
        }
        return contents;
    }


    public static void  mergeSortRecursionImplementationMosh(
       Integer[] inputArray
        ) {

        int arrayLength = inputArray.length;

        if( arrayLength < 2 ){

            return;
        }

        int middleIndex = arrayLength / 2;

        Integer[] leftSideArray = new Integer[middleIndex];


        Integer[] rightSideArray = new Integer[arrayLength - middleIndex];


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

    private static void arrayMerger( Integer[] inputArray, Integer[] leftArray, Integer[] rightArray ){

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
