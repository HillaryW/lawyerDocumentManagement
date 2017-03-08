package Application;

/**
 * Created by centhian on 3/7/17.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ApplicationDriver {

    private JFrame frame;
    private UploadDriver uploadMenu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ApplicationDriver window = new ApplicationDriver();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ApplicationDriver() {
        initialize();
        this.uploadMenu = new UploadDriver(frame);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Document Management System");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        setMainMenu();
    }

    private void reset(){
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
    }

    private void backButton() {
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 250, 87, 23);
        frame.getContentPane().add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
                setMainMenu();
            }
        });
    }

    public void setMainMenu() {

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(10, 21, 87, 23);
        frame.getContentPane().add(btnSearch);

        JButton btnUpload = new JButton("Upload");
        btnUpload.setBounds(10, 71, 87, 23);
        frame.getContentPane().add(btnUpload);


        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchDriver driver = new SearchDriver(frame);
                driver.reset();
                backButton();
            }
        });

        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UploadDriver driver = new UploadDriver(frame);
                driver.reset();
                backButton();

            }
        });
    }
}
