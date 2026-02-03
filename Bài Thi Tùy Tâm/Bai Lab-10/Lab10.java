import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Lab10 {

    public static void main(String[] args) {
        // Tạo cửa sổ Menu chính
        JFrame menuFrame = new JFrame("LAB 10: GUI Menu");
        menuFrame.setSize(400, 300);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel lblTitle = new JLabel("CHỌN BÀI TẬP (JAVA SWING)", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        menuFrame.add(lblTitle);

        JButton btnBai1 = new JButton("Bài 1: GroupLayout (3 Panel)");
        JButton btnBai2 = new JButton("Bài 2: Layout Phức Hợp (7 Panel)");
        JButton btnBai3 = new JButton("Bài 3: Màu nền & Border");

        menuFrame.add(btnBai1);
        menuFrame.add(btnBai2);
        menuFrame.add(btnBai3);

        // Xử lý sự kiện click nút
        btnBai1.addActionListener(e -> new Bai1().setVisible(true));
        btnBai2.addActionListener(e -> new Bai2().setVisible(true));
        btnBai3.addActionListener(e -> new Bai3().setVisible(true));

        menuFrame.setVisible(true);
    }

    // ========================================================
    // BÀI 1: THIẾT KẾ GIAO DIỆN SỬ DỤNG GROUPLAYOUT
    // ========================================================
    static class Bai1 extends JFrame {
        public Bai1() {
            // 1. Cấu hình cửa sổ chính
            setTitle("Lê Văn A - TT601K14 - Bài 1");
            setSize(400, 350); 
            setLocationRelativeTo(null); 
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

            // 2. Tạo 3 JPanel
            JPanel p1 = new JPanel();
            p1.setBackground(Color.YELLOW);
            p1.setPreferredSize(new Dimension(400, 100));

            JPanel p2 = new JPanel();
            p2.setBackground(Color.GREEN);
            p2.setPreferredSize(new Dimension(400, 100));

            JPanel p3 = new JPanel();
            p3.setBackground(Color.BLUE);
            p3.setPreferredSize(new Dimension(400, 100));

            // 3. Sử dụng GroupLayout
            Container contentPane = getContentPane();
            GroupLayout layout = new GroupLayout(contentPane);
            contentPane.setLayout(layout);

            // Chiều ngang: Các panel song song (chiếm hết chiều ngang)
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(p1)
                    .addComponent(p2)
                    .addComponent(p3)
            );

            // Chiều dọc: Các panel xếp nối tiếp nhau
            layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addComponent(p1)
                    .addComponent(p2)
                    .addComponent(p3)
            );
        }
    }

    // ========================================================
    // BÀI 2: GIAO DIỆN PHỨC HỢP (GRID LAYOUT + BORDER LAYOUT)
    // ========================================================
    static class Bai2 extends JFrame {
        public Bai2() {
            setTitle("Lê Văn A - TT601K14 - Bài 2");
            setSize(600, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Sử dụng GridLayout chính: 3 hàng, 1 cột
            setLayout(new GridLayout(3, 1));

            // --- HÀNG 1: 4 Panel xếp ngang ---
            JPanel row1 = new JPanel(new GridLayout(1, 4));
            row1.add(createPanel(Color.YELLOW));
            row1.add(createPanel(Color.PINK));
            row1.add(createPanel(new Color(0, 128, 128))); // Cyan đậm
            row1.add(createPanel(Color.BLACK));
            add(row1);

            // --- HÀNG 2: 2 Khu vực (Trái - Phải) ---
            JPanel row2 = new JPanel(new GridLayout(1, 2));
            row2.add(createPanel(Color.GREEN));
            row2.add(createPanel(new Color(139, 0, 0))); // Đỏ đậm
            add(row2);

            // --- HÀNG 3: 1 Panel chiếm toàn bộ ---
            JPanel row3 = new JPanel(new BorderLayout());
            row3.add(createPanel(Color.BLUE), BorderLayout.CENTER);
            add(row3);
        }

        // Hàm phụ trợ để tạo nhanh JPanel có màu
        private JPanel createPanel(Color color) {
            JPanel p = new JPanel();
            p.setBackground(color);
            p.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            return p;
        }
    }

    // ========================================================
    // BÀI 3: MÀU NỀN VÀ CÁC KIỂU VIỀN (BORDER)
    // ========================================================
    static class Bai3 extends JFrame {
        public Bai3() {
            setTitle("Lê Văn A - TT601K14 - Bài 3");
            setSize(500, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Bố cục chính: 3 hàng, khoảng cách 10px
            setLayout(new GridLayout(3, 1, 10, 10)); 

            // --- HÀNG 1: Panel 1 (Xanh nhạt, Bevel Raised) ---
            JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
            JPanel p1 = createBorderedPanel(new Color(173, 216, 230), 
                    BorderFactory.createBevelBorder(BevelBorder.RAISED)); 
            row1.add(p1);
            add(row1);

            // --- HÀNG 2: Panel Chứa (Panel 7) chứa Panel 2 và Panel 3 ---
            JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            
            JPanel p2 = createBorderedPanel(new Color(144, 238, 144), 
                    BorderFactory.createEtchedBorder()); 
            JPanel p3 = createBorderedPanel(new Color(230, 230, 250), 
                    BorderFactory.createLineBorder(Color.BLACK)); 
            
            row2.add(p2);
            row2.add(p3);
            add(row2);

            // --- HÀNG 3: Panel 4, 5, 6 ---
            JPanel row3 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));
            
            JPanel p4 = createBorderedPanel(new Color(255, 182, 193), 
                    BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED)); 
            JPanel p5 = createBorderedPanel(Color.YELLOW, 
                    new SoftBevelBorder(BevelBorder.RAISED));
            JPanel p6 = createBorderedPanel(Color.CYAN, 
                    BorderFactory.createTitledBorder("Panel 6"));
            
            row3.add(p4);
            row3.add(p5);
            row3.add(p6);
            add(row3);
        }

        // Hàm tạo Panel có kích thước 100x100, màu nền và viền
        private JPanel createBorderedPanel(Color bg, Border border) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(100, 100));
            p.setBackground(bg);
            p.setBorder(border);
            return p;
        }
    }
}