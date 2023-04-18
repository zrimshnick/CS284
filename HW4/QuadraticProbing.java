import java.util.Scanner;

// QuadraticProbing Hash table class
//
// CONSTRUCTION: an approximate initial size or default of 11
//
// ******************PUBLIC OPERATIONS*********************
// bool insert( x )       --> Insert x
// bool remove( x )       --> Remove x
// bool contains( x )     --> Return true if x is present
// void makeEmpty( )      --> Remove all items


/**
 * Probing table implementation of hash tables.
 * Note that all "matching" is based on the equals method.
 * @author Mark Allen Weiss
 */

// Zachary Rimshnick
// I pledge my honor that I have abided by the Stevens Honor System.

public class QuadraticProbing<AnyType>
{
    /**
     * Construct the hash table.
     */
    public QuadraticProbing( )
    {
        this( DEFAULT_TABLE_SIZE );
    }

    /**
     * Construct the hash table.
     * @param size the approximate initial size.
     */
    public QuadraticProbing( int size )
    {
        allocateArray( size );
        makeEmpty( );
    }

    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        // Insert x as active
        int currentPos = findPos( x );
        if( isActive( currentPos ) )
            return;

        array[ currentPos ] = new HashEntry<AnyType>( x, true );

        // Rehash; see Section 5.5
        if( ++currentSize > array.length / 2 )
            rehash( );
    }

    /**
     * Expand the hash table.
     */
    private void rehash( )
    {
        HashEntry<AnyType> [ ] oldArray = array;

        // Create a new double-sized, empty table
        allocateArray( nextPrime( 2 * oldArray.length ) );
        currentSize = 0;

        // Copy table over
        for( int i = 0; i < oldArray.length; i++ )
            if( oldArray[ i ] != null && oldArray[ i ].isActive )
                insert( oldArray[ i ].element );
    }

    /**
     * Method that performs quadratic probing resolution.
     * Assumes table is at least half empty and table length is prime.
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    public int findProbing( AnyType x )   /////// 
    {
    	int temp_num_collision = 1;
        int offset = 1;
        int currentPos = myhash( x );

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
        	temp_num_collision++;
            num_collision_++;   ///////////////////////
            // 23 offset = 1
            // 24 offset = 3   23 + 1
            // 27 offset = 5   23 + 4
            // 32 offset = 7   23 + 9

            //                 23 + n*n
            currentPos += offset;  // Compute ith probe
            offset += 2;
            if( currentPos >= array.length )
                currentPos -= array.length;
            //return temp_num_collision;
        }
        
        return temp_num_collision;
    }
    public int findPos( AnyType x )   /////// 
    {
    	//temp_num_collision = 0;
        int offset = 1;
        int currentPos = myhash( x );

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
        	//temp_num_collision++;
            num_collision_++;   ///////////////////////
            // 23 offset = 1
            // 24 offset = 3   23 + 1
            // 27 offset = 5   23 + 4
            // 32 offset = 7   23 + 9

            //                 23 + n*n
            currentPos += offset;  // Compute ith probe
            offset += 2;
            if( currentPos >= array.length )
                currentPos -= array.length;
        }
        
        return currentPos;
        //return num_collision_;
    }

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        int currentPos = findPos( x );
        if( isActive( currentPos ) )
            array[ currentPos ].isActive = false;
    }

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return the matching item.
     */
    public boolean contains( AnyType x )
    {
        int currentPos = findPos( x );
        return isActive( currentPos );
    }

    /**
     * Return true if currentPos exists and is active.
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    private boolean isActive( int currentPos )
    {
        return array[ currentPos ] != null && array[ currentPos ].isActive;
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
        for( int i = 0; i < array.length; i++ )
            array[ i ] = null;
    }

    private int myhash( AnyType x )
    {
        int hashVal = x.hashCode( );

        hashVal %= array.length;
        if( hashVal < 0 )
            hashVal += array.length;

        return hashVal;
    }

    private static class HashEntry<AnyType>
    {
        public AnyType  element;   // the element
        public boolean isActive;  // false if marked deleted

        public HashEntry( AnyType e )
        {
            this( e, true );
        }

        public HashEntry( AnyType e, boolean i )
        {
            element  = e;
            isActive = i;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<AnyType> [ ] array; // The array of elements
    private int currentSize;              // The number of occupied cells
    int num_collision_;
    //int temp_num_collision;

    /**
     * Internal method to allocate array.
     * @param arraySize the size of the array.
     */
    @SuppressWarnings("unchecked")
    private void allocateArray( int arraySize )
    {
        array = new HashEntry[ nextPrime( arraySize ) ];
    }

    void resetCollision() {
        num_collision_ = 0;
    }

    int getNumCollisions() {
        return num_collision_;
    }

    int getNumElements() {
        return currentSize;
    }

    int getSize() {
        return array.length;
    }


    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime( int n )
    {
        if( n <= 0 )
            n = 3;

        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }


    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }


    // Simple main
    public static void main( String [ ] args )
    {
        QuadraticProbing<String> H = new QuadraticProbing<String>( );

        System.out.println(H.getSize());
        System.out.println(H);

        final int NUMS = 400000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );
        
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            H.insert( ""+i );
        for( int i = 1; i < NUMS; i+= 2 )
            H.remove( ""+i );

        for( int i = 2; i < NUMS; i+=2 )
            if( !H.contains( ""+i ) )
                System.out.println( "Find fails " + i );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( H.contains( ""+i ) )
                System.out.println( "OOPS!!! " +  i  );
        }
        
        
    }


}
