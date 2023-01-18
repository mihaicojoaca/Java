package org.example;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        tableExample();
    }
    public static String[][] convertListToMatrix(List<Person>persons){
        String[][] matrix=new String[100][100];
        AtomicInteger counter =new AtomicInteger(0);
        persons.forEach(person-> {


            matrix[counter.get()][0] = person.getName();
            matrix[counter.get()][1] = person.getAge().toString();
            matrix[counter.get()][2] = person.getPassedExam().toString();

            Set<String> setOfGrades=person.getGrades().stream()
                    .map(n->n.toString())
                    .collect(Collectors.toSet());
            String stringOfGrades=String.join(",",setOfGrades);
            matrix[counter.get()][3]=stringOfGrades;
            counter.incrementAndGet();
        });
        return matrix;
    }

    private static void tableExample() {
        JFrame f =new JFrame();
        f.getContentPane().setLayout(new FlowLayout());
        FileUtility.writeToFile();
        List<Person> persons = FileUtility.readFromFile();
        String[] column ={"name","age","Passed exam","Grades"};
        JTable jt = new JTable(convertListToMatrix(persons), column);
        jt.setBounds(0,100,200,300);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(0, 100, 200, 300);
        JButton addButton = new JButton("Add");
        addButton.setBounds(10, 200, 95, 30);
        ActionListener addAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JDialog dialog = new JDialog();
                    dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setBounds(500, 500, 500, 500);
                    dialog.setVisible(true);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        addButton.addActionListener(addAction);
        f.add(addButton);
        f.add(sp);
        f.getContentPane().setLayout(new FlowLayout());
        f.setSize(600, 1000);
        f.setVisible(true);
    }

}