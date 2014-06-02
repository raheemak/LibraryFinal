

public class BinSearch {

    public static int binSearch ( int[] a, int target ) {
	return binSearchRec( a, target, 0, a.length-1 );
    }


    public static int binSearchRec( int[] a, int target, int lo, int hi ) {
	int tPos = -1;
	int m = (lo + hi) / 2;

	if (lo > hi)
	    return tPos;

	if ( a[m] == target ) 
	    tPos = m;
	else if ( a[m] > target ) 
	    tPos = binSearchRec( a, target, lo, m-1 ); 
	else if ( a[m] < target ) 
	    tPos = binSearchRec( a, target, m+1, hi );

	return tPos;
    }


    public static int binSearchIter( int[] a, int target, int lo, int hi ) {
	int tPos = -1; 
	int m = (lo + hi) / 2; 

	while( lo <= hi ) { 
	    m = (lo + hi) / 2; 
	    if ( a[m] == target ) 
		return m;
	    else if ( a[m] > target ) 
		hi = m - 1;
	    else if ( a[m] < target )
		lo = m + 1; 
	}
	return tPos;
    }

    private static boolean isSorted( int[] arr ) {

	boolean retBoo = true;

	for( int i=0; i < arr.length-1; i++ ) {
	    if ( !( arr[i] < arr[i+1] ) ) {
		return false;
	    }
	}
	return retBoo;
    }


    private static void printArray( int[] arr ) {
	String output = "[ "; 

	for( int i : arr )
	    output += i + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }
    
    
}
