package pset4;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class C2 {
    void forloop() {
        int count = 0;
        for (int i = 0; i < 20; i++) {
            count += 1;
            if (count % 5 == 0)
                count += 5;
            return;
        }
    }

    void whileloop() {
        boolean x = true;
        while(x) {
            if (x)
                return;
        }
    }

    void dowhileloop() {
        boolean x = true;
        do {
            if (x)
                x = false;
        } while(x);
    }
}
