class ErrorHandler implements Runnable{
    public void run() {
        ErrorFrame class_Instance = new ErrorFrame();
        App.gui = class_Instance.errorFrame();
        App.gui.setVisible(true);

    }
}