
package popupmenu;

import java.awt.event.*;
import javax.swing.*;

public class JPopupMenuwithSubMenuTest extends JFrame {
   private JPopupMenu popup;
   private JMenu subMenu;
   //private JMenu subsubMenu;
   
   public JPopupMenuwithSubMenuTest() {
      
      popup = new JPopupMenu();
      popup.add(new JMenuItem("Add Tag"));
      popup.add(new JMenuItem("Update Tag"));
      
      subMenu = new JMenu("Delete Tag");
      subMenu.add("Tag 1");
      subMenu.add("Tag 2");
      subMenu.add("Tag 3");
      subMenu.add("Tag 3");
      
      /*subMenu = new JMenu("Tag 1");
      subsubMenu.add("Item 1");
      subsubMenu.add("Item 2");
      subsubMenu.add("Item 3");
      subsubMenu.add("Item 4");*/
      
      popup.addSeparator();
      popup.add(subMenu);
      addMouseListener(new MouseAdapter() {
         public void mouseReleased(MouseEvent me) {
            showPopup(me);
         }
         
         public void showPopup(MouseEvent me) {
            if(me.isPopupTrigger()) {
                popup.show(me.getComponent(), me.getX(), me.getY());
                
            }
            
         }
         /*public void showsubPopup(MouseEvent me) {
            if(me.isPopupTrigger()) {
                subMenu.show(me.getComponent(), me.getX(), me.getY());
                
            }
            
         }*/
      }) ;
      
      setSize(400, 275);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   
   public static void main(String args[]) {
      new JPopupMenuwithSubMenuTest();
      
   }
}
