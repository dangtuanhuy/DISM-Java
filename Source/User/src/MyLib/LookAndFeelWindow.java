/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mylib;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Shinichi
 */
public class LookAndFeelWindow {
    public static void LookAndFeelWindow()
    {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LookAndFeelWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LookAndFeelWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LookAndFeelWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LookAndFeelWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   
}

//doan code de thay doi icon tach cafe thanh bieu tuong cua minh
//cach dung: copy doan code phia duoi va truyen vao ten file anh da co san trong project
//try {
//            setIconImage(Toolkit.getDefaultToolkit().getImage(new File("src//Image//than.gif").getCanonicalPath()));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        };