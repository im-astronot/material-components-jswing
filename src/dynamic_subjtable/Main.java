/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_subjtable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAVEN
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        //  Test Data
        init();
    }

    private void init() {
        DefaultTableModel model = (DefaultTableModel) tableCustom1.getModel();
        model.addRow(new Object[]{1, "John", "$ 150", getSubTableData()});
        model.addRow(new Object[]{1, "Name", "$ 200", getSubTableData()});
        model.addRow(new Object[]{1, "Kanak", "Price", getSubTableData()});
        tableCustom1.autoRowHeight(tableCustom1);
    }

    public DefaultTableModel getSubTableData() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(4);
        data.addRow(new Object[]{new Header("No", 10), new Header("Item"), new Header("Total", 200), new Header("Detail", 200)});
        data.addRow(new Object[]{1, "ABC", "$ 50", getSubTableData1()});
        data.addRow(new Object[]{1, "Vital", "$ 70", getSubTableData1()});
        data.addRow(new Object[]{1, "Fanta", "$ 20", getSubTableData1()});
        data.addRow(new Object[]{1, "Coca", getSubTableData1(), getSubTableData1()});
        return data;
    }

    public DefaultTableModel getSubTableData1() {
        DefaultTableModel data = new DefaultTableModel();
        data.setColumnCount(3);
        data.addRow(new Object[]{new Header("No", 10), new Header("Type"), new Header("Qty")});
        data.addRow(new Object[]{1, "Unit", "50"});
        data.addRow(new Object[]{1, "Case", "70"});
        data.addRow(new Object[]{1, "Box", "3"});
        return data;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustom1 = new dynamic_subjtable.TableCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableCustom1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Customer", "Total Amount", "Product List"
            }
        ));
        jScrollPane1.setViewportView(tableCustom1);
        if (tableCustom1.getColumnModel().getColumnCount() > 0) {
            tableCustom1.getColumnModel().getColumn(3).setPreferredWidth(500);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private dynamic_subjtable.TableCustom tableCustom1;
    // End of variables declaration//GEN-END:variables
}
