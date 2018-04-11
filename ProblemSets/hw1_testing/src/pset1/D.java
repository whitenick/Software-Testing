package pset1;

public class D extends C {
    int g;

    public D(int g, int f) {
        super(f);
        this.g = g;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }

        if (this.getClass() == o.getClass()){
                if(this.g == ((D) o).g) {
                    if(this.f == ((D) o).f) {
                        return true;
                    }
                }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 8;
        hash = 31*hash+this.f*this.g;
        hash = 31*hash+this.f*this.g;
        return hash;
    }
}
