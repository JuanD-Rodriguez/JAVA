package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gestion.Medalleria;
import gestion.Medallista;
public class InterfazGrafica extends javax.swing.JFrame {

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Medalleria medalleria;

    public InterfazGrafica() {
        medalleria = new Medalleria();

        setTitle("Sistema de Medallería");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(0, 2));

        JTextField campoPais = new JTextField();
        JTextField campoNombre = new JTextField();
        JTextField campoDisciplina = new JTextField();
        JTextField campoCategoria = new JTextField();
        JTextField campoSubcategoria = new JTextField();
        JTextField campoTipoMedalla = new JTextField();
        JTextField campoAño = new JTextField();
        JTextField campoEdad = new JTextField();

        panelFormulario.add(new JLabel("País:"));
        panelFormulario.add(campoPais);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);
        panelFormulario.add(new JLabel("Disciplina:"));
        panelFormulario.add(campoDisciplina);
        panelFormulario.add(new JLabel("Categoría:"));
        panelFormulario.add(campoCategoria);
        panelFormulario.add(new JLabel("Subcategoría:"));
        panelFormulario.add(campoSubcategoria);
        panelFormulario.add(new JLabel("Tipo de Medalla:"));
        panelFormulario.add(campoTipoMedalla);
        panelFormulario.add(new JLabel("Año:"));
        panelFormulario.add(campoAño);
        panelFormulario.add(new JLabel("Edad:"));
        panelFormulario.add(campoEdad);

        JButton botonAgregar = new JButton("Agregar Medallista");
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medallista medallista = new Medallista(
                        campoPais.getText(),
                        campoNombre.getText(),
                        campoDisciplina.getText(),
                        campoCategoria.getText(),
                        campoSubcategoria.getText(),
                        campoTipoMedalla.getText(),
                        Integer.parseInt(campoAño.getText()),
                        Integer.parseInt(campoEdad.getText())
                );
                medalleria.agregarMedallista(medallista);
                JOptionPane.showMessageDialog(null, "Medallista agregado con éxito.");
            }
        });

        JButton botonListar = new JButton("Listar Medallistas");
        botonListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea areaTexto = new JTextArea();
                for (Medallista m : medalleria.listarMedallistas()) {
                    areaTexto.append(m.toString() + "\n");
                }
                JOptionPane.showMessageDialog(null, new JScrollPane(areaTexto), "Listado de Medallistas", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAgregar);
        panelBotones.add(botonListar);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica interfaz = new InterfazGrafica();
            interfaz.setVisible(true);
        });
    }
}

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

