import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * Instructions: 
 * First: Read through the assignment specification, make sure you understand what the assignment is asking for.
 * Second: There are number of "TODO" instructions within this code, make sure to complete all of them fully.
 * Third: Test you code.
 */


// Pledge: I pledge my honor that I have abided by the Stevens Honor System.
// Name: Jerry Cheng


/**
 * HW4 CS284 Spring 2019
 * Implements a Huffman encoding tree.
 * The included code has been commented for the student's benefit, feel free to read through it.
 */
public class HuffmanTree {

	// ******************** Start of Stub Code ******************** //
	// ************************************************************ //
    /** Node<E> is an inner class and it is abstract.
     * There will be two kinds
     * of Node, one for leaves and one for internal nodes. */
    abstract static class Node implements Comparable<Node>{
        /** The frequency of all the items below this node */
        protected int frequency;
        
        public Node(int freq) {
        	this.frequency = freq;
        }
        
		/** Needed for the Minimum Heap used later in this stub. */
		public int compareTo(Node other) {
			return this.frequency - other.frequency;
		}
    }
    /** Leaves of a Huffman tree contain the data items */
    protected static class LeafNode extends Node {
        // Data Fields
        /** The data in the node */
        protected char data;
        /** Constructor to create a leaf node (i.e. no children) */
        public LeafNode(char data, int freq) {
            super(freq);
            this.data = data;
        }
        /** toString method */
        public String toString() {
            return "[value= "+this.data + ",freq= "+frequency+"]";
        }
    }
    /** Internal nodes contain no data,
     * just references to left and right subtrees */
    protected static class InternalNode extends Node {
        /** A reference to the left child */
        protected Node left;
        /** A reference to the right child */
        protected Node right;

        /** Constructor to create an internal node */
        public InternalNode(Node leftC, Node rightC) {
            super(leftC.frequency + rightC.frequency);
            left = leftC; right = rightC;
        }
        public String toString() {
            return "(freq= "+frequency+")";
        }
    }
	
	// Enough space to encode all "extended ascii" values
	// This size is probably overkill (since many of the values are not "printable" in the usual sense)
	private static final int codex_size = 256;
	
	/* Data Fields for Huffman Tree */
	private Node root;
	
	public HuffmanTree(String s) {
		root = buildHuffmanTree(s);
	}
	
	/**
	 * Returns the frequencies of all characters in s.
	 * @param s
	 * @return
	 */
	public static int[] frequency(String s) {
		int[] freq = new int[codex_size];
		for (char c: s.toCharArray()) {
			freq[c]++;
		}
		return freq;
	}
	
	/**
	 * Builds the actual Huffman tree for that particular string.
	 * @param s
	 * @return
	 */
	private static Node buildHuffmanTree(String s) {
		int[] freq = frequency(s);
		
		// Create a minimum heap for creating the Huffman Tree
		// Note to students: You probably won't know what this data structure
		// is yet, and that is okay.
		PriorityQueue<Node> min_heap = new PriorityQueue<Node>();
		
		// Go through and create all the nodes we need
		// as in, all the nodes that actually appear in our string (have a frequency greater then 0)
		for(int i = 0; i < codex_size; i++) {
			if (freq[i] > 0) {
				// Add a new node (for that character) to the min_heap, notice we have to cast our int i into a char.
				min_heap.add(new LeafNode((char) i, freq[i]));
			}
		}
		
		// Edge case (string was empty)
		if (min_heap.isEmpty()) {
			throw new NullPointerException("Cannot encode an empty String");
		}
		
		// Now to create the actual Huffman Tree 
		// NOTE: this algorithm is a bit beyond what we cover in cs284, 
		// you'll see this in depth in cs385
		
		// Merge smallest subtrees together
		while (min_heap.size() > 1) {
			Node left = min_heap.poll();
			Node right = min_heap.poll();
			Node merged_tree = new InternalNode(left, right);
			min_heap.add(merged_tree);
		}
		
		// Return our structured Huffman Tree
		return min_heap.poll();
	}
	
	// ******************** End of Stub Code ******************** //
	// ********************************************************** //

	/**
	 * Helper method for toString. Returns a string of the tree.
	 * @param current current node
	 * @param depth current depth
	 * @return the string representation of the tree
	 */
	private String preOrderTraversal(Node current, int depth) {
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < depth; i ++) {
			sb.append("  ");
		}

		if(current instanceof LeafNode) {
			sb.append(current.toString());
			sb.append("\n");
		}

		else{
			sb.append(current.toString());
			sb.append("\n");
			sb.append(preOrderTraversal(((InternalNode)current).left, depth + 1));
			sb.append(preOrderTraversal(((InternalNode)current).right, depth + 1));
		}

