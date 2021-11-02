import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class InterfaceGrafica extends JFrame 
{
    //instanciacao de objectos de classes auxiliares
    Validacao_Entrada validar_entrada = new Validacao_Entrada();
    Validacao_Saida validar_saida = new Validacao_Saida();
    Conversao_Decimal converter_decimal = new Conversao_Decimal();
    Conversao_Multipla converter_multiplo = new Conversao_Multipla();

    //logotipo
    private static ImageIcon logotipo;

    //Botões
    public JButton btConverter;
    //Labels
    private JLabel lbIncerir,lbResultado,lbMensagem,lbSeta,lbInformacoes,lbIconeUEM;
    //Campos de texto
    private JTextField tfEntrada,tfSaida;
    //Caixina de opcoes
    private JComboBox cbEntrada,cbSaida;

    //calegrafia dos jtextfields
    private Font calegrafia;

    ////abas
    private JTabbedPane abas;

    //painel
    private JPanel painel_principal;
    private JPanel painel_informacoes ;

    public InterfaceGrafica()
    {
        setTitle("Conversor de base"); 
        DefinicaoClasse();
        add(abas);

    }
    //Metodo para ler ficheiro txt
    public void Ler(JLabel lbInformacoes)
    {
        try {
            File ficheiro = new File("Sobre.txt");
            Scanner leitor = new Scanner(ficheiro);
            while (leitor.hasNextLine()) {
                String texto = leitor.nextLine();
                lbInformacoes.setText(texto);

            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo txt nao encontrado.");

        }

    }

    // ////look and feel
    public void LookFeel(){

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }

    }

    public void DefinicaoClasse(){
        //objectos das caixinhas de opcoes
        String bases[] = {"2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};

        //instanciando logotipo
        ImageIcon logotipo = new ImageIcon("logotipo.png");

        //instanciando a jTabbedPane
        abas = new JTabbedPane();

        //instanciando a calegrafia
        calegrafia = new Font("Courier", calegrafia.BOLD,12);

        //instanciando o botao
        btConverter = new JButton("Converter");

        //arrey de esprecoes regulares
        String [] esprecoes_regulares = {"nada","nada","^[0-1]+$","^[0-2]+$","^[0-3]+$","^[0-4]+$","^[0-5]+$","^[0-6]+$","^[0-7]+$","^[0-8]+$","^[0-9]+$","^[0-9aA]+$","^[0-9a-bA-B]+$","^[0-9a-cA-C]+$","^[0-9a-dA-D]+$","^[0-9a-eA-E]+$","^[0-9a-fA-F]+$"};

        //ActionListener do botao
        btConverter.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String strCbEntrada = cbEntrada.getSelectedItem().toString();
                    int intCbEntrada = Integer.parseInt(strCbEntrada);

                    String strCbSaida = cbSaida.getSelectedItem().toString();
                    int intCbSaida = Integer.parseInt(strCbSaida);

                    String strTfEntrada = tfEntrada.getText().toUpperCase();
                    if(strTfEntrada.matches(esprecoes_regulares[intCbEntrada])){
                        if(!("".equals(strTfEntrada))){
                            if(cbEntrada.getSelectedItem() != cbSaida.getSelectedItem()){
                                if("10".equals(strCbEntrada)){
                                    try{ int intTfEntrada = Integer.parseInt(strTfEntrada);
                                        tfSaida.setText(validar_saida.Conversao_Final(converter_multiplo.Transmudar_Final(intTfEntrada,intCbSaida)));
                                        lbMensagem.setForeground(Color.BLUE);
                                        lbMensagem.setText("Conversao bem sucedida!!!");}
                                    catch(Exception erro){
                                        lbMensagem.setForeground(Color.RED); 
                                        lbMensagem.setText("Entrada Invalida!!!");
                                    }
                                }

                                if("10".equals(strCbSaida)){
                                    try{tfSaida.setText(String.valueOf(converter_decimal.Transmudar(validar_entrada.Conversao(strTfEntrada),intCbEntrada)));
                                        lbMensagem.setForeground(Color.BLUE);
                                        lbMensagem.setText("Conversao bem sucedida!!!");}
                                    catch(Exception erro){
                                        lbMensagem.setForeground(Color.RED); 
                                        lbMensagem.setText("Entrada Invalida!!!");
                                    }
                                }

                                if(!("10".equals(strCbEntrada)) && !("10".equals(strCbSaida)) ){

                                    tfSaida.setText(validar_saida.Conversao_Final(converter_multiplo.Transmudar_Final(converter_decimal.Transmudar(validar_entrada.Conversao(strTfEntrada),intCbEntrada),intCbSaida)));
                                    lbMensagem.setForeground(Color.BLUE);
                                    lbMensagem.setText("Conversao bem sucedida!!!");

                                }
                            }
                            else if(cbEntrada.getSelectedItem() == cbSaida.getSelectedItem()){
                                lbMensagem.setForeground(Color.RED);
                                lbMensagem.setText("Erro! Selecione bases diferentes");
                            }
                        }

                    }
                    else{
                        lbMensagem.setForeground(Color.RED);
                        lbMensagem.setText("Digite um numero valido");
                    }
                }

            });

        //instanciando as labels
        lbIncerir = new JLabel("Inserir numero");
        lbResultado = new JLabel("Resultado");
        lbMensagem = new JLabel("");
        lbSeta = new JLabel(new ImageIcon("seta.png"));

        lbInformacoes = new JLabel("");
        lbIconeUEM = new JLabel(new ImageIcon("UEM.jpg"));

        //instanciando campos de texto
        tfEntrada = new JTextField(10);
        tfSaida = new JTextField(10);

        //atribuindo a calegrafia aos textfieds
        tfEntrada.setFont(calegrafia);
        tfSaida.setFont(calegrafia);

        //instanciando as caixingas de opcao e atribuido array como argumento
        cbEntrada = new JComboBox(bases);
        cbSaida = new JComboBox(bases);

        //instanciando o painel
        painel_principal = new JPanel();
        painel_informacoes = new JPanel();

        //Atribuindo qualidades da lbMensagem
        lbMensagem.setOpaque(true);
        lbMensagem.setForeground(Color.BLUE);
        lbMensagem.setBackground(Color.WHITE);
        lbMensagem.setText("Digite um numero");

        //definindo o layout dos paineis
        painel_principal.setLayout(new FlowLayout());
        painel_informacoes.setLayout(new FlowLayout());

        //chamando o metodo leitor e atribuindo a JLabel lbInformacoes como argumento
        Ler(lbInformacoes);

        //adicionando componentes ao painel de informacoes
        painel_informacoes.add(lbIconeUEM);
        painel_informacoes.add(lbInformacoes);

        //adicionar os componentes ao painel principal
        painel_principal.add(cbEntrada);
        painel_principal.add(lbSeta);
        painel_principal.add(cbSaida);
        painel_principal.add(lbIncerir);
        painel_principal.add(tfEntrada);
        painel_principal.add(btConverter);
        painel_principal.add(lbResultado);
        painel_principal.add(tfSaida);

        //adicionando legendas
        tfEntrada.setToolTipText("Incira o numero que deseja converter");
        cbEntrada.setToolTipText("Escolha a base de entrada");
        cbSaida.setToolTipText("Escolha a base pra onde deseja converter");

        //estabelece o plano onde irei adicionar os componetes
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(painel_principal,BorderLayout.NORTH);
        c.add(lbMensagem,BorderLayout.SOUTH);

        //adicionando o logotipo ao frame
        super.setIconImage(logotipo.getImage());

        //organizando os paineis em abas
        abas.add(painel_principal,"Conversor");
        abas.add(painel_informacoes,"Sobre");

        //chamando o metodo que altera a estetica
        LookFeel();

    }

    public static void main(String[]args){
        InterfaceGrafica ig = new InterfaceGrafica();
        ig.setSize(640,170);
        ig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ig.setResizable(false);
        ig.show();

    }
}
