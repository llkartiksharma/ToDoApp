import javax.swing.*;
import java.awt.*;
import java.awt.event.DefaultListSelectionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.DefaultListModel;

public class ToDoApp {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Create model and list for tasks
        DefaultListModel<String> taskModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Create text field and buttons
        JTextField taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Selected");

        // Panel for input and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskInput, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add components to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        // Add task action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText().trim();
                if (!task.isEmpty()) {
                    taskModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        // Delete task action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskModel.remove(selectedIndex);
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}
