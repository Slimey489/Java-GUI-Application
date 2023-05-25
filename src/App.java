import javax.swing.*;

class App implements Runnable {
    public static JFrame gui;

    static boolean startMainFrameFirst;
    static boolean classIsMainframe;

    public void run() {
        startMainFrameFirst = false;
        Main.callingclass = Main.findCallingClass();
        if (startMainFrameFirst) {
            Main classinstance = new Main();
            gui = classinstance.GuessFrame();
        }
        else {
            WordFrame classinstance = new WordFrame();
            gui = classinstance.wordFrame();
        }
        gui.setVisible(true);
        if (classIsMainframe){
            System.out.println(Main.callingclass);
            Main.frameMain.dispose();
        }



    }
}