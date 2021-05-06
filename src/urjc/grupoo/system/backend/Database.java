package urjc.grupoo.system.backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
*   Clase dedicada a ofrecer soporte a la carga y guardado de archivos
*   en disco.
 */
public class Database {

    // Carpeta donde se guardan los ficheros
    public static final String savefolder = "saveddata/";

    // Sufijo de archivos
    public static final String suffix = ".data";

    private HashMap<String, Container> containers;

    public Database() {

        // Inicializar variables
        containers = new HashMap<String, Container>();

        // Crear carpeta de guardado en caso de no existir
        try {
            Path path = Paths.get(savefolder);
            Files.createDirectories(path);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
    *   Añade un contenedor con un objeto, solo deberia ser llamado
    *   la primera vez que se crea.
     */
    public void addContainer(String name, Serializable object) {
        if (!containers.containsKey(name)) {
            Container c = new Container(object);
            c.setDirty(true);
            c.setLoaded(true);
            containers.put(name, c);
        }
    }

    /*
     * Indica que el contenedor esta sucio y tiene que guardarse en disco.
     */
    public void setDirty(String name) {
        containers.get(name).setDirty(true);
    }

    /*
    *   Obtener el valor de un contenedor.
     */
    public Serializable get(String name) {
        Serializable s = null;
        if (containers.containsKey(name)) {
            s = containers.get(name).get();
        }
        return s;
    }

    /*
    *   Cargar contenedores desde el disco. No carga contenedores no listados.
     */
    public void load() {
        for (String ki : containers.keySet()) {
            if (!containers.get(ki).isLoaded()) {
                containers.get(ki).setLoaded(loadContainerFromDisk(ki));
                containers.get(ki).setDirty(false);
            }
        }
    }

    /*
    *   Cargar contenedores listados o no desde la carpeta.
     */
    public void loadFolder() {
        File folder = new File(savefolder);
        File[] files = folder.listFiles();

        // Revisar archivos creados
        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName().replace(suffix, "");
                addContainer(name, null);
                containers.get(name).setLoaded(false);
            }
        }

        load();
    }

    /*
    *   Guardar contenedores en disco
     */
    public void save() {

        for (String ki : containers.keySet()) {
            if (containers.get(ki).isDirty() && containers.get(ki).isLoaded()) {
                saveContainerToDisk(ki);
                containers.get(ki).setDirty(false);
                containers.get(ki).setLoaded(true);
            }
        }
    }

    /*
    *   Guardar un contenedor individual en disco
     */
    public void saveContainerToDisk(String name) {
        try {
            File file = new File(savefolder + name + suffix);
            file.createNewFile();
            FileOutputStream fileOut
                    = new FileOutputStream(file);
            ObjectOutputStream oo = new ObjectOutputStream(fileOut);
            oo.writeObject(containers.get(name).get());
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /*
    *   Cargar un contenedor individual desde el disco.
     */
    public boolean loadContainerFromDisk(String name) {
        boolean r = false;
        try {
            File file = new File(savefolder + name + suffix);
            if (file.exists()) {
                FileInputStream fileIn
                        = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fileIn);
                Container c = new Container((Serializable) oi.readObject());
                containers.replace(name, c);
                containers.get(name).setLoaded(true);
                fileIn.close();
                r = true;
            }
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
            r = false;
        }
        return r;
    }

    public int size() {
        return containers.size();
    }

    /*
    *   Clase de soporte para la Database.
     */
    private class Container {

        private boolean loaded = false;
        private boolean dirty = false;
        private Serializable object;

        public Container(Serializable object) {
            this.object = object;
        }

        protected void setLoaded(boolean a) {
            loaded = a;
        }

        public void setDirty(boolean dirty) {
            this.dirty = dirty;
        }

        public boolean isDirty() {
            return true; // Siempre estan sucios para evitar problemas TODO resolver mejor los problemas
        }

        public Serializable get() {
            return object;
        }

        public boolean isLoaded() {
            return loaded;
        }

    }

}