		return sb.toString();
	}

	/**
	 * Returns a string represenation of the tree.
	 * @return a string representation of the tree
	 */
	@Override
	public String toString() {
		// HINT: Might need helper method for preOrderTraversal
		return preOrderTraversal(root, 0);
	}

	/**
	 * Converts a boolean array into an array in bits
	 * @param encoding the boolean array
	 * @return an array made of bits
	 */
	public String bitsToString(Boolean[] encoding) {
		StringBuilder result = new StringBuilder();

		for (boolean aBoolean : encoding) {
			if (aBoolean) {
				result.append("1");
			} else {
				result.append("0");
			}
		}
		return result.toString();
	}

	/**
	 * Converts an array of bits into a boolean array
	 * @param str the string to be encoded
	 * @return boolean array
	 */

	private Boolean[] stringToBits(String str) {
		Boolean[] x = new Boolean[str.length()];

		for(int i = 0; i < str.length(); i++) {
			x[i] = str.charAt(i) == '1';
		}

		return x;
	}

	/**
	 * An algorithm that uses the Huffman Tree to decode a sequence of bits
	 * @param coding an array of bits
	 * @return an output string of a decoded array of bits
	 */
	public String decode(Boolean[] coding) {
		if(coding.length < 1) {
			throw new IllegalArgumentException("Not a valid coding!");
		}

		Node traversal = root;
		String bits = bitsToString(coding);
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < bits.length(); i++) {

			if(bits.charAt(i) == '1') {
				traversal = ((InternalNode)traversal).right;
			}
			else{
				traversal = ((InternalNode)traversal).left;
			}

			if(traversal instanceof LeafNode) {
				sb.append(((LeafNode)traversal).data);
				traversal = root;
			}
		}
		return sb.toString();
	}

	/**
	 * A helper function for encode. Looks through and finds a bit sequence for each item.
	 * @param current the current node
	 * @param b bits accumulated during recursion
	 * @param target target character
	 * @param sb a string to be appended to
	 */
	private void encodeHelper(Node current, String b, char target, StringBuilder sb) {
		// If the we find it and its a leaf and its what we're looking for, append it. If not what
		// we are looking for, return
		if(current instanceof LeafNode) {
			if(((LeafNode)current).data == target) {
				sb.append(b);
				return;
			}
			else if(((LeafNode)current).data != target){
				return;
			}
		}
		encodeHelper(((InternalNode)current).left, b + "0", target, sb);
		encodeHelper(((InternalNode)current).right, b + "1", target, sb);
	}

	/**
	 * Naive encoding. A method that encodes a string into an array of booleans using a huffman tree.
	 * @param inputText the string to encode
	 * @return an array of booleans that represent an encoded string
	 */
	public Boolean[] encode(String inputText) {
		if(inputText.length() < 1) {
			throw new IllegalArgumentException("Input has to be at least 1 character");
		}
		StringBuilder sb = new StringBuilder();
		String checker;

		for(char c : inputText.toCharArray()) {
			checker = sb.toString();
			encodeHelper(root, "", c, sb);

//			if((sb.toString().equals(checker))) {
//				throw new IllegalArgumentException();
//			}
		}
		return stringToBits(sb.toString());
	}

	private void efficientEncodeHelper(Node current, String accum, HashMap<Character, String> map) {
		// If the current node is a leaf
		if(current instanceof LeafNode) {
			map.put(((LeafNode)current).data, accum);
		}

		// If the current node is an internal node, i.e. it has children
		else if(current instanceof InternalNode) {
			efficientEncodeHelper(((InternalNode)current).left, accum + "0", map);
			efficientEncodeHelper(((InternalNode)current).right, accum + "1", map);
		}
	}

	/**
	 * A more efficient encoding way that does not have redundancies. In order to reuse the results
	 * of previous lookups we use a hashmap.
	 * @param inputText text to be encoded
	 * @return an array of booleans that represent an encoded string
	 */
	public Boolean[] efficientEncode(String inputText) {
		// NOTE: Should only go through the tree once.
		if(inputText == null || inputText.length() < 1) {
			throw new IllegalArgumentException();
		}
		StringBuilder sb = new StringBuilder();
		HashMap<Character, String> huffman = new HashMap<>();
		efficientEncodeHelper(root, "", huffman);
		for(char c : inputText.toCharArray()) {
			if(huffman.containsKey(c) == false) {
				throw new IllegalArgumentException();
			}
			sb.append(huffman.get(c));
		}
		return stringToBits(sb.toString());

	}
	
	public static void main(String[] args) {
		// Code to see if stuff works...
		String s = "Some string you want to encode";
		String u ="101010101010101";
		HuffmanTree t = new HuffmanTree(s); // Creates specific Huffman Tree for "s"
		// Now you can use encode, decode, and toString to interact with your specific Huffman Tree
	}
}
