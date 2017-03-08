package Application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by centhian on 3/7/17.
 */
public class SearchDriver {
    private JFrame frame;
    private JTextField txtPath;
    private JList list;
    private ArrayList<String> results;

    SearchDriver (JFrame frame) {
        this.frame = frame;
    }

    public void reset(){
        frame.getContentPane().removeAll();
        initialize();
        frame.revalidate();
        frame.repaint();
    }

    private void initialize() {

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(10, 41, 87, 23);
        frame.getContentPane().add(btnSearch);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(120, 41, 87, 23);
        frame.getContentPane().add(btnClear);

        txtPath = new JTextField();
        txtPath.setBounds(10, 10, 414, 21);
        txtPath.setColumns(10);
        frame.getContentPane().add(txtPath);

        String[] startingList = {"No files found"};

        list = new JList(startingList);
        list.setBounds(10, 80, 414, 40);
        frame.getContentPane().add(list);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String keyword = txtPath.getText();
                if (keyword.equals("") || keyword.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Keyword is required to search.");
                } else {
                    results = BackEndDriver.getResults(BackEndDriver.searchDocuments(keyword));
                    String[] listArray = new String[results.size()];
                    for (int i = 0; i < listArray.length; i++) {
                        listArray[i] = results.get(i);
                    }
                    frame.getContentPane().remove(list);
                    list = new JList(listArray);
                    list.setBounds(10, 80, 414, 40);
                    frame.getContentPane().add(list);
                    frame.revalidate();
                    frame.repaint();
                    System.out.println("Searched");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtPath.setText("");
            }

        });
    }
}

