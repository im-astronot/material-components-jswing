/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_components;

/**
 *
 * @author Kanak RT
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.ComboBoxEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class MultiSelectComboBox extends JPanel {

    private JComboBox<String> comboBox;
    private MultiSelectComboBoxEditor editor;

    public MultiSelectComboBox(List<String> items) {
        setLayout(new BorderLayout());
        editor = new MultiSelectComboBoxEditor(items);
        comboBox = new JComboBox<>();
        comboBox.setEditor((ComboBoxEditor) editor);
        comboBox.setEditable(true);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editor.setItem(comboBox.getSelectedItem().toString());
            }
        });
        add(comboBox, BorderLayout.CENTER);
    }

    public List<String> getSelectedItems() {
        return editor.getSelectedItems();
    }

    private static class MultiSelectComboBoxEditor extends AbstractCellEditor implements TableCellEditor {

        private List<String> items;
        private List<JCheckBox> checkBoxes;
        private JPanel panel;

        public MultiSelectComboBoxEditor(List<String> items) {
            this.items = items;
            checkBoxes = new ArrayList<>();
            panel = new JPanel();
            for (String item : items) {
                JCheckBox checkBox = new JCheckBox(item);
                checkBoxes.add(checkBox);
                panel.add(checkBox);
            }
        }

        public void setItem(String selectedItem) {
            for (JCheckBox checkBox : checkBoxes) {
                checkBox.setSelected(false);
                if (checkBox.getText().equals(selectedItem)) {
                    checkBox.setSelected(true);
                }
            }
        }

        public List<String> getSelectedItems() {
            List<String> selectedItems = new ArrayList<>();
            for (JCheckBox checkBox : checkBoxes) {
                if (checkBox.isSelected()) {
                    selectedItems.add(checkBox.getText());
                }
            }
            return selectedItems;
        }

        @Override
        public Object getCellEditorValue() {
            return getSelectedItems().toString();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            setItem(value.toString());
            return panel;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        List<String> items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        MultiSelectComboBox comboBox = new MultiSelectComboBox(items);
        frame.getContentPane().add(comboBox);
        frame.pack();
        frame.setVisible(true);
    }
}

