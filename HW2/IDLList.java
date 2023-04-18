package homeworks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

import java.util.ArrayList;

public class IDLList<E> {

//    inner class Node<E>
	private class Node<E> {
//        data fields
		private E data;
		private Node<E> next;
		private Node<E> prev;

//        constructor1
		/**
		 * This constructor creates a node holding elem The next and prev pointing to
		 * null prev|elem|next null|elem|null
		 * 
		 * @param elem : data to be stored in the Node
		 */
		public Node(E elem) {
//            assign values to the variables in the data fields.
			data = elem;
			prev = null;
			next = null;
		}

//        constructor2
		/**
		 * This constructor creates a node holding elem Next pointing to the next param
		 * and prev pointing to the prev param prev node <- prev|elem|next -> next node
		 * 
		 * @param elem
		 * @param prev
		 * @param next
		 */
		public Node(E elem, Node<E> prev, Node<E> next) {
//            assign values to the variables in the data fields.
			this.data = elem;
			this.prev = prev;
			this.next = next;
		}
	}

//    data fields of IDLList Class
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;

//    Constructor for IDLList
	/**
	 * This constructor creates an empty IDLList Head and tail are set to null and
	 * size is set to zero. assign an empty ArrayList to indices and what will be
	 * stored in ArrayList are nodes' references
	 */
	public IDLList() {
		head = null;
		tail = null;
		indices = new ArrayList<Node<E>>();
		size = 0;
	}

//    methods

	/**
	 * This method add elem at the head. (it becomes the first element of the list)
	 * 
	 * @param elem the elem to be placed to be placed at the head.
	 * @return always return ture
	 */
	public boolean add(E elem) {
		// if the list is empty
		// create a new node with prev being null and next being null
		// both head and tail will point to this node

		// if the list is not empty
		// get the reference of the first node. (oldfirst)
		// create a new node:
		// the head point to this new node (newfirst)
		// the next of this new node point to the old first node
		// the prev of the oldfirst node point to the new node.
		// update the size and indices in the data fields

		if (size == 0) {
			Node<E> temp = new Node<E>(elem);
			head = temp;
			tail = head;
			size++;
			indices.add(0, temp);
			return true;
		} else {
			Node<E> temp2 = new Node<E>(elem);
			temp2.next = head;
			head.prev = temp2;
			head = temp2;
			size++;
			indices.add(0, temp2);
			return true;
		}
		
	}

