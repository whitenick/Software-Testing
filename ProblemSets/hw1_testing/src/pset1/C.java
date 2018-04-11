package pset1;

public class C {
    int f;

    public C(int f) {
        this.f = f;
    }

    @Override
    public boolean equals(Object o) {
        if(this == null) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(this.getClass() == o.getClass()) {
            if(this.f == ((C) o).f) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 9;
        hash = 31*hash+f;
        hash =+ 31*hash+f;
        return hash;
    }
}

