package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import thread.PainterThread;

public class GenerateNumbersController implements Initializable {

	public final static String CRIBE = "Criba";
	public final static String TOUR = "Tour";
	public final static String SIMPLE_FORM = "Forma Simple";

	ObservableList<String> list = FXCollections.observableArrayList();

	@FXML
	private ChoiceBox<String> choiceBox;

	@FXML
	BorderPane pane = new BorderPane();

	@FXML
	private TextField tf;

	@FXML
	private Button button;

	@FXML
	private Label time;

	private GridPane gp;

	private PainterThread pt;

	private Text t;

	@SuppressWarnings("unlikely-arg-type")
	public void createBox() {
		list.remove(list);
		list.addAll(CRIBE, TOUR, SIMPLE_FORM);
		choiceBox.getItems().addAll(list);

	}

	@FXML
	public void createTable(ActionEvent e) {
		try {
			String choice = choiceBox.getValue();
			gp = new GridPane();
			gp.setMaxHeight(250);
			gp.setMaxWidth(250);

			int aux = Integer.parseInt(tf.getText());
			int r = numberRow();
			int c = NumberColumn();

			for (int row = 0; row < r; row++) {
				RowConstraints rc = new RowConstraints();
				rc.setFillHeight(true);
				rc.setVgrow(Priority.ALWAYS);
				gp.getRowConstraints().add(rc);
			}
			for (int col = 0; col < c; col++) {
				ColumnConstraints cc = new ColumnConstraints();
				cc.setFillWidth(true);
				cc.setHgrow(Priority.ALWAYS);
				gp.getColumnConstraints().add(cc);
			}

			if (choice.equals(CRIBE)) {
				pt = new PainterThread(this, aux, this.gp, this.t,this.time, 1);
				pt.setDaemon(true);
				pt.start();
			} else if (choice.equals(TOUR)) {
				pt = new PainterThread(this, aux, this.gp, this.t,this.time, 2);
				pt.setDaemon(true);
				pt.start();
			} else {
				pt = new PainterThread(this, aux, this.gp, this.t,this.time, 3);
				pt.setDaemon(true);
				pt.start();
			}

			gp.setHgap(2);
			gp.setVgap(2);
			pane.setCenter(gp);

		} catch (NumberFormatException n) {
			Alert error = new Alert(AlertType.WARNING);
			error.setContentText("¡Llena el campo de texto!");
			error.show();
		} catch (NullPointerException e2) {
			Alert error = new Alert(AlertType.WARNING);
			error.setContentText("¡Selecciona una opcion!");
			error.show();
		}

	}

	public int numberRow() {

		int n = 0;
		try {
			int aux = Integer.parseInt(tf.getText());
			n = (int) Math.floor(Math.sqrt(aux));
		} catch (NumberFormatException e) {
			Alert error = new Alert(AlertType.WARNING);
			error.setContentText("¡Llena el campo de texto!");
			error.show();
		}
		return n;
	}

	public int NumberColumn() {
		int n = 0;
		try {
			int aux = Integer.parseInt(tf.getText());
			n = (int) Math.floor(Math.sqrt(aux));
			if (n * n == aux) {
				int a = n;
				n = a;
			} else if (n * (n + 1) >= aux) {
				n = n + 1;
			} else {
				n = n + 2;
			}
		} catch (NumberFormatException e) {
			Alert error = new Alert(AlertType.WARNING);
			error.setContentText("¡Llena el campo de texto!");
			error.show();
		}
		return n;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		createBox();

	}

}
