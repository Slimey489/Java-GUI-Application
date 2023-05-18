import javax.swing.*;

class App implements Runnable {
    public static JFrame gui;

    static boolean start_mainFrame_First;
    static boolean class_is_mainframe;

    public void run() {
        //debug option
        start_mainFrame_First = false;
        Scratch.callingclass = Scratch.findCallingClass();
        if (start_mainFrame_First) {
            Scratch classinstance = new Scratch();
            gui = classinstance.GuessFrame();
        }
        else {
            WordFrame classinstance = new WordFrame();
            gui = classinstance.wordFrame();
        }
        gui.setVisible(true);
        if (class_is_mainframe){
            System.out.println(Scratch.callingclass);
            Scratch.frameMain.dispose();
        }



    }
}