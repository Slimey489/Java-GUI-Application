class ErrorHandler implements Runnable{
    public void run() {
        ErrorFrame classInstance = new ErrorFrame();
        App.gui = classInstance.errorFrame();
        App.gui.setVisible(true);

    }
}