package NonrecursiveMergeSortAlgorithmProblem;


import com.sun.source.tree.LiteralTree;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static NonrecursiveMergeSortAlgorithmProblem.MergeSortAlgorithm.mergeSortRecursionImplementationMosh;

//  Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;

      ListNode tailNodeReference = this;

      /*
      * mandatory empty constructor, though I don't know how this will be of use
      * since there are no getters and setters for the next and val variables.
      *
      * Will see how it will turn out.
      * */
      ListNode() {

      }

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }


    /**
     *Constructor for making copy of a ListNode,
     *
     * Ideally to be used when passing a new instance of a
     * ListNode rather than a reference of a ListNode
     */

    ListNode( ListNode nodeToCopy ){

          val = nodeToCopy.val;

          if (nodeToCopy.hasNext()){
              next = nodeToCopy.next;
          }
      }


      public boolean hasNext(){
          return  ! ( next == null);
      }

      /*
      * Accepts a ListNode, though it takes the value of the ListNode
      * in order to create a new instance of the ListNode class.
      *
      * This is in order to avoid a pass by reference, though
      * in the first place a reference is passed, A value is saved not
      * a reference.
      * */
      public void setNext(ListNode nodeToAdd){

        next = new ListNode(nodeToAdd);
      }

      public ArrayList<Integer> getAllDataAndPutInsideArrayList(){

          ArrayList<Integer> container = new ArrayList<Integer> ();

          ListNode nodeInCurrentAdd = this;
          while( nodeInCurrentAdd != null ) {

              container.add(nodeInCurrentAdd.val );
              nodeInCurrentAdd = nodeInCurrentAdd.next;
          }

          return container;
      }


  }

  public class Solution {


     /*
     *
     * Main method is used to test if the mergeKList method works as
     * intended.
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
          "Previous Unsorted: \nTest Node #1: " + getStringContentOfListNode(testNodeOne)  + "\nTest Node #2: " + getStringContentOfListNode( testNodeTwo ));


          ListNode mergedList  = mergeKLists( toSort );

          System.out.println( "After Merge Sort: " + getStringContentOfListNode( mergedList ) );

      }

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
      public static ListNode mergeKLists(ListNode[] lists) {

          ArrayList<Integer> valueOfAllNumbers = new ArrayList<Integer>();

          for(  ListNode nodeInside : lists ){

              for( Integer dataInside: nodeInside.getAllDataAndPutInsideArrayList() )
              valueOfAllNumbers.add(dataInside);
          }

          Object[] dataOfAllValues = valueOfAllNumbers.toArray();

          Integer[] valuesToSort = new Integer[dataOfAllValues.length];

          for( int i = 0; i < dataOfAllValues.length; i++)
              valuesToSort[i] = (Integer) dataOfAllValues[i];

          mergeSortRecursionImplementationMosh( valuesToSort );
          return createNodesWithData( valuesToSort );
      }



      private static ListNode createNodesWithData( Integer[] valuesForNodes  ) {

          int lengthOfValuesToAdd = valuesForNodes.length;

          ListNode permanentHeadNode = new ListNode(valuesForNodes[0]);

          ListNode locationFinder = permanentHeadNode;

          for( int iterationCounter = 1; iterationCounter < valuesForNodes.length; iterationCounter++ ){

              if( !locationFinder.hasNext() ){

                  locationFinder.next = new ListNode( valuesForNodes[iterationCounter] );
                  locationFinder = locationFinder.next;
              }
          }

          return permanentHeadNode;
      }




  }
