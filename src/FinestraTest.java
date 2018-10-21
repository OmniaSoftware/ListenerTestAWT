import java.awt.*;
import java.awt.event.*;

public class FinestraTest extends Frame {
    private Button btnEsci = new Button("Esci");
    private TextField txtTest = new TextField("E' un test!");
    private Button btnTest = new Button("Test");
    private TextArea txtArea = new TextArea("Questa è un area testo");

    public FinestraTest(String titolo){
        super(titolo);
        setup();
    }

    private void setup(){
        this.setLayout(null);
        setSize(250,200);
        addDefaultComponents();
        setComponentBounds();
        setVisible(true);
        setListeners();
    }

    private void addDefaultComponents(){
        this.add(btnTest);
        this.add(btnEsci);
        this.add(txtTest);
        this.add(txtArea);
    }
    private void setListeners(){
        setWindowsListener();
        setMouseListener();
        setTextListener();
    }

    private void setMouseListener(){
        btnEsci.addMouseListener(new MouseListenerApp());
        btnTest.addMouseListener(new MouseListenerApp());
        txtTest.addMouseListener(new MouseListenerApp());
        txtArea.addMouseListener(new MouseListenerApp());
    }

    private void setWindowsListener(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowsListener: Premuto icona uscita");
                System.exit(0);
            }
        });
    }

    private void setTextListener(){
        txtTest.addTextListener(new TxtListenerApp());
        txtArea.addTextListener(new TxtAreaListenerApp());
    }

    private void setComponentBounds(){
        btnTest.setBounds(10,40,60,30);
        txtTest.setBounds(80,40,60,30);
        btnEsci.setBounds(160,40,60,30);
        txtArea.setBounds(10,80,200,60);
    }



    private class MouseListenerApp implements MouseListener{
       private Component component;
       private int count = 0;
        @Override
        public void mouseClicked(MouseEvent e) {
            component = e.getComponent();
            int button = e.getButton();
            String parametri = e.paramString();

            addSeparator();
            System.out.println("MouseListener: lista parametri - " + parametri);
            System.out.println("MouseListener: cliccato pulsante " + button);
            System.out.println("MouseListener: numero click: " + count);
            System.out.println("MouseListener: cliccato componente: " + component.getName());


        }

        @Override
        public void mousePressed(MouseEvent e) {
        component = e.getComponent();
        count++;
        addSeparator();
        System.out.println("MouseListener: premuto mouse sul componente: " + component.getName());

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            component = e.getComponent();

            addSeparator();
            System.out.println("MouseListener: rilasciato mouse sul componente: " + component.getName());
            if(e.getSource() == btnEsci )
                System.exit(1);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            component = e.getComponent();

            addSeparator();
            System.out.println("MouseListener: mouse entrato sul componente: " + component.getName());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            component = e.getComponent();

            addSeparator();
            System.out.println("MouseListener: mouse uscito sul componente: " + component.getName());
        }

        private void addSeparator(){
            System.out.println("------------------");
        }
    }


    private class TxtAreaListenerApp implements  TextListener{
        @Override
        public void textValueChanged(TextEvent e) {
            System.out.println("Il testo è cambiato su txtArea");
        }
    }

    private class TxtListenerApp implements TextListener{

        @Override
        public void textValueChanged(TextEvent e) {
            System.out.println("Il testo è cambiato su txtTest");
        }
    }
}