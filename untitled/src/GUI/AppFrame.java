package GUI;

import COM_DECOM.Compressor;
import COM_DECOM.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AppFrame implements ActionListener {
    JFrame frame;
    JButton compressBtn;
    JButton decompressBtn;

    public AppFrame() {
        frame = new JFrame("Compressor/Decompressor");
        frame.setLayout(null);
        this.compressBtn = new JButton("Select file to compress");
        this.decompressBtn = new JButton("Select file to decompress");

        this.compressBtn.setBounds(550, 400, 300, 50);
        this.decompressBtn.setBounds(550, 300, 300, 50);

        this.compressBtn.addActionListener(this);
        this.decompressBtn.addActionListener(this);

        frame.add(compressBtn);
        frame.add(decompressBtn);
        frame.setSize(1000, 5000);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressBtn) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Compressor.method(file);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }

        if(e.getSource() == decompressBtn) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Decompressor.method(file);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }
}
