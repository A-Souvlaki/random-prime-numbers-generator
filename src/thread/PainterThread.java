package thread;

import java.util.concurrent.TimeUnit;

import controller.GenerateNumbersController;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.GenerateNumbers;

public class PainterThread extends Thread {

	private GenerateNumbersController gnc;

	private GenerateNumbers gn;

	private int stop;

	private GridPane gp;

	private Text t;
	
	private Label l;

	private int value;

	private int i;

	private int j;

	private int k;

	private int n;

	public PainterThread(GenerateNumbersController gnc, int stop, GridPane gp, Text t,Label l, int value) {
		this.stop = stop;
		this.gp = gp;
		this.gnc = gnc;
		this.t = t;
		this.l = l;
		
		this.value = value;
		this.i = 0;
		this.j = 0;
		this.k = 2;
		this.n = 2;

		this.gn = new GenerateNumbers();
	}

	private void increment() {
		boolean[] prime = null;
		if (value == 1) {
			prime = gn.eratostenesCribAlgorithm(stop);
		} else if (value == 2) {
			prime = gn.tourAlgorithm(stop);
		} else if (value == 3) {
			prime = gn.anSimpleFormAlgorithm(stop);
		}
	
		if (prime[k] == false) {
			t = new Text("" + n);
			t.setFill(Color.MEDIUMSEAGREEN);
			gp.add(t, j, i);
		} else {
			t = new Text("" + n);
			t.setFill(Color.DARKRED);
			gp.add(t, j, i);
		}

		if (j < gnc.NumberColumn() - 1) {
			j++;
		} else if (i < gnc.numberRow()) {
			i++;
			j = 0;
		}

		if (n < stop) {
			n++;
			k++;
		}

	}

	public void run() {
		int n = 0;
		while (n <= stop - 2) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					Long t1 = System.nanoTime();
					increment();
					Long t2 = System.nanoTime();
					long elapsedTime =t2-t1;
					l.setText(""+(elapsedTime)+" nano-segundos");
				}
			});
			n++;
			try {
				sleep(50);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
