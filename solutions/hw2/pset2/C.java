package pset2;


/**
*
* @author  Cagdas Yelen
* @since   03-15-2017 
*/

public class C {     
	String s;
    public C(String s) 
    {         
    	this.s = s;     
    }

    @Override     
    public boolean equals(Object o) {
        // returns a boolean consistent with the Java contract for equals method;         
        // returns true if and only if o is an object of class         
        // C and has the same value for field f as this.f         
        if (o != null && o.getClass() == C.class) {             
        	C other = (C) o;     

        	if(this.s == null){
        		return other.s == null;
        	}else{
        		return this.s.equals(other.s);
        	}
        	       
        }         
        return false;     
    }




    @Override
    public int hashCode() {

        if(s == null)
            return 0;
        
        int result = 0;
        final int base = 31;
        for(int n = 0; n < s.length(); n++){
            result += ((int)s.charAt(n) * Math.pow(base, n)); 
        }
        return result;

    }  



}