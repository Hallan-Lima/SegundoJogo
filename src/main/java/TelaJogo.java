import Construtor.ConstrutorJogo;
import InterfaceContainer.Container;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @author hlima
 * 
 * Ctrl + Alt + K = para marcação
 * 
 *  NAVEGAÇÃO RAPIDA
 * 
 * -> topicos importantes começa com '#'
 * 
 * Sair, Opções123, 
 * 
 * FAZER    --> comentarios que precisa implementar melhoria
 * 
 * 
 */
public class TelaJogo extends javax.swing.JFrame {
    
    /**
     * Vt           -> variavel temporaria
     * delay        -> tempo para realizar o delay
     * QtTurno      -> qt de dias para gerar uma "tecnologia"...
     * Valor        -> variavel temporaria
     */
    int StatusTristezaPessoas,      StatusTristezaAlimentos,    StatusTristezaRiquezas, StatusTristezaSoldados,
    	StatusRaivaPessoas, 	    StatusRaivaRiquezas,    	StatusRaivaArmas,   	StatusRaivaSoldados,
        StatusFelicidadePessoas,	StatusFelicidadeAlimentos,	StatusFelicidadeVilas,	StatusFelicidadeRiquezas,	
        StatusFelicidadeArmas,	    StatusFelicidadeSoldados,   StatusSoma,             sentimento10,
        sentimento20,               sentimento30,               sentimento40,           sentimento50, 
        StatusFelicidade,           StatusTristeza,             StatusRaiva,            QtRodada,
        QtRiquezas,                 QtArmas,                    QtSoldados,             Status, 
        Vt,                         VtPrimeirosPassos=0,        Valor,                  debug=0, 
        QtDias,                     QtTrabalhadores,            QtFazendas,             VtHistoria,
        QtAlimentos=100,            QtPessoas=10,               QtVilas=1,              delay1=10000000,
        delay2=4000,                QtTurnos,                   QtMoedas,               QtBarraOuro;
    
    private int valorA=102, valorB=102, valorC=102;
    String nome;                                                // nome do jogador
    
    Random aleatorio = new Random();                            // gerador de numeros
    ConstrutorJogo construtor = new ConstrutorJogo();

    public TelaJogo() {                                             // função para iniciar programa
        initComponents();
        Jogo();
    }
    
    public void exportaNome(ConstrutorJogo construtor) {            // pegar o nome do usuario
        lblNomeReino.setText(construtor.getNomeReino());
        nome = construtor.getNome();
    }
   
