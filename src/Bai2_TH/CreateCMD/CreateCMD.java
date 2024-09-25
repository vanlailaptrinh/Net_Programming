package Bai2_TH.CreateCMD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateCMD extends JFrame {
    private JTextField textField;  // Dòng nhập lệnh
    private JLabel label;
    String location ;// Nhãn để hiển thị đường dẫn

    public CreateCMD() {
        setTitle("Command Line Simulator");
        setSize(800, 600);
        setLocationRelativeTo(null);  // Căn giữa màn hình

        // Tạo panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());  // Sử dụng BorderLayout
        mainPanel.setBackground(Color.BLACK);     // Đặt màu nền đen cho panel chính

        // Panel cho dòng lệnh nhập
        JPanel cmdPanel = new JPanel();
        cmdPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  // Bố cục dòng cho JLabel và JTextField
        cmdPanel.setBackground(Color.BLACK);

        // Tạo JLabel để hiển thị đường dẫn
        location ="C:\\Users\\Van Tran>" ;
        label = new JLabel(location);
        label.setForeground(Color.WHITE);  // Màu chữ trắng
        label.setFont(new Font("Monospaced", Font.PLAIN, 16));  // Font chữ CMD
        cmdPanel.add(label);  // Thêm JLabel vào panel

        // Tạo JTextField để nhập liệu
        textField = new JTextField(40);  // Độ dài của trường nhập
        textField.setBackground(Color.BLACK);   // Màu nền đen
        textField.setForeground(Color.white);   // Màu chữ xanh lá giống CMD
        textField.setFont(new Font("Monospaced", Font.PLAIN, 16));  // Font chữ CMD
        textField.setBorder(BorderFactory.createEmptyBorder());  // Loại bỏ viền
        textField.setCaretColor(Color.GREEN);   // Màu con trỏ chuột xanh lá giống CMD
        cmdPanel.add(textField);  // Thêm JTextField vào panel

        // Thêm panel dòng lệnh vào panel chính
        mainPanel.add(cmdPanel, BorderLayout.NORTH);  // Đặt ở phía trên cùng của cửa sổ

        // Thêm panel chính vào frame
        this.add(mainPanel);

        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String a = textField.getText();
                    String b ;
                    if (a.equals("EXIT")) {
                        dispose();
                    }
                    if (a.equals("CD")){
                        textField.setText("");
                    }
                    if (a.contains("CD ")) {
                            b = a.replace("CD", "").trim();
                            location ="C:\\Users\\Van Tran\\"+b +">";
                            label.setText(location);
                            textField.setText("");


                    }
                }
            }
        });

        // Thiết lập frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateCMD();  // Khởi chạy giao diện
            }
        });
    }
}
