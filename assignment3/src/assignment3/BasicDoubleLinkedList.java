package assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements Iterable<T> {

	 protected Node head;
	 protected Node tail; 
	 protected int size; 
    
	 public class Node {
		    protected Node prev;
		    protected Node next;
		    protected T data;

		    public Node(T data) {
		      this.prev = null;
		      this.next = null;
		      this.data = data;
		    }
		  }
	
	 /**
	  * 
	  * @return returns the size of the list.
	  */
	 public int getSize() {
		 return size;
	 }
	 
	 public BasicDoubleLinkedList() {
		 head = null ;
		 tail = null;
		 size = 0;
	 }
      
	 /**
	  * Adds element to the front of the list.
	  * @param data element
	  * @return returns reference to current object.
	  */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		 
		 Node newNode = new Node(data);
		  if (size == 0) {
	            
	            head = newNode;
	            tail = newNode;
	        } else {
	            
	            tail.next = newNode;
	            tail = newNode;
	        }

		 size++;
		 return this;
	 }
	
	
	
	
	
	/**
	 *  add an element to the front of the list.
	 * @param data element
	 * @return returns a reference to this object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		 Node newNode = new Node(data);
		  if (size == 0) {
	            
	            head = newNode;
	            tail = newNode;
	        } else {
	        	
	        	head.next = newNode;
	        	head = newNode;
	        }
		  
		        size++;
		        return this;
		
	}
	 
	/**
	 *  gets the first element within the list.
	 * @return returns null or the first element.
	 */
	public T getFirst() {
		if(size ==0) {
			return null;
		} else {
			return head.data;
		}
		
	}
	
	
	
	
	/**
	 * gets the last element within the list.
	 * @return returns null or last element.
	 */
	public T getLast() {
		if(size ==0) {
			return null;
		} else {
			return tail.data;
		}
		
	}
	
	/**
	 * Removes and returns the first element from the list. 
	 * If there are no elements the method returns null. 
	 * @return returns first element or null.
	 */
	
	public T retrieveFirstElement() {
		Node first = head;
		while(first!=null) {
			head.prev=null;
			head = head.next;
			size--;
			return first.data;
		}
		return null;
	}
	
	/**
	 * Removes and returns the last element from the list.
	 *  If there are no elements the method returns null. 
	 * @return returns null or last element.
	 */
	 public T retrieveLastElement(){
	        if(size==0){
	        	return null;
	        } else {
	            Node currentNode = head;
	            Node previousNode = null;

	            while (currentNode != null) {
	                if (currentNode.equals(tail)) {
	                    tail = previousNode;
	                    break;
	                }
	                previousNode = currentNode;
	                currentNode = currentNode.next;
	            }
                
	                size--;
                    return currentNode.data;
	        }
                 
	       }
                  
	 
	 /**
	     * Returns node list converted to array list
	     *
	     * @return Array list
	     */
	    
		public ArrayList<T> toArrayList()
	    {
			
			ArrayList<T> arrayList = new ArrayList<T>();
			Node  newNode;
			newNode = head;
			for (int steps = 0; steps < size; steps++) {	
				arrayList.add(newNode.data);
				if (newNode.next != null)
				newNode = newNode.next;
			}
			return arrayList;
	    	  }
	    	   
	    
	    
	 
	
	
	
	/**
	 * Removes the first instance of the targetData from the list. Notice that you must remove the elements 
	 * by performing a single traversal over the list.
	 * @param element element being looked for
	 * @param comparator comparing the elements in the list.
	 * @return  returns null or targeted element
	 */
	 public BasicDoubleLinkedList<T> remove(T element, Comparator<T> comparator) {
		 Node current=head;
			if(head==null)
				return null;
			else{
				while(comparator.compare(element, current.data)!=0) {
					current=current.next;
				}
				if(current==head) {
					head = head.next;
					size--;
					return this;
				}
				if(current==tail) {
					tail = tail.prev;
					size--;
					return this;
				}
				current.prev=current.next.prev;
				current.next=current.prev;
	            size--;
	            return this;
			}
		    }
	 
	 
	 
	 
	/**
	 * This method implements ListIterator and defines the methods of hasNext(), next(), hasPrevious()
   * and previous().
   * 
   * @return an iterator positioned at the head of the list
   * @throws UnsupportedOperationException When there´s no more elements (at the end of the list and
   *         calling next() or at the beginning of the list and calling previous()).
   * @throws NoSuchElementException If remove(), add(), nextIndex() and previousIndex() and set()
   *         methods are called 
	 */
	 public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
         
			class Iterator implements ListIterator<T> {
				protected Node current=null;
				private int elements=0;
				
				public Iterator() {
					this.current=null;
				}
				@Override
				public boolean hasNext() {
					if(current==null&&head!=null) {
						return true;
					}
					else if(elements>0) {
						return current.next!=null;
						}
					else if(elements==size){
						return false;
					}
					else return false;
				}

				@Override
				public T next() {
					if(hasNext()==false)
					throw new NoSuchElementException("no element");
					
					if(current==null&& head!=null) {
						current=head;
						elements++;
						return current.data;
						
					}
					else if(current!=null) {
						current = current.next;
						elements++;
						return current.data;
					}
					else 
						throw new NoSuchElementException();
				}

				@Override
				public boolean hasPrevious() {
					if(elements==size)
						return true;
					else if(elements==1) {
						current=head;
						return true;}
					else if(elements>1) {
						return current.prev!=null;
						}
					else return false;
				}

				@Override
				public T previous() {
					if(hasPrevious()==false)
						throw new NoSuchElementException("no element");
					if(elements==size) {
						elements--;
						return current.data;
						}
					else if(elements ==1) {
						elements--;
						return current.data;
						}
					else if(elements>1) {
						current = current.prev;
						elements--;
						return current.data;
					}
					else throw new NoSuchElementException("no element");
				}

				@Override
				public int nextIndex() {
					throw new UnsupportedOperationException();
				}

				@Override
				public int previousIndex() {
					throw new UnsupportedOperationException();
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

				@Override
				public void set(T e) {
					throw new UnsupportedOperationException();
				}

				@Override
				public void add(T e) {
					throw new UnsupportedOperationException();
				}
				
			}
			return new Iterator();
		}
	 
	 
	 
	 
	 
	 
 }


	 
	 
	 
	 
	 

