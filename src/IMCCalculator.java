import javax.swing.*;

public class IMCCalculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel pesoLabel = new JLabel("Peso (Kg):");
        pesoLabel.setBounds(50, 50, 100, 30);
        frame.add(pesoLabel);

        JTextField pesoField = new JTextField();
        pesoField.setBounds(150, 50, 150, 30);
        frame.add(pesoField);

        JLabel alturaLabel = new JLabel("Altura (Cm):");
        alturaLabel.setBounds(50, 100, 100, 30);
        frame.add(alturaLabel);

        JTextField alturaField = new JTextField();
        alturaField.setBounds(150, 100, 150, 30);
        frame.add(alturaField);

        JButton calcularButton = new JButton("Calcular IMC");
        calcularButton.setBounds(100, 150, 200, 30);
        frame.add(calcularButton);

        JLabel resultadoLabel = new JLabel("");
        resultadoLabel.setBounds(50, 200, 300, 30);
        frame.add(resultadoLabel);

        calcularButton.addActionListener(_ -> {
            try {
                double peso = Double.parseDouble(pesoField.getText().replace(',','.'));
                double altura = Double.parseDouble(alturaField.getText().replace(',','.'));

                double imc = peso / (altura * altura);

                String classificacaoImc = getClassificacaoIMC(imc);

                resultadoLabel.setText(String.format("IMC: %.2f - %s", imc, classificacaoImc));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static String getClassificacaoIMC(double imc) {
        return (imc < 18.5) ? "Abaixo do peso" :
                (imc < 24.9) ? "Peso normal" :
                        (imc < 29.9) ? "Sobrepeso" :
                                (imc < 34.9) ? "Obesidade grau I" :
                                        (imc < 39.9) ? "Obesidade grau II" :
                                                "Obesidade grau III";
    }

}
