package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.setDisplayStatView(false);
        
        app.start();
    }
    
    Geometry g1;
    Geometry g2;
    Geometry g3;
    Geometry g4;
    int contador;
    float i;
    
    
    @Override
    public void simpleInitApp() {
        
        i = 0f;
        contador = 0;
        flyCam.setMoveSpeed(100f);
        
        
        g1 = crearGeometria(new Vector3f(5f, 5f, 5f));
        g2 = crearGeometria(new Vector3f(0f, 0f, 0f));
        g3 = crearGeometria(new Vector3f(-5f, -5f, -5f));
        g4 = crearGeometria(new Vector3f(10f, 10f, 10f));
        
        

        rootNode.attachChild(g1);
        rootNode.attachChild(g2);
        rootNode.attachChild(g3);
        rootNode.attachChild(g4);
    }

    @Override
    public void simpleUpdate(float tpf) {
        
        i+=tpf;
        Quaternion q1 = new Quaternion();
        q1.fromAngleAxis(i*2, new Vector3f(1, 1, 1));
        g2.setLocalRotation(q1);
        
        
        
        
        //g3.setLocalTranslation(i*2, new Vector3f(1, 1, 1));
        
        contador++;
        
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

    private Geometry crearGeometria(Vector3f vector3f) {
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box"+contador, b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.randomColor());
        geom.setMaterial(mat);

        geom.setLocalTranslation(vector3f);
        contador ++;
        
        return geom;
        
    }
}
