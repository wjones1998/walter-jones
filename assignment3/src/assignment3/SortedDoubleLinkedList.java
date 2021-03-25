package assignment3;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Iterable<T> {
	
	 private Comparator<T> comparator;

	  /**
	   * Creates an empty list that is associated with the specified comparator.
	   * 
	   * @param comparator - Comparator to compare data elements
	   */
	 
	  public SortedDoubleLinkedList(Comparator<T> comparator) {
	    this.comparator = comparator;
	  }
	
	
	  /**
	   * Inserts the specified element at the correct position in the sorted list.
	   * 
	   * @param data - the data to be added to the list
	   * @return reference to the current object
	   */
	  public SortedDoubleLinkedList<T> add(T data) {
	    Node newNode = new Node(data);
	    Node curNode = head;

	    if (size == 0) {
	      head = newNode;
	      tail = head;
	      size++;
	      return this;
	    } else if (comparator.compare(head.data, data) > 0) {
	      newNode.next = head;
	      head.prev = newNode;
	      head = newNode;
	      size++;
	      return this;
	    } else {
	      while (comparator.compare(curNode.data, data) < 0) {
	        // Add after the tail
	        if (curNode.next == null) {
	          curNode.next = newNode;
	          newNode.prev = curNode;
	          tail = newNode;
	          size++;
	          return this;
	        } else {
	          curNode = curNode.next;
	        }
	      }
	      curNode.prev.next = newNode;
	      newNode.prev = curNode.prev;
	      curNode.prev = newNode;
	      newNode.next = curNode;
	      size++;
	      return this;
	    }
	  }

	  
	  @Override
	  /**
	   * This operation is invalid for a sorted list.
	   * 
	   * @param data - the data element to be removed
	   * @return reference to the current object
	   * @throws UnsupportedOperationException if method is called
	   */
	  public BasicDoubleLinkedList<T> addToEnd(T data)
              throws java.lang.UnsupportedOperationException{
		  throw new UnsupportedOperationException("Invalid operation for sorted list");
		  
	  }
	  
	  @Override
	  /**
	   * This operation is invalid for a sorted list.
	   * 
	   * @param data - the data element to be removed
	   * @return reference to the current object
	   * @throws UnsupportedOperationException if method is called
	   */
	  public BasicDoubleLinkedList<T> addToFront(T data)
              throws java.lang.UnsupportedOperationException{
		  throw new UnsupportedOperationException("Invalid operation for sorted list");
		  
	  }
	  
	  
	  /**
	   * Implements the iterator by calling the super class iterator method.
	   * 
	   * @return an iterator positioned at the head of the list
	   */
	  @Override
	  public ListIterator<T> iterator() {
	    return super.iterator();
	  }
	  
	  /**
	   * Implements the remove operation by calling the super class remove method.
	   * 
	   * @param data - the data element to be removed
	   * @param comparator - the comparator to determine equality of data elements
	   * @return reference to the current object
	   */
	  @Override
	  public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
	    return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
	  }
	  
}
