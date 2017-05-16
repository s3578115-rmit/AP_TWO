package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
/**
*
* 
* @author : Carol Benita Saldanha
* @version : 1
* Class Description: The SwimmerAnimation class is where the animation for swimming takes place. 
* The UI elements are linked via SwimmingAnimation.fxml 
* 
* 
* 
* 
*/

public class SwimmerAnimationController extends SwimmingController implements Initializable {

	/**
	 * 
	 * These are the FXML variables that are set in SwimmingAnimation.fxml and linked to this controller.
	 * 
	 */
	@FXML
	private ImageView participant2;

	@FXML
	private ImageView participant1;

	@FXML
	private ImageView swimPath;

	@FXML
	private ImageView participant8;

	@FXML
	private ImageView participant7;

	@FXML
	private ImageView participant6;

	@FXML
	private ImageView participant5;

	@FXML
	private ImageView participant4;

	@FXML
	private ImageView participant3;

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private Label label3;

	@FXML
	private Label label4;

	@FXML
	private Label label5;

	@FXML
	private Label label6;

	@FXML
	private Label label7;

	@FXML
	private Label label8;
	
	/**
	 * 
	 * This method is an Action event that takes place when the View Results button is clicked. The DisplayController class is invoked next.
	 * 
	 */

	@FXML
	void displayResults(ActionEvent event) throws Exception {
		Utility utility = new Utility();
		utility.displayUX(DisplayController.class, "application/Display.fxml", null);
	}
	/**
	 * 
	 * This method is where all the initialization for the controller takes place.
	 * 
	 */
	public void initialize(URL url, ResourceBundle rb) {
		/**
		 * 
		 * time and name are two Array Lists that are created which fetch the time and name of all the players.
		 * 
		 */
		ArrayList<Float> time = new ArrayList<Float>();
		ArrayList<String> name = new ArrayList<String>();

		for (int i = 0; i < driver.displaySwimmingResults().size(); i++) {
			time.add(driver.displaySwimmingResults().get(i).getATime());

		}
		for (int i = 0; i < driver.displaySwimmingResults().size(); i++) {
			String result = driver.displaySwimmingResults().get(i).toString();
			name.add(result.substring(result.indexOf("name=") + 5, result.indexOf(",")));
		}
		/**
		 * 
		 * This method is used to create parallel transition for Swimming Animation and then play all these animations.These
		 * animations will vary depending on the number of participants that the user will chose.
		 * 
		 */
		TranslateTransition transition1 = new TranslateTransition();
		transition1.setDuration(Duration.seconds(time.get(0) / 4));
		transition1.setNode(participant1);
		transition1.setToX(330);

		TranslateTransition transition2 = new TranslateTransition();
		transition2.setDuration(Duration.seconds(time.get(1) / 4));
		transition2.setNode(participant2);
		transition2.setToX(330);

		TranslateTransition transition3 = new TranslateTransition();
		transition3.setDuration(Duration.seconds(time.get(2) / 4));
		transition3.setNode(participant3);
		transition3.setToX(330);

		TranslateTransition transition4 = new TranslateTransition();
		transition4.setDuration(Duration.seconds(time.get(3) / 4));
		transition4.setNode(participant4);
		transition4.setToX(330);

		TranslateTransition transition5 = new TranslateTransition();
		transition5.setNode(participant5);
		transition5.setToX(330);

		TranslateTransition transition6 = new TranslateTransition();
		transition6.setNode(participant6);
		transition6.setToX(330);

		TranslateTransition transition7 = new TranslateTransition();
		transition7.setNode(participant7);
		transition7.setToX(330);

		TranslateTransition transition8 = new TranslateTransition();
		transition8.setNode(participant8);
		transition8.setToX(330);

		if (driver.displaySwimmingResults().size() == 8) {

			transition5.setDuration(Duration.seconds(time.get(4) / 4));
			transition6.setDuration(Duration.seconds(time.get(5) / 4));
			transition7.setDuration(Duration.seconds(time.get(6) / 4));
			transition8.setDuration(Duration.seconds(time.get(7) / 4));
			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4,
					transition5, transition6, transition7, transition8);
			parallel.play();
			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));
			label5.setText("5) " + name.get(4));
			label6.setText("6) " + name.get(5));
			label7.setText("7) " + name.get(6));
			label8.setText("8) " + name.get(7));
		}

		else if (driver.displaySwimmingResults().size() == 4) {

			participant5.setVisible(false);
			participant6.setVisible(false);
			participant7.setVisible(false);
			participant8.setVisible(false);

			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4);
			parallel.play();
			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));

		} else if (driver.displaySwimmingResults().size() == 5) {

			participant6.setVisible(false);
			participant7.setVisible(false);
			participant8.setVisible(false);

			transition5.setDuration(Duration.seconds(time.get(4) / 4));

			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4,
					transition5);
			parallel.play();

			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));
			label5.setText("5) " + name.get(4));

		} else if (driver.displaySwimmingResults().size() == 6) {

			label5.setText(name.get(4));
			label6.setText(name.get(5));
			transition5.setDuration(Duration.seconds(time.get(4) / 4));
			transition6.setDuration(Duration.seconds(time.get(5) / 4));
			participant7.setVisible(false);
			participant8.setVisible(false);
			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4,
					transition5, transition6);
			parallel.play();
			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));
			label5.setText("5) " + name.get(4));
			label6.setText("6) " + name.get(5));

		} else {

			label5.setText(name.get(4));
			label6.setText(name.get(5));
			label7.setText(name.get(6));
			transition5.setDuration(Duration.seconds(time.get(4) / 4));
			transition6.setDuration(Duration.seconds(time.get(5) / 4));
			transition7.setDuration(Duration.seconds(time.get(6) / 4));
			participant8.setVisible(false);
			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4,
					transition5, transition6, transition7);
			parallel.play();

			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));
			label5.setText("5) " + name.get(4));
			label6.setText("6) " + name.get(5));
			label7.setText("7) " + name.get(6));

		}

	}
}
