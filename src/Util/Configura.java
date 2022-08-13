
package Util;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
public class Configura {
    public static void LookAndFeel(String laf) throws ClassNotFoundException{
        try{
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if(laf.equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        }catch(UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e){
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
