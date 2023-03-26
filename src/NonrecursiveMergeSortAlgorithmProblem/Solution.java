package NonrecursiveMergeSortAlgorithmProblem;

import java.util.ArrayList;

/*
*
* The ListNode class is an implementation of singly-LinkedList.
*
* */
 class ListNode {
      int val;
      ListNode next;

//      ListNode tailNodeReference = this;

      /*
      * mandatory empty constructor, though I don't know how this will be of use
      * since there are no getters and setters for the next and val variables.
      *
      * Will see how it will turn out.
      * */
      ListNode() {

      }

      /*
      *
      * Create a ListNode with a data.
      *
      * */
      ListNode(int val) {
          this.val = val;
      }


      /*
      * Create a ListNode with a Data and
      * a tail ListNode.
      *
      *
      * */
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }



    /**
     *Constructor for making copy of a ListNode,
     *
     * Ideally to be used when passing a new instance of a
     * ListNode rather than a reference of a ListNode
     */
//
//    ListNode( ListNode nodeToCopy ){
//
//        val = nodeToCopy.val;
//
//        if (nodeToCopy.hasNext()){
//            next = nodeToCopy.next;
//        }
//    }

    /*
      *
      * returns a boolean value according to whether or not
      * there is a next ListNode
      * */
//      public boolean hasNext(){
//          return  ! ( next == null);
//      }


      /*
      * Accepts a ListNode, though it takes the value of the ListNode
      * in order to create a new instance of the ListNode class.
      *
      * This is in order to avoid a pass by reference, though
      * in the first place a reference is passed, A value is saved not
      * a reference.
      * */
//      public void setNext(ListNode nodeToAdd){
//
//        next = new ListNode(nodeToAdd);
//      }



      /*
      *
      * Returns an ArrayList Of Integer representing the
      * data contained by the ListNode, from Head to Tail.
      *
      *
      * */
