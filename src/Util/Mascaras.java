
package Util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Gabriel Gomes Macedo N6598A4 CC4P33
 */
public class Mascaras {
    
    public static DefaultFormatterFactory getCpfMask(){
        MaskFormatter mask = null;
        
        try{
            mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException ex){
            return null;
        }
        return(new DefaultFormatterFactory(mask, mask));
    }
    
    public static DefaultFormatterFactory getFoneMask(){
        MaskFormatter mask = null;
        
        try{
            mask = new MaskFormatter("(##) ####-####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException ex){
            return null;
        }
        return(new DefaultFormatterFactory(mask, mask));
        
    }
    
    public static DefaultFormatterFactory getCellMask(){
        MaskFormatter mask = null;
        
        try{
            mask = new MaskFormatter("(##) # ####-####");
            mask.setPlaceholderCharacter('_');
        }catch(ParseException ex){
            return null;
        }
        return(new DefaultFormatterFactory(mask, mask));    
    }
    
    public static DefaultFormatterFactory getValorMask(){
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        df.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormatter nf = new NumberFormatter();
        nf.setAllowsInvalid(false);
        nf.setMinimum(0.00);
        nf.setMaximum(99999.99);
        return (new DefaultFormatterFactory(nf));
    }
    
    
    
}
