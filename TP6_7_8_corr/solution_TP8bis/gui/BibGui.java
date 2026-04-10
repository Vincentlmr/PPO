package gui;


import java.awt.*;
import javax.swing.*;
import java.util.*;
import lib.*;

import java.awt.event.*;
import javax.swing.event.*;
import java.text.*;

import java.io.*;


public class BibGui extends JFrame {
    Bibliotheque bib = new Bibliotheque();

    Map<String,JLabel> jlabels = new TreeMap<String,JLabel>();
    Map<String,JPanel> jpanels = new TreeMap<String,JPanel>();
    Map<String,JButton> jbuttons = new TreeMap<String,JButton>();

    private JLabel bibLabel = new JLabel("", JLabel.CENTER);
    private JPanel panelAdd = new JPanel();
    private JTextField codeLabel = new JTextField("ER");
    private JTextField titreLabel = new JTextField("EE");
    private JTextField auteurLabel = new JTextField("RR");
    private JButton buttonAdd = new JButton("Add");



    public BibGui() {
        Container cp = this.getContentPane();
        cp.setLayout(new CardLayout());
        panelAdd.setLayout(new GridLayout(1,4));
        panelAdd.add(codeLabel);
        panelAdd.add(titreLabel);
        panelAdd.add(auteurLabel);
        panelAdd.add(buttonAdd);
        buttonAdd.addActionListener(e -> {
            this.add(codeLabel.getText(),new Ouvrage(titreLabel.getText(),auteurLabel.getText()));
            updateBib();
        });
        try {
            bib.load("bib.bin");
            Map<String,Ouvrage> elBib = bib.getElements();
            for (String code : elBib.keySet()) {
                this.add(code,elBib.get(code));
            }
        } catch (IOException | ClassNotFoundException ie) {
            this.add("I101",new Ouvrage("C","Kernighan"));
            this.add("L202",new Ouvrage("Germinal","Zola"));
            this.add("S303",new Ouvrage("Parapente","Ali Gali"));
            this.add("I345",new Ouvrage("Java","Eckel"));
        }
        updateBib();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    bib.save("bib.bin");
                } catch (IOException ie ) {

                }
            }
        });
    }

    public void add(String code, Ouvrage o) {
        if (!jpanels.containsKey(code)) {
            this.bib.add(code,o);
            this.jlabels.put(code,new JLabel("["+code + "] "+ o.toString(), JLabel.CENTER));
            this.jpanels.put(code,new JPanel());
            this.jbuttons.put(code,new JButton("emprunter"));
            this.jbuttons.get(code).addActionListener(new EmpruntListener(code));
            this.jpanels.get(code).setLayout(new GridLayout(1,2));
            this.jpanels.get(code).add(this.jlabels.get(code));
            this.jpanels.get(code).add(this.jbuttons.get(code));
        }
    }

    public void updateBib() {
        Container cp = this.getContentPane();
        cp.setLayout(new GridLayout(jlabels.values().size()+1,1));
        cp.add(panelAdd);

        for (JPanel p : jpanels.values()) {
            cp.add(p);
        }

        this.setVisible(false);
        this.setVisible(true);
    }

    class EmpruntListener implements ActionListener {
        String code;

        EmpruntListener(String code) {
            this.code = code;
        }

        public void actionPerformed(ActionEvent event) {
            Ouvrage o = bib.get(code);
            try {
                o.emprunter();
                jbuttons.get(code).setText("Rendre");
            } catch (NonDisponibleException nde) {
                o.retourner();
                jbuttons.get(code).setText("Emprunter");
            }
            jlabels.get(code).setText("["+code + "] "+ bib.get(code).toString());
        }
    }




}
