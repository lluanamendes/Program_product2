module exercicio_11 {
	requires javafx.controls;
    requires javafx.fxml;
    
    opens ui to javafx.fxml;
    exports ui;
}