//      public ArrayList<Integer> getAllDataAndPutInsideArrayList(){
//
//          ArrayList<Integer> container = new ArrayList<Integer> ();
//
//          ListNode nodeInCurrentAdd = this;
//          while( nodeInCurrentAdd != null ) {
//
//              container.add(nodeInCurrentAdd.val );
//              nodeInCurrentAdd = nodeInCurrentAdd.next;
//          }
//
//          return container;
//      }


  }

  /*
  * Class with Solution to make problem in Leet Code.
  *
  * The input is about receiving an array of singly linkedlist,
  * and producing an Output of a sorted singly linkedlist.
  *
  * As per the description of the problem.
  *
  * Input: lists = [[1,4,5],[1,3,4],[2,6]]
  * Output: [1,1,2,3,4,4,5,6]
  * Explanation: The linked-lists are:
  *  [
  *     1->4->5,
  *     1->3->4,
  *      2->6
  * ]
  *  merging them into one sorted list:
  * 1->1->2->3->4->4->5->6
  *
  *
  * A recursive implementation of the merge-sort algorithm have the
  * risk of throwing a StackOverFlow error. An Exception can be handled
  * during runtime, I don't know how to handle an Error during runtime, a
  * try and catch block is used for handling Exceptions.
  *
  * Haven't tried handling Errors during runtime.
  *
  * */
  public class Solution {


      /*
       *
       * Main method is used to test if the mergeKList method works as
       * intended.
       *
       * I am having a problem with implementing a loop
       * to automatically create a ListNode with contents loaded
       * already.
       *
       * So I am chose to repetively make nodes and add them
       * to the tail.
       *
       * */
      public static void main(String[] args) {

          ListNode testNodeOne = new ListNode(123);

          ListNode nodeA = new ListNode(12);

          testNodeOne.next = nodeA;

          ListNode nodeB = new ListNode(234);

          nodeA.next = nodeB;

          ListNode nodeC = new ListNode(567);

          nodeB.next = nodeC;

          ListNode nodeD = new ListNode(5);

          nodeC.next = nodeD;

          ListNode nodeE = new ListNode(5);

          nodeD.next = nodeE;



          ListNode testNodeTwo = new ListNode(1311);



          ListNode[] toSort = { testNodeOne, testNodeTwo };

          System.out.println(
          "Previous Unsorted: \nTest Node #1: " + getStringContentOfListNode(testNodeOne)
          + "\nTest Node #2: " + getStringContentOfListNode( testNodeTwo ));

          Solution solutionObject = new Solution();

          ListNode mergedList  = solutionObject.mergeKLists( toSort );


          System.out.println( "After Merge Sort: " + getStringContentOfListNode( mergedList ) );

      }

      /*
       *
       * returns a boolean value according to whether or not
       * there is a next ListNode
       * */
      public boolean hasNext( ListNode nodeToCheck ){
          return  ! ( nodeToCheck.next == null);
      }


      /*
       *
       * Returns an ArrayList Of Integer representing the
       * data contained by the ListNode, from Head to Tail.
       *
       *
       * */
      public ArrayList<Integer> getAllDataAndPutInsideArrayList( ListNode listNodeWithData ){

          ArrayList<Integer> container = new ArrayList<Integer> ();

//          ListNode nodeInCurrentAdd = listNodeWithData;
          while( listNodeWithData != null ) {

              container.add(listNodeWithData.val );
              listNodeWithData = listNodeWithData.next;
          }

          return container;
      }



      /*
      *
      * Convert a ListNode into a String, the String contains all contents
      * of the ListNode, From Head to Tail.
      *
      * */
      private static String getStringContentOfListNode( ListNode ListNodeToPrint ){

          ListNode nodeInUseForPrinting = ListNodeToPrint;

          String listOfContents = "";

          while( nodeInUseForPrinting  != null){

              listOfContents += nodeInUseForPrinting.val + ", " ;

              nodeInUseForPrinting = nodeInUseForPrinting.next;
          }

          return listOfContents;
      }



      /*
      * Receives an array of ListNode, a ListNode is an implementation
      * of a singly linkedlist, this method returns a ListNode with all the
      * contents properly ordered.
      *
      * */
      public ListNode mergeKLists(ListNode[] lists) {

          ArrayList<Integer> valueOfAllNumbers = new ArrayList<Integer>();

          for(  ListNode nodeInside : lists ){

              for( Integer dataInside: getAllDataAndPutInsideArrayList( nodeInside ) )
              valueOfAllNumbers.add( dataInside );
          }

          Object[] dataOfAllValues = valueOfAllNumbers.toArray();

          Integer[] valuesToSort = new Integer[dataOfAllValues.length];

          for( int i = 0; i < dataOfAllValues.length; i++)
              valuesToSort[i] = ( Integer ) dataOfAllValues[i];

          mergeSortRecursionImplementationMosh( valuesToSort );
          return createNodesWithData( valuesToSort );
      }


      /*
      *
      * Accepts an Array of Integer to serve as the data for creating
      * a ListNode with Tails ListNodes. The data that the ListNode
      * contains is the same data that the Passed Array Contains.
      *
      * */
      private ListNode createNodesWithData( Integer[] valuesForNodes  ) {

          int lengthOfValuesToAdd = valuesForNodes.length;

          ListNode permanentHeadNode = new ListNode(valuesForNodes[0]);

          ListNode locationFinder = permanentHeadNode;

          for( int iterationCounter = 1; iterationCounter < valuesForNodes.length; iterationCounter++ ){

              if( !hasNext( locationFinder ) ){

                  locationFinder.next = new ListNode( valuesForNodes[iterationCounter] );
                  locationFinder = locationFinder.next;
              }
          }

          return permanentHeadNode;
      }


      public void  mergeSortRecursionImplementationMosh(
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

      private void arrayMerger( Integer[] inputArray, Integer[] leftArray, Integer[] rightArray ){

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
