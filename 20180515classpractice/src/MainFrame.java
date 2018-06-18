import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private JButton jbut[][] = new JButton[4][5];
    private ImageIcon image[] = new ImageIcon[9];
    private JLabel jlb = new JLabel();
    private Container cp;
    private JPanel jpnn = new JPanel(new GridLayout());
    private JPanel jpnc = new JPanel(new GridLayout(4,5,3,3));
    int op = -1;
    double v1,v2;
    double v3 = 0;
    boolean flag = true;
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(100,100,600,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnn,BorderLayout.NORTH);
        cp.add(jpnc, BorderLayout.CENTER);
        jpnn.add(jlb);





        jbut[0][0] = new JButton("7");
        jbut[0][1] = new JButton("8");
        jbut[0][2] = new JButton("9");
        jbut[0][3] = new JButton("/");
        jbut[0][4] = new JButton("AC");
        jbut[1][0] = new JButton("4");
        jbut[1][1] = new JButton("5");
        jbut[1][2] = new JButton("6");
        jbut[1][3] = new JButton("*");
        jbut[1][4] = new JButton("sqrt");
        jbut[2][0] = new JButton("1");
        jbut[2][1] = new JButton("2");
        jbut[2][2] = new JButton("3");
        jbut[2][3] = new JButton("-");
        jbut[2][4] = new JButton("PI");
        jbut[3][0] = new JButton("0");
        jbut[3][1] = new JButton(".");
        jbut[3][2] = new JButton("=");
        jbut[3][3] = new JButton("+");
        jbut[3][4] = new JButton("EXIT");



        for (int i=0;i<4;i++){
            for (int j=0;j<5;j++){
                jpnc.add(jbut[i][j]);
            }
        }


        for (int i=0;i<4;i++){
            for (int j=0;j<5;j++){
                jbut[i][j].addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmpbut = (JButton) e.getSource();
                        switch (tmpbut.getText()){
                            case "AC":
                                jlb.setText("0");
                                op = -1;
                                break;

                            case "sqrt":
                                jlb.setText(Double.toString(Math.sqrt(Double.parseDouble(jlb.getText()))));
                                break;

                            case "PI":
                                jlb.setText(Double.toString(Math.PI));
                                break;

                            case "EXIT":
                                System.exit(0);
                                break;

                            case ".":
                                jlb.setText(jlb.getText() + ".");
                                break;

                            case "+":
                                op = 0;
                                v1 = Double.parseDouble(jlb.getText());
                                flag = false;
                                break;

                            case "-":
                                op = 1;
                                v1 = Double.parseDouble(jlb.getText());
                                flag = false;
                                break;

                            case "*":
                                op = 2;
                                v1 = Double.parseDouble(jlb.getText());
                                flag = false;
                                break;

                            case "/":
                                op = 3;
                                v1 = Double.parseDouble(jlb.getText());
                                flag = false;
                                break;

                            case "=":
                                v2 = Double.parseDouble(jlb.getText());
                                switch (op) {
                                    case 0:
                                        v3 = v1 + v2;
                                        break;

                                    case 1:
                                        v3 = v1 - v2;
                                        break;

                                    case 2:
                                        v3 = v1 * v2;
                                        break;

                                    case 3:
                                        v3 = v1 / v2;
                                        break;
                                }
                                jlb.setText(Double.toString(v3));
                                op = -1;
                                break;

                                default:
                                    if (jlb.getText().equals("0") || (op>-1&& !flag)){
                                        jlb.setText(tmpbut.getText());
                                    }else{
                                        jlb.setText(jlb.getText()+tmpbut.getText());
                                    }
                                    break;
                        }
                    }
                });
            }
        }
    }
}