    public void ContagemTempo(){                                    // função para contar o tempo                                

        QtRodada++;
        QtTurnos++;

        if (QtTurnos == 7) {                            // a cada 2,333 dias
            CienciaTec();            
            Soldados();
        }

        if (QtRodada == 3) {
                
            QtDias++;
            Fazendas();
            Minerador();
            QtRodada=0;

        }else{};

        Timer timer = new Timer();
        
        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
                
            Valor = aleatorio.nextInt((QtAlimentos/10)+(QtPessoas/10));
            QtAlimentos -= Valor;

            }
        };
        timer.schedule(tarea, 0, 500000);
    }
    
    void IniciarAtualizar(){                                        // função para validar e atualizar valores dentro de variaveis

        if (VtPrimeirosPassos==0) {                                 //reiniciar valores (jogar novamente)

            StatusTristezaPessoas       = 0;
            StatusTristezaAlimentos     = 0;
            StatusTristezaRiquezas      = 0;
            StatusTristezaSoldados      = 0;
            StatusRaivaPessoas          = 0;
            StatusRaivaRiquezas         = 0;
            StatusRaivaArmas            = 0;
            StatusRaivaSoldados         = 0;
            StatusFelicidadePessoas     = 100;
            StatusFelicidadeAlimentos   = 100;
            StatusFelicidadeVilas       = 100;
            StatusFelicidadeRiquezas    = 100;
            StatusFelicidadeArmas       = 100;
            StatusFelicidadeSoldados    = 0;
            
            QtAlimentos     = 100;
            QtPessoas       = 10;
            QtRiquezas      = 0;
            QtArmas         = 0;
            QtSoldados      = 0;
            QtVilas         = 1;
            QtDias          = 0;
            Vt              = 0;
            QtDias          = 0;
            QtRodada        = 0;
            QtMoedas        = 0;
            QtBarraOuro     = 0;

            btnOp1.setEnabled(true);
            btnOp2.setEnabled(true);
            btnOp3.setEnabled(true);
            btnCentral.setEnabled(true);
            btnCentral.setText("Tarefas");
            btnSair.setText("Sair do Jogo");
            
        } else {
            
            QtAlimentos = (QtAlimentos > 100)? 100: QtAlimentos;                //validando valor dentro da variavel

            lblValoresAlimentos.setText(    Integer.toString(QtAlimentos)   +"%");
            lblValoresPessoas.setText(      Integer.toString(QtPessoas)     );
            lblValoresRiquezas.setText(     Integer.toString(QtRiquezas)    );
            lblValoresArmas.setText(        Integer.toString(QtArmas)       );
            lblValoresSoldados.setText(     Integer.toString(QtSoldados)    );
            lblValoresVilas.setText(        Integer.toString(QtVilas)       );
            lblValoresDias.setText(         Integer.toString(QtDias)        );
        }
        Status();
        LimparOp();        
    }
        
    void LimparOp(){                                                // limpar as opções 
        btnOp1.setText("-");
        btnOp2.setText("-");
        btnOp3.setText("-");
        btnOp1.setEnabled(true);
        btnOp2.setEnabled(true);
        btnOp3.setEnabled(true);
    }
 
    void PrimeirosPassos(){                                         // tutorial
        
        if (Vt==2) {
            btnOp1.setText("Ok");
                        
            switch (VtPrimeirosPassos) {
                case 1:
            
                lblMsg.setText("<html>No canto direito podemos observa<br/> a quantidade de pessoas que <br/>temos em nossa vila.<br/><br/> Atualmente temos 10 Pessoas.</html>");
                    
                break;
                case 2:
            
                lblMsg.setText("<html>Abaixo temos os alimentos das vilas,<br/> nunca deixe abaixo da metade.<br/> Isso pode gerar um pouco de <br/> confusão nas cidades!<br/><br/></html>");
                    
                break;
                case 3:
                    
                lblMsg.setText("<html>Como estamos começando,<br/> temos apenas uma vila... <br/>mas tenho certeza que vamos<br/> conseguir muito mais!</html>");

                break;
                case 4:

                lblMsg.setText("<html>E não podemos esquecer<br/> as nossas riquezas! <br/> quanto maior for o nosso posicionamento<br/> mais feliz os cidadões ficam! <br/> mas cuidado, isso tambem pode atrair latroes!</html>");

                break;
                case 5:

                lblMsg.setText("<html>Ao lado esquerdo<br/> podemos observar quantos </br> soltados temos.<br/> Quanto mais melhor! <br/> isso deixa as vilas mais seguras </html>");

                break;
                case 6:

                lblMsg.setText("<html>Abaixo temos as armas,<br/> precisamos sempre estar<br/> armados para futuros confrontos.</html>");

                break;
                case 7:

                lblMsg.setText("<html>E por fim, temos o status<br/> fique de olhada para saber como as<br/> coisas estão indo.</html>");

                break;
                case 8:

                lblMsg.setText("<html>Agora vamos trabalhar!</html>");
                btnOp1.setText("Vamos la!");

                break;
            }
          
        }else{
        lblMsg.setText("<html>Ola, seja bem vindo! <br/> estou aqui para te ensinar meu lorde!<br/><br/>Gostaria de um tutorial?</html>");
        btnOp1.setText("Sim");
        btnOp3.setText("Não");
        Vt=1;           //variavel para tutorial
        
        }
    }
   
    void Historia(){                                                // função da historia do jogo              

        Valor           = aleatorio.nextInt(7)+1;
        sentimento10    = (aleatorio.nextInt(10)+5);
        sentimento20    = (aleatorio.nextInt(20)+5);
        sentimento30    = (aleatorio.nextInt(30)+5);
        sentimento40    = (aleatorio.nextInt(40)+5);
        sentimento50    = (aleatorio.nextInt(50)+5);

        if ((StatusRaivaPessoas <= -50 || StatusFelicidadePessoas <= 50) && (VtHistoria == 0)) {

            Valor = (StatusRaivaPessoas <= -50)?        21 : Valor;
            Valor = (StatusFelicidadePessoas <= 50)?    22 : Valor;
            
            switch (Valor) {
                case 21:
                    lblMsg.setText("<html>Ola Sr."+nome+"<br/>As pessoas estão muito irritadas<br/>O que devemos fazer?</html>");
                    btnOp1.setText("Vamos fazer uma festa!");
                    btnOp2.setText("Não a pq ficarem irritados.");
                    btnOp3.setText("Uma hora vai passar...");
                    Vt=21;
                    VtHistoria++;
                break;
                case 22:
                    lblMsg.setText("<html>Ola Sr."+nome+"<br/>As pessoas estão ficando infeliz<br/>O que devemos fazer?</html>");
                    btnOp1.setText("Vamos fazer uma festa!");
                    btnOp2.setEnabled(false);
                    btnOp2.setText("-");
                    btnOp3.setText("Uma hora vai passar...");
                    Vt=22;
                    VtHistoria++;
                break;
            }
            
        } else {
                    
        switch (Valor) {                    //INCLUIR MAIS "HISTORIAS" ou "Cases"
            case 1:
                lblMsg.setText("<html>Ola Sr."+nome+"<br/>Estamos aqui pois chegou alguns nomades<br/> que querem viver aqui.<br/><br/>Eles podem fica?</html>");
                btnOp1.setText("Sim");
                btnOp2.setEnabled(false);
                btnOp2.setText("-");
                btnOp3.setText("Não");
                Vt=11;               //Numero da historia nos botões
            break;
            case 2:
                lblMsg.setText("<html>Ola Sr."+nome+"<br/>um grupo de pessoas estão<br/>indo embora,<br/><br/>o que devemos fazer?</html>");
                btnOp1.setText("Deixar eles irem");
                btnOp2.setText("Pedir para ficar");
                btnOp3.setText("Não deixar ninguem ir");
                Vt=12;              //Numero da historia nos botões
            break;
            case 3:
                lblMsg.setText("<html>Sr."+nome+"<br/>um tigre esta atacando a vila,<br/><br/>o que devemos fazer?</html>");
                btnOp1.setText("O importante é proteger as pessoas!");
                btnOp2.setText("O importante é matar o tigre");
                btnOp3.setText("Espera ele ir embora");
                Vt=13;              //Numero da historia nos botões
            break;
            case 4:
                lblMsg.setText("<html>Sr."+nome+"<br/>um forasteiro chegou na vila<br/>pedindo para ficar</html>");
                btnOp1.setText("Pode deixar ele fica");
                btnOp2.setText("Fica de olho nele");
                btnOp3.setText("Não quero ele aqui");
                Vt=14;              //Numero da historia nos botões
            break;
            case 5:
                lblMsg.setText("<html>Sr."+nome+"<br/>Uma vila vizinha esta<br/>querendo formar uma aliança<br/><br/>Devemos formar uma aliança?</html>");
                btnOp1.setText("Sim, vamos fazer uma festa!");
                btnOp2.setText("Ok");
                btnOp3.setText("Não");
                Vt=15;              //Numero da historia nos botões
            break;
            case 6:
                lblMsg.setText("<html>Sr."+nome+"<br/>Algumas pessoas da vila<br/>querem formar uma aliança<br/>com uma vila vizinha,<br/><br/>Devemos formar uma aliança?</html>");
                btnOp1.setText("Claro, mande um presente!");
                btnOp2.setText("Sim");
                btnOp3.setText("Não");
                Vt=16;              //Numero da historia nos botões
            break;
            case 7:
                if (construtor.QtSpinnerFazendas > 0) {

                    lblMsg.setText("<html>Sr."+nome+"<br/>Alguns dos fazendeiros<br/>estão com medo.<br/><br/>O que devemos fazer?</html>");
                    btnOp1.setText("Fale que ficara tudo bem");
                    btnOp2.setText("São apenas medrosos");
                    btnOp3.setText("Mande alguem proteger eles");
                    Vt=17;              //Numero da historia nos botões        
                    
                } else {

                    lblMsg.setText("<html>Sr."+nome+"<br/>Alguns ladrões chegaram na vila<br/><br/>O que devemos fazer?</html>");
                    btnOp1.setText("Fique de olho");
                    btnOp2.setText("Mate eles!");
                    btnOp3.setText("Proteja as riquezas");
                    Vt=18;              //Numero da historia nos botões  
                    
                }
            break;
            }
        }
    }

    void Status(){                                                  // função para atualizar o status

         //para diminuir aos poucos o valor
        if (QtRodada > 7) {

            VtHistoria=0;

            StatusRaivaPessoas       = (StatusRaivaPessoas < 0 )        ?       StatusRaivaPessoas + sentimento10       : StatusRaivaPessoas;     
            StatusTristezaPessoas    = (StatusTristezaPessoas  < 0)     ?       StatusTristezaPessoas  + sentimento10   : StatusTristezaPessoas;
            StatusTristezaAlimentos  = (StatusTristezaAlimentos  < 0)   ?       StatusTristezaAlimentos  + sentimento10 : StatusTristezaAlimentos;
            StatusTristezaRiquezas   = (StatusTristezaRiquezas  < 0)    ?       StatusTristezaRiquezas  + sentimento10  : StatusTristezaRiquezas;
            StatusTristezaSoldados   = (StatusTristezaSoldados  < 0)    ?       StatusTristezaSoldados  + sentimento10  : StatusTristezaSoldados;
            StatusRaivaPessoas       = (StatusRaivaPessoas  < 0)        ?       StatusRaivaPessoas  + sentimento10      : StatusRaivaPessoas;
            StatusRaivaRiquezas      = (StatusRaivaRiquezas  < 0)       ?       StatusRaivaRiquezas  + sentimento10     : StatusRaivaRiquezas;
            StatusRaivaArmas         = (StatusRaivaArmas  < 0)          ?       StatusRaivaArmas  + sentimento10        : StatusRaivaArmas;
            StatusRaivaSoldados      = (StatusRaivaSoldados  < 0)       ?       StatusRaivaSoldados  + sentimento10     : StatusRaivaSoldados;
            StatusFelicidadePessoas  = (StatusFelicidadePessoas > 50)   ?       StatusFelicidadePessoas  - sentimento10 : StatusFelicidadePessoas;
            StatusFelicidadeVilas    = (StatusFelicidadeVilas > 50)     ?       StatusFelicidadeVilas  - sentimento10   : StatusFelicidadeVilas;
            StatusFelicidadeRiquezas = (StatusFelicidadeRiquezas > 50)  ?       StatusFelicidadeRiquezas  - sentimento10: StatusFelicidadeRiquezas;
            StatusFelicidadeArmas    = (StatusFelicidadeArmas > 50)     ?       StatusFelicidadeArmas  - sentimento10   : StatusFelicidadeArmas;
            StatusFelicidadeAlimentos  =  (StatusFelicidadeAlimentos > 50)      ?  StatusFelicidadeAlimentos - sentimento10 : StatusFelicidadeAlimentos;
            StatusFelicidadeSoldados   = (StatusFelicidadeSoldados > 50)        ? StatusFelicidadeSoldados  - sentimento10  : StatusFelicidadeSoldados;

            QtRodada=0;                                                                
        }
        
        // validando valor dentro da varial (não pode ser maior ou menor que 100)
        StatusTristezaPessoas       =  (StatusTristezaPessoas  < (-100))        ? -100: StatusTristezaPessoas;
        StatusTristezaAlimentos     =  ( StatusTristezaAlimentos  < (-100))     ? -100:  StatusTristezaAlimentos;
        StatusTristezaRiquezas      =  ( StatusTristezaRiquezas  < (-100))      ? -100:  StatusTristezaRiquezas;
        StatusTristezaSoldados      =  ( StatusTristezaSoldados  < (-100))      ? -100:  StatusTristezaSoldados;
        StatusRaivaPessoas          =  ( StatusRaivaPessoas  < (-100))          ? -100:  StatusRaivaPessoas;
        StatusRaivaRiquezas         =  ( StatusRaivaRiquezas  < (-100))         ? -100:  StatusRaivaRiquezas;
        StatusRaivaArmas            =  ( StatusRaivaArmas  < (-100))            ? -100:  StatusRaivaArmas;
        StatusRaivaSoldados         =  ( StatusRaivaSoldados  < (-100))         ? -100:  StatusRaivaSoldados;
        StatusFelicidadePessoas     =  ( StatusFelicidadePessoas  >  100)       ? 100:  StatusFelicidadePessoas;
        StatusFelicidadeAlimentos   =  ( StatusFelicidadeAlimentos  >  100)     ? 100:  StatusFelicidadeAlimentos;
        StatusFelicidadeVilas       =  ( StatusFelicidadeVilas  >  100)         ? 100:  StatusFelicidadeVilas;
        StatusFelicidadeRiquezas    =  ( StatusFelicidadeRiquezas  >  100)      ? 100:  StatusFelicidadeRiquezas;
        StatusFelicidadeArmas       =  ( StatusFelicidadeArmas  >  100)         ? 100:  StatusFelicidadeArmas;
        StatusFelicidadeSoldados    =  ( StatusFelicidadeSoldados  >  100)      ? 100:  StatusFelicidadeSoldados;
        
        StatusRaiva      =  (StatusRaivaArmas   +   StatusRaivaPessoas  +   StatusRaivaRiquezas +   StatusRaivaSoldados);
        StatusTristeza   =  (StatusTristezaAlimentos    +   StatusTristezaPessoas   +   StatusTristezaRiquezas  +   StatusTristezaSoldados);
        StatusFelicidade =  (StatusFelicidadeAlimentos   +   StatusFelicidadeArmas   +   StatusFelicidadePessoas +        StatusFelicidadeRiquezas    +   StatusFelicidadeSoldados    +   StatusFelicidadeVilas);

        StatusSoma       =  (StatusTristezaPessoas  +	StatusTristezaAlimentos + StatusTristezaRiquezas    +	StatusTristezaSoldados  +	
        StatusRaivaPessoas  + StatusRaivaRiquezas   +	StatusRaivaArmas    +	StatusRaivaSoldados +	StatusFelicidadePessoas +	
        StatusFelicidadeAlimentos   +	StatusFelicidadeVilas   +	StatusFelicidadeRiquezas    +	StatusFelicidadeArmas   +	StatusFelicidadeSoldados)/5;
        
        if (StatusSoma >= 100) {
            lblMsgStatus.setText("Todos estão alegres!");
        } else {
            if (StatusSoma < 100 && StatusSoma >= 80) {
                lblMsgStatus.setText("O povo esta Feliz");
            } else {
                if (StatusSoma < 80 && StatusSoma >= 60 ) {
                    lblMsgStatus.setText("Estamos bem");
                } else {
                    if (StatusSoma < 60 && StatusSoma >= 40 ) {
                        lblMsgStatus.setText("Estamos levando");
                    } else {
                        if (StatusSoma < 40 && StatusSoma >= 25) {
                            lblMsgStatus.setText("Cuidado!");
                        } else {
                            if (StatusSoma < 25 && StatusSoma >= 0) {
                                 lblMsgStatus.setText("Crise em iminencia !!!");
                            } else { 

                            }
                        }
                    }
                }
            }
        }
    }

    void Jogo(){                                                    // função raiz para o jogo
                
        construtor.Leitor();
        Debug();
        
        if (QtPessoas <= 0 || QtAlimentos <=0 || QtVilas <= 0) {        //validação de vida
            lblMsg.setText("<html>Infelizmente seu reino <br/> não deu certo <br/><br/> Boa sorte na proxima! </html>");
            LimparOp();
            QtPessoas=0;
            btnOp1.setEnabled(false);
            btnOp2.setEnabled(false);
            btnOp3.setEnabled(false);
            btnCentral.setEnabled(false);
            btnCentral.setText("-");
            btnSair.setText("Jogar novamente");
            IniciarAtualizar();
        }else{
        
        IniciarAtualizar();                                         //função para validar e atualizar valores dentro das variaveis
        
        if (VtPrimeirosPassos <= 7) {
        PrimeirosPassos();                                          //tutorial
        } else {
        
        Historia();
        ContagemTempo();                                            // fazer contagem dos dias e diminuir o alimento

        }
        
        //analise das variaveis
        debug++;
        System.out.println("----/Inicio/----- "+debug);
        System.out.println("----/Fim/-----");
        }

    }
    
    void Fazendas(){                                               // função para quando tiver fazendas

        if (construtor.QtSpinnerFazendas > 0) {
        
            if (aleatorio.nextInt(2) == 0) {
                QtAlimentos += construtor.QtSpinnerFazendas;
            } else {
                QtAlimentos += (construtor.QtSpinnerFazendas/2);
            }
            
        } else {                                                    // sem funcionarios não faz nada
            
        }
    }

    void Soldados(){                                                // função para criar soldados

        if ((construtor.QtSpinnerSoldados != 0) && (QtSoldados <= QtPessoas)) {
            QtSoldados += construtor.QtSpinnerSoldados;
        }

    }

    void CienciaTec(){                                              // função para expandir a ciencia e tecnologia

        if (construtor.QtSpinnerCiencia > 0) {
            
            switch (Valor) {
                case 1:

                break;
            
                default:
                    
                break;
            }

        } else {
            
        }

    }

    void Construcao(){                                              // função para criar vilas, casas, comercios... 

        if (construtor.QtSpinnerConstrucao > 0) {
          //criar vilas
        }

    }

    void Minerador(){                                               // função para criar riqueza a vila
        if (construtor.QtSpinnerMineradores > 0) {

            QtMoedas += (construtor.QtSpinnerMineradores/3);            //gerador de moeda

            if ((aleatorio.nextInt(5) == 2)) {
                QtBarraOuro++;                                          //gerador de barra de ouro
            } else {
                
            }
        }
    }

    void Debug(){

        if (QtSoldados > QtPessoas) {
            QtSoldados = QtPessoas;
        }

        construtor.Leitor();
        QtTrabalhadores = (construtor.QtSpinnerCiencia + construtor.QtSpinnerConstrucao + construtor.QtSpinnerExploradores + construtor.QtSpinnerFazendas + construtor.QtSpinnerFeiticaria + construtor.QtSpinnerFerreiro + construtor.QtSpinnerMineradores + construtor.QtSpinnerSoldados);

        if (QtPessoas < QtTrabalhadores) {

            construtor.setQtTrabalhadores(QtPessoas);            // enviar quantidade de pessoas
            TelaTarefas tela = new TelaTarefas();                // criando obj
            tela.exportaTrabalhadores(construtor);               // enviar Quantidade de pessoas
            tela.Atualizar();
            tela.setVisible(true);
            btnOp1.setEnabled(false);
            btnOp2.setEnabled(false);
            btnOp3.setEnabled(false);

        }else{
            
            btnOp1.setEnabled(true);
            btnOp2.setEnabled(true);
            btnOp3.setEnabled(true);

        }
        if (QtPessoas > QtTrabalhadores) {              //mudar a cor do botão para quando tiver pessoas sem trabalho
            valorA=150;
            valorB=200;
            valorC=200;
            
            btnCentral.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(valorA, valorB, valorC)));

        }else{
            valorA=102;
            valorB=102;
            valorC=102;
            
            btnCentral.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(valorA, valorB, valorC)));

        }


        // validar quantidade de pessoas e ajustar automaticamente #FAZER
    }

    @SuppressWarnings("Generated Code")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblMsg = new javax.swing.JLabel();
        btnOp1 = new javax.swing.JButton();
        btnOp2 = new javax.swing.JButton();
        btnOp3 = new javax.swing.JButton();
        lblNomeReino = new javax.swing.JLabel();
        lblPessoas = new javax.swing.JLabel();
        lblValoresPessoas = new javax.swing.JLabel();
        lblAlimentos = new javax.swing.JLabel();
        lblValoresAlimentos = new javax.swing.JLabel();
        lblVilas = new javax.swing.JLabel();
        lblValoresVilas = new javax.swing.JLabel();
        lblRiquezas = new javax.swing.JLabel();
        lblValoresRiquezas = new javax.swing.JLabel();
        lblSoldados = new javax.swing.JLabel();
        lblValoresSoldados = new javax.swing.JLabel();
        lblArmas = new javax.swing.JLabel();
        lblValoresArmas = new javax.swing.JLabel();
        lblMsgStatus = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnCentral = new javax.swing.JButton();
        lblDias = new javax.swing.JLabel();
        lblValoresDias = new javax.swing.JLabel();
        btnExplorar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblMsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsg.setText("Mensagem");

        btnOp1.setForeground(new java.awt.Color(204, 204, 204));
        btnOp1.setText("Opção 1");
        btnOp1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));
        btnOp1.setContentAreaFilled(false);
        btnOp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp1ActionPerformed(evt);
            }
        });

        btnOp2.setForeground(new java.awt.Color(204, 204, 204));
        btnOp2.setText("Opção 2");
        btnOp2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));
        btnOp2.setContentAreaFilled(false);
        btnOp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp2ActionPerformed(evt);
            }
        });

        btnOp3.setForeground(new java.awt.Color(204, 204, 204));
        btnOp3.setText("Opção 3");
        btnOp3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(51, 51, 51), new java.awt.Color(102, 102, 102)));
        btnOp3.setContentAreaFilled(false);
        btnOp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOp3ActionPerformed(evt);
            }
        });

        lblNomeReino.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNomeReino.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeReino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeReino.setText("Nome do Reino");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeReino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMsg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOp1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOp2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeReino, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblPessoas.setForeground(new java.awt.Color(255, 255, 255));
        lblPessoas.setText("Pessoas");

        lblValoresPessoas.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresPessoas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresPessoas.setText("-");

        lblAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        lblAlimentos.setText("Alimentos");

        lblValoresAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresAlimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresAlimentos.setText("-");

        lblVilas.setForeground(new java.awt.Color(255, 255, 255));
        lblVilas.setText("Vilas");

        lblValoresVilas.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresVilas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresVilas.setText("-");

        lblRiquezas.setForeground(new java.awt.Color(255, 255, 255));
        lblRiquezas.setText("Riquezas");

        lblValoresRiquezas.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresRiquezas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresRiquezas.setText("-");

        lblSoldados.setForeground(new java.awt.Color(255, 255, 255));
        lblSoldados.setText("Soldados");

        lblValoresSoldados.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresSoldados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresSoldados.setText("-");

        lblArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblArmas.setText("Armas");

        lblValoresArmas.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresArmas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresArmas.setText("-");

        lblMsgStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblMsgStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsgStatus.setText("-");

        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair do Jogo");
        btnSair.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        btnSair.setContentAreaFilled(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCentral.setForeground(new java.awt.Color(255, 255, 255));
        btnCentral.setText("Tarefas");
        btnCentral.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(valorA, valorB, valorC)));
        btnCentral.setContentAreaFilled(false);
        btnCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCentralActionPerformed(evt);
            }
        });

        lblDias.setForeground(new java.awt.Color(255, 255, 255));
        lblDias.setText("Dias");

        lblValoresDias.setForeground(new java.awt.Color(255, 255, 255));
        lblValoresDias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValoresDias.setText("-");

        btnExplorar.setForeground(new java.awt.Color(255, 255, 255));
        btnExplorar.setText("Explorar");
        btnExplorar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        btnExplorar.setContentAreaFilled(false);
        btnExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExplorarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblSoldados, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresSoldados, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDias, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresDias, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMsgStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExplorar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblVilas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresVilas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRiquezas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValoresRiquezas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresSoldados, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoldados, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMsgStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresDias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExplorar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCentral, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresVilas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVilas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValoresRiquezas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRiquezas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExplorarActionPerformed(java.awt.event.ActionEvent evt) {//Janela do jogo 2D
        
        Container interfaContainer = new Container();
        interfaContainer.setVisible(true);

        construtor.audioAndando(Valor++);
        construtor.audioClick();
        
    }//GEN-LAST:event_btnExplorarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//botão sair
        // #Sair
        
        construtor.audioClick();
        
        if (QtPessoas==0) {

            VtPrimeirosPassos=0;
            QtPessoas=10;
            Jogo();

        } else {
            System.exit(0);
        }


        
    }                                       

    private void btnOp1ActionPerformed(java.awt.event.ActionEvent evt) {//botão opção 1
        // #Opção 1
        construtor.audioClick();

        switch(Vt){
            case 1:     //Iniviar Tutorial
                Vt=2;
                PrimeirosPassos();
                btnOp3.setText("Finalizar");
                VtPrimeirosPassos++;
            break;
            case 2:     //Fazer o Tutorial
                VtPrimeirosPassos++;
                PrimeirosPassos();
            break;      //fim do tutorial  
            case 11:    //Inicio Historia
                lblMsg.setText("<html>Muito bem meu lorde.<br/>Eles ficam gratos!<html/>");
                QtPessoas+=6;
                StatusFelicidadePessoas += sentimento30;
            break;
            case 12:    //Historia
                lblMsg.setText("Eles foram embora.");
                QtPessoas-=6;
                StatusTristezaPessoas -= sentimento30;
            break;
            case 13:    //Historia
                lblMsg.setText("Conseguimos salvar todos!");
                QtAlimentos-=10;
                StatusFelicidadePessoas += sentimento10;
            break;
            case 14:    //Historia
                lblMsg.setText("o forasteiro é grato.");
                QtPessoas+=1;
                StatusFelicidadePessoas += sentimento10;
            break;
            case 15:    //Historia
                lblMsg.setText("<html>A vila e as pessoas<br/>Ficaram feliz!<html/>");
                QtAlimentos-=10;
            break;
            case 16:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. enviamos comida e a <br/>outra vila ficou muito feliz<br/> com a aliança, mandaram <br/> alguns soldados em retribuição<br/> da nova amizade!<html/>");
                    QtAlimentos-=10;
                    StatusFelicidadePessoas += sentimento10;
                    Valor       += (aleatorio.nextInt(5)+2);
                    QtPessoas   += Valor;
                    QtSoldados  += Valor;
                } else {
                lblMsg.setText("<html>Enviamos comida!<br/>Todos ficaram felizes!<html/>");
                QtAlimentos-=10;
                StatusFelicidadePessoas += sentimento10;
                }
            break;
            case 21:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. fizemos uma festa mas o povo não gostou<br/> saquearam e distruiram tudo.<html/>");
                    QtAlimentos-= sentimento40;
                    StatusRaivaPessoas += sentimento10;
                } else {
                lblMsg.setText("<html>Sr. fizemos uma festa e o povo <br/> parece ter ficado mais tranquilo.<html/>");
                QtAlimentos-=30;
                StatusRaivaPessoas += sentimento30;
                }
            break;
            case 22:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. fizemos uma festa mas o <br/>povo não gostou muito.<html/>");
                    QtAlimentos-= sentimento40;
                    StatusFelicidadePessoas += sentimento20;
                } else {
                lblMsg.setText("<html>Sr. fizemos a festa e o povo <br/> adorou.<html/>");
                QtAlimentos -=  sentimento40;
                StatusFelicidadePessoas += sentimento50;
                }
            break;
            case 17:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. eles ficam mais seguros<br/>com as suas palavras.<html/>");
                    StatusFelicidadePessoas += sentimento10;
                } else {
                    lblMsg.setText("<html>Sr. eles não se sentiram muito seguro,<br/>com as suas palavras.<html/>");
                    QtAlimentos -=  sentimento10;
                }
            break;
            case 18:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. eles acabaram roubando alguns alimentos.<html/>");
                    QtAlimentos                 -=  sentimento10;
                    StatusRaivaPessoas          +=  sentimento10;
                    StatusFelicidadePessoas     -=  sentimento10;
                } else {
                    lblMsg.setText("<html>Sr. eles acabaram roubando alguns alimentos.<html/>");
                    QtAlimentos                 -=  sentimento20;
                    StatusRaivaPessoas          +=  sentimento30;
                    StatusFelicidadePessoas     -=  sentimento20;
                }
            break;
            
        }
        LimparOp();

        if (VtPrimeirosPassos <= 7) {
            Jogo();
        } else {

            Timer timer = new Timer();
        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
                Jogo();
            }
        };
        timer.schedule(tarea, delay2, delay1);

        }
        
    }                                      

    private void btnOp2ActionPerformed(java.awt.event.ActionEvent evt) {//botão opção 2
        // #Opção 2
        construtor.audioClick();

        switch(Vt){
            case 12:    //Inicio Historia
                lblMsg.setText("Alguns deles ficaram.");
                QtPessoas-=3;
                StatusTristezaPessoas -= sentimento20;
                StatusRaivaPessoas -= sentimento20;
            break;
            case 13:    //Historia
                lblMsg.setText("Pessoas morreram, mas matamos o tigre.");
                QtPessoas-=3;
                QtAlimentos+=10;
                StatusTristezaPessoas -= sentimento20;
                StatusFelicidadePessoas += sentimento30;
                StatusRaivaPessoas -= sentimento20;
            break;
            case 14:    //Historia
                lblMsg.setText("Ok Sr.");
                QtPessoas+=1;
                StatusRaivaPessoas -= sentimento20;
            break;
            case 15:    //Historia
                lblMsg.setText("Otimo, vamos avisar eles.");
                if (1 == (aleatorio.nextInt(2)+1)) {
                    StatusFelicidadePessoas += sentimento10;
                } else {
                    StatusRaivaPessoas -= sentimento10;
                    StatusTristezaPessoas -= sentimento10;
                }
            break;
            case 16:    //Historia
                lblMsg.setText("Ok Sr.");
                StatusFelicidadePessoas += sentimento10;
            break;
            case 21:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. o povo esta saqueando e distruiram tudo<br/> tivemos que usar a força.<html/>");
                    QtAlimentos-=15;
                    StatusRaivaPessoas -= sentimento30;
                } else {
                lblMsg.setText("<html>Sr. precisamos mostra quem manda aqui<br/> execultamos algumas pessoas.<html/>");
                QtPessoas -= (sentimento30/10);
                StatusRaivaPessoas += sentimento50;
                }
            break;
            case 17:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. os fazendeiros ficaram irritados.<html/>");
                    StatusRaivaPessoas += sentimento30;
                } else {
                    lblMsg.setText("<html>Sr. alguns fazendeiros jogaram frutas em<br/>alguns dos nossos soldados falaram.<html/>");
                    QtAlimentos         -= sentimento10;
                    StatusRaivaPessoas  += sentimento50;
                }
            break;
            case 18:    //Historia
                if (1 == (aleatorio.nextInt(2))) {
                    lblMsg.setText("<html>Sr. matamos todos eles!<html/>");
                    StatusFelicidadePessoas     +=  sentimento10;
                    StatusRaivaPessoas          +=  sentimento10;
                } else {
                    lblMsg.setText("<html>Sr. matamos eles, mas eles<br/>mataram alguns dos nossos tambem.<html/>");
                    QtPessoas                   -= (sentimento50/10);
                    StatusRaivaPessoas          += sentimento30;
                    StatusTristezaPessoas       += sentimento40;
                }
            break;

        }
    
         LimparOp();

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
                Jogo();
            }
        };
        timer.schedule(tarea, delay2, delay1);
        
    }                                      

    private void btnOp3ActionPerformed(java.awt.event.ActionEvent evt) {//botão opção 3
        // #Opção 3
        construtor.audioClick();

        switch(Vt){
            case 1:     //Não quero iniciar Tutorial?
                lblMsg.setText("Ok Sr. boa sorte!");
                VtPrimeirosPassos+=8;
            break;      //fim do tutorial
            case 11:    //Inicio Historia
                lblMsg.setText("<html>Muito bem meu lorde.<br/>Eles foram embora<html/>");
                StatusTristezaPessoas -= (sentimento50+10);
            break;
            case 12:    //Historia
                lblMsg.setText("Eles ficaram, mas estão reclamando.");
                StatusRaivaPessoas -= (sentimento50+10);
            break;
            case 13:    //Historia
                lblMsg.setText("<html>O tigre foi embora,<br/> mas matou algumas pessoas.</html>");
                QtPessoas-=5;
                QtAlimentos-=3;
                StatusTristezaPessoas -= sentimento30;
                StatusRaivaPessoas -= sentimento20;
            break;
            case 14:    //Historia
                lblMsg.setText("<html>Ele saiu reclamando e<br/>falou que deve se vingar.</html>");
                StatusRaivaPessoas -= sentimento40;
            break;
            case 15:    //Historia
                lblMsg.setText("<html>O lider da vila,<br/> não entendeu o motivo da recusa.<br/> Mas devemos ficar bem.</html>");
                StatusRaivaPessoas -= sentimento30;
                StatusRaivaSoldados -= sentimento10;
            break;
            case 16:    //Historia
                lblMsg.setText("Algumas pessoas não gostaram.");
                StatusRaivaPessoas -= sentimento30;
                StatusTristezaPessoas -= sentimento20;
            break;
            case 21:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. algumas pessoas se juntaram<br/> e ficaram protestante<br/> mas ja foram embora.<html/>");
                    StatusRaivaPessoas += sentimento20;
                } else {
                    lblMsg.setText("<html>OK Sr.<html/>");
                    StatusRaivaPessoas += sentimento10;
                }
            break;
            case 22:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>Sr. algumas pessoas se mataram.<html/>");
                    QtPessoas               -= (sentimento30/10);
                    StatusRaivaPessoas      += sentimento20;
                    StatusFelicidadePessoas -= sentimento30;
                } else {
                    lblMsg.setText("<html>OK Sr.<html/>");
                    StatusRaivaPessoas      += sentimento10;
                    StatusFelicidadePessoas -= sentimento20;
                }
            break;
            case 17:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>OK Sr.<html/>");
                    StatusFelicidadePessoas += sentimento10;
                } else {
                    lblMsg.setText("<html>OK Sr. eles ficaram feliz.<html/>");
                    StatusFelicidadePessoas += sentimento20;
                }
            break;
            case 18:    //Historia
                if (1 == (aleatorio.nextInt(2)+1)) {
                    lblMsg.setText("<html>OK Sr.<html/>");
                    StatusFelicidadePessoas     -= sentimento30;
                    StatusFelicidadeRiquezas    += sentimento20;
                } else {
                    lblMsg.setText("<html>Sr. as pessoas não gostaram.<html/>");
                    StatusFelicidadePessoas     -= sentimento50;
                    StatusRaivaPessoas          += sentimento30;
                }
            break;
        }
 
         LimparOp();

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask(){
            @Override
            public void run(){
                Jogo();
            }
        };
        timer.schedule(tarea, delay2, delay1);
        
    }                                      

    private void btnCentralActionPerformed(java.awt.event.ActionEvent evt) {//botão de tarefas
        // Abrir Central de tarefas

        construtor.audioClick();

        construtor.setQtTrabalhadores(QtPessoas);            // enviar quanntidade de pessoas
        TelaTarefas tela = new TelaTarefas();                // criando obj
        tela.exportaTrabalhadores(construtor);               // enviar Quantidade de pessoas
        tela.Atualizar();
        tela.setVisible(true);


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCentral;
    private javax.swing.JButton btnExplorar;
    private javax.swing.JButton btnOp1;
    private javax.swing.JButton btnOp2;
    private javax.swing.JButton btnOp3;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAlimentos;
    private javax.swing.JLabel lblArmas;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblMsgStatus;
    private javax.swing.JLabel lblNomeReino;
    private javax.swing.JLabel lblPessoas;
    private javax.swing.JLabel lblRiquezas;
    private javax.swing.JLabel lblSoldados;
    private javax.swing.JLabel lblValoresAlimentos;
    private javax.swing.JLabel lblValoresArmas;
    private javax.swing.JLabel lblValoresDias;
    private javax.swing.JLabel lblValoresPessoas;
    private javax.swing.JLabel lblValoresRiquezas;
    private javax.swing.JLabel lblValoresSoldados;
    private javax.swing.JLabel lblValoresVilas;
    private javax.swing.JLabel lblVilas;
    // End of variables declaration//GEN-END:variables

  
}
