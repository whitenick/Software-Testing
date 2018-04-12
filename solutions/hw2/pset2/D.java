package pset2;


/**
*
* @author  Cagdas Yelen
* @since   03-15-2017 
*/


public class D extends C {
    int g;
    public D(String s, int g) {
        super(s);
		this.g = g; 
	}

    @Override
    public boolean equals(Object o) {
    	if (o == null) 
            return false;
        
        if (o.getClass() != D.class) 
            return false;
        
        D other = (D) o;
        if ((this.s == null) ? (other.s != null) : !this.s.equals(other.s)) 
            return false;
        
        if (this.g != other.g) {
            return false;
        }
        return true;
    }
	@Override
	public int hashCode() {

        if(this.s == null)
            return 0;

        String str = s +  Integer.toString(this.g);

        int hash = 0;
        final int base = 31;
        for(int n = 0; n < str.length(); n++){
            hash += ((int)str.charAt(n) * Math.pow(base, n)); 
        }
        return hash;
	}
}