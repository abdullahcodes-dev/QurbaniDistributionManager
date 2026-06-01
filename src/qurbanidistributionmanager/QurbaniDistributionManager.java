package qurbanidistributionmanager;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class QurbaniDistributionManager {

    public static void main(String[] args) {

        // MAIN APPLICATION WINDOW

        JFrame frame = new JFrame();

        // LABEL COMPONENTS

        JLabel titleLabel = new JLabel("Qurbani Distribution Manager");

        JLabel nameLabel = new JLabel("Recipient Name:");

        JLabel categoryLabel = new JLabel("Category:");

        JLabel quantityLabel = new JLabel("Quantity (kg):");

        JLabel areaLabel = new JLabel("Area:");

        JLabel totalLabel = new JLabel("Total Quantity Distributed: 0 kg");

        // DROPDOWN OPTIONS

        String[] categories = {"Family", "Relative", "Neighbour", "Needy"};

        // DROPDOWN COMPONENT

        JComboBox<String> categoryBox = new JComboBox<>(categories);
        
        // TEXT FIELD COMPONENTS

        JTextField nameField = new JTextField();

        JTextField quantityField = new JTextField();

        JTextField areaField = new JTextField();

        // BUTTON COMPONENTS

        JButton addButton = new JButton("Add Recipient");

        JButton deleteButton = new JButton("Delete Selected Row");

        // TABLE COLUMNS

        String[] columnNames = {"Recipient", "Category", "Quantity (kg)", "Area"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        JTable distributionTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(distributionTable);

        // COMPONENT POSITIONING

        titleLabel.setBounds(180, 10, 250, 30);

        nameLabel.setBounds(50, 50, 120, 30);

        nameField.setBounds(180, 50, 200, 30);

        addButton.setBounds(180, 300, 150, 30);

        categoryLabel.setBounds(50, 100, 120, 30);

        categoryBox.setBounds(180, 100, 200, 30);

        quantityLabel.setBounds(50, 150, 120, 30);

        quantityField.setBounds(180, 150, 200, 30);

        areaLabel.setBounds(50, 200, 120, 30);

        areaField.setBounds(180, 200, 200, 30);

        scrollPane.setBounds(50, 350, 500, 150);

        deleteButton.setBounds(350, 300, 170, 30);

        totalLabel.setBounds(50, 520, 250, 30);

        // ADD COMPONENTS TO FRAME

        frame.add(titleLabel);

        frame.add(nameLabel);

        frame.add(nameField);

        frame.add(addButton);

        frame.add(categoryLabel);

        frame.add(categoryBox);

        frame.add(quantityLabel);

        frame.add(quantityField);

        frame.add(areaLabel);

        frame.add(areaField);

        frame.add(scrollPane);

        frame.add(deleteButton);

        frame.add(totalLabel);

        loadData(tableModel, totalLabel);

        // BUTTON CLICK EVENT

        addButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                String recipientName = nameField.getText();

                String quantity = quantityField.getText();

                int quantityValue;

                String category = categoryBox.getSelectedItem().toString();

                String area = areaField.getText();

                if (recipientName.isEmpty() || quantity.isEmpty() || area.isEmpty()) {

                    JOptionPane.showMessageDialog(frame, "Please fill all fields" );

                    return;
                }

                try {

                    quantityValue = Integer.parseInt(quantity);

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(frame, "Quantity must be a number!");

                    return;

                }

                String[] rowData = {recipientName, category, quantity, area};

                tableModel.addRow(rowData);

                updateTotal(tableModel, totalLabel);

                saveData(tableModel);

                nameField.setText("");

                quantityField.setText("");

                areaField.setText("");

                categoryBox.setSelectedIndex(0);
            }

        });

        deleteButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                int selectedRow = distributionTable.getSelectedRow();

                if(selectedRow != -1) {

                    int choice = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to delete this recipient?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                    );

                    if (choice == JOptionPane.YES_OPTION) {

                        tableModel.removeRow(selectedRow);

                        updateTotal(tableModel, totalLabel);

                        saveData(tableModel);

                    }

                } else {

                    JOptionPane.showMessageDialog(frame, "Please select row first!");

                }
            }

        });

        // FRAME SETTINGS

        frame.setSize(650, 600);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(null);

        frame.setVisible(true);

    }

     public static void updateTotal(DefaultTableModel tableModel, JLabel totalLabel) {

        int total = 0;

        for (int i = 0; i < tableModel.getRowCount(); i++) {

            int rowQuantity = Integer.parseInt(tableModel.getValueAt(i, 2).toString());

            total += rowQuantity;

        }

        totalLabel.setText("Total Distributed: " + total + " KG");

    }

     public static void saveData(DefaultTableModel tableModel) {

         try {

             PrintWriter writer = new PrintWriter(new FileWriter("data.txt"));

             for (int i = 0; i < tableModel.getRowCount(); i++) {

                 String recipient = tableModel.getValueAt(i, 0).toString();

                 String category = tableModel.getValueAt(i, 1).toString();

                 String quantity = tableModel.getValueAt(i, 2).toString();

                 String area = tableModel.getValueAt(i, 3).toString();

                 writer.println(recipient + "," + category + "," + quantity + "," + area);

             }

             writer.close();

         } catch (Exception e) {

             System.out.println("Error saving file.");

         }

     }

     public static void loadData(DefaultTableModel tableModel, JLabel totalLabel) {

         try {

             File file = new File("data.txt");

             Scanner reader = new Scanner(file);

             while (reader.hasNextLine()) {

                 String line = reader.nextLine();

                 String[] rowData = line.split(",");

                 tableModel.addRow(rowData);

             }

             reader.close();

             updateTotal(tableModel, totalLabel);


         } catch (Exception e) {

             System.out.println("No previous data found!");

         }

     }


}
