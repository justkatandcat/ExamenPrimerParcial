package examenconvertir;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Juárez Alcantar Katia Fernanda
 */
public class Convertir extends JFrame {

    JTextField teclas;
    double resultado;
    String operacion;
    JPanel Digitos, Opciones;
    boolean opera = true;
    

    public Convertir() {
        super();
        //Caracteristicas de la ventana
        setSize(400, 400);
        setTitle("Examen Pesos a Dolares");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

           // Campo de texto donde aparecen los numeros pulsados
        teclas = new JTextField("0", 20);
        teclas.setBorder(new EmptyBorder(4, 4, 4, 4));
        teclas.setEditable(false);
        teclas.setHorizontalAlignment(JTextField.RIGHT);
        panel.add("North", teclas);

        //Agrega los numeros con digitos
        Digitos = new JPanel();
        Digitos.setLayout(new GridLayout(4, 3));
        Digitos.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int i=9; i>=0; i--) {
            newButtonD("" + i);

        }
        panel.add("Center", Digitos);
        
        //Agrega los numeros con opciones convertir y limpiar
        Opciones = new JPanel();
        Opciones.setLayout(new GridLayout(6, 1));
        Opciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        newButtonO("Convertir");
        newButtonO("Limpiar");

        panel.add("East", Opciones);

        validate();

    }
    //Agrega los botones numericos al panel
    private void newButtonD(String digit) {
        JButton btn = new JButton();
        btn.setText(digit);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent ev) {
                JButton btn = (JButton) ev.getSource();
                numeroPulsado(btn.getText());
            }
        });
        Digitos.add(btn);
    }


    //Metodo que agrega los botones de operacion Convertir y Limpiar
    private void newButtonO(String operacion) {
        JButton btn = new JButton(operacion);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent ev) {
                JButton btn = (JButton) ev.getSource();
                oPulsado(btn.getText());
            }
        });

        Opciones.add(btn);
    }
    
    //Agrega al campo de texto los numeros pulsados
        private void numeroPulsado(String digito) {
        if (teclas.getText().equals("0") || opera) {
            teclas.setText(digito);
        } else {
            teclas.setText(teclas.getText() + digito);
        }
        opera = false;
    }

        //Metodo que realiza las conversiones y limpia el campo de texto
    private void oPulsado(String dato) {
        if (dato.equals("Convertir")) {
            resultado = new Double(teclas.getText());
            resultado = (resultado / 17);
            teclas.setText("" + resultado);
            operacion = "";
        } else if (dato.equals("Limpiar")) {
            teclas.setText("0");
            resultado = 0;
            opera = true;
        }

        opera = true;
    }

}