	/**
	 * This method add elem at position index and use the index for fast access
	 * 
	 * @param index the position in which the elem to be placed in the IDLL
	 * @param elem  the elem to be placed
	 * @return always return true
	 */
	public boolean add(int index, E elem) {
		// Invalid index, throw IllegalArgumentException()

		// if the index is 0, use the add(E elem) to add elem at head
		// else if the index is this.size - 1, the elem is added at the tail
		// call append(elem)
		// else:
		// get the current node at the input index and the prev node of current node
		// create a new node: prev -> prev node of current node
		// next -> current node
		// for the prev node of current node: the next of it is the new node
		// for the current node: the prev is the new node
		// update the size of the IDLList and the indices
		if (index < 0 || index > size || elem == null) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			add(elem);
			return true;
		} else if (index == this.size - 1) {
			append(elem);
			return true;
		} else {
			Node<E> current = indices.get(index);
			Node<E> newCurrent = new Node<>(elem, current, current.prev);
			current.prev.next = newCurrent;
			current.prev = newCurrent;
			size++;
			indices.add(index, newCurrent);
		}
		return true;
	}

	/**
	 * This method adds elem as the new last element of the list (i.e. at the tail).
	 * 
	 * @param elem the elem to be placed at the tail
	 * @return always return true
	 */
	public boolean append(E elem) {
		// if the list is empty -> call add(elem)
		// else:
		// get the old last node (which is also the tail)
		// create a new node: prev -> last node
		// next -> last node's next
		// for the old last node: the next of it is the new node
		// now the last node is the new node
		// update the indices and the size of the IDLList

		if (tail == null) {
			add(elem);
		} else {
			Node<E> temp = tail;
			tail = new Node<E>(elem, tail, null);
			temp.next = tail;
			indices.add(tail);
			size++;
		}
		return true;
	}

	/**
	 * This method returns the object at position index from the head. It uses the
	 * index for fast access The return type is E, which is the element type.
	 * 
	 * @param index the index of the node
	 * @return the data value of that node
	 */
	public E get(int index) {
		// if the index is invaild, throw IllegalArgumentException
		// else: return the data of the node at the input index

		if(size < index) {
			throw new IllegalArgumentException();
		} else {
			return indices.get(index).data;
		}
		
	}

	/**
	 * This method returns the object at the head. The return type is E, which is
	 * the element type.
	 * 
	 * @return the data value at the head
	 */
	public E getHead() {
		// if the list is empty, throw IllegalArgumentException()
		// else: return the data value of the head;

		if (size == 0) {
			throw new IllegalArgumentException("List is empty");
		} else {
			return head.data;
		}
	}

	/**
	 * This method returns the object at the tail. The return type is E, which is
	 * the element type.
	 * 
	 * @return the data value at the tail
	 */
	public E getLast() {
		// if the list is empty, throw IllegalArgumentException()
		// else: return the data value of the tail;

		if (size == 0) {
			throw new IllegalArgumentException("List is empty");
		} else {
			return tail.data;
		}
	}

	/**
	 * this method returns the list size.
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return size;
		// return the size of the list
	}

	/**
	 * removes and returns the element at the head. Should throw an
	 * IllegalStateException if there is no such element.
	 * 
	 * @return the data value of the head being removed
	 */
	public E remove() {
		// if there is no head (head is null), throw IllegalStateException();

		// if this list only has 1 node, return the data value of the head
		// update the variable values of the data filed

		// if more the one nodes:
		// get the oldhead of the list
		// if we remove the oldhead:
		// the new head will be oldhead.next
		// the prev of the new head will be null
		// update the values of the data fields if needed
		// return the data value of the head

		if (head == null) {
			throw new IllegalStateException();
		}
		if (head == tail) {
			E tempHead = head.data;
			head = null;
			tail = null;
			indices.remove(0);
			size--;
			return tempHead;
		} else {
			Node<E> current = head;
			head = head.next;
			head.prev = null;
			size--;
			indices.remove(0);

			return current.data;
		}

	}

	/**
	 * This method removes and returns the element at the tail. Should throw an
	 * IllegalStateException if there is no such element.
	 * 
	 * @return the data value of the tail being removed
	 */
	public E removeLast() {
		// if the list is empty, throw IllegalStateException()

		// if only 1 node in the list, call remove()

		// if more than 1 node
		// get the oldTail of the list
		// if we remove the oldtail:
		// the new tail will be oldtail.prev
		// the next of the new tail will be null
		// update the values of the data fields if needed
		// return the data value of the tail

		if (head == null && tail == null) {
            throw new IllegalStateException();
        }
        if (head == tail) {
            return remove();
        }
        Node<E> current = tail;
        Node<E> currentPrev = current.prev;
        currentPrev.next = null;
        tail = currentPrev;
        indices.remove(size-1); 
        size--;

        return current.data;
	}

	/**
	 * This method removes and returns the element at the index.
	 * 
	 * @param index the index of the element to be removed
	 * @return the data value of the node being removed
	 */
	public E removeAt(int index) {
		// if there is no such element: throw IllegalStateException.
		// if the node is the head or the tail
		// get current node (n), prev node of the current node (nPrev)
		// and next node of the current node (nNext)
		// if we remove the current node:
		// nPrev.next -> n.next
		// nNext.prev -> n.prev
		// update the variable values in data fields

		if (index < 0 || index > size) {
			throw new IllegalStateException();
		}
		if (index == 0) {
			return remove();
		}
		if (index == size) {
			return removeLast();
		} else {
			Node<E> current = indices.remove(index);
			current.prev.next = current.next;
			current.prev.prev = current.prev;
			size--;

			return current.data;
		}

	}

	/**
	 * This method removes the first occurrence of elem in the list
	 * 
	 * @param elem
	 * @return returns true if elem was in the list, false if not.
	 */
	public boolean remove(E elem) {
		// if the list is empty : throw IllegalStateException()

		// iterate from the head to the tail and compare every elem
		// if the elem is found, remove and return true; else return false

		if (head == null && tail == null) {
			throw new IllegalStateException();
		}
		int index = 0;
		boolean iterate = false;

		while (index < size && !iterate) {
			if (indices.get(index).data.equals(elem)) {
				removeAt(index);
				iterate = true;
			} else {
				index++;
			}
		}

		return iterate;
	}

	/**
	 * This method resents a string representation of the list.
	 * 
	 * @return a string
	 */
	public String toString() {
//        for example "9,8,7,6,5,4,3,2,1,0"
//        start from the empty string
//        add elem to the string
//        can use + to do concatenation

		Node<E> current = head;
		String str = "";
		while (current != null) {
			str = str + current.data + ",";
			current = current.next;
		}
		return str.substring(0, str.length() - 1);
	}

}