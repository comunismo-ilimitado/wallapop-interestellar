package urjc.grupoo.data;

import java.io.Serializable;

public class ClaseDePueba implements Serializable {

    public ClaseDePueba() {
    }

    public String propiedad = "";

    public void metodDePrueba(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }
}
