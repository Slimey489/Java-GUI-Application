class ErrorHandler implements Runnable{
    public void run() {
        ErrorFrame classinstance = new ErrorFrame();
        App.gui = classinstance.errorFrame();
        App.gui.setVisible(true);

    }
}